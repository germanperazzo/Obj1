package ar.edu.unlp.info.oo1.ej16;

public class PrismaRectangular extends Pieza {
	
	private double ladoMayor;
	private double ladoMenor;
	private double altura;

	
	public PrismaRectangular(String material, String color,double ladoMayor,double ladoMenor,double altura) {
		super(material, color);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}

	@Override
	public double volumen() {
		
		return this.ladoMayor * this.ladoMenor * this.altura;
	}

	@Override
	public double superficie() {
		
		return  2 * (this.ladoMayor * this.ladoMenor + this.ladoMayor * this.altura + this.ladoMenor * this.altura);
	}

}
