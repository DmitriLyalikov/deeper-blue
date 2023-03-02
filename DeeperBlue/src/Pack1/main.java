package Pack1;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class main extends DrawBoard {

	public static void main(String[] args) throws IOException {
		int Resoultion = 1000;
		int square_size = Resoultion/8;
		
		// Create Class Object for Drawboard.java
		
		DrawBoard draw = new DrawBoard();
		JFrame fr = new JFrame();
		
    	// Byte Representation of the Chess Board
    	// 0 = empty, negative denotes black, 1 = pawn, 2 = knight, 3 = bishop, 4 = rook, 5 = queen, 6 = king
		byte[][] boardstate = {
			    {-ROOK,-KNIGHT,-BISHOP,-QUEEN,-KING,-BISHOP,-KNIGHT,-ROOK},
			    {-PAWN,-PAWN,-PAWN,-PAWN,-PAWN,-PAWN,-PAWN,-PAWN},
			    {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
			    {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
			    {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
			    {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
			    {PAWN,PAWN,PAWN,PAWN,PAWN,PAWN,PAWN,PAWN},
			    {ROOK,KNIGHT,BISHOP,QUEEN,KING,BISHOP,KNIGHT,ROOK}
			};

    	// Create an array of images and store the chess pieces into them
		Image[] images = new Image[12];
		try {
		    images[0] = ImageIO.read(new File("PiecesImages/Chess_plt60.png"));  // White Pawn
		    images[1] = ImageIO.read(new File("PiecesImages/Chess_nlt60.png"));  // White Knight
		    images[2] = ImageIO.read(new File("PiecesImages/Chess_blt60.png"));  // White Bishop
		    images[3] = ImageIO.read(new File("PiecesImages/Chess_klt60.png"));  // White King
		    images[4] = ImageIO.read(new File("PiecesImages/Chess_qlt60.png"));  // White Queen
		    images[5] = ImageIO.read(new File("PiecesImages/Chess_rlt60.png"));  // White Rook
		    images[6] = ImageIO.read(new File("PiecesImages/Chess_pdt60.png"));  // Black Pawn
		    images[7] = ImageIO.read(new File("PiecesImages/Chess_ndt60.png"));  // Black Knight
		    images[8] = ImageIO.read(new File("PiecesImages/Chess_bdt60.png"));  // Black Bishop
		    images[9] = ImageIO.read(new File("PiecesImages/Chess_kdt60.png"));  // Black King
		    images[10] = ImageIO.read(new File("PiecesImages/Chess_qdt60.png"));  // Black Queen
		    images[11] = ImageIO.read(new File("PiecesImages/Chess_rdt60.png"));  // Black Rook
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
        // Display Board
		
        draw.DisplayBoard(boardstate,images,Resoultion,square_size,fr);
        
        
        int startrow;
        int endrow;
        int startcol;
        int endcol;
        
        MovePieces move = new MovePieces();
        while(true) {
        	System.out.println("Enter the row and col of the piece you want to move: ");
        	Scanner input = new Scanner(System.in);
        	startrow = input.nextInt();
        	startcol = input.nextInt();
        	System.out.println("Enter the row and col of the square you want to move to: ");
        	endrow = input.nextInt();
        	endcol = input.nextInt();
        	
        	boardstate = move.MakeMove(boardstate, startrow, startcol, endrow, endcol);
        	
        	
        	draw.DisplayBoard(boardstate,images,Resoultion,square_size,fr);  	
        	
        }
        
        
        
	}

}
