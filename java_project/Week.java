import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Week extends JFrame implements ActionListener {
	
	public JTextField nickname;
	public JTextField week;
	public JTextField goal;

	 public static void main(String[] args) {
		 Week gui = new Week( );
	        gui.setVisible(true);
	 }
	 public Week() {
		 setTitle("목표설정!");
         setSize(800, 400);	
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout());
         
         JPanel Panel=new JPanel();
         Panel.setLayout(new GridLayout(4,1));
         
         JPanel termPanel=new JPanel();
         JLabel term =new JLabel("목표기간: ");
         term.setFont(new Font("굴림체", Font.BOLD, 30));
         termPanel.add(term);
         
         week=new JTextField(3);
         week.setBackground(Color.WHITE);
         week.setFont(new Font("굴림체", Font.BOLD, 30));
         termPanel.add(week);
         JLabel term1 =new JLabel(" 주");
         term1.setFont(new Font("굴림체", Font.BOLD, 30));
         termPanel.add(term1);
         Panel.add(termPanel);
         
         
         JPanel goalPanel=new JPanel();
         JLabel goalwrite =new JLabel("목표: ");
         goalwrite.setFont(new Font("굴림체", Font.BOLD, 30));
         goalPanel.add(goalwrite);
         goal=new JTextField(30);
         goal.setBackground(Color.WHITE);
         goal.setFont(new Font("굴림체", Font.BOLD, 30));
         goalPanel.add(goal);
         Panel.add(goalPanel);
         
         JPanel nicknamePanel=new JPanel();
         JLabel nicknamewrite =new JLabel("닉네임: ");
         nicknamewrite.setFont(new Font("굴림체", Font.BOLD, 30));
         nicknamePanel.add(nicknamewrite);
         nickname=new JTextField(10);
         nickname.setBackground(Color.WHITE);
         nickname.setFont(new Font("굴림체", Font.BOLD, 30));
         nicknamePanel.add(nickname);
         Panel.add(nicknamePanel);
         
         JPanel buttonPanel=new JPanel();
         JButton start=new JButton("시작");
         start.setFont(new Font("굴림체", Font.BOLD, 30));
         start.addActionListener(this);
         buttonPanel.setLayout(new FlowLayout());
         buttonPanel.add(start);
         Panel.add(buttonPanel);
         
         add(Panel,BorderLayout.CENTER);
         
	 }
	 
	 public void actionPerformed(ActionEvent e) {
		    Scheduler scheduler = new Scheduler(goal.getText(), nickname.getText(),Integer.parseInt(week.getText()));
		    scheduler.setVisible(true);	   
		    
		    dispose( );
	 }
}
