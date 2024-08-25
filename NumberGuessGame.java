package oasis_infobyte.intern;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        int totalRounds = 0;
        int roundsWons = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        while (playAgain){
            int min = 1;
            int max = 100;
            int attemptsLeft = 10;
            int guessToNumber = ra.nextInt(max - min + 1)+min;
            totalRounds++;
            System.out.println(" Round "+ totalRounds + ": Guess the number " + min + " and " + max + " you have "+ attemptsLeft +"attempts");

            boolean guessed = false;

            while (attemptsLeft > 0 && !guessed) {
                System.out.println("Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess < min || userGuess > max) {
                    System.out.println("Yours guess is out of bound, Please guess a number between " + min + "and" + max + ".");
                    continue;
                }
                if(userGuess < guessToNumber){
                    System.out.println("too low");
                } else if (userGuess > guessToNumber) {
                    System.out.println("too high");
                } else {
                    System.out.println("Congratulations! You guessed the correct number!");
                    guessed = true;
                    roundsWons++;
                    totalAttempts += (10 - attemptsLeft + 1);
                }
                attemptsLeft --;

                if (attemptsLeft > 0 && !guessed){
                    System.out.println("You have "+ attemptsLeft + "attempts Lesft");
                } else if (!guessed) {
                    System.out.println("Sorry, you have used all your attemots, the correct number was "+ guessToNumber+",");
                    totalAttempts += 10;
                }
            }
            System.out.println("would you like to play another round ? ( yes/no)");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
        System.out.println("Game Over! you won"+ roundsWons+"out of"+ totalRounds+"rounds");
        System.out.println("Total attempts made"+ totalAttempts);
        if (roundsWons > 0){
            double average_attempts = (double) totalAttempts/roundsWons;
            System.out.println("Average number of attempts per win: "+ average_attempts);
        } else {
            System.out.println("no rounds won, so no, average attempts to calculate.");
        }
    }
}
