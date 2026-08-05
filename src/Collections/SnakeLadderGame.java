package Collections;

import java.util.*;

class SnakeAndLadder {
    private int player1 = 1;
    private int player2 = 1;
    private Random dice = new Random();
    private Map<Integer, Integer> snakes = new HashMap<>();
    private Map<Integer, Integer> ladders = new HashMap<>();
    
    SnakeAndLadder() {
        // Snakes: head -> tail
        snakes.put(16, 6);
        snakes.put(47, 26);
        snakes.put(49, 11);
        snakes.put(56, 53);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(87, 24);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 78);
        
        // Ladders: bottom -> top
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 100);
    }
    
    private int rollDice() {
        return dice.nextInt(6) + 1; // 1 to 6
    }
    
    private int movePlayer(int position) {
        int diceValue = rollDice();
        System.out.println("Dice rolled: " + diceValue);
        
        int newPosition = position + diceValue;
        
        if(newPosition > 100) {
            System.out.println("Can't move. Need exact " + (100 - position) + " to win");
            return position; // stay in same place
        }
        
        // Check for ladder
        if(ladders.containsKey(newPosition)) {
            System.out.println("Climbed Ladder! " + newPosition + " -> " + ladders.get(newPosition) + " 🪜");
            newPosition = ladders.get(newPosition);
        }
        // Check for snake
        else if(snakes.containsKey(newPosition)) {
            System.out.println("Bitten by Snake! " + newPosition + " -> " + snakes.get(newPosition) + " 🐍");
            newPosition = snakes.get(newPosition);
        }
        
        return newPosition;
    }
    
    public void startGame() {
        Scanner sc = new Scanner(System.in);
        int turn = 1; // 1 = player1, 2 = player2
        
        System.out.println("===== SNAKE AND LADDER =====");
        System.out.println("First to reach 100 wins!");
        
        while(player1 < 100 && player2 < 100) { // main game loop
            System.out.println("\n--- Player " + turn + " Turn ---");
            System.out.print("Press Enter to roll dice...");
            sc.nextLine();
            
            if(turn == 1) {
                player1 = movePlayer(player1);
                System.out.println("Player 1 is at position: " + player1);
                if(player1 == 100) {
                    System.out.println("Player 1 Wins! 🎉🏆");
                    break;
                }
                turn = 2; // ternary alternative: turn = (turn == 1) ? 2 : 1;
            } else {
                player2 = movePlayer(player2);
                System.out.println("Player 2 is at position: " + player2);
                if(player2 == 100) {
                    System.out.println("Player 2 Wins! 🎉🏆");
                    break;
                }
                turn = 1;
            }
        }
        sc.close();
    }
}

public class SnakeLadderGame {
    public static void main(String[] args) {
        SnakeAndLadder game = new SnakeAndLadder();
        game.startGame();
    }
}
