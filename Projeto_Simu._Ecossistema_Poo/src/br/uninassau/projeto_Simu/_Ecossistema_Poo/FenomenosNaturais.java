package br.uninassau.projeto_Simu._Ecossistema_Poo;

import java.util.Random;

public class FenomenosNaturais {
    private boolean chovendo;
    private boolean diaEnsolarado;

    public FenomenosNaturais() {
        this.chovendo = false;
        this.diaEnsolarado = true;
    }
    public void setChovendo(boolean chovendo) {
        this.chovendo = chovendo;
    }
    public void iniciarChuva() {
        chovendo = true;
        diaEnsolarado = false;
    }

    public void pararChuva() {
        chovendo = false;
        diaEnsolarado = true;
    }

    public boolean estaChovendo() {
        return chovendo;
    }

    public boolean estaDiaEnsolarado() {
        return diaEnsolarado;
    }

    public void simularFenomenosNaturaisAleatorios() {
        Random random = new Random();
        int escolha = random.nextInt(2);

        if (escolha == 0) {
            iniciarChuva();
        } else {
            pararChuva();
        }
    }
}
