package ar.edu.unlp.info.oo1.ej8;



public class Circulo implements Figura{
 	private double radio;
	

	public double getDiametro() {
		return this.getRadio()*2;
	}
	
	public void setDiametro(double d) {
		this.setRadio(d/2);
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	public void setRadio(double r) {
		this.radio = r;
	}
	@Override
	public double getPerimetro() {
		return (Math.PI * this.getDiametro());
	}
	@Override
	public double getArea() {
		return (Math.PI * (Math.pow(this.getRadio(), 2)));
	}
}
