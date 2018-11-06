package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapa.cuadro.Cuadro;

public class MapaCargado extends Mapa {

	private int[] pixeles;

	public MapaCargado(String ruta) {
		super(ruta);

	}

	protected void cargarMapa(String ruta) {
		try {
			BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
			
			ancho = imagen.getWidth();
			alto = imagen.getHeight();
			
			cuadrosCatalogo = new Cuadro[ancho * alto];
			pixeles = new int[ancho * alto];
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void generarMapa() {
		for (int i = 0; i < pixeles.length; i++) {
			switch (pixeles[i]) {
			case 0xFFFFF549:
				cuadrosCatalogo[i] = Cuadro.ARBUSTO_FLOR_AMARILLA;
				continue;
			case 0xFFFF3033:
				cuadrosCatalogo[i] = Cuadro.FLOR_ROJA;
				continue;
			case 0xFFF7F4FF:
				cuadrosCatalogo[i] = Cuadro.ARBUSTO_FLOR_BLANCA;
				continue;
			case 0xFF7F9DFF:
				cuadrosCatalogo[i] = Cuadro.ARBUSTO;
				continue;
			case 0xFFFFB90A:
				cuadrosCatalogo[i] = Cuadro.TRONCO_CORTADO;
				continue;
			case 0xFF7F0000:
				cuadrosCatalogo[i] = Cuadro.HIERBA;
				continue;
			case 0xFF000000:
				cuadrosCatalogo[i] = Cuadro.BOSQUE_ARRIBA_DERECHA;
				continue;
			case 0xFFFF5BF6:
				cuadrosCatalogo[i] = Cuadro.BOSQUE_ARRIBA_IZQUIERDA;
				continue;
			case 0xFFACFFA8:
				cuadrosCatalogo[i] = Cuadro.BOSQUE_ABAJO_IZQUIERDA;
				continue;
			case 0xFF47FF81:
				cuadrosCatalogo[i] = Cuadro.BOSQUE_ABAJO_DERECHA;
				continue;
			case 0xFFFF5811:
				cuadrosCatalogo[i] = Cuadro.ARBOL_ABAJO_DERECHA;
				continue;
			case 0xFF7F593F:
				cuadrosCatalogo[i] = Cuadro.ARBOL_ABAJO_IZQUIERDA;
				continue;
			case 0xFF240080:
				cuadrosCatalogo[i] = Cuadro.ARBOL_ARRIBA_IZQUIERDA;
				continue;
			case 0xFF5B7F00:
				cuadrosCatalogo[i] = Cuadro.ARBOL_ARRIBA_DERECHA;
				continue;
			default:
				cuadrosCatalogo[i] = Cuadro.HIERBA;
				continue;
			}
		}
	}

}
