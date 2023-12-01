package br.uninassau.ecossistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.uninassau.ecossistema.animais.Animal;
import br.uninassau.ecossistema.animais.Anta;
import br.uninassau.ecossistema.animais.Coelho;
import br.uninassau.ecossistema.animais.Leao;
import br.uninassau.ecossistema.animais.Onca;
import br.uninassau.ecossistema.animais.Zebra;

public class AcoesEcossistem {
	private List<Animal> animals = new ArrayList<>();
	private List<Planta> plantas = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	private Terreno terreno;
	public AcoesEcossistem() {

		terreno = new Terreno(10);

		System.out.println("Digite quantos leoes voce quer no terreno: ");
		int quantLeao = sc.nextInt();
		System.out.println("Digite quantos oncas voce quer no terreno: ");
		int quantOnca = sc.nextInt();
		System.out.println("Digite quantos coelhos voce quer no terreno: ");
		int quantCoelho = sc.nextInt();
		System.out.println("Digite quantas antas voce quer no terreno: ");
		int quantAnta = sc.nextInt();
		System.out.println("Digite quantos zebras voce quer no terreno: ");
		int quantZebra = sc.nextInt();
		System.out.println("Digite quantos arbustos voce quer no terreno: ");
		int quantArbustos = sc.nextInt();
		System.out.println("Digite quantas arvores voce quer no terreno: ");
		int quantArvores = sc.nextInt();

		for (int i = 0; i < quantLeao; i++) {
			animals.add(new Leao((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		for (int i = 0; i < quantOnca; i++) {
			animals.add(new Onca((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		for (int i = 0; i < quantCoelho; i++) {
			animals.add(new Coelho((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		for (int i = 0; i < quantAnta; i++) {
			animals.add(new Anta((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		for (int i = 0; i < quantZebra; i++) {
			animals.add(new Zebra((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		for (int i = 0; i < quantArvores; i++) {
			plantas.add(new Arvore((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}
		for (int i = 0; i < quantArbustos; i++) {
			plantas.add(new Arbusto((int) (Math.random() * 10), (int) (Math.random() * 10)));
		}

		System.out.println("Iniciando Ecossistema...");
	}

	public void iniciarEcossistema() {
		terreno.exibirTerreno(animals, plantas);

		while (true) {
			for (Animal animal : animals) {
				animal.andar(terreno, animals);
			}
			
			for (Planta planta : plantas) {
				for (Animal animal : animals) {
					if (animal.getSpecies().equals("Presa") && planta.getType().equals("Arbusto")) {
						if (animal.getAtualX() == planta.getAtualX() && animal.getAtualY() == planta.getAtualY())
							((Arbusto) planta).esconderAnimal(animal);
					}
				}
			}

			for (Planta planta : plantas) {
				for (Animal animal : animals) {
					if (animal.getSpecies().equals("Presa") && planta.getType().equals("Arvore")) {
						if (animal.getAtualX() == planta.getAtualX() && animal.getAtualY() == planta.getAtualY())
							((Arvore) planta).alimentarAnimal(animal);
					}
				}
			}

			for (Animal predador : animals) {
			    if (predador.getSpecies().equals("Predador")) {
			        for (Animal presa : animals) {
			            if (presa instanceof Anta && presa.getSpecies().equals("Presa") && predador.podeAtacar(presa)) {
			                if (presa.getLife() > 0 && predador.getAtualX() == presa.getAtualX()
			                        && predador.getAtualY() == presa.getAtualY() && predador.podeAtacar(presa)) {
			                    ((Anta) presa).fazerBarulho();
			                    predador.atacar(presa);
			                    System.out.printf("%s atacou o %s%n", predador.getName(), presa.getName());
			                }
			            }
			        }
			    }
			}

			List<Animal> deadAnimals = new ArrayList<>();

			for (Animal animal : animals) {
				if (animal.getLife() == 0) {
					deadAnimals.add(animal);
				}
			}
			animals.removeAll(deadAnimals);

			terreno.exibirTerreno(animals, plantas);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}