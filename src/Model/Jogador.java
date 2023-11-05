package Model;

import Interfaces.IJogador;

import java.time.LocalDate;
import java.util.Random;

public class Jogador implements IJogador {
    private int id;
    public String nome;
    public LocalDate dataDeNascimento;
    public int numero;
    public String posicao;
    private int qualidade = 50;
    public int cartoes;
    public boolean suspenso = false;
    public boolean treinou = false;

    public Jogador(int id, String nome, LocalDate dataDeNascimento, int numero, String posicao) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.numero = numero;
        this.posicao = posicao;
    }

    @Override
    public boolean verificarCondicaoDeJogo() {
        if(suspenso){
            System.out.println("Não está apto a jogar");
        }else{
            System.out.println("Está apto a jogar");
        }
        return false;
    }

    @Override
    public void aplicarCartaoAmarelo(int quantidade) {
        if(quantidade > 3){
            quantidade = 3;
        }
        cartoes += quantidade;
        if(cartoes ==3){
            suspenso = true;
            System.out.println("Jogador Suspenso");
        }

    }

    @Override
    public void aplicarCartaoVermelho() {
        suspenso = true;
        System.out.println("Jogador Suspenso");

    }

    @Override
    public void sofrerLesao() {
        Random random = new Random();
        int probabilidade = random.nextInt(1,100);
        int decremento = 0;
        if (probabilidade < 5) {
            decremento = 1;
        } else if (probabilidade < 15) {
            decremento = 2;
        } else if (probabilidade < 30) {
            double porcentagem = this.qualidade * 0.05;
            decremento = (int) porcentagem;
        } else if (probabilidade < 60) {
            double porcentagem = this.qualidade * 0.1;
            decremento = (int) porcentagem;
        } else {
            double porcentagem = this.qualidade * 0.15;
            decremento = (int) porcentagem;
        }
        this.qualidade = this.qualidade - decremento;
        System.out.println("Probabilidade: " + probabilidade);
        System.out.println("Decremento: " + decremento);
        System.out.println("Qualidade: " + this.qualidade);


    }

    @Override
    public void cumprirSuspencao() {
        cartoes = 0;
        suspenso = false;

    }

    @Override
    public void executarTreinamento() {
        if (treinou) {
            System.out.println("O jogador já treinou antes desta partida. Treinamento permitido apenas uma vez por partida.");
            return;
        }
        Random random = new Random();
        int probabilidade = random.nextInt(1,100);
        int incremento = 0;

        if (probabilidade < 5) {
            incremento = 5;
        } else if (probabilidade < 15) {
            incremento = 4;
        } else if (probabilidade < 30) {
            incremento = 3;
        } else if (probabilidade < 60) {
            incremento = 2;
        } else {
            incremento = 1;
        }

        treinou = true;
        qualidade = Math.min(100, this.qualidade + incremento);
        System.out.println("Qualidade:" + qualidade);
        System.out.println("Incremento:" + incremento);
        System.out.println("Probabilidade:" + probabilidade);

    }
    @Override
    public void prepararParaProximaPartida() {
        treinou = false;
}
}