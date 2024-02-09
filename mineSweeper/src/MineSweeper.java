import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int row;
    int column;
    int[][] mineField;
    int[] mineRow;
    int[] mineColumn;
    int[][] gameBoard;
    String[][] backupGameBoard;

    boolean[][] backupGameBoardStatus;
    Scanner input = new Scanner(System.in);

    public MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.mineField = new int[row][column];
        this.gameBoard = new int[row][column];
        this.backupGameBoard = new String[row][column];
        this.backupGameBoardStatus = new boolean[row][column];
    }

    public void game() {

        Random rand = new Random();
        int n = (this.row*this.column) / 4;
        mineRow = new int[n];
        mineColumn = new int[n];

        //create random row indexes for mine location
        for(int i=0; i<n; i++) {
            int a = rand.nextInt(this.row);
            mineRow[i] = a;
        }

        //create random column indexes for mine location
        for (int j=0; j<n; j++) {
            int b = rand.nextInt(this.column);
            mineColumn[j] = b;
        }

        /*for(int y=0; y<n; y++) {
            System.out.print(mineRow[y]+" ");
        }
        System.out.print("\n");
        for(int y=0; y<n; y++) {
            System.out.print(mineColumn[y]+" ");
        }
        System.out.print("\n");*/


        //place mines in the field
        for(int k=0; k<n; k++) {
            mineField[mineRow[k]][mineColumn[k]] = 1;
        }

        //show game board (first version)
        for(int i=0; i<this.row; i++) {
            for (int j=0; j<this.column; j++) {
                System.out.print("- ");
            }
            System.out.print("\n");
        }


        while(true) { //continue as long as the mine location is not opened
            System.out.println("row: ");
            int row = input.nextInt();
            System.out.println("column: ");
            int column = input.nextInt();
            if(row>this.row || row<0 || column>this.column || column<0) {
                System.out.println("Incorrectly value!!");
            }
            if(mineField[row][column]==1){
                System.out.println("Game Over!");

                for(int i=0; i<this.row; i++) {
                    for (int j=0; j<this.column; j++) {
                        if(mineField[i][j]==1) {
                            System.out.print("* ");
                        } else {
                            System.out.print("- ");
                        }
                    }
                    System.out.print("\n");
                }

                break;
            } else {
                //right side: i->fixed - j->j+1
                if(((column+1)<=(mineColumn.length-1)) && mineField[row][column+1]==1 && !backupGameBoardStatus[row][column]) {
                    gameBoard[row][column] += 1;
                }
                //left side: i->fixed - j->j-1
                if(((column-1)>=0) && mineField[row][column-1]==1) {
                    gameBoard[row][column] += 1;
                }
                //under side: i->i+1 - j->fixed
                if(((row+1)<=(mineRow.length-1)) && mineField[row+1][column]==1 && !backupGameBoardStatus[row][column]) {
                    gameBoard[row][column] += 1;
                }
                //upper side: i->i-1 - j->fixed
                if(((row-1)>=0) && mineField[row-1][column]==1 && !backupGameBoardStatus[row][column]) {
                    gameBoard[row][column] += 1;
                }
                //upper right side: i->i-1 - j->j+1
                if((row-1)>=0 && (column+1)<=(mineColumn.length-1) && mineField[row-1][column+1]==1 && !backupGameBoardStatus[row][column]) {
                    gameBoard[row][column] += 1;
                }
                //under right side: i->i+1 - j->j+1
                if((row+1)<=(mineRow.length-1) && (column+1)<=(mineColumn.length-1) && mineField[row+1][column+1]==1 && !backupGameBoardStatus[row][column]) {
                    gameBoard[row][column] += 1;
                }
                //upper left side: i->i-1 - j->j-1
                if((row-1)>=0 && (column-1)>=0 && mineField[row-1][column-1]==1 && !backupGameBoardStatus[row][column]) {
                    gameBoard[row][column] += 1;
                }
                //under left side: i->i+1 - j->j-1
                if((row+1)<=(mineRow.length-1) && (column-1)>=0 && mineField[row+1][column-1]==1 && !backupGameBoardStatus[row][column]) {
                    gameBoard[row][column] += 1;
                }

                backupGameBoard[row][column] = gameBoard[row][column] + " ";
                backupGameBoardStatus[row][column] = true;

                for(int i=0; i<this.row; i++) {
                    for (int j=0; j<this.column; j++) {
                        if(backupGameBoard[i][j]==null){
                            System.out.print("- ");
                        }else{
                            System.out.print(backupGameBoard[i][j]);
                        }
                    }
                    System.out.print("\n");
                }

                int count = 0;
                for(int i=0; i<this.row; i++) {
                    for (int j=0; j<this.column; j++) {
                        if(!backupGameBoardStatus[i][j]){
                            count++;
                        }
                    }
                }
                if(count==n) {
                    System.out.println("*****You won this game*****");
                    break;
                }
            }
        }

    }
}
