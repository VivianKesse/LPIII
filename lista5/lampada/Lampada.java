package lampada;

public class Lampada {
  private int nivelLuz;

  void LampadaLuzVariavel() {
  }

  void LampadaLuzVariavel(int nivelLuz) {
    acende(nivelLuz);
  }

  private boolean ehValidoNivelLuz(int luz) {
    boolean valido = true;
    if (luz < 0 || luz > 100)
      valido = false;

    return valido;
  }

  public void acende(int luz) {
    if (ehValidoNivelLuz(luz))
      this.nivelLuz = luz;
  }

  public void apaga() {
    this.nivelLuz = 0;
  }

  public void mostraEstadoAtual() {
    System.out.println("A lâmpada está com nível de luz em " + nivelLuz);
  }

  public boolean estaLigada() {
    if (nivelLuz > 0)
      return true;
    return false;
  }

  public int getNivelLuz() {
    return nivelLuz;
  }
}
