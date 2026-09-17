package ar.edu.unlp.info.oo1.ej8;

public class Cuadrado implements Figura{
	private double lado;
	
	public void setLado(double l) {
		this.lado = l;
	}
	
	public double getLado() {
		return this.lado;
	}
	
	@Override
	public double getPerimetro() {
		return this.lado*4;
	}
	
	@Override
	public double getArea() {
		return Math.pow(this.lado,2);
	}
}
