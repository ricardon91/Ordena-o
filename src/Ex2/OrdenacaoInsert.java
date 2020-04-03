package Ex2;

import java.util.Random;

public class OrdenacaoInsert {

	public static void main(String[] args) {

		int[] v = gerarVetorDesordenado(0, 10000, 10000);

		long tempoInicio;
		long tempoFinal;
		long[] temposBubble = new long[10];
		long[] temposSelect = new long[10];
		long[] temposInsert = new long[10];
		int indice = 0;
		int indice2 = 0;
		int indice3 = 0;
		long somaBubble = 0;
		long somaSelect = 0;
		long somaInsert = 0;

		System.out.println("Rodada Bubble Sort");
		for (int j = 0; j < 10; j++) {

			tempoInicio = System.nanoTime();

			BubbleSort(v);

			for (int i = 0; i < v.length; i++) {
				//System.out.print(resultado[i] + ", ");
				if ((i + 1) % 100 == 0) {
					//System.out.println();
				}
			}
			
			tempoFinal = System.nanoTime();
			
			temposBubble[indice] = tempoFinal - tempoInicio;
			somaBubble += temposBubble[indice] / 10;
			indice++;
		}
		
		for(int j = 0; j < 10; j++) {
			System.out.println("Rodada: " + j + " tempo: " + temposBubble[j]);			
		}
		System.out.println("Média Bubble Sort: " + somaBubble);
		
		System.out.println();
		System.out.println("Rodada Select Sort");
		
		for (int j = 0; j < 10; j++) {

			tempoInicio = System.nanoTime();

			SelectSort(v);

			for (int i = 0; i < v.length; i++) {
				//System.out.print(resultado[i] + ", ");
				if ((i + 1) % 100 == 0) {
					//System.out.println();
				}
			}
			
			tempoFinal = System.nanoTime();
			
			temposSelect[indice2] = tempoFinal - tempoInicio;
			somaSelect += temposSelect[indice2] / 10;
			indice2++;
		}
		
		for(int j = 0; j < 10; j++) {
			System.out.println("Rodada: " + j + " tempo: " + temposSelect[j]);
		}
		System.out.println("Média Select Sort: " + somaSelect);
		
		System.out.println();
		System.out.println("Rodada Insert Sort");
		
		for (int j = 0; j < 10; j++) {

			tempoInicio = System.nanoTime();

			InsertSort(v);

			for (int i = 0; i < v.length; i++) {
				//System.out.print(resultado[i] + ", ");
				if ((i + 1) % 100 == 0) {
					//System.out.println();
				}
			}
			
			tempoFinal = System.nanoTime();
			
			temposInsert[indice3] = tempoFinal - tempoInicio;
			somaInsert += temposInsert[indice3] / 10;
			indice3++;
		}
		
		for(int j = 0; j < 10; j++) {
			System.out.println("Rodada: " + j + " tempo: " + temposInsert[j]);
		}
		System.out.println("Média Insert Sort: " + somaInsert);
	}

	// metodo que gera o vetor desordenado
	public static int[] gerarVetorDesordenado(int minimo, int tamanho, int valorMaximo) {
		Random random = new Random();		

		int[] vet = new int[tamanho];
		
		for (int i = minimo; i < tamanho; i++) {
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

	// metodo ordenar vetor Selection Sort
	public static int[] SelectSort(int vet[]) {
		int a, b, c, auxiliar;

		for (a = 0; a < vet.length - 1; a++) {
			c = a;
			auxiliar = vet[a];
			for (b = a + 1; b < vet.length; b++) {
				if (vet[b] < auxiliar) {
					c = b;
					auxiliar = vet[b];
				}
			}
			vet[c] = vet[a];
			vet[a] = auxiliar;
		}
		return vet;
	}

	// metodo ordenar vetor Insert Sort
	public static int[] InsertSort(int vet[]) {
		int a, b, auxiliar;

		for (a = 1; a < vet.length; a++) {
			auxiliar = vet[a];
			b = a - 1;
			while (b >= 0 && auxiliar < vet[b]) {
				vet[b + 1] = vet[b];
				b--;
			}
			vet[b + 1] = auxiliar;
		}
		return vet;
	}

}
