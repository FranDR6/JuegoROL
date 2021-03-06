package entes.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

public class Jugador extends Criatura {

	private Teclado teclado;

	private int animacion;

	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite) {
		this.mapa = mapa;
		this.teclado = teclado;
		this.sprite = sprite;

	}

	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite, int posicionX, int posicionY) {
		this.mapa = mapa;
		this.teclado = teclado;
		this.sprite = sprite;
		this.x = posicionX;
		this.y = posicionY;
	}

	public void actualizar() {

		int desplazamientoX = 0;
		int desplazamientoY = 0;

		int velocidadMovimiento = 1;

		if (animacion < 32767) {
			animacion++;
		} else {
			animacion = 0;
		}

		if (teclado.correr) {
			velocidadMovimiento = 2;
		}

		if (teclado.arriba) {
			desplazamientoY -= velocidadMovimiento;
		}
		if (teclado.abajo) {
			desplazamientoY += velocidadMovimiento;
		}
		if (teclado.izquierda) {
			desplazamientoX -= velocidadMovimiento;
		}
		if (teclado.derecha) {
			desplazamientoX += velocidadMovimiento;
		}

		if (desplazamientoX != 0 || desplazamientoY != 0) {
			mover(desplazamientoX, desplazamientoY);
			enMovimiento = true;
		} else {
			enMovimiento = false;
		}

		if (direccion == 'n') {
			sprite = sprite.ARRIBA1;
			if (enMovimiento) {
				int resto = animacion % 30;
				if (resto > 15 && resto <= 20) {
					sprite = sprite.ARRIBA2;
				} else if (resto > 20) {
					sprite = sprite.ARRIBA3;
				} else {
					sprite = sprite.ARRIBA2;
				}
			}
		}
		if (direccion == 'e') {
			sprite = sprite.DERECHA1;
			if (enMovimiento) {
				int resto = animacion % 30;
				if (resto > 15 && resto <= 20) {
					sprite = sprite.DERECHA2;
				} else if (resto > 20) {
					sprite = sprite.DERECHA3;
				} else {
					sprite = sprite.DERECHA2;
				}
			}
		}
		if (direccion == 's') {
			sprite = sprite.ABAJO1;
			if (enMovimiento) {
				int resto = animacion % 30;
				if (resto > 15 && resto <= 20) {
					sprite = sprite.ABAJO2;
				} else if (resto > 20) {
					sprite = sprite.ABAJO3;
				} else {
					sprite = sprite.ABAJO2;
				}
			}
		}
		if (direccion == 'o') {
			sprite = sprite.IZQUIERDA1;
			if (enMovimiento) {
				int resto = animacion % 30;
				if (resto > 15 && resto <= 20) {
					sprite = sprite.IZQUIERDA2;
				} else if (resto > 20) {
					sprite = sprite.IZQUIERDA3;
				} else {
					sprite = sprite.IZQUIERDA2;
				}
			}
		}
	}

	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarJugador(x, y, this);

	}

}
