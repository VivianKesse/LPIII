import java.util.Random;

public class Multimetro {
    public static void main(String[] args) {
        Random rand = new Random();
        float[] valores = new float[10];
        float soma = 0, media = 0, desvio = 0;
        
        for (int i = 0; i < valores.length; i++) {
            valores[i] = rand.nextFloat();
            soma += valores[i];
        }

        media = soma / valores.length;
        
        for (int i = 0; i < valores.length; i++) {
            desvio += Math.pow(valores[i] - media, 2);
        }
        desvio = (float) Math.sqrt(desvio / (valores.length - 1));

        limpaTela();
        System.out.println("--- Relatório ---");
        for(int i=0; i<valores.length; i++){
            System.out.println("Medição "+ (i+1) +": " + valores[i]);
        }
        System.out.println("Média das medições: "+ media);
        System.out.println("Desvio padrão: " + desvio);
        String msg =  desvio > (media*0.1)?"COM PROBLEMAS":"OK";
        System.out.println("Status do aparelho: "+msg);
    }

    public static void limpaTela(){
        for (short i = 1; i<100; i++) System.out.println("\n");
    }
}