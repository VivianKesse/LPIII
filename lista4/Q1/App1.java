package Q1;

public class App1 {
  public static void main(String[] args) {
    Data date = new Data();
    date.imprimirData();
    date.inicializarData(1, 1, 2021);
    date.imprimirData();
    date.imprimirDataExtenso();
    System.out.println();
    Data date2 = new Data();
    date2.imprimirData();
    date2.inicializarData(1, 1, -500);
    date2.imprimirData();
    date2.imprimirDataExtenso();
  }
}
