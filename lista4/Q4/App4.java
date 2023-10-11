package Q4;

public class App4 {
  public static void main(String[] args) {
    Ponto2D a = new Ponto2D();
    Ponto2D b = new Ponto2D();

    a.setX(40);
    a.setY(20);
    a.imprimirPonto();
    System.out.println();

    b.setX(0);
    b.setY(50);
    b.imprimirPonto();

    System.out.println("O ponto B está em algum eixo? " + b.isEixos());
    System.out.println("O ponto B está no eixo x? " + b.isEixoX());
    System.out.println("O ponto B está no eixo y? " + b.isEixoY());
    System.out.println();

    System.out.println("A distancia entre A e B é: " + a.distancia(b));

  }
}
