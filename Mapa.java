package teste;

import java.util.Random;

public class Mapa {
	
	//Criação de Variaveis
	//Variavel de mapa de estrutura onde true = tesouro, false = armadilha e null = areia, nele o programa conseguira entender de forma mais rápida e simples
	private Boolean[][] estrutura = new Boolean[8][8];
	//Variavel de mapa visual, nele será mostrado a visão os quesitos visuais como areia(~), tesouro(T), armadilha(A) e buracos(O) para que o usuário entenda 
	private String[][] visual = new String[8][8];
	
	//Contrutor
	public Mapa() {
	}

	//getters e setters 
	public Boolean[][] getEstrutura() {
		return estrutura;
	}

	public void setEstrutura(int x, int y, boolean status) {
		this.estrutura[x][y] = status;
	}

	public String[][] getVisual() {
		return visual;
	}

	public void setVisual(int x, int y, String status) {
		this.visual[x][y] = status;
	}

	
	//Adiciona Tesouros no mapa(como paramento pede-se o número total de Tesouros)
	public void addTesouro(int num){
		Random random = new Random();
		int i=0;
		//ficará em loop enquanto a quantidade total de tesouros não for colocada no mapa
        while (i<num) {
        	//aleatoriza um numero de 0 a 7, assim ficando uma coordenada aleatória
        	int a = random.nextInt(8);
            int b = random.nextInt(8);

            //somente adiciona tesouros se a coordenada aleatória for em uma areia
            if (this.estrutura[a][b] == null) {
            	//adiciona o tesouro
                this.estrutura[a][b] = true;
                //contabiliza o número de tesouros colocados
                i++;
            }
        
        }
    }

	//Adiciona Armadilhas no mapa(como paramento pede-se o número total de Armadilhas)
	public void addArmadilha(int num){
		Random random = new Random();
		int i=0;
		//ficará em loop enquanto a quantidade total de armadilhas não for colocada no mapa
        while (i<num) {
        	//aleatoriza uma coordenada
            int a = random.nextInt(8);
            int b = random.nextInt(8);
            //verifica se o tesouro está sendo colocado em um lugar vazio(areia)
            if (this.estrutura[a][b] == null) {
                //coloca a armadilha no mapa
            	this.estrutura[a][b] = false;
            	//contabiliza as armadilhas colocadas
                i++;
            }
        }
    }

	//Imprime o mapa visual em linhas e colunas
	public void mostrarMapa(){
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < this.visual.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < this.visual.length; j++) {
                System.out.print(this.visual[i][j]+" ");
            }
            System.out.println();
        }
    }
	
	
	//Imprime o mapa completo com tudo escavado(respostas do mapa final)
	public void gameOverMap(){
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < this.estrutura.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < this.estrutura.length; j++) {
                //faz a conferencia de onde tiver areia colocasse um "O", Tesouro "T" e Armadilha "A"
            	if (this.estrutura[i][j] == null) {
                    System.out.print("O ");
                }else if (this.estrutura[i][j] == true) {
                    System.out.print("T ");
                }else{
                    System.out.print("A ");
                }
            }
            System.out.println();
        }
    }

	//Inicializa o mapa visual para areia em tudo
	public void inicializarVisual() {
		for (int i = 0; i < this.visual.length; i++) {
            for (int j = 0; j < this.visual.length; j++) {
                this.visual[i][j] = "~";
            }
            System.out.println();
        }
	}
}
