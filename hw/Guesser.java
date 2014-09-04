import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

class Guesser {
  private static final int minRandom = 0;
  private static final int maxRandom = 1000;

  public static boolean guessed = false;
  public static int answer;
  public static int numGuesses = 0;

  public static void main(String[] args) {
    setAnswer();

    while (!guessed) {
      promptForGuess();
    }

    System.out.println("It took you: " + numGuesses + " guesses.");
  }

  public static void promptForGuess() {
    System.out.println("Please enter a guess.");
    processGuess(getGuess());
  }

  private static int getGuess() {
    int guess = -1;

    while (guess == -1) {
      try {
        Scanner sc = new Scanner(System.in);
        guess = sc.nextInt();
      } catch(InputMismatchException e) {
        System.out.println("That's not a number... please try again.");
      }
    }

    return(guess);
  }    

  private static void processGuess(int guess) {
    numGuesses++;

    if (guess < answer) {
      System.out.println("That was too low.");
    } else if (guess > answer) {
      System.out.println("That was too high.");
    } else if (guess == answer) {
      System.out.println("Bingo!");
      guessed = true;
    }
  }

  private static void setAnswer() {
    Random rand = new Random();
    answer = rand.nextInt((maxRandom - minRandom) + 1) + minRandom;
  }
}

