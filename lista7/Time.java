
import java.time.LocalTime;

public class Time {
  private int segundos;
  static final private int max = 86400;

  private boolean horaValida(int horas, int minutos, int segundos) {
    if (horas < 0 || horas > 24)
      return false;
    if (horas == 24 && minutos == 60)
      return false;
    if (minutos < 0 || minutos > 60)
      return false;
    if (segundos < 0 || segundos > 60)
      return false;
    return true;
  }

  Time(int horas, int minutos, int segundos) {
    if (horaValida(horas, minutos, segundos)) {
      this.segundos = segundos;
      this.segundos += minutos * 60;
      this.segundos += horas * 3600;
    } else {
      this.segundos = 0;
    }
  }

  Time(int horas, int minutos) {
    this(horas, minutos, 0);
  }

  Time(int horas) {
    this(horas, 0);
  }

  Time() {
    this(0);
  }

  Time(Time base) {
    this.segundos = base.segundos;
  }

  public void print() {
    System.out.println("A hora é: " + this.toString());
  }

  public String toString() {
    int aux = segundos;
    int hr = aux / 3600;
    aux -= hr * 3600;
    int minutos = aux / 60;
    aux -= minutos * 60;
    return hr + ":" + minutos + ":" + aux;
  }

  public boolean isAm() {
    return isAm(this);
  }

  public void addTime(int seconds) {
    this.segundos += seconds;
    if (this.segundos > max)
      this.segundos %= max;
  }

  public void addTime(int m, int s) {
    addTime(s + (m * 60));
  }

  public void addTime(int h, int m, int s) {
    addTime(s + (m * 60) + (h * 3600));
  }

  public void addTime(Time outro) {
    addTime(outro.segundos);
  }

  // retorna a quantidade de segundos transcorridos até a hora
  // enviada como parâmetro, se o parâmetros outraHora for anterior ao tempo do
  // objeto
  // considerar que o parâmetro se refere ao dia seguinte
  public int cron(Time outraHora) {
    Time resultado = calculaDiferenca(this, outraHora);
    return resultado.segundos;
  }

  private static Time calculaDiferenca(Time t1, Time t2) {
    int diferencaTempo;
    if (t2.segundos >= t1.segundos) {
      diferencaTempo = t2.segundos - t1.segundos;
    }

    diferencaTempo = (max - t1.segundos) + t2.segundos;

    // cria um objeto com a diferença
    Time objDiferenca = new Time(0);
    objDiferenca.addTime(diferencaTempo);
    return objDiferenca;
  }

  public static Time diffTime(Time t1, Time t2) {
    return calculaDiferenca(t1, t2);
  }

  // outro parâmetro é a hora atual
  public static Time diffTime(Time t) {
    LocalTime horaAtual = LocalTime.now();
    Time atual = new Time(horaAtual.getHour(), horaAtual.getMinute(), horaAtual.getSecond());
    return calculaDiferenca(t, atual);
  }

  public static boolean isAm(Time t) {
    if (t.segundos <= max / 2)
      return true;
    return false;
  }

  public static boolean isPm(Time t) {
    return !isAm(t);
  }

  public int getSegundos() {
    return segundos;
  }
}