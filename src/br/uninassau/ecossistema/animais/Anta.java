package br.uninassau.ecossistema.animais;


public class Anta extends Animal {


	public Anta(int startX, int startY) {
		super("Anta", "Presa", 'A', 1, startX, startY);
	}


	public void fazerBarulho() {
		System.out.println("Anta esta fazendo um barulho esquisito.");
	}

}