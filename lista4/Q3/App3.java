package Q3;

public class App3 {
  public static void main(String[] args) {
    Lampada lampadaSala = new Lampada();

    lampadaSala.acende(53);
    lampadaSala.mostraEstadoAtual();
    System.out.println(
        "Com o nível em " + lampadaSala.getNivelLuz() + ", a lâmpada está ligada? " + lampadaSala.estaLigada());

    lampadaSala.apaga();
    System.out.println(
        "Com o nível em " + lampadaSala.getNivelLuz() + ", a lâmpada está ligada? " + lampadaSala.estaLigada());
  }
}
