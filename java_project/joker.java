import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class joker extends JFrame implements ActionListener{
	
	
	private int n;	
	private JTextField ioField1; 
    
  /*  public static void main(String[] args) {
    	joker jo=new joker();
    	jo.setVisible(true);
    }*/
	public joker() {
		
		setSize(300,200);
		setLayout(new BorderLayout(0,50));
		
		JLabel dukeLabel = new JLabel("joker위치를 고르시오. ");
		dukeLabel.setFont(new Font("궁서체", Font.BOLD, 20));
	     add(dukeLabel, BorderLayout.NORTH);
	   
	     
	     JPanel textPanel = new JPanel( );
	     textPanel.setLayout(new FlowLayout( )); 
	         
	     ioField1 = new JTextField(3);
	     ioField1.setBackground(Color.WHITE);	           
	     textPanel.add(ioField1);
	     
	     JLabel nameLabel = new JLabel("번째 카드 오른쪽 ");
	     textPanel.add(nameLabel);
			
	        
	     add(textPanel, BorderLayout.CENTER);
	     
	     JPanel buttonPanel = new JPanel( );
	     buttonPanel.setLayout(new GridLayout(1,3));
	     JButton front=new JButton("맨앞");
	     front.addActionListener(this);
	     buttonPanel.add(front);
	     
	     JButton YN=new JButton("확인");
	     YN.addActionListener(this);
	     buttonPanel.add(YN);
	     
	  
	     
	     add(buttonPanel, BorderLayout.SOUTH);
	     
			
	}
	public int getn() {
		return n;
	}
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand( );
		int a=Integer.parseInt(ioField1.getText());
		
		if(actionCommand.equals("맨앞")) {
			n=0;
			dispose();
			
		}
		else {
			n=a;
			dispose();
				
		}
	
			
	}
}
