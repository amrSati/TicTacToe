package tictactoe;

import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;

public class TicTacToe {
    static Scanner sc = new Scanner(System.in);
    static ArrayList <List> winn = new ArrayList<>();
    static ArrayList <Integer> plyr1Pos = new ArrayList<>();
    static ArrayList <Integer> plyr2Pos = new ArrayList<>();
    	public static void main(String[] args) {
            boolean ext = true;
            while (ext) {
                plyr1Pos.clear();
                plyr2Pos.clear();
                winn.clear();
                char[][] gBoard = {{' ','|',' ','|',' '},                       //creativity  fam >_<\\
                                   {'-','+','-','+','-'},
                                   {' ','|',' ','|',' '},
                                   {'-','+','-','+','-'},
                                   {' ','|',' ','|',' '}};
                char plyr1, plyr2;
                boolean extt;
                extt = true;
                                   //take input for user symbol
                System.out.println("Choose a symbol: ( x | o)");
                    plyr1 = sc.next().charAt(0);
                while (extt) {
                    if (plyr1 == 'x' || plyr1 == 'o') {
                        extt = false;
                    } else {
                        System.out.println("Choose one of the symbols given!! (x | o)");
                            plyr1 = sc.next().charAt(0);
                    }
                }
                if (plyr1 == 'x') plyr2 = 'o';
                else plyr2 = 'x';
                extt = true;
                gameBoard(gBoard);
                while (true) {
                    System.out.printf("Player '%s' place your move: (1 - 9)%n",plyr1);      
                        int positin1 = sc.nextInt();
                    while (plyr1Pos.contains(positin1) || plyr2Pos.contains(positin1)) {
                        System.out.println("POSITION TAKEN!!! \n Enter a correct one.");
                            positin1 = sc.nextInt();
                    }
                    placement(gBoard, positin1, plyr1);
                    gameBoard(gBoard);
                    String rslt = winnerCheck();
                    if (rslt.length() > 0) {
                        System.out.println(rslt);
                            break;
                    } //this condition bcaus the method returning an empty string it must not be empty
                    System.out.printf("Player '%s' place your move: (1 - 9)%n",plyr2);      
                        int positin2 = sc.nextInt();
                    while (plyr2Pos.contains(positin2) || plyr1Pos.contains(positin2)) {
                        System.out.println("POSITION TAKEN!!! \n Enter a correct one.");
                            positin2 = sc.nextInt();
                    }
                    placement(gBoard, positin2, plyr2);
                    gameBoard(gBoard);
                    rslt = winnerCheck();
                    if (rslt.length() > 0) {
                        System.out.println(rslt);
                            break;
                    } 
                }
                    while (extt) {
                        System.out.println("Do you want to play again? ( y | n)");
                            String rnd = sc.next();
                        switch (rnd) {
                            case "n" :
                                System.out.println("Bye !>_<!");
                                ext = extt = false;
                                    break;
                            case "y" :
                                System.out.println("YaY!!");
                                extt = false;
                                    break;
                            default :
                                System.out.println("WRONG INPUT!");
                                    break;
                        }
                    }
            }
        }   /* 
            this method is to chck the winner and couldnt write it until i learnd about this arraylist thing
            it helped!
            */
        public static String winnerCheck() {
            List tRw = Arrays.asList(1,2,3); 
            List mRw = Arrays.asList(4,5,6); 
            List bRw = Arrays.asList(7,8,9);
            List lCol = Arrays.asList(1,4,7); 
            List mCol = Arrays.asList(2,5,8); 
            List rCol = Arrays.asList(3,6,9);
            List fDiag = Arrays.asList(1,5,9); 
            List sDiag = Arrays.asList(3,5,7);
            
            winn.add(tRw);
            winn.add(mRw);
            winn.add(bRw);
            winn.add(lCol);
            winn.add(mCol);
            winn.add(rCol);
            winn.add(fDiag);
            winn.add(sDiag);
            boolean full = ((plyr1Pos.size() + plyr2Pos.size()) == 9);
            for(List l : winn) {
                if((full && plyr1Pos.containsAll(l)) || plyr1Pos.containsAll(l)) {
                    return "Congrats Player 'x' you won!  \n hard luck loser.";
                }   else if ((full && plyr2Pos.containsAll(l)) || plyr2Pos.containsAll(l)) {
                        return "Congrats Player 'o' you won!  \n hard luck loser.";
                    }   else if (full) {
                            return "it's a TIE!!";
                        }
            }
            return "";
        }
        public static void placement(char[][] gBoard, int positin, char plyr) {
            char iCon = ' ';
            if (plyr == 'x') {
                iCon = 'X';
                    plyr1Pos.add(positin);
            }   else if (plyr == 'o') {
                    iCon = 'O';
                        plyr2Pos.add(positin);
                }
            boolean ext = true;
            while (ext) {
                switch (positin) {
                    case 1 :
                        gBoard[0][0] = iCon;
                            break;
                    case 2 :
                        gBoard[0][2] = iCon;
                            break;
                    case 3 :
                        gBoard[0][4] = iCon;
                            break;
                    case 4 :
                        gBoard[2][0] = iCon;
                            break;
                    case 5 :
                        gBoard[2][2] = iCon;
                            break;    
                    case 6 :
                        gBoard[2][4] = iCon;
                            break;
                    case 7 :
                        gBoard[4][0] = iCon;
                            break;
                    case 8 :
                        gBoard[4][2] = iCon;
                            break;
                    case 9 :
                        gBoard[4][4] = iCon;
                            break;
                    default:
                        System.out.println("WRONG INPUT!!");
                            break;
                }
                ext = false;
            }
        }
        public static void gameBoard(char[][] gBoard) {
                for (int i=0; i< gBoard.length; i++) {
                    for (int j = 0; j < gBoard[i].length; j++) {
                        System.out.print(gBoard[i][j] + "");
                    }
                    System.out.println("");
                }
        }
}
