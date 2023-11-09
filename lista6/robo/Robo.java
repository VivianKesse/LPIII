public class Robo {
  private String nomeRobo;
  private int xAtual, yAtual;
  private char direcaoAtual;

  Robo(String nome, int px, int py, char d) {
    nomeRobo = nome;
    xAtual = px;
    yAtual = py;
    direcaoAtual = d;
  }

  Robo(String nome) {
    this(nome, 0, 0, 'N');
  }

  Robo() {
    this("Gepeto");
  }

  public void move() {
    this.move(1);
  }

  public void move(int passos, String direcao) {
    if (direcao.length() == 2) {
      char direcaoAnterior = getDirecaoAtual();
      // primeira direção
      if (direcao.charAt(0) == 'N') {
        mudaDireção('N');
      } else {
        mudaDireção('S');
      }
      move(passos);

      // segunda direção
      if (direcao.charAt(1) == 'O') {
        mudaDireção('O');
      } else {
        mudaDireção('E');
      }
      move(passos);

      // retorna para a direção inicial
      mudaDireção(direcaoAnterior);
    }
  }

  public void move(int passos) {
    if (direcaoAtual == 'N')
      yAtual += passos;
    else if (direcaoAtual == 'S')
      yAtual -= passos;
    else if (direcaoAtual == 'E')
      xAtual += passos;
    else if (direcaoAtual == 'O')
      xAtual -= passos;
  }

  public void mudaDireção(char novaDirecao) {
    if (direcaoAtual == 'N')
      direcaoAtual = novaDirecao;
    else if (direcaoAtual == 'S')
      direcaoAtual = novaDirecao;
    else if (direcaoAtual == 'E')
      direcaoAtual = novaDirecao;
    else if (direcaoAtual == 'O')
      direcaoAtual = novaDirecao;
  }

  public void print() {
    System.out.println();
    System.out.println("---Robô ---");
    System.out.println("Nome: " + nomeRobo);
    System.out.println("Posicao atual: (" + xAtual + ", " + yAtual + ")");
    System.out.println("Direção: " + direcaoAtual);
  }

  public char getDirecaoAtual() {
    return direcaoAtual;
  }
}
