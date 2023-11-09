import java.util.Calendar;

public class Contato {
  private String nome, email, telefone;
  private Data dataNasc;

  public Contato(String nome, String telefone, String email, Data data) {
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.dataNasc = data;
  }

  // sem data e email
  public Contato(String nome, String telefone) {
    this(nome, telefone, "-", new Data());
  }

  // sem email
  public Contato(String nome, String telefone, Data data) {
    this(nome, telefone, "-", data);
  }

  // sem data
  public Contato(String nome, String telefone, String email) {
    this(nome, email, telefone, new Data());
  }

  public void imprimirContato() {
    System.out.println("---");
    System.out.println(nome);
    System.out.println("Email: " + email);
    System.out.println("Telefone: " + telefone);
    System.out.print("Data de Nascimento: ");
    dataNasc.imprimirData();
    System.out.println();
  }

  public int calcularIdade() {
    if (dataNasc.getAno() == 0)
      return 0;
    int anoHoje = Calendar.getInstance().get(Calendar.YEAR);
    return anoHoje - dataNasc.getAno();
  }

  public int getIdade() {
    return calcularIdade();
  }

  public Data getDataNasc() {
    return dataNasc;
  }

  public String getEmail() {
    return email;
  }

  public String getNome() {
    return nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setDataNasc(Data dataNasc) {
    this.dataNasc = dataNasc;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}
