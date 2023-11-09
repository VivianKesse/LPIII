public class App5 {

  static final int QUANT_CONTATOS = 4;

  public static void main(String[] args) {

    Contato[] cont = new Contato[QUANT_CONTATOS];
    String[] nomes = { "Vivian", "Kesse", "Theus", "Isac" };
    String[] emails = { "vivian@gmail.com", "kesse@outlook.com", "isac@yahoo.com.br", "theus@hotmail.com" };
    String[] telefones = { "75 982564896", "73 96666-6666", "73 91212-1212", "76 94545-4545" };

    for (int x = 0; x < QUANT_CONTATOS; x++) {
      // cria a data de nascimento
      Data dataNascimento = new Data(x + 1, 2 * (x + 1), 2000 - x);

      // cria o contato
      cont[x] = new Contato(nomes[x], telefones[x], emails[x], dataNascimento);
    }

    exibeContatos(cont);

    // exemplo sem data e sem email
    Contato semEmailData = new Contato("Beltrano", "78933432234");

    System.out.println("\nO contato de nome " + semEmailData.getNome() + " tem " + semEmailData.getIdade() + " anos");
    System.out.println("O seu email é: " + semEmailData.getEmail());

    // exemplo sem email
    Data novaData = new Data(5, 5, 2005);
    Contato semEmail = new Contato("Ciclano", "78933432234", novaData);

    System.out.println("\nO contato de nome " + semEmail.getNome() + " tem " + semEmail.getIdade() + " anos");
    System.out.println("O seu email é: " + semEmail.getEmail());

  }

  public static void exibeContatos(Contato[] listaContatos) {
    for (int x = 0; x < QUANT_CONTATOS; x++) {
      listaContatos[x].imprimirContato();
      System.out
          .println("O contato de nome " + listaContatos[x].getNome() + " tem " + listaContatos[x].getIdade() + " anos");
    }
  }
}