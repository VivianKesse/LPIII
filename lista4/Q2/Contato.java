package Q2;

import java.util.Calendar;
import javax.xml.crypto.Data;

public class Contato {
  private String nome, email, telefone;
  private Data dataNasc;

  public void inicializarContato(String nome, String email, String telefone, Data data) {
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.dataNasc = data;
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
    int anoHoje = Calendar.getInstance().get(Calendar.YEAR);
    return anoHoje - dataNasc.getAno();
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
