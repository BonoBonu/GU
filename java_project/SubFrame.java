import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SubFrame extends JFrame implements ActionListener{
	int num;
	JButton[] button=new JButton[289];
	
	public SubFrame() {
		setSize(500,500);
		setLayout(new BorderLayout());
		
		JPanel j = new JPanel(); 
		JButton horizontal=new JButton("hor");
		horizontal.setPreferredSize(new Dimension(50,400));
		horizontal.addActionListener(this);
		j.add(horizontal);
		 
		
		JButton Vertical=new JButton("ver");
		Vertical.setPreferredSize(new Dimension(400,50));
		Vertical.addActionListener(this);
		j.add(Vertical);
		
		add(j, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand( );
		String a,b;
		if(actionCommand.equals("hor")) {
			a=button[num-17].getText();
			b=button[num+17].getText();
			
			if(!a.equals("close")&&!b.equals("close")) {
				button[num-17].setText("close");
				button[num+17].setText("close");
				button[num].setEnabled(false);
				dispose( );
			
			}
		}
		else {
			a=button[num-1].getText();
			b=button[num+1].getText();
			if(!a.equals("close")&&!b.equals("close")){
				button[num-1].setText("close");
				button[num+1].setText("close");
				button[num].setEnabled(false);
				dispose( );
		
			}
		}
	}
	
}
