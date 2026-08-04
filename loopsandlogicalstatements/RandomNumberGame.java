package loopsandlogicalstatements;

import java.util.Scanner;
import java.util.Random;

import java.util.Scanner;
import java.util.Random;

public class RandomNumberGame {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int randomNumber = rand.nextInt(10) + 1; // 1 to 10
        int guess = 0;
        int attempts = 0;
        int maxAttempts = 3; // only 3 chances
        boolean won = false;
        
        System.out.println("===== GUESS THE NUMBER GAME =====");
        System.out.println("I have chosen a number between 1 to 10");
        System.out.println("You have only " + maxAttempts + " attempts!");

        while(!won && attempts < maxAttempts) { // loop until win OR attempts over
            System.out.print("\nAttempt " + (attempts+1) + "/" + maxAttempts + " - Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            String hint = (guess < randomNumber)? "Too Low! 📉" : 
                          (guess > randomNumber)? "Too High! 📈" : 
                          "Correct! 🎉"; // nested ternary
            
            System.out.println(hint);
            
            won = (guess == randomNumber)? true : false; // ternary to set win
        }

        // Final result using ternary
        System.out.println( won? 
                            "\nYou Won in " + attempts + " attempts! 🏆" : 
                            "\nGame Over! The number was " + randomNumber + " 😢" );
        
        sc.close();
    }
}