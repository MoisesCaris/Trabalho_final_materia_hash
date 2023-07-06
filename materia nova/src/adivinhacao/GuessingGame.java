package adivinhacao;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame<T extends Comparable<T>> {
    private T objectToGuess;
    private int attempts;

    public GuessingGame(T objectToGuess) {
        this.objectToGuess = objectToGuess;
        this.attempts = 0;
    }

    public void guess(T guess) {
        attempts++;
        int comparison = guess.compareTo(objectToGuess);
        if (comparison == 0) {
            System.out.println("Parabens! Voce acertou em " + attempts + " tentativas.");
        } else if (comparison < 0) {
            System.out.println("Tente um valor maior.");
        } else {
            System.out.println("Tente um valor menor.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao jogo de adivinhacao!");

        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        GuessingGame<Integer> game = new GuessingGame<>(numberToGuess);

        while (true) {
            System.out.print("Digite seu palpite: ");
            int guess = scanner.nextInt();
            game.guess(guess);
        }
    }
}