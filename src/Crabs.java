import java.util.Random;

// jogo do crabs
public class Crabs {

    public static void main(String[] args) {
        //variaveis e objetos
        Random random = new Random();
        int dado1, dado2, soma, ponto;
        short count;

        //primeiro estagio
        System.out.println("Estágio 1:");
        dado1 = random.nextInt(7);
        System.out.print("\nDado1: " + dado1);
        dado2 = random.nextInt(7);
        System.out.print("\tDado2: "+dado2);

        soma = dado1 + dado2;
        if (soma == 7 && soma == 11) {
            System.out.println("Venceu");
        } else if (soma == 2 && soma ==3 && soma ==12){
            System.out.println("Perdeu");
        } else {
            //segundo estágio
            ponto = soma;
            
            System.out.println("\n\nEstágio 2:");
            System.out.print("Ponto: " + ponto);
            count = 1;
            do{
                dado1 = random.nextInt(7);
                System.out.print("\nDado1: " + dado1);
                dado2 = random.nextInt(7);
                System.out.println("\tDado2: "+dado2);
                soma = dado1+dado2;
                System.out.println("Jogada "+ count + ": " + soma);

                if (soma ==7 ){
                    System.out.println("Perdeu");
                } else if(soma == ponto) {
                    System.out.println("Venceu");
                } else {
                    count++;
                }
            }while(soma != ponto && soma !=7);
        }
    }
}