package br.uninassau.ecossistema;

public class Leao extends Animal {
	//

	public Leao(int startX, int startY) {
		super("Leao", "Predador", 'L', 5, startX, startY);
	};

	public void rugir() {
		System.out.println("O leao esta rugindo!");
	};
};