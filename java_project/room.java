import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class room extends JFrame 
implements ActionListener{
	
	 public static void main(String[] args) {
		 room room = new room( );
	     room.setVisible(true);
	 }

	
	public room() {
		 setTitle("My room");
         setSize(800, 800);	
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(null);
       
         
         JButton game=new JButton("GAME");
         game.addActionListener(this);
         game.setFont(new Font("굴림체", Font.BOLD, 80));
         game.setBounds(70, 80, 650, 200);
         add(game);
         
         JButton scheduler=new JButton("SCHDULER");
         scheduler.addActionListener(this);
         scheduler.setFont(new Font("굴림체", Font.BOLD, 80));
         scheduler.setBounds(70, 400, 650, 200);
         add( scheduler);
         
         
	}
	
	public void actionPerformed(ActionEvent e) {
		String cho=e.getActionCommand( );
		if(cho=="GAME") {
			game_q gui = new game_q( );
	        gui.setVisible(true);
		}
		else {
			 Week gui = new Week( );
		     gui.setVisible(true);
		}
			
	}
}
