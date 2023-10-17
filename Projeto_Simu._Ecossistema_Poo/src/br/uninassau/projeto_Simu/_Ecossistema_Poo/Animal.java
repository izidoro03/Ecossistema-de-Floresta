package br.uninassau.projeto_Simu._Ecossistema_Poo;

import java.util.Random;

public class Animal {
	private String nome;
	private int idade;
	private int energia;
	private Animal alvo;

	
	public Animal(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.idade = 0;
		this.energia = 100;
		
		}
	public Animal(String nome, Animal alvo) {
	    this.nome = nome;
	    this.alvo = alvo;
	    this.idade = 0;
	    this.energia = 100;
	    this.alvo = alvo;
	}
	
    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void emitirSom() {
        System.out.println("O animal emite um som.");
    }

    public String getNome() {
        return nome;
    }


	  public void mover() {
	        System.out.println(this.nome + " esta se movendo.");
	  }
	
	public void envelhecer() {
		idade++;
		System.out.println(this.nome + " esta envelhecendo.");

	}
	
	public void comer() {
		energia -= 5;
		System.out.println(this.nome + " esta comendo.");
	}
	
	public void beber() {
		energia += 10;
		System.out.println(this.nome + " esta bebendo agua.");
	}
	public void descansar() {
		energia += 15;
		System.out.println(this.nome + " esta descansando.");
	}
	public void realizarAcaoAleatoria() {
	    Random random = new Random();
	    int escolha = random.nextInt(10);

	    if (escolha <= 3) { 
	        mover();
	    } else if (escolha <= 6) { 
	        comer();
	    } else if (escolha <= 8) { 
	        beber();
	    } else { 
	        descansar();
	    }
	}
}

