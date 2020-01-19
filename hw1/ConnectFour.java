//seven column six row

import java.util.Scanner;

public class ConnectFour {

    private boolean RED = true;
    private boolean YELLOW = false;
    private boolean currentColor;

    protected class board {
        
        private char[][] gameBoard;
        
        protected board() {
            gameBoard = new char[7][6];
        }
        
        protected void displayBoard() {

        }

        /* Returns true if diskColor won, false if no result */ 
        protected boolean dropDisk(boolean diskColor, int col) {
            //get the next free spot on y-axis
            int i;
            for(i = 6; i >= 0; i--) {
                if(this.inBounds(i+1,col) && this.isOccupied(i+1,col)) break;
            }

            gameBoard[i][col] = (diskColor ? 'R' : 'Y');

            displayBoard();

            //call checkBoard at end to see if anyone won
            return checkBoard();
        }

        private boolean checkBoard() {

            

            return false;
        }
        
        //is it in bounds?
        protected boolean inBounds(int x, int y) {
            if(x >= 7 || x < 0 || y >= 6 || y < 0) return false;
            else return true;
        }

        //is there a disk on that spot?
        private boolean isOccupied(int x, int y) {
            if(gameBoard[x][y] == 'R' ||gameBoard[x][y] == 'Y') return false;
            else return true;
        }
    }

    protected class Game {;
        protected game() {
            theGame();
        }
        
        private void theGame() {

            currentColor = RED;
            int colToDropIn;
            boolean result;
            displayBoard();

            
            while(true) {

                while(true){
                    System.out.print("Drop a " + getColor(currentColor) +" disk at column (0-6): ");
                    colToDropIn = sc.nextInt();
                    
                    if(inBounds(6,colToDropIn)) System.out.println("That's not a valid column! Try again!");
                    else if(isOccupied(6,colToDropIn)) System.out.println("That column is already full of disks! Try again!");
                    else break;
                }

                result = dropDisk(currentColor, colToDropIn);
                

                if(result) {
                    System.out.println( (currentColor ? "Red" : "Yellow") + "wins. Game End!" );
                    break;
                }

            }
        }
        
        private getColor(boolean currentColor) {
            if(currentColor) return "red";
            else return "yellow";
        }
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        
        Game game = new Game();
    }
}