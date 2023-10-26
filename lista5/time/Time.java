package time;

public class Time {
  private int segundos;
  final private int max = 86400;

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

  public void exibe() {
    int aux = segundos;
    int hr = aux / 3600;
    aux -= hr * 3600;
    int minutos = aux / 60;
    aux -= minutos * 60;
    System.out.println("A hora é: " + hr + ":" + minutos + ":" + aux);
  }

  public boolean isAm() {
    if ((segundos / 3600) <= 12)
      return true;

    return false;
  }

  public void addSeconds(int seconds) {
    this.segundos += seconds;
    if (this.segundos > this.max)
      this.segundos %= this.max;
  }

  // retorna a quantidade de segundos transcorridos até a hora
  // enviada como parâmetro, se o parâmetros outraHora for anterior ao tempo do
  // objeto
  // considerar que o parâmetro se refere ao dia seguinte
  public int cron(Time outraHora) {
    if (outraHora.segundos >= this.segundos) {
      return outraHora.segundos - this.segundos;
    }

    return (max - this.segundos) + outraHora.segundos;
  }

}