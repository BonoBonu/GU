
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class game_q extends JFrame 
                            implements ActionListener
{

	public static final int WIDTH = 750;
    public static final int HEIGHT = 750;
    JButton[] actionButton=new JButton[289];
    
    int wall1=0;
    int wall2=0;
    
    int p1,p2;
    
  
    public static void main(String[] args)
    {
    	game_q gui = new game_q( );
        gui.setVisible(true);
    }
    
    public game_q(){
    	 setTitle("2Quoridor game");
         setSize(WIDTH, HEIGHT);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout());
         
       
         JPanel position = new JPanel();
         position.setLayout(new FlowLayout());
     	int cnt=0;
		int c=1;
         for (int i = 0; i < 289; i++) {
 			
 			if(c%2==1&&(i+1)%2==0) {
 				actionButton[i]=new JButton(Integer.toString(i));
 				actionButton[i].setPreferredSize(new Dimension(10,60));
 				actionButton[i].setEnabled(false);
 				position.add(actionButton[i]);
 				actionButton[i].setFont(new Font("궁서체", Font.BOLD, 8));
 			}
 			else if(c%2==0&&(i+1)%2==0) {
 				actionButton[i]=new JButton(Integer.toString(i));
 				actionButton[i].setPreferredSize(new Dimension(60,10));
 				actionButton[i].setEnabled(false);
 				position.add(actionButton[i]);
 				actionButton[i].setFont(new Font("궁서체", Font.BOLD, 8));
 			}
 			else if(c%2==1&&(i+1)%2==1) {
 				actionButton[i]=new JButton(Integer.toString(i));
 				actionButton[i].setPreferredSize(new Dimension(60,60));
 				actionButton[i].addActionListener(this);
 				position.add(actionButton[i]);
 				actionButton[i].setBackground(new Color(241, 244, 189)); 
 				actionButton[i].setFont(new Font("궁서체", Font.BOLD, 20)); 
 				actionButton[i].setForeground(new Color(18, 50, 133)); 
 				
 			}
 			else {
 				actionButton[i]=new JButton("W"+Integer.toString(i));
 				actionButton[i].addActionListener(this);
 				actionButton[i].setPreferredSize(new Dimension(10,10));
 				position.add(actionButton[i]);
 				actionButton[i].setFont(new Font("궁서체", Font.BOLD, 8));
 				
 			}
 			cnt++;
			if(cnt==17){
				cnt=0;
				c++;
			}
         }
         
         
         actionButton[8].setBackground(Color.red);	
         actionButton[8].setOpaque(true);
         p1=8;
         
         actionButton[280].setBackground(Color.blue);	
         actionButton[280].setOpaque(true);
         add(position, BorderLayout.CENTER);
         p2=280;
         
    }
	public void actionPerformed(ActionEvent e) {
		  String actionCommand = e.getActionCommand( );
		 
		  
		  
		  if(actionCommand.contains("W")) {
			  if(wall1==10)
				  return;
			  
			  wall1++;
			  int num=Integer.parseInt(actionCommand.substring(1));
			  
			  SubFrame sub = new SubFrame( );
			  sub.num=num;
			  sub.button=actionButton;
		      sub.setVisible(true);
		  }
		  
		  int n=Integer.parseInt(actionCommand);
		  String wall=actionButton[(p1+n)/2].getText();
		  if(!wall.equals("close")) {
			  if(actionCommand.equals(Integer.toString(p1-2))||actionCommand.equals(Integer.toString(p1+2))||actionCommand.equals(Integer.toString(p1+34))||actionCommand.equals(Integer.toString(p1-34))) {
				  
				  actionButton[p1].setBackground(Color.gray);
				  actionButton[p1].setText(Integer.toString(p1));
			      actionButton[p1].setOpaque(false);
				  
				  actionButton[n].setBackground(Color.red);	
				  actionButton[n].setText("p1");
			      actionButton[n].setOpaque(true);
			      p1=n;
			  }
		 
		  }
		
	
	
	
	
	}
}
