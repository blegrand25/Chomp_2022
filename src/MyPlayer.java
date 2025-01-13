import java.awt.*;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];
//        print3x3boards();
        oneMoveAway(3,3,3);


        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */


    }

    public void myPlayerClicked (){


    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;



        System.out.println("MY PLAYER CLICKED");

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        // add code to fill in the column array
        // so that it represents the gameBoard in number form
        // print columns array to show its working

        for (int c = 0; c < columns.length; c++ ) {
            int count = 0;
            for (int r = 0; r < gameBoard.length; r++) {
                if (gameBoard[r][c].isAlive == true) {
                    count++;
                }
            }
            columns[c] = count;
        }
        System.out.println(Arrays.toString(columns));

        Point myMove = new Point(row, column);
        return myMove;
    }

    public void print3x3boards(){
// print all possible 3x3 board states using 1 or more for loop
        for(int s = 1; s <=3 ; s++) {
           for(int j = 0; j <=3; j++) {
               for (int z = 0; z <=3; z++){
                   if (s >= j && j >= z) {
                       System.out.println(s + " " + j + " " + z);
                       //oneMoveAway(s, j, z);
                   }

               }
           }
            System.out.println();
        }

    }

    public void oneMoveAway(int s, int j, int z) {// for each possible board print all boards that results from a single move


        if (a < j) {
            for (int a = 3; a <= 3; a--) {
                System.out.println(s + " " + j + " " + z);
            }
        }
        // System.out.println("one move away from " + s + " " + j + " " + z);




    }

}
