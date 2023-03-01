package Pack1;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class main {

	public static void main(String[] args) throws IOException {
		// Create Class Object for Drawboard
		
		DrawBoard draw = new DrawBoard();
		
		
		
    	// Byte Representation of the Chess Board
    	// 0 = empty, negative denotes black, 1 = pawn, 2 = knight, 3 = bishop, 4 = rook, 5 = queen, 6 = king
    	byte[][] boardstate = {
    			{-4,-2,-3,-5,-6,-3,-2,-4},
    			{-1,-1,-1,-1,-1,-1,-1,-1},
    			{0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0},
    			{1,1,1,1,1,1,1,1},
    			{4,2,3,5,6,3,2,4}
    	};
    	// Create an array of images and store the chess pieces into them
        Image[] images = new Image[12];
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
        
        
        
        // Display Board
        draw.DisplayBoard(boardstate,images);
        
        
        
	}

}
