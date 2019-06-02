import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class subframe extends JFrame implements ActionListener{
	public subframe() {
		setSize(400,200);
		setLayout(new BorderLayout());
		
		JPanel j = new JPanel(); 
	
		JButton ans=new JButton("맞추기");
		ans.setPreferredSize(new Dimension(100,100));
		ans.addActionListener(this);
		j.add(ans);
		 
		
		JButton cho=new JButton("뽑기");
		cho.setPreferredSize(new Dimension(100,100));
		cho.addActionListener(this);
		j.add(cho);
		
		add(j, BorderLayout.CENTER);
		
	}
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand( );
	}
}
