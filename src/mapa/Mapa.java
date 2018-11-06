package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

public abstract class Mapa {

	protected int ancho;
	protected int alto;

	protected int[] cuadro;
	protected Cuadro[] cuadrosCatalogo;

	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		cuadro = new int[ancho * alto];
		generarMapa();
	}

	public Mapa(String ruta) {
		cargarMapa(ruta);
		generarMapa();

	}

	protected void cargarMapa(String ruta) {

	}

	protected void generarMapa() {

	}

	public void actualizar() {

	}

	public void mostrar(int compensacionX, int compensacionY, Pantalla pantalla) {
		pantalla.establecerDiferencia(compensacionX, compensacionY);
		int oeste = compensacionX >> 5;
		int este = (compensacionX + pantalla.getAncho() + Cuadro.LADO >> 5);
		int norte = compensacionY >> 5;
		int sur = (compensacionY + pantalla.getAncho() + Cuadro.LADO >> 5);

		for (int y = norte; y < sur; y++) {
			for (int x = oeste; x < este; x++) {
//				obtenCuadro(x, y).mostrar(x, y, pantalla);
				if (x < 0 || y < 0 || x >= ancho || y >= alto) {
					Cuadro.VACIO.mostrar(x, y, pantalla);
				} else {
					cuadrosCatalogo[x + y * ancho].mostrar(x, y, pantalla);
				}
			}
		}
	}

	public Cuadro obtenCuadro(final int x, final int y) {
		if (x < 0 || y < 0 || x >= ancho || y >= alto) {
			return Cuadro.VACIO;
		}
		switch (cuadro[x + y * ancho]) {
		case 0:
			return Cuadro.HIERBA;
		case 1:
			return Cuadro.ARBUSTO;
		case 2:
			return Cuadro.ARBUSTO_FLOR_AMARILLA;
		case 3:
			return Cuadro.ARBUSTO_FLOR_BLANCA;
		case 4:
			return Cuadro.FLOR_ROJA;
		default:
			return Cuadro.VACIO;
		}
	}
}
