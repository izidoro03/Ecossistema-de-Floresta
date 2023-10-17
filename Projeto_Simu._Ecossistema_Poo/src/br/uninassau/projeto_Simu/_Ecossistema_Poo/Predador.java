package br.uninassau.projeto_Simu._Ecossistema_Poo;


public class Predador extends Animal {
    private boolean cacouEsteCiclo; 

    public Predador(String nome, int idade) {
        super(nome, idade);
        cacouEsteCiclo = false; 
    }

    public void cacarPresa(Animal presa) {
        if (!cacouEsteCiclo) { 
            System.out.println(this.getNome() + " esta cacando " + presa.getNome() + "!");
            if (Math.random() < 0.5) {
                System.out.println(this.getNome() + " pegou " + presa.getNome() + "!");
                comer(presa);
                cacouEsteCiclo = true;
            } else {
                System.out.println(presa.getNome() + " escapou!");
            }
        } 
        }

    public void comer(Animal presa) {
        System.out.println(this.getNome() + " esta comendo " + presa.getNome() + "!");
    }
}

