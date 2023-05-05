package JavaChessAI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
public class UserInterface extends JPanel implements MouseListener, MouseMotionListener{
	// Define some static variables for tracking mouse position and square size
    static int mouseX, mouseY, newMouseX, newMouseY;
    static int squareSize=64;
 // Override the paintComponent method of the JPanel class to draw the chessboard and pieces
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.blue);
        this.addMouseListener(this); // add mouse listener to the JPanel
        this.addMouseMotionListener(this); // add mouse motion listener to the JPanel
     // Draw the alternating square colors of the chessboard
        for (int i=0;i<64;i+=2) {
            g.setColor(new Color(255,200,100));
            g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
            g.setColor(new Color(150,50,30));
            g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
        }
     // Load the image of the chess pieces and draw them on the board based on their current positions
        Image chessPiecesImage;
        chessPiecesImage=new ImageIcon("ChessPieces.png").getImage();
        for (int i=0;i<64;i++) {
            int j=-1,k=-1;
            switch (ABchess.chessBoard[i/8][i%8]) {
                case "P": j=5; k=0;
                    break;
                case "p": j=5; k=1;
                    break;
                case "R": j=2; k=0;
                    break;
                case "r": j=2; k=1;
                    break;
                case "K": j=4; k=0;
                    break;
                case "k": j=4; k=1;
                    break;
                case "B": j=3; k=0;
                    break;
                case "b": j=3; k=1;
                    break;
                case "Q": j=1; k=0;
                    break;
                case "q": j=1; k=1;
                    break;
                case "A": j=0; k=0;
                    break;
                case "a": j=0; k=1;
                    break;
            }
            if (j!=-1 && k!=-1) {
                g.drawImage(chessPiecesImage, (i%8)*squareSize, (i/8)*squareSize, (i%8+1)*squareSize, (i/8+1)*squareSize, j*64, k*64, (j+1)*64, (k+1)*64, this);
            }
        }
          }
    
  //Overrides mouseMoved() method from the MouseMotionListener interface with an empty implementation
    @Override
    public void mouseMoved(MouseEvent e) {}
  //Overrides mousePressed() method from the MouseListener interface
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX()<8*squareSize &&e.getY()<8*squareSize) {
            //if inside the board
            mouseX=e.getX();
            mouseY=e.getY();
          //triggers a repaint() method to draw the chess piece on the clicked square
            repaint();
        }
    }
  //Overrides mouseReleased() method from the MouseListener interface
    @Override
    public void mouseReleased(MouseEvent e) {
    	//checks if the mouse click was inside the chessboard
        if (e.getX()<8*squareSize &&e.getY()<8*squareSize) {
            //if inside the board
            newMouseX=e.getX();
            newMouseY=e.getY();
          //checks if the mouse button pressed was the left mouse button
            if (e.getButton()==MouseEvent.BUTTON1) {
                String dragMove;
              //checks if it's a pawn promotion move
                if (newMouseY/squareSize==0 && mouseY/squareSize==1 && "P".equals(ABchess.chessBoard[mouseY/squareSize][mouseX/squareSize])) {
                    //pawn promotion
                    dragMove=""+mouseX/squareSize+newMouseX/squareSize+ABchess.chessBoard[newMouseY/squareSize][newMouseX/squareSize]+"QP";
                  //if it's not a pawn promotion move
                } else {
                    //regular move
                    dragMove=""+mouseY/squareSize+mouseX/squareSize+newMouseY/squareSize+newMouseX/squareSize+ABchess.chessBoard[newMouseY/squareSize][newMouseX/squareSize];
                }
                String userPosibilities=ABchess.posibleMoves();
              //checks if the drag move is a valid move
                if (userPosibilities.replaceAll(dragMove, "").length()<userPosibilities.length()) {
                    //if valid move
                    ABchess.makeMove(dragMove);
                    ABchess.flipBoard();
                  //triggers an alpha-beta pruning algorithm to calculate the best move for the computer
                    try {
                    ABchess.makeMove(ABchess.alphaBeta(ABchess.globalDepth, 1000000, -1000000, "", 0));
                    ABchess.flipBoard();
                    System.out.println();
                    
                    // keeping track of positions
                    
                    int movenum = 0;
                    ArrayList<String[][]> chessBoardStates = new ArrayList<>();
                    chessBoardStates.add(ABchess.chessBoard);
                    String[][] boardState = chessBoardStates.get(movenum);
                    for (int i = 0; i < boardState.length; i++) {
                        for (int j = 0; j < boardState[i].length; j++) {
                            System.out.print(boardState[i][j] + " ");
                        }
                        System.out.println();
                    }
                    movenum++;
                    
                  
                    }catch(Exception end) {
                    	System.out.println("Game Over");
                    	repaint();
                    }
                    repaint();
                }
            }
        }
    } 
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}