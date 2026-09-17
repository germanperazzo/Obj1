package ar.edu.unlp.info.oo1.ej8;



public class Cuerpo3D {
	private double altura;
	private Figura caraBasal;
	
	public void setAltura(double a) {
		this.altura = a;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setCaraBasal(Figura c) {
		this.caraBasal = c;
	}
	
	public double getVolumen() {
		return (this.caraBasal.getArea() * this.getAltura());
	}
	public double getSuperficieExterior() {
		return (2 * this.caraBasal.getArea() + this.caraBasal.getPerimetro() * this.getAltura());
	}
}
