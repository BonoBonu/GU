
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class game_q extends JFrame 
                            implements ActionListener
{
    SubFrame sub = new SubFrame();
	public static final int WIDTH =2000;
    public static final int HEIGHT =1450;
    
    JButton[] actionButton=new JButton[289];
    JButton information = new JButton();
    
    
    int wall1=0;
    int wall2=0;
    
    int p1,p2;
    int use=1;
  
    public game_q(){
    	 setTitle("Quoridor game");
         setSize(WIDTH, HEIGHT);	
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     
         setLayout(null);
         //information.setText("<html>>>p1턴  <br><br>벽"+(10-wall1)+"개</html>");
         information.setText("p1턴            벽"+(10-wall1)+"개");
         information.setFont(new Font("굴림체", Font.BOLD, 80));

         information.setBounds(1500,50,450,800);
       
         JPanel position = new JPanel();
         
         position.setBackground(new Color(102, 051, 000));
         position.setLayout(new FlowLayout());
     	int cnt=0;
		int c=1;
         for (int i = 0; i < 289; i++) {
 			
 			if(c%2==1&&(i+1)%2==0) {
 				actionButton[i]=new JButton(Integer.toString(i));
 				actionButton[i].setPreferredSize(new Dimension(25,120));
 				actionButton[i].setBackground(new Color(102, 051, 000));
 				actionButton[i].setEnabled(false);
 				position.add(actionButton[i]);
 				actionButton[i].setFont(new Font("궁서체", Font.BOLD, 0));
 			}
 			else if(c%2==0&&(i+1)%2==0) {
 				actionButton[i]=new JButton(Integer.toString(i));
 				actionButton[i].setPreferredSize(new Dimension(120,25));
 				actionButton[i].setBackground(new Color(102, 051, 000));
 				actionButton[i].setEnabled(false);
 				position.add(actionButton[i]);
 				actionButton[i].setFont(new Font("궁서체", Font.BOLD, 0));
 			}
 			else if(c%2==1&&(i+1)%2==1) {
 				actionButton[i]=new JButton(Integer.toString(i));
 				actionButton[i].setPreferredSize(new Dimension(120,120));
 				actionButton[i].addActionListener(this);
 				position.add(actionButton[i]);
 				actionButton[i].setBackground(Color.black); 
 				actionButton[i].setFont(new Font("궁서체", Font.BOLD, 0)); 
 				actionButton[i].setForeground(new Color(18, 50, 133)); 
 				
 			}
 			else {
 				actionButton[i]=new JButton("W"+Integer.toString(i));
 				actionButton[i].addActionListener(this);
 				actionButton[i].setPreferredSize(new Dimension(25,25));
 				position.add(actionButton[i]);
 				actionButton[i].setFont(new Font("궁서체", Font.BOLD, 0));
 				
 			}
 			cnt++;
			if(cnt==17){
				cnt=0;
				c++;
			}
         }
         
         
         actionButton[8].setBackground(Color.red);	
         actionButton[8].setText("p1");
         actionButton[8].setFont(new Font("굴림체", Font.BOLD, 30));
         actionButton[8].setForeground(Color.BLACK);
         actionButton[8].setOpaque(true);
         actionButton[8].setEnabled(false);
         p1=8;
         
         actionButton[280].setBackground(Color.blue);	
         actionButton[280].setText("p2");
         actionButton[280].setOpaque(true);
         actionButton[280].setFont(new Font("굴림체", Font.BOLD, 30));
         actionButton[280].setForeground(Color.WHITE);
         actionButton[280].setEnabled(false);
         add(position, BorderLayout.CENTER);
         p2=280;
         position.setBounds(10, 0, 1450, 1450);
     
         
    }
	public void actionPerformed(ActionEvent e) {
		  String actionCommand = e.getActionCommand( );
		 
		  if(use==1) {		  
			  if(actionCommand.contains("W")) {
				  if(wall1==10)
					  return;
				  
				  
				 
				  int num=Integer.parseInt(actionCommand.substring(1));
				  if((actionButton[num+1].getText()).equals("close")&&((actionButton[num+17].getText()).equals("close")||(actionButton[num-17].getText()).equals("close"))) {
					  actionButton[num].setEnabled(false);
					  actionButton[num].setText("close");
					  actionButton[num].setBackground(new Color(255, 204, 153));
					  return;
				  }
				  else if((actionButton[num-1].getText()).equals("close")&&((actionButton[num+17].getText()).equals("close")||(actionButton[num-17].getText()).equals("close"))) {
					  actionButton[num].setEnabled(false);
					  actionButton[num].setText("close");
					  actionButton[num].setBackground(new Color(255, 204, 153));
					  return;
				  }
				  
				  sub = new SubFrame(wall1);
				  sub.num=num;
				  sub.button=actionButton;
				  
			      sub.setVisible(true);
			      wall1++;
			   	  use=2;
			      information.setText("<html>>>p2턴  <br><br>벽"+(10-wall2)+"개</html>");
			      information.setFont(new Font("굴림체", Font.BOLD, 80));
			      
			  }
			  else {
				  int n=Integer.parseInt(actionCommand);
				  String wall=actionButton[(p1+n)/2].getText();
				  if(!wall.equals("close")) {
					  if(actionCommand.equals(Integer.toString(p1-2))||actionCommand.equals(Integer.toString(p1+2))||actionCommand.equals(Integer.toString(p1+34))||actionCommand.equals(Integer.toString(p1-34))) {
						  
						  actionButton[p1].setBackground(Color.black); 
						  actionButton[p1].setText(Integer.toString(p1));
						  actionButton[p1].setFont(new Font("굴림체", Font.BOLD, 0));
						  actionButton[p1].setEnabled(true);
						  
						  actionButton[n].setBackground(Color.red);	
						  actionButton[n].setText("p1");
						  actionButton[n].setFont(new Font("굴림체", Font.BOLD, 30));
						  actionButton[n].setEnabled(false);
					      p1=n;
					      use=2;
					      information.setText("<html>>>p2턴  <br><br>벽"+(10-wall2)+"개</html>");
					      information.setFont(new Font("굴림체", Font.BOLD, 80));
					     if(n==272||n==274||n==276||n==278||n==280||n==282||n==284||n==286||n==288) {
					    	 victory vic=new victory("p1");
					    	 vic.setVisible(true); 
					     }
					  }
					  else if((p1+n)/2==p2&&(Math.abs(p1-p2)==2||Math.abs(p1-p2)==34)) {
						  if(!(actionButton[(p1+p2)/2].getText()).equals("close")) {
							  actionButton[p1].setBackground(Color.black); 
							  actionButton[p1].setText(Integer.toString(p1));
							  actionButton[p1].setFont(new Font("굴림체", Font.BOLD, 0));
							  actionButton[p1].setEnabled(true);
							  
							  actionButton[n].setBackground(Color.red);	
							  actionButton[n].setText("p1");
							  actionButton[n].setFont(new Font("굴림체", Font.BOLD, 30));
							  actionButton[n].setEnabled(false);
						      p1=n;
						      use=2;
						      information.setText("<html>>>p2턴  <br><br>벽"+(10-wall2)+"개</html>");
						      information.setFont(new Font("굴림체", Font.BOLD, 80));
						     if(n==272||n==274||n==276||n==278||n==280||n==282||n==284||n==286||n==288) {
						    	 victory vic=new victory("p1");
						    	 vic.setVisible(true); 
						     }
						
						  }
					  }
				 
				  }
			  
			 
			  }
			  
		  
		  }
		  else {
			  if(actionCommand.contains("W")) {
				  if(wall2==10)
					  return;
				  
				  int num=Integer.parseInt(actionCommand.substring(1));
				  if((actionButton[num+1].getText()).equals("close")&&((actionButton[num+17].getText()).equals("close")||(actionButton[num-17].getText()).equals("close"))) {
					  actionButton[num].setEnabled(false);
					  actionButton[num].setText("close");
					  actionButton[num].setBackground(new Color(255, 204, 153));
					  return;
				  }
				  else if((actionButton[num-1].getText()).equals("close")&&((actionButton[num+17].getText()).equals("close")||(actionButton[num-17].getText()).equals("close"))) {
					  actionButton[num].setEnabled(false);
					  actionButton[num].setText("close");
					  actionButton[num].setBackground(new Color(255, 204, 153));
					  return;
				  } 
				  
				  sub = new SubFrame(wall2);
				  sub.num=num;
				  sub.button=actionButton;
				  
			      sub.setVisible(true);
			      
				  wall2++;
			   	  use=1;
				  information.setText("<html>>>p1턴  <br><br>벽"+(10-wall1)+"개</html>");
			      information.setFont(new Font("굴림체", Font.BOLD, 80));
			      
			      
			  }
			  else {
				  int n=Integer.parseInt(actionCommand);
				  String wall=actionButton[(p2+n)/2].getText();
				  if(!wall.equals("close")) {
					  if(actionCommand.equals(Integer.toString(p2-2))||actionCommand.equals(Integer.toString(p2+2))||actionCommand.equals(Integer.toString(p2+34))||actionCommand.equals(Integer.toString(p2-34))) {
						  
						  actionButton[p2].setBackground(Color.black); 
						  actionButton[p2].setText(Integer.toString(p2));
						  actionButton[p2].setFont(new Font("굴림체", Font.BOLD, 0));
						  actionButton[p2].setEnabled(true);
						  
						  actionButton[n].setBackground(Color.blue);	
						  actionButton[n].setText("p2");
						  actionButton[n].setForeground(Color.WHITE);
						  actionButton[n].setFont(new Font("굴림체", Font.BOLD, 30));
						  actionButton[n].setEnabled(false);
					      p2=n;
					      use=1;
					      information.setText("<html>>>p1턴  <br><br>벽"+(10-wall1)+"개</html>");
					      information.setFont(new Font("굴림체", Font.BOLD, 80));
					     if(n==0||n==2||n==4||n==6||n==8||n==10||n==12||n==14||n==16) {
					    	 victory vic=new victory("p2");
					    	 vic.setVisible(true);
					     }
					  }
					  else if((p2+n)/2==p1&&(Math.abs(p1-p2)==2||Math.abs(p1-p2)==34)) {
						  if(!(actionButton[(p1+p2)/2].getText()).equals("close")) {
							  actionButton[p2].setBackground(Color.black); 
							  actionButton[p2].setText(Integer.toString(p2));
							  actionButton[p2].setFont(new Font("굴림체", Font.BOLD, 0));
							  actionButton[p2].setEnabled(true);
							  
							  actionButton[n].setBackground(Color.blue);	
							  actionButton[n].setText("p2");
							  actionButton[n].setForeground(Color.WHITE);
							  actionButton[n].setFont(new Font("굴림체", Font.BOLD, 30));
							  actionButton[n].setEnabled(false);
						      p2=n;
						      use=1;
						      information.setText("<html>>>p1턴  <br><br>벽"+(10-wall1)+"개</html>");
						      information.setFont(new Font("굴림체", Font.BOLD, 80));
						     if(n==0||n==2||n==4||n==6||n==8||n==10||n==12||n==14||n==16) {
						    	 victory vic=new victory("p2");
						    	 vic.setVisible(true);
						     }
						 
						  }
					  }
				 
				  }
			  
			 
			  }
			  
		  }
			  
	
	
	
	
	}
}
