package Q2;

import javax.xml.crypto.Data;

public class App2 {
  static final int QUANT_CONTATOS = 4;

  public static void main(String[] args) {
    Contato[] cont = new Contato[QUANT_CONTATOS];
    String[] nomes = { "Larissa", "Parsec", "João Manoel", "John" };
    String[] emails = { "lary@gmail.com", "parsec@outlook.com", "joaomanoel@yahoo.com.br", "john@hotmail.com" };
    String[] telefones = { "75 98888-8888", "73 96666-6666", "73 91212-1212", "76 94545-4545" };

    for (int x = 0; x < QUANT_CONTATOS; x++) {
      // cria a data de nascimento
      Data dataNascimento = new Data();
      dataNascimento.inicializarData(x + 1, 2 * (x + 1), 2000 - x);

      // cria o contato
      cont[x] = new Contato();
      cont[x].inicializarContato(nomes[x], emails[x], telefones[x], dataNascimento);
    }

    exibeContatos(cont);

  }

  public static void exibeContatos(Contato[] listaContatos) {
    int idade;
    for (int x = 0; x < QUANT_CONTATOS; x++) {
      listaContatos[x].imprimirContato();
      idade = listaContatos[x].calcularIdade();
      System.out.println("O contato de nome " + listaContatos[x].getNome() + " tem " + idade + " anos");
    }
  }
}
