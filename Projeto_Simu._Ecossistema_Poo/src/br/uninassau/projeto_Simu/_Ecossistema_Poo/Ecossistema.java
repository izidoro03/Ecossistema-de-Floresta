package br.uninassau.projeto_Simu._Ecossistema_Poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ecossistema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Simulador de Ecossistema!");
        System.out.print("Digite o numero de ciclos que deseja simular: ");
        int numeroCiclos = scanner.nextInt();

        if (numeroCiclos > 0) {
            List<Animal> animais = new ArrayList<>();
            List<Planta> plantas = new ArrayList<>();
            FenomenosNaturais fenomenos = new FenomenosNaturais();
            Random random = new Random();

            Predador onca = new Predador("Onca", 5);
            Presa capivara = new Presa("Capivara", 3);

            Predador aguia = new Predador("Aguia", 7);
            Presa cobra = new Presa("Cobra", 2);

            
            animais.add(new Onca("Onca"));
            animais.add(new Capivara("Capivara"));
            animais.add(new Aguia("Aguia"));
            animais.add(new Cobra("Cobra"));

            plantas.add(new Planta("Camomila"));
            plantas.add(new Planta("Espada de Sao Jorge"));

            for (int ciclo = 0; ciclo < numeroCiclos; ciclo++) {
                System.out.println("CICLO " + (ciclo + 1));
                fenomenos.simularFenomenosNaturaisAleatorios(); 

                boolean chovendo = fenomenos.estaChovendo(); 

                if (chovendo) {
                    System.out.println("Esta chovendo.");
                } else {
                    System.out.println("O dia esta ensolarado.");
                }

                onca.cacarPresa(capivara);
                capivara.fugir();

  

                for (Animal animal : animais) {
                    animal.realizarAcaoAleatoria();
                }

                for (Planta planta : plantas) {
                    planta.crescer();
                    planta.realizarAcaoAleatoria(fenomenos);
                }

                for (int i = 0; i < 1; i++) {
                    for (Animal animal1 : animais) {
                        animal1.envelhecer();
                        if (random.nextBoolean()) {
                            animal1.mover();
                        }
                        aguia.cacarPresa(cobra);
                        cobra.fugir();
                    }
                }
            }
        } else {
            System.out.println("Numero invalido.");
        }
    }
}
