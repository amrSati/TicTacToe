package tictactoe;

import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;

public class TicTacToe {
    Scanner supp = new Scanner(System.in);
           //to build lsts used in winnr chck method
    static ArrayList <List> winn = new ArrayList<>();
    static ArrayList <Integer> plyr1Pos = new ArrayList<>();
    static ArrayList <Integer> plyr2Pos = new ArrayList<>();
    	public static void main(String[] args) {
                Scanner supp = new Scanner(System.in);
            boolean ext = true;
            while (ext){
                plyr1Pos.clear();
                plyr2Pos.clear();
                winn.clear();
                char[][] gBoard = {{' ','|',' ','|',' '},                       //creativity  fam >_<\\
                                   {'-','+','-','+','-'},
                                   {' ','|',' ','|',' '},
                                   {'-','+','-','+','-'},
                                   {' ','|',' ','|',' '}};
                String plyr1, plyr2;
                boolean extt, exttt;
                extt = exttt = true;
                                   //take input for user symbol
                System.out.println("Choose a symbol: ( x | o)");
                    plyr1 = supp.next();
                while (exttt) {
                    if (plyr1.equals("x") || plyr1.equals("o")) {
                        exttt = false;
                    } else {
                        System.out.println("Choose one of the symbols given!! (x | o)");
                            plyr1 = supp.next();
                    }
                    System.out.println("You are player "+"'"+plyr1+"'");
                }
                System.out.println("Choose a symbol: ( x | o)");
                    plyr2 = supp.next();
                exttt = true;
                while (exttt) {
                    if (plyr2.equals(plyr1)) {
                        System.out.println("You can't choose the same symbol! \n please try again");
                            plyr2 = supp.next();
                    }   else if (plyr2.equals("o") || plyr2.equals("x")) {
                            exttt = false;
                        }
                }
                System.out.println("You are player "+"'"+plyr2+"'");
                gameBoard(gBoard);
                while (true){
                    System.out.println("Player 'x' place your move: (1 - 9)");      
                        int positin1 = supp.nextInt();
                    while(plyr1Pos.contains(positin1) || plyr2Pos.contains(positin1)) {
                        System.out.println("POSITION TAKEN!!! \n Enter a correct one.");
                            positin1 = supp.nextInt();
                    }
                    placement(gBoard, positin1, plyr1);
                    gameBoard(gBoard);
                    String rslt = winnerCheck();
                    if (rslt.length() > 0){
                        System.out.println(rslt);
                            break;
                    } //this condition bcaus the method returning an empty string it must not be empty
                    System.out.println("Player 'o' place your move: (1 - 9)");      
                        int positin2 = supp.nextInt();
                    while (plyr2Pos.contains(positin2) || plyr1Pos.contains(positin2)){
                        System.out.println("POSITION TAKEN!!! \n Enter a correct one.");
                            positin2 = supp.nextInt();
                    }
                    placement(gBoard, positin2, plyr2);
                    gameBoard(gBoard);
                    rslt = winnerCheck();
                    if (rslt.length() > 0){
                        System.out.println(rslt);
                            break;
                    } 
                }
                    while (extt) {
                        System.out.println("Do you want to play again? ( y | n)");
                            String rnd = supp.next();
                        switch (rnd) {
                            case "n":
                                System.out.println("Bye !>_<!");
                                ext = extt = false;
                                    break;
                            case "y":
                                System.out.println("YaY!!");
                                extt = false;
                                    break;
                            default:
                                System.out.println("WRONG INPUT!");
                                    break;
                        }
                    }
            }
        }



            /* this method is to chck the winner and couldnt write it until i learnd about this arraylist thing
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
            List<List> winn = new ArrayList<List>();
            winn.add(tRw);
            winn.add(mRw);
            winn.add(bRw);
            winn.add(lCol);
            winn.add(mCol);
            winn.add(rCol);
            winn.add(fDiag);
            winn.add(sDiag);
            for(List l : winn) {
                if(plyr1Pos.containsAll(l)) {
                    return "Congratulations Player 'x' you won!  \n Sorry Player 'o' good luck next time.";
                }   else if(plyr2Pos.containsAll(l)) {
                        return "Congratulations Player 'o' you won!  \n Sorry Player 'x' good luck next time.";
                    }   else if((plyr1Pos.size() + plyr2Pos.size()) == 9) {
                            if (plyr1Pos.containsAll(l)) {
                                return "Congratulations Player 'x' you won!  \n Sorry Player 'o' good luck next time.";
                            }   else if (plyr1Pos.containsAll(l)) {
                                    return "Congratulations Player 'o' you won!  \n Sorry Player 'x' good luck next time.";
                                }   else {
                                        return "it's a TIE!!";
                                    }
                        }
            }
            return "";
        }       

        public static void placement(char[][] gBoard, int positin, String plyr) {
            char iCon = ' ';
            if(plyr.equals("x")) {
                iCon = 'X';
                    plyr1Pos.add(positin);
            }   else if(plyr.equals("o")) {
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