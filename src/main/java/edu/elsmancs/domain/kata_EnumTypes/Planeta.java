package edu.elsmancs.domain.kata_EnumTypes;

import java.util.ArrayList;
import java.util.List;

public enum Planeta {
	
	MERCURY(3.303e+23, 2.4397e6), VENUS(4.869e+24, 6.0518e6), EARTH(5.976e+24, 6.37814e6), MARS(6.421e+23, 3.3972e6), JUPITER(1.9e+27,   7.1492e7), SATURN(5.688e+26, 6.0268e7), URANUS(8.686e+25, 2.5559e7), NEPTUNE(1.024e+26, 2.4746e7);

	private double masa = 0d;
	private double radio = 0d;
	private final double g = 6.67300E-11;
	static List<Planeta> planetasTerrestres = new ArrayList<Planeta>();
	static List<Planeta> planetasGaseoso = new ArrayList<Planeta>();
	
	private Planeta(double masa, double radio) {
		
		this.masa = masa;
		this.radio = radio;
		
	}
	
	public double getMasa() {
		return this.masa;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	private double gravity() {
		return g * (getMasa()/Math.pow(this.getRadio(), 2));
	}
	
	public double masaTerricola(double peso) {
		return peso / EARTH.gravity();
	}

	public double pesoSuperficie(double peso) {
		return masaTerricola(peso) * gravity();
	}
	
	static List<Planeta> getPlanetasTerrestres() {
		for (Planeta planeta : Planeta.values()) {
			if (planeta.ordinal() <= 3) {
				planetasTerrestres.add(planeta);
			}
		}
		return planetasTerrestres;
	}
	
	static List<Planeta> getGigantesGaseosos() {
		for (Planeta planeta : Planeta.values()) {
			if (planeta.ordinal() > 3) {
				planetasGaseoso.add(planeta);
			}
		}
		return planetasGaseoso;
	}


}
