package io.maroni.model;

/**
 * Created by Vanderson Maroni on 10/03/2017.
 */
public class Usuario {
  private String nome;
  private int dinheiro;
  private boolean moderador;

  public Usuario(String nome, int dinheiro) {
    this.nome = nome;
    this.dinheiro = dinheiro;
    this.moderador = false;
  }

  public Usuario(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public int getDinheiro() {
    return dinheiro;
  }

  public void tornarModerador(){
    this.moderador = true;
  }

  public boolean isModerador() {
    return moderador;
  }

  @Override
  public String toString() {
    return "Usuario{" +
            "nome='" + nome + '\'' +
            ", pontos=" + dinheiro +
            ", moderador=" + moderador +
            '}';
  }
}
