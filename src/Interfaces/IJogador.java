package Interfaces;

public interface IJogador  {
    public boolean verificarCondicaoDeJogo();

    void aplicarCartaoAmarelo(int quantidade);

    public void aplicarCartaoVermelho();
    public void sofrerLesao();
    public void cumprirSuspencao();
    public void executarTreinamento();
    public void prepararParaProximaPartida();

}
