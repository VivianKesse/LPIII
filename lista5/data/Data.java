package data;

import java.util.Calendar;

public class Data {
  private int dia, mes, ano;
  private boolean valido = false;
  private final String[] nomeMeses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
      "Setembro", "Outubro", "Novembro", "Dezembro" };
  private final String[] diasDaSemana = { "Sábado", "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira",
      "Quinta-feira", "Sexta-feira" };

  Data(int d, int m, int a) {
    if (verificarData(d, m, a)) {
      dia = d;
      mes = m;
      ano = a;
    } else {
      dia = 0;
      mes = 0;
      ano = 0;
    }
  }

  Data() {
    this(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
  }

  Data(int dia) {
    this(dia, Calendar.getInstance().get(Calendar.MONTH) + 1);
  }

  Data(int dia, int mes) {
    this(dia, mes, Calendar.getInstance().get(Calendar.YEAR));
  }

  private boolean verificarData(int dd, int mm, int aa) {
    boolean valido = true;
    if (dd <= 0 || dd > 31)
      valido = false;
    if (mm <= 0 || mm > 12)
      valido = false;
    this.valido = valido;
    return valido;
  }

  public int getDia() {
    return dia;
  }

  public int getMes() {
    return mes;
  }

  public int getAno() {
    return ano;
  }

  public boolean getValido() {
    return valido;
  }

  public void imprimirData() {
    String texto;
    if (valido) {
      texto = ano < 0 ? dia + "/" + mes + "/" + (ano * (-1)) + " A.C." : dia + "/" + mes + "/" + ano;
    } else {
      texto = "Essa data não é válida";
    }
    System.out.println(texto);
  }

  public void imprimirDataExtenso() {
    if (!valido) {
      System.out.println("Essa data não é válida");
      return;
    }

    String texto;
    int m = mes - 1;
    texto = ano < 0 ? dia + " de " + nomeMeses[m] + " de " + (ano * (-1)) + " A.C."
        : dia + " de " + nomeMeses[m] + " de " + ano;
    System.out.println(texto);
  }

  // boolean isPrevious(Data outraData): retorna verdadeiro se a data, que
  // passamos
  // por parâmetro, é anterior a data do objeto;
  public boolean isPrevious(Data outra) {
    if (!this.valido && !outra.valido)
      return false;

    if (outra.ano < this.ano)
      return true;
    else if (outra.ano == this.ano) {
      if (outra.mes < this.mes)
        return true;
      else if (outra.mes == this.mes) {
        if (outra.dia < this.dia)
          return true;
      }
    }
    return false;
  }

  // int howManyDays(Data outraData): retorna a quantidade de dias até a data
  // enviada como parâmetros, se a data for anterior o valor retornado deve ser
  // negativo
  public int howManyDays(Data outra) {
    int diaIni = this.getDia(), mesIni = this.getMes(), anoIni = this.getAno();
    int diaFim = outra.getDia(), mesFim = outra.getMes(), anoFim = outra.getAno();

    int difAno = (anoFim - anoIni) * 365;
    int difMes = (mesFim - mesIni) * 30;
    int difDia = diaFim - diaIni;

    return difAno + difMes + difDia;
  }

  // String dayOfWeek(): retorna o dia da semana representado pela data;
  public String dayOfWeek() {
    int d = this.getDia(), m = this.getMes(), y = this.getAno();
    int numDiaSemana = ((d + ((m + 1) * 26 / 10) + y + (y / 4) + (6 * (y / 100)) + (y / 400)) % 7);
    return diasDaSemana[numDiaSemana];
  }
}
