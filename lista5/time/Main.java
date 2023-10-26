package time;

public class Main {
  public static void main(String[] args) {
    Time hora1 = new Time(3);
    hora1.exibe();

    Time hora2 = new Time(3, 22);
    hora2.exibe();
    System.out.println(hora2.isAm());
    System.out.println(hora1.cron(hora2));
    System.out.println(hora2.cron(hora1));
    System.out.println(hora1.cron(hora1));
  }
}
