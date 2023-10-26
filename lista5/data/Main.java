package data;

public class Main {
  public static void main(String[] args) {
    Data date = new Data(10, 5, 2023);
    date.imprimirData();
    date.imprimirDataExtenso();
    System.out.println();

    Data date2 = new Data(1, 1, -500);
    date2.imprimirData();
    date2.imprimirDataExtenso();
    System.out.println();

    Data date3 = new Data();
    System.out.println("Dia da semana: " + date3.dayOfWeek());
    date3.imprimirData();
    date3.imprimirDataExtenso();
    System.out.println();

    Data date4 = new Data(12, 4, 2023);
    date4.imprimirData();
    date4.imprimirDataExtenso();
    System.out.println();

    System.out.println(date2.isPrevious(date3));
    System.out.println(date3.isPrevious(date2));

    System.out.println("Diferença de dias: " + date4.howManyDays(date));
    System.out.println("Diferença de dias: " + date.howManyDays(date4));
  }
}
