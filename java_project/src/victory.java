import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class victory extends JFrame 
implements ActionListener {
	
	
	public victory(String winner) {
		 setTitle("Winner");
         setSize(600, 700);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout());
         
        JLabel label=new JLabel("  "+winner+"승리!!");
 		label.setFont(new Font("굴림체", Font.BOLD, 60)); 
 		add(label, BorderLayout.NORTH);
 		
 		
 		JPanel j = new JPanel(); 
 		JButton exit=new JButton("게임종료");
 		exit.setPreferredSize(new Dimension(300,200));
 		exit.setFont(new Font("굴림체", Font.BOLD, 60));
 		exit.addActionListener(this);
 		j.add(exit);
 		 
 		
 		JButton reset=new JButton("다시하기");
 		reset.setPreferredSize(new Dimension(300,200));
 		reset.setFont(new Font("굴림체", Font.BOLD, 60));
 		reset.addActionListener(this);
 		j.add(reset);
 		
 		add(j, BorderLayout.CENTER);
         
	}
	
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand( );
		if(actionCommand.equals("게임종료")) {
			game_q gui = new game_q( );
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dispose();
		}
		else {
			
			game_q gui = new game_q( );	
	        gui.setVisible(true);
			dispose();
		}
	}
	

}
