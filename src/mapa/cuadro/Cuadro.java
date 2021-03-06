package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class Cuadro {

	private int x;
	private int y;

	public Sprite sprite;

	private boolean solido;

	public static final int LADO = 32;

	// COLECCION DE CUADROS
	public static final Cuadro VACIO = new Cuadro(Sprite.VACIO, true);

	public static final Cuadro HIERBA = new Cuadro(Sprite.HIERBA);

	public static final Cuadro TRONCO_CORTADO = new Cuadro(Sprite.TRONCO_CORTADO);

	public static final Cuadro ARBUSTO = new Cuadro(Sprite.ARBUSTO);

	public static final Cuadro ARBUSTO_FLOR_BLANCA = new Cuadro(Sprite.ARBUSTO_FLOR_BLANCA);

	public static final Cuadro ARBUSTO_FLOR_AMARILLA = new Cuadro(Sprite.ARBUSTO_FLOR_AMARILLA);

	public static final Cuadro FLOR_ROJA = new Cuadro(Sprite.FLOR_ROJA);

	public static final Cuadro ARBOL_ARRIBA_IZQUIERDA = new Cuadro(Sprite.ARBOL_ARRIBA_IZQUIERDA, true);
	public static final Cuadro ARBOL_ARRIBA_DERECHA = new Cuadro(Sprite.ARBOL_ARRIBA_DERECHA, true);
	public static final Cuadro ARBOL_ABAJO_IZQUIERDA = new Cuadro(Sprite.ARBOL_ABAJO_IZQUIERDA, true);
	public static final Cuadro ARBOL_ABAJO_DERECHA = new Cuadro(Sprite.ARBOL_ABAJO_DERECHA, true);

	public static final Cuadro BOSQUE_ARRIBA_IZQUIERDA = new Cuadro(Sprite.BOSQUE_ARRIBA_IZQUIERDA, true);
	public static final Cuadro BOSQUE_ARRIBA_DERECHA = new Cuadro(Sprite.BOSQUE_ARRIBA_DERECHA, true);
	public static final Cuadro BOSQUE_ABAJO_IZQUIERDA = new Cuadro(Sprite.BOSQUE_ABAJO_IZQUIERDA, true);
	public static final Cuadro BOSQUE_ABAJO_DERECHA = new Cuadro(Sprite.BOSQUE_ABAJO_DERECHA, true);

	// FIN DE LA COLECCION

	public Cuadro(Sprite sprite) {
		this.sprite = sprite;
		solido = false;
	}

	public Cuadro(Sprite sprite, boolean solido) {
		this.sprite = sprite;
		this.solido = solido;
	}

	public void mostrar(int x, int y, Pantalla pantalla) {
		pantalla.mostrarCuadro(x << 5, y << 5, this);
	}

	public boolean esSolido() {
		return solido;
	}
}
