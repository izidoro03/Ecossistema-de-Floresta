package br.uninassau.ecossistema;


import java.util.List;
import java.util.Random;

public class Animal {

	private char abbreviation;
	private String name, species;
	private int life;
	private int atualX;
	private int atualY;

	
	public Animal(String name, String species, char abbreviation, int life, int startX, int startY) {
		
		this.name = name;
		this.species = species;
		this.abbreviation = abbreviation;
		this.life = life;
		this.atualX = startX;
		this.atualY = startY;
	}


	public String getName() {
		return name;
	};


	public String getSpecies() {
		return species;
	}

	public char getabbreviation() {
		return abbreviation;
	}

	public int getLife() {
		return life;
	}


	public int getAtualX() {
		return atualX;
	}

	public int getAtualY() {
		return atualY;
	}


	public void setLife(int life) {
		this.life = life;
	}


	public void decreaseLife() {
		this.life--;
	}

	public void increaseLife() {
		this.life++;
	}


	public void andar(Terreno terreno, List<Animal> animals) {

		int direcao = new Random().nextInt(4);
		int novoX = atualX;
		int novoY = atualY;

		switch (direcao) {
		case 0: 
			novoX++;
			break;
		case 1: 
			novoX--;
			break;
		case 2: 
			novoY++;
			break;
		case 3: 
			novoY--;
			break;
		}


		if (novoX >= 0 && novoX < terreno.getTamanho() && novoY >= 0 && novoY < terreno.getTamanho()) {
			if (animals.contains(this)) {
				terreno.tirarAnimal(atualX, atualY, animals);
				atualX = novoX;
				atualY = novoY;
				terreno.adicionarAnimal(this, novoX, novoY);
			}

		}
	}

	public boolean podeAtacar(Animal outroAnimal) {
		return this.getSpecies().equals("Predador") && !this.equals(outroAnimal)
				&& outroAnimal.getSpecies().equals("Presa");
	}

	public void atacar(Animal outroAnimal) {
		if (this.podeAtacar(outroAnimal)) {
			outroAnimal.decreaseLife();
		}
	}
	
	public void fazerBarulho() {
        System.out.printf("Algum animal esta fazendo um barulho estranho.\n");
    }
}