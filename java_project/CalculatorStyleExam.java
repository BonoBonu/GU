
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
 

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



class SubFrame extends JFrame implements ActionListener{
	//public int W;
	JPanel j = new JPanel(); 
	 MyMouseListener listener =new MyMouseListener();
	 wall walls =new wall();
	 
	public SubFrame() {
		super("SubFrame");
	
		add(j, "Center"); 
		setSize(500,500);
		
		JButton horizontal=new JButton("hor");
		horizontal.setPreferredSize(new Dimension(50,400));
		j.add(horizontal);
		horizontal.addMouseListener(walls);
		 
		
		JButton Vertical=new JButton("ver");
		Vertical.setPreferredSize(new Dimension(400,50));
		j.add(Vertical);
		Vertical.addMouseListener(walls);
		
		setLocation(200,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}

class MyMouseListener implements MouseListener{
	public JButton user;
	
	public void mouseClicked(MouseEvent e) {
		
		JButton buttonn=(JButton)e.getSource();
		String str=buttonn.getText();
		
		if(user!=null)
			user.setBackground(new Color(241, 244, 189));
		
		user=(JButton)e.getSource();
		
		buttonn.setBackground(Color.red);	
		}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent argO) {}
}

class wall implements MouseListener{
	public JButton user;
	
	public void mouseClicked(MouseEvent e) {
		
		JButton buttonn=(JButton)e.getSource();
		String str=buttonn.getText();
		
		if(user!=null)
			user.setBackground(new Color(241, 244, 189));
		
		user=(JButton)e.getSource();
		
		buttonn.setBackground(Color.black);	
		}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent argO) {}
}


public class CalculatorStyleExam extends JFrame implements ActionListener{
	 
	 SubFrame sf;
	 
	 MyMouseListener listener =new MyMouseListener();
	 

 
	JPanel jp = new JPanel(); 
	JButton[] jbtn = new JButton[289]; 

	public CalculatorStyleExam(){
		super("CalculatorStyleExam"); 
		


		add(jp, "Center"); 
		
		int cnt=0;
		int c=1;
		
		for (int i = 0; i < 289; i++) {
			
			if(c%2==1&&(i+1)%2==0) {
				jbtn[i]=new JButton();
				jbtn[i].setPreferredSize(new Dimension(20,100));
				jbtn[i].setEnabled(false);
				jp.add(jbtn[i]);
			}
			else if(c%2==0&&(i+1)%2==0) {
				jbtn[i]=new JButton();
				jbtn[i].setPreferredSize(new Dimension(100,20));
				jbtn[i].setEnabled(false);
				jp.add(jbtn[i]);
			}
			else if(c%2==1&&(i+1)%2==1) {
				jbtn[i]=new JButton(Integer.toString(i+1));
				jbtn[i].setPreferredSize(new Dimension(100,100));
				jp.add(jbtn[i]);
				
				jbtn[i].addMouseListener(listener);
				
				jbtn[i].setBackground(new Color(241, 244, 189)); 
				jbtn[i].setFont(new Font("궁서체", Font.BOLD, 20)); 
				jbtn[i].setForeground(new Color(18, 50, 133)); 
				
			}
			else {
				jbtn[i]=new JButton();
				jbtn[i].setPreferredSize(new Dimension(20,20));
				jp.add(jbtn[i]);
				
				jbtn[i].addActionListener(this);
			}
				
			cnt++;
			if(cnt==17){
				cnt=0;
				c++;
			}
			
			
		}

		setSize(1260, 1260);
		
	
		super.setVisible(true);
	
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
	
		if(sf==null) {
			sf=new SubFrame();
		}
		else {
			sf.dispose();
			sf=new SubFrame();
		}
	}
	public static void main(String[] args){
	
		new CalculatorStyleExam();
		
		
	}
}





