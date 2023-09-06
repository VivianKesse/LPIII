package Batalha;

public class Jogador{
    char[][] mapa = new char[5][5];
    String nome;
    final int MAX_COORD = 4;
    final int MIN_COORD = 0;
    final char VAZIO = '-';
    final char NAVIO = '@';
    final char AFUNDADO = 'X';
    final char BOMBA = 'O';
    boolean ganhou = false;
    short qtdNaviosPerdidos = 0;
    public Jogador(int id){
        // inicializa o mapa
        this.inicializaMapa();
        
        // nome de player
        this.nome = "Player " + id;
    }

    public void inicializaMapa(){
        for (short x = 0; x <= this.MAX_COORD; x++)
            for (short y = 0; y<=this.MAX_COORD; y++) this.mapa[x][y] = this.VAZIO;
    }

    public String insereCoordenadas(int tempx, int tempy){
        boolean existe;
        // validar o máximo
        if (tempx > this.MAX_COORD || tempy > this.MAX_COORD || tempx < this.MIN_COORD || tempy < this.MIN_COORD){
            return "Invalid coordinates. Choose different coordinates.";
        } else {
            existe = false;
            // valida com o mapa
            if (this.mapa[tempx][tempy] == '@'){
                existe = true;
            }
            
            if (existe) {
                return "You already have a ship there. Choose different coordinates.";
            } else {
                this.mapa[tempx][tempy]=this.NAVIO;
                return "";
            }
        }
    }

    public void exibeMapaPlayer(){
        System.out.println("\n\n  0  1  2  3  4");
        for (short x = 0; x <= this.MAX_COORD; x++){
            System.out.print(x);
            for (short y = 0; y<=this.MAX_COORD; y++){
                System.out.print(" "+this.mapa[x][y]+" ");
            }
            System.out.println();
        }
    }

    public void exibeMapaGame(){
        char temp;
        System.out.println("\n\n  0  1  2  3  4");
        for (short x = 0; x <= this.MAX_COORD; x++){
            System.out.print(x);
            for (short y = 0; y<=this.MAX_COORD; y++){
                temp = this.mapa[x][y];
                if (temp == this.NAVIO) System.out.print(" "+ this.VAZIO +" ");
                else System.out.print(" "+this.mapa[x][y]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean atiraEm(Jogador alvo, int tempx, int tempy){
        // validar o máximo
        if (tempx > this.MAX_COORD || tempy > this.MAX_COORD || tempx < this.MIN_COORD || tempy < this.MIN_COORD){
            System.out.println("Invalid coordinates. Choose different coordinates.");
            return false;
        }

        char ponto = alvo.mapa[tempx][tempy];

        if (ponto == this.NAVIO){
            alvo.mapa[tempx][tempy] = this.AFUNDADO;
            System.out.println(this.nome + " hit " + alvo.nome + "'s Ship!!!");
            alvo.qtdNaviosPerdidos ++;
            if (alvo.qtdNaviosPerdidos == Batalha.QTD_NAVIOS) this.ganhou = true;
            return true;
        } else if(ponto == this.VAZIO) {
            alvo.mapa[tempx][tempy] = this.BOMBA;
            System.out.println(this.nome + ", MISSED!");
            return true;
        }  else if (ponto == this.BOMBA || ponto == this.AFUNDADO) {
            System.out.println("You already fired on this spot. Choose different coordinates.");
            return false;
        }
        return true;
    }
 }