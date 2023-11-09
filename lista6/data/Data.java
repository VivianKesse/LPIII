public class Data {
  private int dia, mes, ano;
  private boolean valido = false;
  private final String[] nomeMeses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
      "Setembro", "Outubro", "Novembro", "Dezembro" };
  private final String[] diasDaSemana = { "Sábado", "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira",
      "Quinta-feira", "Sexta-feira" };

  public Data(int d, int m, int a) {
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

  public Data() {
    this(1, 1, 1970);
  }

  public Data(Data outra) {
    this(outra.dia, outra.mes, outra.ano);
  }

  public void setData(int d, int m, int a) {
    if (verificarData(d, m, a)) {
      dia = d;
      mes = m;
      ano = a;
    }
  }

  public void setData(Data outra) {
    setData(outra.dia, outra.mes, outra.ano);
  }

  public void setData(int daquiAxDias) {
    int novoDias = this.dia + daquiAxDias, novoMes = this.mes, novoAno = this.ano;
    if (!diaValido(novoDias)) {
      int mesesCompletos = novoDias / 30;
      novoDias %= 30;
      novoMes += mesesCompletos;
      if (!mesValido(novoMes)) {
        int anosCompletos = novoMes / 12;
        novoMes %= 12;
        novoAno += anosCompletos;
      }
    }
    setData(novoDias, novoMes, novoAno);
  }

  public void setData(byte primeiroDiaDoMesX) {
    if (mesValido(primeiroDiaDoMesX)) {
      setData(1, primeiroDiaDoMesX, this.ano);
    }
  }

  public void setData(short primeiraSegundaDoMesX) {
    if (mesValido(primeiraSegundaDoMesX)) {
      int dia;
      for (dia = 1; dayOfWeek(dia, primeiraSegundaDoMesX, this.ano) != diasDaSemana[2]; dia++)
        ;
      setData(dia, primeiraSegundaDoMesX, this.ano);
    }
  }

  private boolean verificarData(int dd, int mm, int aa) {
    boolean valido = true;
    if (!mesValido(mm))
      valido = false;
    if (!diaValido(dd))
      valido = false;
    this.valido = valido;
    return valido;
  }

  private boolean diaValido(int dia) {
    if (dia <= 0 || dia > 31)
      return false;
    return true;
  }

  private boolean mesValido(int mes) {
    if (mes <= 0 || mes > 12)
      valido = false;
    return true;
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

  public boolean isPrevious(int dia, int mes, int ano) {
    Data outraData = new Data(dia, mes, ano);
    return isPrevious(outraData);
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

  private String dayOfWeek(int dd, int mm, int ano) {
    if (verificarData(dd, mm, ano)) {
      int d = dd, m = mm, y = ano;
      int numDiaSemana = ((d + ((m + 1) * 26 / 10) + y + (y / 4) + (6 * (y / 100)) + (y / 400)) % 7);
      return diasDaSemana[numDiaSemana];
    }
    return "";
  }
}
