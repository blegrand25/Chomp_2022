import java.awt.*;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public Board [] losingBoards = new Board[5];
    public Board [] winningBoards = new Board[14];
    int w = 0;
    int l = 0;

    public MyPlayer() {
        columns = new int[10];
        Board a = new Board(1,0,0, 0,0);
        print3x3boards();

    }



    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;
// print3x3boards();



        System.out.println("MY PLAYER CLICKED");


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
        for (int u = 0; u <l; u++){
            if (columns[0] == losingBoards[u].cols[0] && columns[1] == losingBoards[u].cols[1] && columns[2] == losingBoards[u].cols[2]) {
                System.out.println("myplayer is making a winning move");
                row = losingBoards[u].winRow;
                column = losingBoards[u].winCol;

            }
        }
        for (int u = 0; u < w; u++){
            if (columns[0] == winningBoards[u].cols[0] && columns[1] == winningBoards[u].cols[1] && columns[2] == winningBoards[u].cols[2]) {
                System.out.println("myplayer is making a winning move");
                row = winningBoards[u].winRow;
                column = winningBoards[u].winCol;

            }
        }




        Point myMove = new Point(row, column);
        return myMove;
    }

    public void print3x3boards(){
        for(int s = 1; s <=3 ; s++) {
           for(int j = 0; j <=3; j++) {
               for (int z = 0; z <=3; z++){
                   if (s >= j && j >= z) {
                       System.out.println(s + " " + j + " " + z);
                       oneMoveAway(s, j, z);
                   }
               }
           }
            System.out.println();
        }
    }

    public void oneMoveAway(int s, int j, int z) {

        boolean isWinning = false;
        int r = 0;
        int c = 0;

        System.out.println("ORIGINAL BOARD: " + s + " " + j + " " + z);

        System.out.println("LAST COLUMN");
        if (z>=0) {
            for (int x = z- 1; x >= 0; x--) {
                for (int i = 0; i < l; i ++) {
                    if (s == losingBoards[i].cols[0] && j == losingBoards[i].cols[1] && x == losingBoards[i].cols[2]) {
                        isWinning = true;
                        System.out.println("found a losing board!");
                        System.out.println("reduced board: " + s + " " + j + " " + x);
                        System.out.println("Move made: (" + x + " , " + 2 +  ")");
                        r = x;
                        c = 2;
                    }
                }
            }
        }


        System.out.println();
        System.out.println("MIDDLE COLUMN");
        if (j>=0) {
            for (int x = j - 1; x >= 0; x--) {
                if (x<=z){
                    for (int i = 0; i < l; i ++) {
                        if (s == losingBoards[i].cols[0] && x == losingBoards[i].cols[1] && x == losingBoards[i].cols[2]) {
                            isWinning = true;
                            System.out.println("found a losing board!");
                            System.out.println( "reduced board:" + s + " " + x + " " + x);
                            System.out.println("Move made: (" + x + ", " + 1 + ")");
                            r = x;
                            c = 1;
                        }
                    }

                }else{
                    for (int i = 0; i < l; i ++) {
                        if (s == losingBoards[i].cols[0] && x == losingBoards[i].cols[1] && z == losingBoards[i].cols[2]) {
                            isWinning = true;
                            System.out.println("found a losing board!");
                            System.out.println( "reduced board:" + s + " " + x + " " + z);
                            System.out.println("Move made: (" + x + ", " + x + ")");
                            r = x;
                            c = x;
                        }
                    }

                }

            }
        }

        System.out.println();
        System.out.println("FIRST COLUMN");
        if (s>=0) {
            for (int x = s- 1; x >= 1; x--) {
                if (x<j && x<z) {
                    for (int i = 0; i < l; i ++) {
                        if (x == losingBoards[i].cols[0] && x == losingBoards[i].cols[1] && x == losingBoards[i].cols[2]) {
                            isWinning = true;
                            System.out.println("found a losing board!");
                            System.out.println("reduced board: " + x + " " + x + " " + x);
                            System.out.println("Move made: (" + x + " , " + 0 + ")");
                            r = x;
                            c = 0;
                        }
                    }


                }else if (x<j) {
                    for (int i = 0; i < l; i ++) {
                        if (x == losingBoards[i].cols[0] && x == losingBoards[i].cols[1] && x == losingBoards[i].cols[2]) {
                            isWinning = true;
                            System.out.println("found a losing board!");
                            System.out.println("reduced board: " + x + " " + x + " " + z);
                            System.out.println("Move made: (" + x + " , " + 0 + ")");
                            r = x;
                            c = 0;
                        }
                    }

                } else {
                    for (int i = 0; i < l; i ++) {
                        if (x == losingBoards[i].cols[0] && j == losingBoards[i].cols[1] && z == losingBoards[i].cols[2]) {
                            isWinning = true;
                            System.out.println("found a losing board!");
                            System.out.println("reduced board: " + x + " " + j + " " + z);
                            System.out.println("Move made: (" + x + " , " + 0 + ")");
                            r = x;
                            c = 0;
                        }
                    }

                }
            }
        }

        if(isWinning == true){
            winningBoards[w] = new Board(s,j,z, r,c);
            w++;
            System.out.println("this is a Winning Board! move: " + r + ", " + c + "\n");
        }else{
            losingBoards[l] = new Board(s,j,z, r,c);
            l++;
            System.out.println("this is a Losing Board!\n");
        }
    }

}
