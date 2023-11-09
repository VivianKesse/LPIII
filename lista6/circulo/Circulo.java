public class Circulo extends Ponto2D {
  private float raio;
  private Ponto2D centro;

  private boolean validaCirculo(float r) {
    if (r > 0)
      return true;
    return false;
  }

  Circulo(int x, int y, float r) {
    Ponto2D c = new Ponto2D(x, y);
    if (validaCirculo(r)) {
      centro = c;
      raio = r;
    } else {
      centro = new Ponto2D();
      raio = 1;
    }
  }

  Circulo(int r) {
    this(0, 0, r);
  }

  Circulo(int x, int y) {
    this(x, y, 1);
  }

  Circulo() {
    this(0, 0, 1);
  }

  public void imprimirCirculo() {
    System.out.print("Círculo de raio: " + raio + " e centro ");
    centro.imprimirPonto();
  }

  boolean isInnerPoint(Ponto2D ponto) {
    double distancia = centro.distance(ponto);
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
