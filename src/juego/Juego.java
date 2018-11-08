package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import control.Teclado;
import entes.criaturas.Jugador;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;
import mapa.MapaCargado;

public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static final int ANCHO = 800;
	private static final int ALTO = 800;

	private static volatile boolean enFuncionamiento = false;

	private static final String NOMBRE = "Juego";

	private static String CONTADOR_APS = "";
	private static String CONTADOR_FPS = "";

	private static int aps = 0;
	private static int fps = 0;

	private static JFrame ventana;
	private static Thread thread;
	private static Teclado teclado;
	private static Pantalla pantalla;
	private static Mapa mapa;
	private static Jugador jugador;

	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();

	// EJECUTABLE 51
	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.iniciar();
	}

	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		pantalla = new Pantalla(ANCHO, ALTO);

//		mapa = new MapaGenerado(40, 40);

		teclado = new Teclado();
		addKeyListener(teclado);

		mapa = new MapaCargado("../mapa/Mapa1.png");
		jugador = new Jugador(mapa, teclado, Sprite.ABAJO2, 600, 300);

		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.setUndecorated(false);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

	}

	public void run() {
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJECTIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJECTIVO;

		long referenciaActualizacon = System.nanoTime();
		long referenciaContador = System.nanoTime();

		double tiempoTranscurrido;
		double delta = 0;

		requestFocus();

		while (enFuncionamiento) {
			final long inicioBucle = System.nanoTime();
			tiempoTranscurrido = inicioBucle - referenciaActualizacon;
			referenciaActualizacon = inicioBucle;
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				actualizar();
				delta--;
			}

			mostrar();

			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
//				ventana.setTitle(NOMBRE + " || APS: " + aps + " || FPS: " + fps);
				CONTADOR_APS = "APS: " + aps;
				CONTADOR_FPS = "FPS: " + fps;
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}

	private void actualizar() {
		teclado.actualizar();
		jugador.actualizar();

		if (teclado.salir) {
			System.exit(0);
		}

		aps++;
	}

	private void mostrar() {
		BufferStrategy estrategy = getBufferStrategy();
		if (estrategy == null) {
			createBufferStrategy(3);
			return;
		}

		mapa.mostrar(jugador.obtenX() - pantalla.getAncho() / 2 + jugador.obtenSprite().getLado() / 2,
				jugador.obtenY() - pantalla.getAlto() / 2 + jugador.obtenSprite().getLado() / 2, pantalla);
		jugador.mostrar(pantalla);

		System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
		Graphics g = estrategy.getDrawGraphics();

		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.RED);
		g.drawString(CONTADOR_APS, 10, 20);
		g.drawString(CONTADOR_FPS, 10, 35);
		g.drawString("Y -> " + String.valueOf(jugador.obtenY() + " X-> " + String.valueOf(jugador.obtenX())), 10, 50);
		g.dispose();

		estrategy.show();

		fps++;
	}

	private synchronized void iniciar() {
		enFuncionamiento = true;
		thread = new Thread(this, "Graficos");
		thread.start();
	}

	private synchronized void detener() {
		enFuncionamiento = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
