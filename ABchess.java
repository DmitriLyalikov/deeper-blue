package frenkichess;
import javax.swing.*;

public class ABchess {
	 static String chessBoard[][]={
		        {"r","k","b","q","a","b","k","r"},
		        {"p","p","p","p","p","p","p","p"},
		        {" "," "," "," "," "," "," "," "},
		        {" "," "," "," "," "," "," "," "},
		        {" "," "," "," "," "," "," "," "},
		        {" "," "," "," "," "," "," "," "},
		        {"P","P","P","P","P","P","P","P"},
		        {"R","K","B","Q","A","B","K","R"}};
		    static int kingPositionC, kingPositionL;
		    public static void main(String[] args) {
		        /*
		         * PIECE=WHITE/black
		         * pawn=P/p
		         * kinght (horse)=K/k
		         * bishop=B/b
		         * rook (castle)=R/r
		         * Queen=Q/q
		         * King=A/a
		         * 
		         * My strategy is to create an alpha-beta tree diagram wich returns
		         * the best outcome
		         * 
		         * (1234b represents row1,column2 moves to row3, column4 which captured
		         * b (a space represents no capture))
		         */
		        /*JFrame f=new JFrame("Chess Tutorial");
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        UserInterface ui=new UserInterface();
		        f.add(ui);
		        f.setSize(500, 500);
		        f.setVisible(true);*/
		        System.out.println(posibleMoves());
		    }
		    public static String posibleMoves() {
		        String list="";
		        for (int i=0; i<64; i++) {
		            switch (chessBoard[i/8][i%8]) {
		                case "P": list+=posibleP(i);
		                    break;
		                case "R": list+=posibleR(i);
		                    break;
		                case "K": list+=posibleK(i);
		                    break;
		                case "B": list+=posibleB(i);
		                    break;
		                case "Q": list+=posibleQ(i);
		                    break;
		                case "A": list+=posibleA(i);
		                    break;
		            }
		        }
		        return list;//x1,y1,x2,y2,captured piece
		    }
		    public static String posibleP(int i) {
		        String list="";
		        return list;
		    }
		    public static String posibleR(int i) {
		        String list="", oldPiece;
		        int r=i/8, c=i%8;
		        int temp=1;
		        for (int j=-1; j<=1; j+=2) {
		            try {
		                while(" ".equals(chessBoard[r][c+temp*j]))
		                {
		                    oldPiece=chessBoard[r][c+temp*j];
		                    chessBoard[r][c]=" ";
		                    chessBoard[r][c+temp*j]="R";
		                    if (kingSafe()) {
		                        list=list+r+c+r+(c+temp*j)+oldPiece;
		                    }
		                    chessBoard[r][c]="R";
		                    chessBoard[r][c+temp*j]=oldPiece;
		                    temp++;
		                }
		                if (Character.isLowerCase(chessBoard[r][c+temp*j].charAt(0))) {
		                    oldPiece=chessBoard[r][c+temp*j];
		                    chessBoard[r][c]=" ";
		                    chessBoard[r][c+temp*j]="R";
		                    if (kingSafe()) {
		                        list=list+r+c+r+(c+temp*j)+oldPiece;
		                    }
		                    chessBoard[r][c]="R";
		                    chessBoard[r][c+temp*j]=oldPiece;
		                }
		            } catch (Exception e) {}
		            temp=1;
		            try {
		                while(" ".equals(chessBoard[r+temp*j][c]))
		                {
		                    oldPiece=chessBoard[r+temp*j][c];
		                    chessBoard[r][c]=" ";
		                    chessBoard[r+temp*j][c]="R";
		                    if (kingSafe()) {
		                        list=list+r+c+(r+temp*j)+c+oldPiece;
		                    }
		                    chessBoard[r][c]="R";
		                    chessBoard[r+temp*j][c]=oldPiece;
		                    temp++;
		                }
		                if (Character.isLowerCase(chessBoard[r+temp*j][c].charAt(0))) {
		                    oldPiece=chessBoard[r+temp*j][c];
		                    chessBoard[r][c]=" ";
		                    chessBoard[r+temp*j][c]="R";
		                    if (kingSafe()) {
		                        list=list+r+c+(r+temp*j)+c+oldPiece;
		                    }
		                    chessBoard[r][c]="R";
		                    chessBoard[r+temp*j][c]=oldPiece;
		                }
		            } catch (Exception e) {}
		            temp=1;
		        }
		        return list;
		    }
		    public static String posibleK(int i) {
		        String list="", oldPiece;
		        int r=i/8, c=i%8;
		        for (int j=-1; j<=1; j+=2) {
		            for (int k=-1; k<=1; k+=2) {
		                try {
		                    if (Character.isLowerCase(chessBoard[r+j][c+k*2].charAt(0)) || " ".equals(chessBoard[r+j][c+k*2])) {
		                        oldPiece=chessBoard[r+j][c+k*2];
		                        chessBoard[r][c]=" ";
		                        if (kingSafe()) {
		                            list=list+r+c+(r+j)+(c+k*2)+oldPiece;
		                        }
		                        chessBoard[r][c]="K";
		                        chessBoard[r+j][c+k*2]=oldPiece;
		                    }
		                } catch (Exception e) {}
		                try {
		                    if (Character.isLowerCase(chessBoard[r+j*2][c+k].charAt(0)) || " ".equals(chessBoard[r+j*2][c+k])) {
		                        oldPiece=chessBoard[r+j*2][c+k];
		                        chessBoard[r][c]=" ";
		                        if (kingSafe()) {
		                            list=list+r+c+(r+j*2)+(c+k)+oldPiece;
		                        }
		                        chessBoard[r][c]="K";
		                        chessBoard[r+j*2][c+k]=oldPiece;
		                    }
		                } catch (Exception e) {}
		            }
		        }
		        return list;
		    }
		    public static String posibleB(int i) {
		        String list="", oldPiece;
		        int r=i/8, c=i%8;
		        int temp=1;
		        for (int j=-1; j<=1; j+=2) {
		            for (int k=-1; k<=1; k+=2) {
		                try {
		                    while(" ".equals(chessBoard[r+temp*j][c+temp*k]))
		                    {
		                        oldPiece=chessBoard[r+temp*j][c+temp*k];
		                        chessBoard[r][c]=" ";
		                        chessBoard[r+temp*j][c+temp*k]="B";
		                        if (kingSafe()) {
		                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
		                        }
		                        chessBoard[r][c]="B";
		                        chessBoard[r+temp*j][c+temp*k]=oldPiece;
		                        temp++;
		                    }
		                    if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))) {
		                        oldPiece=chessBoard[r+temp*j][c+temp*k];
		                        chessBoard[r][c]=" ";
		                        chessBoard[r+temp*j][c+temp*k]="B";
		                        if (kingSafe()) {
		                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
		                        }
		                        chessBoard[r][c]="B";
		                        chessBoard[r+temp*j][c+temp*k]=oldPiece;
		                    }
		                } catch (Exception e) {}
		                temp=1;
		            }
		        }
		        return list;
		    }
		    public static String posibleQ(int i) {
		        String list="", oldPiece;
		        int r=i/8, c=i%8;
		        int temp=1;
		        for (int j=-1; j<=1; j++) {
		            for (int k=-1; k<=1; k++) {
		                if (j!=0 || k!=0) {
		                    try {
		                        while(" ".equals(chessBoard[r+temp*j][c+temp*k]))
		                        {
		                            oldPiece=chessBoard[r+temp*j][c+temp*k];
		                            chessBoard[r][c]=" ";
		                            chessBoard[r+temp*j][c+temp*k]="Q";
		                            if (kingSafe()) {
		                                list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
		                            }
		                            chessBoard[r][c]="Q";
		                            chessBoard[r+temp*j][c+temp*k]=oldPiece;
		                            temp++;
		                        }
		                        if (Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))) {
		                            oldPiece=chessBoard[r+temp*j][c+temp*k];
		                            chessBoard[r][c]=" ";
		                            chessBoard[r+temp*j][c+temp*k]="Q";
		                            if (kingSafe()) {
		                                list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
		                            }
		                            chessBoard[r][c]="Q";
		                            chessBoard[r+temp*j][c+temp*k]=oldPiece;
		                        }
		                    } catch (Exception e) {}
		                    temp=1;
		                }
		            }
		        }
		        return list;
		    }
		    public static String posibleA(int i) {
		        String list="", oldPiece;
		        int r=i/8, c=i%8;
		        for (int j=0; j<9; j++) {
		            if (j!=4) {
		                try {
		                    if (Character.isLowerCase(chessBoard[r-1+j/3][c-1+j%3].charAt(0)) || " ".equals(chessBoard[r-1+j/3][c-1+j%3])) {
		                        oldPiece=chessBoard[r-1+j/3][c-1+j%3];
		                        chessBoard[r][c]=" ";
		                        chessBoard[r-1+j/3][c-1+j%3]="A";
		                        int kingTemp=kingPositionC;
		                        kingPositionC=i+(j/3)*8+j%3-9;
		                        if (kingSafe()) {
		                            list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece;
		                        }
		                        chessBoard[r][c]="A";
		                        chessBoard[r-1+j/3][c-1+j%3]=oldPiece;
		                        kingPositionC=kingTemp;
		                    }
		                } catch (Exception e) {}
		            }
		        }
		        //need to add casting later
		        return list;
		    }
		    public static boolean kingSafe() {
		        return true;
		    }
}