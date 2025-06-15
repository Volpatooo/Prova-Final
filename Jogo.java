package teste;

public class Jogo {
	
	//Criaçao de variáveis
	//Coordenadas
	private int x;
	private int y;
	
	private int tentativas;//Número total de tentativas(padrão 25)
	private int tesouros;//Número total de tesouros(padrão 8)
	private int armadilhas;//Número total de armadilhas(padrão 5)
	private int tesourosEncontrados;//Número de tesouros encontrados pelo usuário
	private int pontuacao;//Pontuação do usuário
	
	
	//Construtores
	public Jogo() {
	}

	public Jogo(int tentativas, int tesouros, int armadilhas) {
		this.tentativas = tentativas;
		this.tesouros = tesouros;
		this.armadilhas = armadilhas;
	}
	
	
	//getters e setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTentativas() {
		return tentativas;
	}

	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	public int getTesouros() {
		return tesouros;
	}

	public void setTesouros(int tesouros) {
		this.tesouros = tesouros;
	}

	public int getArmadilhas() {
		return armadilhas;
	}

	public void setArmadilhas(int armadilhas) {
		this.armadilhas = armadilhas;
	}

	public int getTesourosEncontrados() {
		return tesourosEncontrados;
	}

	public void setTesourosEncontrados(int tesourosEncontrados) {
		this.tesourosEncontrados = tesourosEncontrados;
	}

	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	
	//Descobre um lugar no mapa conforme as coordenadas solicitadas. O método retorna a pontuação a mais que o usuário ganhou ao cavar algo importante
	public int cavar(Mapa mp) {
		//revela o que está na areia, se for true coloca uma "T"(tesouro) no mapa visual, caso false um "A"(armadilha) e null "O"(buraco vazio(substituindo a areia)) 
		if (mp.getEstrutura()[x][y] == null) {
            mp.setVisual(x, y, "O");
            System.out.println("Não achou nada além de areia");
            return 0;
        }else if (mp.getEstrutura()[x][y] == true) {
            mp.setVisual(x, y, "T");
            System.out.println("Boa! Você encontrou um Tesouro");
            System.out.println("+10 pontos");
            this.tesourosEncontrados++;
            return 10;
        }else{
            mp.setVisual(x, y, "A");
            System.out.println("Essa não! Você cavou uma armadilha ;-;");
            System.out.println("-5 pontos");
            return -5;
        }
	}

	//Verifica se as coordenas de escavação solicitas já não foram cavadas antes
	//retorna true se estiver disponivel para escavação e false se ja foi escavado, logo não pode ser escavado novamente
	public boolean verificarEscavacao(Mapa mp){
        if (!mp.getVisual()[x][y].equals("~")) {
            System.out.println("Parece que você ja escavou esse lugar!");
            return false;
        }else{
            return true;
        }
    }
	
	//inicia o jogo colocando as armadilhas, tesouros e inicializando o mapa visual
	public void iniciar(Mapa mp) {
		mp.addArmadilha(this.armadilhas);
		mp.addTesouro(this.tesouros);
		mp.inicializarVisual();
	}
	
	//finaliza o jogo, colocando uma mensagem de fim de jogo e mostrando se venceu ou perdeu, além dos pontos e seus status
	public void finalizar(Mapa mp) {
		System.out.println("\n\n==============================================");
        System.out.println("                FIM  DE  JOGO                 \n\n");

        //diz ao usuário se ele ganhou(encontrou os 8 tesouros) ou perdeu(acabou o número total de tentivas)
        if (tesourosEncontrados == 8) {
            System.out.println("Parabéns, você conseguiu achar os 8 tesouros");
        }else{
            System.out.println("Parece que suas tentivas acabaram!");
        }

        //mostra o mapa final(com todos os lugares escavados(dizendo as respostas para o jogador)
        mp.gameOverMap();

        System.out.println("Sua pontuação foi de "+ pontuacao +" pontos");

        //fala o status do jogador conforme a sua pontuação
        if (pontuacao >= 70) {
            System.out.println("Explorador Lendário!");
        }else if (pontuacao >= 50 && pontuacao <= 69 ) {
            System.out.println("Caçador de Tesouros Experiente!");
        }else if (pontuacao >= 30 && pontuacao <= 49) {
            System.out.println("Aventureiro Iniciante");
        }else{
            System.out.println("Precisa de mais prática na exploração");
        }
	}


}
