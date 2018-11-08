package graficos;

public class Sprite {
	private final int lado;

	private int x;
	private int y;

	public int[] pixeles;
	private HojaSprites hoja;

	// Sprites terreno
	public static final Sprite VACIO = new Sprite(32, 0);

	public static final Sprite HIERBA = new Sprite(32, 8, 3, HojaSprites.HojaTile);

	public static final Sprite TRONCO_CORTADO = new Sprite(32, 10, 3, HojaSprites.HojaTile);

	public static final Sprite ARBUSTO = new Sprite(32, 14, 3, HojaSprites.HojaTile);

	public static final Sprite ARBUSTO_FLOR_BLANCA = new Sprite(32, 16, 3, HojaSprites.HojaTile);

	public static final Sprite ARBUSTO_FLOR_AMARILLA = new Sprite(32, 6, 3, HojaSprites.HojaTile);

	public static final Sprite FLOR_ROJA = new Sprite(32, 4, 3, HojaSprites.HojaTile);

	public static final Sprite ARBOL_ARRIBA_IZQUIERDA = new Sprite(32, 6, 0, HojaSprites.HojaTile);
	public static final Sprite ARBOL_ARRIBA_DERECHA = new Sprite(32, 7, 0, HojaSprites.HojaTile);
	public static final Sprite ARBOL_ABAJO_IZQUIERDA = new Sprite(32, 6, 1, HojaSprites.HojaTile);
	public static final Sprite ARBOL_ABAJO_DERECHA = new Sprite(32, 7, 1, HojaSprites.HojaTile);

	public static final Sprite BOSQUE_ARRIBA_IZQUIERDA = new Sprite(32, 3, 0, HojaSprites.HojaTile);
	public static final Sprite BOSQUE_ARRIBA_DERECHA = new Sprite(32, 4, 0, HojaSprites.HojaTile);
	public static final Sprite BOSQUE_ABAJO_IZQUIERDA = new Sprite(32, 3, 1, HojaSprites.HojaTile);
	public static final Sprite BOSQUE_ABAJO_DERECHA = new Sprite(32, 4, 1, HojaSprites.HojaTile);

	// Sprite Personajes
	public static final Sprite DERECHA1 = new Sprite(32, 0, 2, HojaSprites.HojaJugador);
	public static final Sprite DERECHA2 = new Sprite(32, 1, 2, HojaSprites.HojaJugador);
	public static final Sprite DERECHA3 = new Sprite(32, 2, 2, HojaSprites.HojaJugador);

	public static final Sprite IZQUIERDA1 = new Sprite(32, 1, 1, HojaSprites.HojaJugador);
	public static final Sprite IZQUIERDA2 = new Sprite(32, 2, 1, HojaSprites.HojaJugador);
	public static final Sprite IZQUIERDA3 = new Sprite(32, 3, 1, HojaSprites.HojaJugador);

	public static final Sprite ABAJO1 = new Sprite(32, 0, 0, HojaSprites.HojaJugador);
	public static final Sprite ABAJO2 = new Sprite(32, 1, 0, HojaSprites.HojaJugador);
	public static final Sprite ABAJO3 = new Sprite(32, 2, 0, HojaSprites.HojaJugador);

	public static final Sprite ARRIBA1 = new Sprite(32, 0, 3, HojaSprites.HojaJugador);
	public static final Sprite ARRIBA2 = new Sprite(32, 1, 3, HojaSprites.HojaJugador);
	public static final Sprite ARRIBA3 = new Sprite(32, 2, 3, HojaSprites.HojaJugador);

	public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja) {
		this.lado = lado;

		pixeles = new int[lado * lado];

		this.x = columna * lado;
		this.y = fila * lado;
		this.hoja = hoja;

		for (int y = 0; y < lado; y++) {
			for (int x = 0; x < lado; x++) {
				pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
			}
		}
	}

	public Sprite(final int lado, final int color) {
		this.lado = lado;
		pixeles = new int[lado * lado];

		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = color;
		}
	}

	public int getLado() {
		return lado;
	}

}
