package br.com.vainaweb;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MegaSena {

	public static void main(String[] args) {
		int[] userNumbers = getUserNumbers();
		int[] sortedNumbers = sortMegaSenaNumbers();

		int userHits = compareUserHits(userNumbers, sortedNumbers);
		
		showFinalResult(userHits);

	}

	public static int[] getUserNumbers() {
		Scanner sc = new Scanner(System.in);

		boolean validNumberInterval;
		int[] userNumbers = new int[7];
		int index = 0;

		System.out.println("\nBem vindo a Mega Sena Vai na Web!!!");
		System.out.println("Escolha 7 números");

		do {
			try {
				System.out.print("\nDigite um valor entre 0 e 100: ");
				userNumbers[index] = sc.nextInt();

				validNumberInterval = userNumbers[index] >= 0 && userNumbers[index] <= 100;

				if(validNumberInterval) {
					index++;					
				}

			} catch(InputMismatchException err) {
				System.out.println(
					"O valor digitado é inválido, por favor digite " +
					"um valor no intervalo informado\n"
				);
				sc.next();
			}
		} while(index < 7);
	
		sc.close();

		return userNumbers;
	}

	public static int[] sortMegaSenaNumbers() {
		Random random = new Random();

		int[] sortedNumbers = new int[7];

		for(int i = 0; i < sortedNumbers.length; i++) {
			sortedNumbers[i] = random.nextInt(101);
		}

		return sortedNumbers;
	}

	public static int compareUserHits(int[] userNumbers, int[] sortedNumbers) {
		int userHits = 0;

		for(int i = 0; i < sortedNumbers.length; i++) {
			for(int j = 0; j < userNumbers.length; j++) {
				if(sortedNumbers[i] == userNumbers[j]) {
					userHits ++;
					sortedNumbers[i] = -1;
					userNumbers[j] = -2;
					break;
				}
			}
		}

		return userHits;
	}

	public static void showFinalResult(int userHits) {
		System.out.printf("\nVocê acertou um total de %d \n", userHits);

		if(userHits < 5) {
			System.out.println("Infelizmente não foi dessa vez");
		} else if(userHits == 5) {
			System.out.println("Parabéns, você ganhou 10 mil reais");
		} else if(userHits == 6) {
			System.out.println("Parabéns, você ganhou 50 mil reais");
		} else if(userHits == 7) {
			System.out.println("Parabéns, você ganhou 200 mil reais");
		}
	}
}
