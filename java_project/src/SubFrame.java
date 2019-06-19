import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubFrame extends JFrame implements ActionListener{
	int num;
	JButton[] button=new JButton[289];
	int wall=0;
	public SubFrame() {
		
	}
	
	public SubFrame(int cnt) {
		wall=0;
		setTitle("Wall position");
		setSize(600,600);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocation(1500,10);
		JLabel label=new JLabel(cnt+"번째 벽으로 막을 방향!");
		label.setFont(new Font("굴림체", Font.BOLD, 40)); 
		 add(label, BorderLayout.NORTH);
		
		JPanel j = new JPanel(); 
		JButton horizontal=new JButton("H");
		horizontal.setPreferredSize(new Dimension(60,400));
		horizontal.setFont(new Font("굴림체", Font.BOLD, 40)); 
		horizontal.setBackground(new Color(255, 204, 153));
		horizontal.addActionListener(this);
		
		horizontal.addMouseListener(new MouseListener(){
			  public void mouseEntered(MouseEvent e){
				  if(button[num-17].getText()!="close"&&button[num+17].getText()!="close") {
				  button[num-17].setBackground(new Color(255, 204, 153));
				  button[num+17].setBackground(new Color(255, 204, 153));
				  }
			  }
			  public void mouseExited(MouseEvent e){
				  if(button[num-17].getText()!="close"&&button[num+17].getText()!="close") {
				  button[num-17].setBackground(new Color(102, 051, 000));
				  button[num+17].setBackground(new Color(102, 051, 000));
				  }
			  }
			  public void mouseClicked(MouseEvent arg0) {}
			  public void mousePressed(MouseEvent arg0) {}
			  public void mouseReleased(MouseEvent arg0) {}
			  });
		j.add(horizontal);
		 
		
		JButton Vertical=new JButton("V");
		Vertical.setPreferredSize(new Dimension(400,60));
		Vertical.setFont(new Font("굴림체", Font.BOLD, 40)); 
		Vertical.setBackground(new Color(255, 204, 153));
		Vertical.addActionListener(this);
		
		Vertical.addMouseListener(new MouseListener(){
			  public void mouseEntered(MouseEvent e){
				  if(button[num-1].getText()!="close"&&button[num+1].getText()!="close") {
				  button[num-1].setBackground(new Color(255, 204, 153));
				  button[num+1].setBackground(new Color(255, 204, 153));
				  }
			  }
			  public void mouseExited(MouseEvent e){
				  if(button[num-1].getText()!="close"&&button[num+1].getText()!="close") {
				  button[num-1].setBackground(new Color(102, 051, 000));
				  button[num+1].setBackground(new Color(102, 051, 000));
				  }
			  }
			  public void mouseClicked(MouseEvent arg0) {}
			  public void mousePressed(MouseEvent arg0) {}
			  public void mouseReleased(MouseEvent arg0) {}
			  });
		j.add(Vertical);

		add(j, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
	
		String actionCommand = e.getActionCommand( );
		String a,b;
		game_q q=new game_q();
		
		if(actionCommand.equals("H")) {
			wall++;
			a=button[num-17].getText();
			b=button[num+17].getText();
			
			if(!a.equals("close")&&!b.equals("close")) {
				button[num-17].setText("close");
				button[num-17].setBackground(new Color(255, 204, 153));
				button[num+17].setText("close");
				button[num+17].setBackground(new Color(255, 204, 153));
				button[num].setBackground(new Color(255, 204, 153));
				button[num].setText("close");
				button[num].setEnabled(false);
				
				dispose( );
			
			}
		}
		else {
			a=button[num-1].getText();
			b=button[num+1].getText();
			if(!a.equals("close")&&!b.equals("close")){
				button[num-1].setText("close");
				button[num+1].setBackground(new Color(255, 204, 153));
				button[num+1].setText("close");
				button[num-1].setBackground(new Color(255, 204, 153));
				button[num].setBackground(new Color(255, 204, 153));
				button[num].setText("close");
				button[num].setEnabled(false);
				
				dispose( );
			}
			
		}
	}
	
}
