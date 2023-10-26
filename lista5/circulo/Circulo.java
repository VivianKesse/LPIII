package circulo;

public class Circulo {
  private Ponto2D centro;
  private float raio;

  private boolean validaCirculo(float r) {
    if (r > 0)
      return true;
    return false;
  }

  Circulo(Ponto2D c, float r) {
    if (validaCirculo(r)) {
      centro = c;
      raio = r;
    } else {
      centro = new Ponto2D(0);
      raio = 1;
    }
  }

  Circulo(Ponto2D c) {
    this(c, 1);
  }

  Circulo() {
    this(new Ponto2D(0), 1);
  }

  public void imprimirCirculo() {
    System.out.print("Círculo de raio: " + raio + " e centro ");
    centro.imprimirPonto();
  }

  boolean isInnerPoint(Ponto2D ponto) {
    double distancia = centro.distancia(ponto);
    if (Math.abs(distancia - raio) < 0.00000001) {
      return true;
    }
    return false;
  }

  double area() {
    return raio * raio * Math.PI;
  }

  double perimeter() {
    return raio * 2 * Math.PI;
  }

  boolean isBiggerThan(Circulo outro) {
    if (this.raio > outro.raio)
      return true;
    return false;
  }

  public Ponto2D getCentro() {
    return centro;
  }

  public float getRaio() {
    return raio;
  }
}
