package Ex1;

import java.util.Random;

import javax.swing.JOptionPane;

public class OrdenacaoBubbleSelection {

// Declara o contador como uma variável da classe
	static long contador = 0;

	public static void main(String[] args) {

		// para gerar o vetor
		//int[] v = gerarVetorOrdenado(0, 1000, 1);

		int[] v = gerarVetorDesordenado(0, 100, 100);

		System.out.println("Contando os loops na geração do vetor: " + contador);

		contador = 0;

		// Exemplo do vetor sendo utilizado
		long tempoInicioMilliseconds = System.currentTimeMillis();
		long tempoInicio = System.nanoTime();

		// AQUI !
		// Supondo que esse é o código do algoritmo de busca

		for (int i = 0; i < v.length; i++) {
			contador++;
			System.out.print(v[i] + ", ");
			if ((i + 1) % 100 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Vetor ordenado pelo Bubble Sort");
		
		int[] resultado = BubbleSort(v);
		
		for (int i = 0; i < v.length; i++) {
			contador++;
			System.out.print(resultado[i] + ", ");
			if ((i + 1) % 100 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Vetor ordenado pelo Selection Sort");
		
		int[] resultado2 = SelectionSort(v);
		
		for (int i = 0; i < v.length; i++) {
			contador++;
			System.out.print(resultado2[i] + ", ");
			if ((i + 1) % 100 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println();
		
		int frase = Integer.parseInt(JOptionPane.showInputDialog("Digite um número dentro do vetor"));
		
		int resultado3 = buscaRecursiva(v, 0, v.length, frase);
		
		System.out.println("O número digitado está na posição " + resultado3);
		
		long tempoFinalMilliseconds = System.currentTimeMillis();
		long tempoFinal = System.nanoTime();
		System.out.println();
		System.out.println();
		System.out.println("Tempo de Execução em nanosegundos: " + (tempoFinal - tempoInicio));
		System.out.println("Tempo de Execução em milesegundos: " + (tempoFinalMilliseconds - tempoInicioMilliseconds));
		System.out.println("Contador: " + contador);
		contador = 0;		
	}

	// metodo que gera o vetor ordenado
	public static int[] gerarVetorOrdenado(int minimo, int tamanho, int incremento) {

		int[] vet = new int[tamanho];
		int valor = minimo;
		for (int i = minimo; i < tamanho; i++) {
			contador++;
			vet[i] = valor;
			valor += incremento;
		}
		return vet;
	}

	// metodo que gera o vetor desordenado
	public static int[] gerarVetorDesordenado(int minimo, int tamanho, int valorMaximo) {
		Random random = new Random();
		int randomico = 0;

		int[] vet = new int[tamanho];
		int valor = minimo;
		for (int i = minimo; i < tamanho; i++) {
			contador++;
			vet[i] = random.nextInt(valorMaximo);
		}
		return vet;
	}

	// metodo ordenar vetor Bubble Sort
	public static int[] BubbleSort(int vet[]) {
		int auxiliar;

		for (int a = 1; a < vet.length; a++) {
			for (int b = vet.length - 1; b >= a; b--) {
				if (vet[b - 1] > vet[b]) {
					auxiliar = vet[b - 1];
					vet[b - 1] = vet[b];
					vet[b] = auxiliar;
				}
			}
		}		
		return vet;
	}
	
	//metodo ordenar vetor Selection Sort
	public static int[] SelectionSort(int vet[]) {
		int a, b, c, auxiliar;
		
		for(a = 0; a < vet.length - 1; a++) {
			c = a;
			auxiliar = vet[a];
			for(b = a + 1; b < vet.length; b++) {
				if(vet[b] < auxiliar) {
					c = b;
					auxiliar = vet[b];
				}
			}
			vet[c] = vet[a];
			vet[a] = auxiliar;
		}
		return vet;
	}
	
	//metodo busca recursiva
	public static int buscaRecursiva(int vetor[], int baixa, int alta, int n) {
		int media = (baixa + alta) / 2;
		if (baixa <= alta) {
			if (n < vetor[media]) {
				return buscaRecursiva(vetor, baixa, media - 1, n);
			} else {
				if (n > vetor[media]) {
					return buscaRecursiva(vetor, media + 1, alta, n);
				} else {
					return media;
				}
			}
		}
		return -1;
	}
}
