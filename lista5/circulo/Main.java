package circulo;

public class Main {
  public static void main(String[] args) {
    Circulo c1 = new Circulo(new Ponto2D(0, 0));
    c1.imprimirCirculo();
    System.out.println();

    Circulo c2 = new Circulo(new Ponto2D(1, 2), 4);
    c2.imprimirCirculo();
  }

}
