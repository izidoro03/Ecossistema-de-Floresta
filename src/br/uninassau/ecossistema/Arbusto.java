package br.uninassau.ecossistema;

import br.uninassau.ecossistema.animais.Animal;

public class Arbusto extends Planta {

	public Arbusto(int atualX, int atualY) {
		super('*', "Arbusto", atualX, atualY);
	}

	
	public void esconderAnimal(Animal animal) {
		System.out.printf("%c esta escondido %n", animal.getabbreviation());
	}
}