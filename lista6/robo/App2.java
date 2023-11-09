public class App2 {
  public static void main(String[] args) {
    Robo groucho = new Robo("Groucho", 20, 10, 'S');
    Robo chico = new Robo("Chico");
    Robo semNome = new Robo();

    groucho.print();
    chico.print();
    semNome.print();

    System.out.println("\nGroucho se move 10 passos.");
    groucho.move(10);
    System.out.println("\nChico se move 3 passos para noroeste.");
    chico.move(3, "NE");
    System.out.println("\nChico se move 5 passos.");
    chico.move(5);
    System.out.println("\nGepeto se move.");
    semNome.move();

    groucho.print();
    chico.print();
    semNome.print();
  }
}