
public class App2 {
  public static void main(String[] args) {
    Time hora1 = new Time(12, 0, 1);
    hora1.print();

    Time hora2 = new Time(12, 0);
    hora2.print();
    System.out.println(hora1.isAm());
    System.out.println(hora2.isAm());
    System.out.println(hora1.cron(hora2));
    System.out.println(hora2.cron(hora1));
    System.out.println(hora1.cron(hora1));

    System.out.println(Time.diffTime(hora1, hora2).getSegundos());
    System.out.println(Time.diffTime(hora2).getSegundos());
    System.out.println(Time.isAm(hora1));
    System.out.println(Time.isAm(hora2));
  }
}