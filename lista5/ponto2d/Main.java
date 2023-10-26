package ponto2d;

import circulo.Ponto2D;

public class Main {
  public static void main(String[] args) {
    Ponto2D a = new Ponto2D(40, 20);
    Ponto2D b = new Ponto2D(0, 50);

    a.imprimirPonto();
    System.out.println();
    b.imprimirPonto();

    System.out.println("O ponto B está em algum eixo? " + b.isEixos());
    System.out.println("O ponto B está no eixo x? " + b.isEixoX());
    System.out.println("O ponto B está no eixo y? " + b.isEixoY());
    System.out.println();

    System.out.println("A distancia entre A e B é: " + a.distancia(b));

  }
}
