//seven column six row

import java.util.Scanner;
import java.util.InputMismatchException;

public class ConnectFour {

    private boolean RED = true;
    private boolean YELLOW = false;
    private boolean currentColor;

    private Scanner sc = new Scanner(System.in);

    private class Board {
        
        private char[][] gameBoard;
        private int numRows, numColumns;
        
        private Board(int numRows, int numColumns) {
            this.numRows = numRows;
            this.numColumns = numColumns;
            gameBoard = new char[numRows][numColumns];
        }

        private String getDividingLine() {
            return "-----------------------------";
        }
        
        private void displayBoard() {

            for(int i = 0; i < numRows; i++) {

                System.out.println(getDividingLine());
                System.out.print("|");

                for(int j = 0; j < numColumns; j++) {
                    System.out.print(" " + (gameBoard[i][j]=='\0' ? ' ' : gameBoard[i][j]) + " |");
                }
                System.out.println();
            }

            System.out.println(getDividingLine()+"\n");

        }

        /* Returns true if diskColor won, false if no result */ 
        private boolean dropDisk(boolean diskColor, int col) {
            //get the next free spot on y-axis
            int i;

            for(i = 0; i < 6; i++) {
                if(this.inBounds(i+1,col) && !this.isFree(i+1,col)) break;

                if(!this.inBounds(i+1, col)) break;
            }

            gameBoard[i][col] = (diskColor ? 'R' : 'Y');

            displayBoard();

            //call checkBoard at end to see if anyone won
            return checkBoard(diskColor);
        }

        /* Returns true if diskColor won, false if no result */ 
        private boolean checkBoard(boolean diskColor) {


            int currentRow = 0;
            int currentCol = 0;

            for(int i = 0; i < numRows; i++) {
                int j;

                for(j = 0; j < numColumns; j++) {
                    if(getColor(gameBoard[i][j]) != diskColor) {
                        //clear column
                        currentRow = 0;
                        break;
                    }

                    if(gameBoard[i][j] != '\0') currentRow++;
                    if(currentRow == 4) return true;
                }

                if(inBounds(i+1,j) && getColor(gameBoard[i][j]) == getColor(gameBoard[i+1][j]) && gameBoard[i][j] != '\0') {
                    System.out.println("i: " + i + " j: " + j + " currentCol: " + currentCol);
                    currentCol++;
                }

                else currentCol = 0;
                if(currentCol == 4) return true;
            }

            return false;
        }
        
        //is it in bounds? There are 6 rows and 7 columns total!
        private boolean inBounds(int row, int col) {
            if(row > 5 || row < 0) return false;
            
            else if(col > 6 || col < 0) return false;

            else return true;
        }

        //is there a disk on that spot? R for Red Y for Yellow
        private boolean isFree(int row, int col) {
            if(gameBoard[row][col] == 'R') return false;

            else if(gameBoard[row][col] == 'Y') return false;

            else return true;
        }
    }

    private void start() {

        Board board = new Board(6,7);

        currentColor = RED;
        int colToDropIn = 0;
        boolean result;
        board.displayBoard();

        
        while(true) {

            while(true){
                System.out.print("Drop a " + this.getColor(currentColor) + " disk at column (0-6): ");

                try {
                    colToDropIn = sc.nextInt();
                } catch(InputMismatchException ex) {
                    System.out.println("That's not a valid integer input!");
                    System.exit(0);
                }

                if(!board.inBounds(0,colToDropIn)) System.out.println("That's not a valid column! Try again!");

                else if(!board.isFree(0,colToDropIn)) System.out.println("That column is already full of disks! Try again!");
               
                else break;
            }

            result = board.dropDisk(currentColor, colToDropIn);
            

            if(result) {
                System.out.println( (currentColor ? "Red" : "Yellow") + " wins. Game End!" );
                break;
            }

            currentColor = !currentColor;

        }
    }
    
    //if boolean color given, color char given as String
    private String getColor(boolean currentColor) {
        if(currentColor) return "red";
        else return "yellow";
    }
    
    //if char color given, boolean char returned
    private boolean getColor(char currentColor) {
        if(currentColor == 'R') return true;
        else return false;
    }

    public static void main(String[] args) {        
        ConnectFour game = new ConnectFour();
        game.start();
    }
}