import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class game  extends JFrame implements ActionListener{
	 public static final int WINDOW_WIDTH = 1150;
	 public static final int WINDOW_HEIGHT = 800;
	 
	 JButton[] Black=new JButton[13];
	 JButton[] White=new JButton[13];
	 
	 JLabel dukeLabel = new JLabel("4개를 고르시오!\n");
	 
	 JButton[] my=new JButton[13];
	 JButton[] com=new JButton[13];
	 
	 JPanel comcard = new JPanel( );
	 JPanel mycard = new JPanel( ); 
	 int number=0;
	 
	 int count_com=0;
	 int count_my=0;
	 
	 int[] black=new int[13];
	 int[] white=new int[13];
	 Random random=new Random();
	 
	 public static void main(String[] args) {
		 game card=new game();
		 card.setVisible(true);
		 
	 }
	
	 public game() {
		 setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setTitle("Davinci code game"); 
	     setLayout(new BorderLayout(0,150));
	     
	     dukeLabel.setFont(new Font("궁서체", Font.BOLD, 20));
	     add(dukeLabel, BorderLayout.NORTH);
	     
	     JPanel buttonPanel = new JPanel( );      
	     buttonPanel.setLayout(new FlowLayout());
	     
	     
	     for(int i=0;i<13;i++) {
				black[i]=i;
				white[i]=i;
			}
	     for(int i=0;i<13;i++) {
				int num1=random.nextInt(13);
				int num2=random.nextInt(13);
				
				int a=black[i];
				black[i]=black[num1];
				black[num1]=a;
				
				a=white[i];
				white[i]=white[num2];
				white[num2]=a;
			}
	     
	     for(int i=0;i<13;i++) {
	        	Black[i] = new JButton("B"+Integer.toString(black[i]));
		        Black[i].addActionListener(this);
		        Black[i].setBackground(Color.BLACK);	
		        Black[i].setOpaque(true);
		        Black[i].setMargin(new Insets(50, 20, 50, 20));
		        Black[i].setFont(new Font("궁서체", Font.BOLD, 0));
		        buttonPanel.add(Black[i]);
	        }
	        
	        for(int j=0;j<13;j++) {
	        	White[j] = new JButton("W"+Integer.toString(white[j]));
	        	White[j].addActionListener(this);
	        	White[j].setBackground(Color.WHITE);	
	        	White[j].setOpaque(true);
	        	White[j].setMargin(new Insets(50, 20, 50, 20));
	        	White[j].setFont(new Font("궁서체", Font.BOLD, 0));
		        buttonPanel.add(White[j]);
	        }
	        
	     add(buttonPanel, BorderLayout.CENTER);
	     
	     
	 }
	 
	 public void actionPerformed(ActionEvent e)
	    {
		 practice action=new practice();
		 if(count_my==4) {
			 return;
		 }
		 count_my++;
		 JButton button=(JButton)e.getSource();
		 String actionCommand = e.getActionCommand( );
	       mycard.setLayout(new FlowLayout());
	       
		
	       int num=Integer.parseInt(actionCommand.substring(1));
	    
	   
	       if(actionCommand.contains("B")) {
	    	   button.setVisible(false);
	    	   if(num==12) {
	    		   my[number]=new JButton("B-");
		    	   my[number].setBackground(Color.BLACK);	
		    	   my[number].setOpaque(true);
		    	   my[number].setMargin(new Insets(50, 20, 50, 20));
		    	   my[number].setFont(new Font("궁서체", Font.BOLD, 10));
		    	   mycard.add(my[number]);
		    	   
		    	   add(mycard, BorderLayout.SOUTH);
		    	   
		    	   number++;		    	   
	    	   }
	    	   else {
	    		   my[number]=new JButton(actionCommand);
		    	   my[number].setBackground(Color.BLACK);	
		    	   my[number].setOpaque(true);
		    	   my[number].setMargin(new Insets(50, 20, 50, 20));
		    	   my[number].setFont(new Font("궁서체", Font.BOLD, 10));
		    	   mycard.add(my[number]);
		    	   
		    	   add(mycard, BorderLayout.SOUTH);
		    			 
		    	   number++;
	    	   }
	       }
	       else if(actionCommand.contains("W")) {
	    	 
	    	   button.setVisible(false);
	    	   
	    	   if(num==12) {
	    		   my[number]=new JButton("W-");
		    	   my[number].setBackground(Color.WHITE);	
		    	   my[number].setOpaque(true);
		    	   my[number].setMargin(new Insets(50, 20, 50, 20));
		    	   my[number].setFont(new Font("궁서체", Font.BOLD, 10));
		    	   mycard.add(my[number]);
		    	   
		    	   add(mycard, BorderLayout.SOUTH);
		    			 
		    	   number++;
		    
	    	   }
	    	   else {
	    		   my[number]=new JButton(actionCommand);
		    	   my[number].setBackground(Color.WHITE);	
		    	   my[number].setOpaque(true);
		    	   my[number].setMargin(new Insets(50, 20, 50, 20));
		    	   my[number].setFont(new Font("궁서체", Font.BOLD, 10));
		    	   mycard.add(my[number]);
		    	   
		    	   add(mycard, BorderLayout.SOUTH);
		    			 
		    	   number++;
	    	   }
				  
	       }
	       comcard.setLayout(new FlowLayout());
	       int check=0;
	       while(check==0) {
	    	   int color=random.nextInt(2);
	    	   if(color==1) {
	    		   int c=random.nextInt(13);
	    		   boolean o=Black[c].isVisible();
	    		   if(o) {
	    			   com[count_com]=new JButton(Black[c].getActionCommand());
			    	   com[count_com].setBackground(Color.BLACK);	
			    	   com[count_com].setOpaque(true);
			    	   com[count_com].setMargin(new Insets(50, 20, 50, 20));
			    	   com[count_com].setFont(new Font("궁서체", Font.BOLD, 0));
			    	   comcard.add(com[count_com]);
			    	   
			    	   add(comcard, BorderLayout.NORTH);
			    	   count_com++;
	    			   check=1;
	    			   Black[c].setVisible(false);
	    		   }
	    	   }
	    	   else {
	    		   int c=random.nextInt(13);
	    		   boolean o=White[c].isVisible();
	    		   if(o) {
	    			   com[count_com]=new JButton(White[c].getActionCommand());
			    	   com[count_com].setBackground(Color.WHITE);	
			    	   com[count_com].setOpaque(true);
			    	   com[count_com].setMargin(new Insets(50, 20, 50, 20));
			    	   com[count_com].setFont(new Font("궁서체", Font.BOLD, 0));
			    	   comcard.add(com[count_com]);
			    	   
			    	   add(comcard, BorderLayout.NORTH);
			    	   count_com++;
	    			   check=1;
	    			   White[c].setVisible(false);
	    		   }
	    	   }
	       }
	       if(count_my==4) {
	    	   dukeLabel.setText("게임시작!");
	       	   dukeLabel.setFont(new Font("궁서체", Font.BOLD, 20));
	       	   
	       /*	subframe choice=new subframe();
	       	choice.setVisible(true);*/
	       	   
	       	   for(int i=0;i<number;i++) {
	       		   if(((my[i].getText()).substring(1)).equals("-")) {
	       			   joker joker=new joker();			    	  
			    	   joker.setVisible(true);
			    	   
			    	   
			    	 
	       		   }
	       	   }
	       }
	    }
}
