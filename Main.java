package teste;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		//Inicializa o mapa definindo o número de tentativas, tesouros e armadilhas.
        Scanner input = new Scanner(System.in);
        Mapa mp = new Mapa();
        final int maxTesouro = 8;
        Jogo jg = new Jogo(25, maxTesouro, 5); // tentativas, tesouros, armadilhas

		// Depois de inicar entra em loop while, e continua até não estourar o limite ou achar todos os tesouros.
        jg.iniciar(mp); 
        while (jg.getTentativas() > 0 && jg.getTesourosEncontrados() < maxTesouro) {
            mp.mostrarMapa();
            System.out.println("Você tem " + jg.getTentativas() + " tentativas restantes.");

            jg.setX(lerCoordenada(input, "linha"));
            jg.setY(lerCoordenada(input, "coluna"));

            if (jg.verificarEscavacao(mp)) {
                jg.setPontuacao(jg.getPontuacao() + jg.cavar(mp));
                jg.setTentativas(jg.getTentativas() - 1);
            }
        }

        jg.finalizar(mp);
    }

	//Lê as coordenadas e verifica se são coordenadas válidas 
    public static int lerCoordenada(Scanner input, String eixo) {
        int valor = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print("Digite a " + eixo + " da escavação (0 a 7): ");
            if (input.hasNextInt()) {
                valor = input.nextInt();
                if (valor >= 0 && valor <= 7) {
                    valido = true;
                } else {
                    System.out.println("Número fora do intervalo permitido. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                input.next(); 
            }
        }

        return valor;
    }
}
