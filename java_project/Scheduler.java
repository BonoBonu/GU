import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Scheduler extends JFrame implements ActionListener {
	
	public int today=1;
	String[] Day = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	public Scheduler(String g,String name,int w) {
		Week set=new Week();
		 setTitle(g);
		 System.out.println(g);
         setSize(1400, 1500);	
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //setLayout(CardLayout());
         
         JPanel panel=new JPanel();
         panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
         
         JPanel panel_1=new JPanel();
         panel_1.setLayout(new FlowLayout());
         JLabel nickname=new JLabel(name+"의 ");
         nickname.setFont(new Font("굴림체", Font.BOLD, 50));
         panel_1.add(nickname);
         JButton button=new JButton(+w+" 주 계획표");
         button.setFont(new Font("굴림체", Font.BOLD, 50));
         panel_1.add(button);
         panel.add(panel_1);
         
         JPanel panel_2=new JPanel();
         panel_2.setBackground(Color.WHITE);
         panel_2.setLayout(new GridLayout(2,1));
         JLabel Progress=new JLabel("목표진행률");
         Progress.setFont(new Font("굴림체", Font.BOLD, 30));
         panel_2.add(Progress);
         JLabel progress=new JLabel("2주차 월요일입니다. 현재까지 50% 진행했습니다");
         progress.setFont(new Font("굴림체", Font.BOLD, 40));
         panel_2.add(progress);
         panel.add(panel_2);
         
         JPanel panel_3=new JPanel();
         panel_3.setLayout(new FlowLayout());
         JPanel west=new JPanel();
         west.setLayout(new GridLayout(w,1));
         JButton[] b_1=new JButton[w];
         for(int i=0;i<w;i++) {
        	 b_1[i]=new JButton((i+1)+" WEEK");
        	 b_1[i].setFont(new Font("굴림체", Font.BOLD, 30));
        	 b_1[i].setPreferredSize(new Dimension(150,100));
        	 west.add(b_1[i]);
         }
        panel_3.add(west);
         
         JPanel center=new JPanel();
         center.setLayout(new GridLayout(w,7));
         JButton[] b_2=new JButton[w*7];
         for(int i=0;i<w*7;i++) {
        	 b_2[i]=new JButton("X");
        	 b_2[i].setFont(new Font("굴림체", Font.BOLD, 50));
        	 b_2[i].setPreferredSize(new Dimension(100,100));
        	 center.add(b_2[i]);
         }
         panel_3.add(center);
         
         JPanel east=new JPanel();
         east.setLayout(new GridLayout(w,7));
         JButton[] b_3=new JButton[w];
         for(int i=0;i<w;i++) {
        	 b_3[i]=new JButton(10+"% 완료");
        	 b_3[i].setFont(new Font("굴림체", Font.BOLD, 20));
        	 b_3[i].setPreferredSize(new Dimension(150,100));
        	 east.add(b_3[i]);
         }
         panel_3.add(east);
         panel.add(panel_3);
         
         JPanel panel_4=new JPanel();
         panel_4.setLayout(new GridLayout(2,1));
         JTextArea comment=new JTextArea(1,15);
         comment.setText("공부 좀 더 파이팅!! ");
         comment.setFont(new Font("굴림체", Font.BOLD, 30));
         panel_4.add(comment);
         
         
         JLabel date=new JLabel("TODAY "+today+"WEEK"+Day[2]+"DAY 00:00");
         date.setFont(new Font("굴림체", Font.BOLD, 40));
         panel_4.add(date);
         panel.add(panel_4);
         
         JPanel today_plan=new JPanel();
         JLabel now =new JLabel("지금 할 일");
         now.setFont(new Font("굴림체", Font.BOLD, 30));
         today_plan.add(now);
         
         JButton complete=new JButton("완료");
         complete.setFont(new Font("굴림체", Font.BOLD, 30));
         today_plan.add(complete);
         
         JTextArea plan=new JTextArea(3,80);
         plan.setText("계획들");
         plan.setFont(new Font("굴림체", Font.BOLD, 30));
         today_plan.add(plan);
         
        
         
         panel.add(today_plan);
      
         
         
         
         add(panel);
	}
	

	 public void actionPerformed(ActionEvent e){
		 
	 }
}
