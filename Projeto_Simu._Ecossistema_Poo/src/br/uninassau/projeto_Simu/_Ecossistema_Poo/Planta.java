package br.uninassau.projeto_Simu._Ecossistema_Poo;

import java.util.Random;

public class Planta {
	private String nome;
	private int tamanho;
	
	public Planta(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.tamanho = 1;
	}
	public void crescer() {
		tamanho ++;
		System.out.println(this.nome + " esta crescendo.");

	}
	public void fotosintese() {
		tamanho ++;
		System.out.println(this.nome + " esta fazendo fotossintese.");

	}
    public void realizarAcaoAleatoria(FenomenosNaturais fenomenos) {
        Random random = new Random();
        int escolha = random.nextInt(2);

        if (escolha == 0) {
            crescer();
        } else if (escolha == 1 && fenomenos.estaDiaEnsolarado()) {
            fotosintese();
        }
    }
	    }

