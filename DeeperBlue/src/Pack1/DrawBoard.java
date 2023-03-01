package Pack1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class DrawBoard {
	static int Resoultion = 1000;
	static int square_size = Resoultion/8;
	
	
	
	public static void DisplayBoard(byte[][] boardstate, Image[] images ) {
        JFrame fr = new JFrame();
        fr.setBounds(0,0,Resoultion,Resoultion);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pn = new JPanel() {
            public void paint(Graphics g) {
                for(int rank = 1; rank <= 8; rank++) {
                    for(int file = 1; file <= 8; file++) {
                        if((rank+file) % 2 == 0) {
                            g.setColor(new Color(0,150,0));
                        }
                        else {
                            g.setColor(new Color(255,255,255));
                        }
                        g.fillRect((file-1)*Resoultion/8, (rank-1)*Resoultion/8, Resoultion/8, Resoultion/8);
                      
                        
                        if(boardstate[rank-1][file-1] == -4) {
                        	g.drawImage(images[11],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                        
                        if(boardstate[rank-1][file-1] == -5) {
                        	g.drawImage(images[10],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                        
                        if(boardstate[rank-1][file-1] == -6) {
                        	g.drawImage(images[9],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                        
                        if(boardstate[rank-1][file-1] == -3) {
                        	g.drawImage(images[8],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                        
                        if(boardstate[rank-1][file-1] == -2) {
                        	g.drawImage(images[7],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                        
                        if(boardstate[rank-1][file-1] == -1) {
                        	g.drawImage(images[6],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                        
                        if(boardstate[rank-1][file-1] == 4) {
                        	g.drawImage(images[5],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                        
                        if(boardstate[rank-1][file-1] == 5) {
                        	g.drawImage(images[4],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                        
                        if(boardstate[rank-1][file-1] == 6) {
                        	g.drawImage(images[3],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                        
                        if(boardstate[rank-1][file-1] == 3) {
                        	g.drawImage(images[2],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                        
                        if(boardstate[rank-1][file-1] == 2) {
                        	g.drawImage(images[1],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                        
                        if(boardstate[rank-1][file-1] == 1) {
                        	g.drawImage(images[0],(file-1)*square_size,(rank-1)*square_size,square_size,square_size,null);
                        	
                        }
                    }
                }
            }
        };
        pn.setPreferredSize(new Dimension(Resoultion,Resoultion));
        fr.add(pn);
        fr.pack();
        fr.setVisible(true);
		
	}
}
                           
