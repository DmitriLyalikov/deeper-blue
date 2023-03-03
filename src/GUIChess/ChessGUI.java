package GUIChess;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
 
public class ChessGUI extends JFrame implements MouseListener, MouseMotionListener {
	  // Declare instance variables
	  JLayeredPane layeredPane; // The layered pane that holds the chess board and chess pieces
	  JPanel chessBoard; // The chess board panel
	  JLabel chessPiece; // The chess piece label that is being dragged
	  int xAdjustment; // The x-coordinate adjustment of the mouse click when a piece is clicked and dragged
	  int yAdjustment; // The y-coordinate adjustment of the mouse click when a piece is clicked and dragged
 
// Declare constructor for ChessGUI class
  public ChessGUI(){
// set the size of the chess board
  Dimension boardSize = new Dimension(512, 512);
 
  //  Use a Layered Pane for this this application
 layeredPane = new JLayeredPane();
  getContentPane().add(layeredPane);
  layeredPane.setPreferredSize(boardSize);
  layeredPane.addMouseListener(this);
  layeredPane.addMouseMotionListener(this);
 
  //Add a chess board to the Layered Pane 
 
  chessBoard = new JPanel();
  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
  chessBoard.setLayout( new GridLayout(8, 8) );
  chessBoard.setPreferredSize( boardSize );
  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
  
//Loop through each square on the board (64 total) (0 - 63)
for (int squareIndex = 0; squareIndex < 64; squareIndex++) {
 
 // Create a new panel for the current square
 JPanel squarePanel = new JPanel(new BorderLayout());
 
 // Set the background color of the current square
 int currentRow = (squareIndex / 8) % 2; // Determine if the square is on an even or odd numbered row
 if (currentRow == 0) { // If the square is on an even row
   if (squareIndex % 2 == 0) { // If the square index is even, set the background color to blue
     squarePanel.setBackground(new Color(0,150,0));
   } else { // If the square index is odd, set the background color to white
     squarePanel.setBackground(Color.white);
   }
 } else { // If the square is on an odd row
   if (squareIndex % 2 == 0) { // If the square index is even, set the background color to white
     squarePanel.setBackground(Color.white);
   } else { // If the square index is odd, set the background color to blue
     squarePanel.setBackground(new Color(0,150,0));
   }
 }
 
 // Add the current square panel to the chess board container
 chessBoard.add(squarePanel);
}
  
  // Create an array of images
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
  // Create Starting Position
	
	// Chess board is indexed from 0 to 63, a8 = 0 a7 = 1 ... h1 = 63
 
  JLabel piece = new JLabel( new ImageIcon(images[11]) );
  JPanel panel = (JPanel)chessBoard.getComponent(0);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[7]));
  panel = (JPanel)chessBoard.getComponent(1);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[8]));
  panel = (JPanel)chessBoard.getComponent(2);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[10]));
  panel = (JPanel)chessBoard.getComponent(3);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[9]));
  panel = (JPanel)chessBoard.getComponent(4);
  panel.add(piece);
   
  piece = new JLabel(new ImageIcon(images[8]));
  panel = (JPanel)chessBoard.getComponent(5);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[7]));
  panel = (JPanel)chessBoard.getComponent(6);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[11]));
  panel = (JPanel)chessBoard.getComponent(7);
  panel.add(piece);
 
  piece = new JLabel(new ImageIcon(images[6]));
  panel = (JPanel)chessBoard.getComponent(8);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[6]));
  panel = (JPanel)chessBoard.getComponent(9);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[6]));
  panel = (JPanel)chessBoard.getComponent(10);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[6]));
  panel = (JPanel)chessBoard.getComponent(11);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[6]));
  panel = (JPanel)chessBoard.getComponent(12);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[6]));
  panel = (JPanel)chessBoard.getComponent(13);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[6]));
  panel = (JPanel)chessBoard.getComponent(14);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[6]));
  panel = (JPanel)chessBoard.getComponent(15);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[0]));
  panel = (JPanel)chessBoard.getComponent(48);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[0]));
  panel = (JPanel)chessBoard.getComponent(49);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[0]));
  panel = (JPanel)chessBoard.getComponent(50);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[0]));
  panel = (JPanel)chessBoard.getComponent(51);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[0]));
  panel = (JPanel)chessBoard.getComponent(52);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[0]));
  panel = (JPanel)chessBoard.getComponent(53);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[0]));
  panel = (JPanel)chessBoard.getComponent(54);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[0]));
  panel = (JPanel)chessBoard.getComponent(55);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[5]));
  panel = (JPanel)chessBoard.getComponent(56);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[1]));
  panel = (JPanel)chessBoard.getComponent(57);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[2]));
  panel = (JPanel)chessBoard.getComponent(58);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[4]));
  panel = (JPanel)chessBoard.getComponent(59);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[3]));
  panel = (JPanel)chessBoard.getComponent(60);
  panel.add(piece);
  
  
  piece = new JLabel(new ImageIcon(images[2]));
  panel = (JPanel)chessBoard.getComponent(61);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[1]));
  panel = (JPanel)chessBoard.getComponent(62);
  panel.add(piece);
  
  piece = new JLabel(new ImageIcon(images[5]));
  panel = (JPanel)chessBoard.getComponent(63);
  panel.add(piece);
  }
 
  public void mousePressed(MouseEvent e){
  chessPiece = null;
  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
 
  if (c instanceof JPanel) 
  return;
 
  Point parentLocation = c.getParent().getLocation();
  xAdjustment = parentLocation.x - e.getX();
  yAdjustment = parentLocation.y - e.getY();
  chessPiece = (JLabel)c;
  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
  }
 
  //Move the chess piece around
  
  public void mouseDragged(MouseEvent me) {
  if (chessPiece == null) return;
 chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
 }
 
  //Drop the chess piece back onto the chess board
 
  public void mouseReleased(MouseEvent e) {
  if(chessPiece == null) return;
 
  chessPiece.setVisible(false);
  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
 
  if (c instanceof JLabel){
  Container parent = c.getParent();
  parent.remove(0);
  parent.add( chessPiece );
  }
  else {
  Container parent = (Container)c;
  parent.add( chessPiece );
  }
 
  chessPiece.setVisible(true);
  }
 
  public void mouseClicked(MouseEvent e) {
  
  }
  public void mouseMoved(MouseEvent e) {
 }
  public void mouseEntered(MouseEvent e){
  
  }
  public void mouseExited(MouseEvent e) {
  
  }
 
  public static void main(String[] args) {
  JFrame frame = new ChessGUI();
  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
  frame.pack();
  frame.setResizable(true);
  frame.setLocationRelativeTo( null );
  frame.setVisible(true);
 }
}