import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Scheduler extends JFrame implements ActionListener {
	public int now_Week=1;
	public int Today=1;
	String[] Day = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday","every week"};
	
	public static final int WIDTH =1400;
    public static final int HEIGHT =1500;
    
    JTabbedPane tp=new JTabbedPane(); 
    
	public Scheduler(String g,String name,int w) {
		 Week set=new Week();
		 setTitle(g);
		 System.out.println(g);
         setSize(WIDTH, HEIGHT);	
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         //setLayout(CardLayout());
         
         JPanel panel=new JPanel();
         panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
         
         JPanel panel_1=new JPanel();
         panel_1.setLayout(new FlowLayout());
         JLabel nickname=new JLabel(name+"의 "+w+" 주 계획표");
         nickname.setFont(new Font("굴림체", Font.BOLD, 50));
         panel_1.add(nickname);
         
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
        	 b_1[i].setPreferredSize(new Dimension(180,100));
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
        	 b_3[i]=new JButton(0+"% 완료");
        	 b_3[i].setFont(new Font("굴림체", Font.BOLD, 20));
        	 b_3[i].setPreferredSize(new Dimension(150,100));
        	 east.add(b_3[i]);
         }
         panel_3.add(east);
         
         JScrollPane js = new JScrollPane(panel_3,
                                         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         js.setPreferredSize(new Dimension(1400,550));
       
         panel.add(js);
         
         JPanel panel_4=new JPanel();
         panel_4.setLayout(new GridLayout(2,1));
         JTextArea comment=new JTextArea(1,15);
         comment.setText("공부 좀 더 파이팅!! ");
         comment.setEditable(false);
         comment.setFont(new Font("굴림체", Font.BOLD, 30));
         panel_4.add(comment);
         
         Date today = new Date();
         
         JLabel date=new JLabel("TODAY "+now_Week+" WEEK "+Day[Today]+" "+today.getHours()+":"+today.getMinutes());
         date.setFont(new Font("굴림체", Font.BOLD, 40));
         panel_4.add(date);
         panel.add(panel_4);
         
         JPanel today_plan=new JPanel();
         JLabel now =new JLabel("지금 할 일");
         now.setFont(new Font("굴림체", Font.BOLD, 30));
         today_plan.add(now);
         
         JTextArea plan=new JTextArea(3,80);
         plan.setText("오늘 계획들");
         plan.setEditable(false);
         plan.setFont(new Font("굴림체", Font.BOLD, 30));
         
         JScrollPane j = new JScrollPane(plan,
                 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

         today_plan.add(j);     
         
         JButton complete=new JButton("완료");
         complete.addActionListener(this);
         complete.setFont(new Font("굴림체", Font.BOLD, 30));
         today_plan.add(complete);
         panel.add(today_plan);
         
         tp.add("main",panel);
         tp.setFont(new Font("굴림체", Font.BOLD, 20));
         
         
         JPanel set_panel=new JPanel();
         set_panel.setLayout(null);
         
         JPanel set_panel1=new JPanel();
         set_panel1.setLayout(new FlowLayout());
         JLabel everyday=new JLabel("planner scheduler  ");
         everyday.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel1.add(everyday);
         
         JComboBox comboBox=new JComboBox();
         String[] week_n=new String[w+1];
         for(int i=0;i<w;i++)
        	 week_n[i]=(i+1)+" WEEK";
         week_n[w]="every day";
         comboBox.setModel(new DefaultComboBoxModel(week_n));
         comboBox.setPreferredSize(new Dimension(180,50));
         comboBox.setFont(new Font("굴림체", Font.BOLD, 30));
         comboBox.setBackground(Color.WHITE);
         set_panel1.add(comboBox);
         
         
         JComboBox comboBox2=new JComboBox();
         comboBox2.setModel(new DefaultComboBoxModel(Day));
         comboBox2.setPreferredSize(new Dimension(200,50));
         comboBox2.setFont(new Font("굴림체", Font.BOLD, 30));
         comboBox2.setBackground(Color.WHITE);
         set_panel1.add(comboBox2);
         
         
         set_panel1.setBounds(200, 50,1000, 60);
         set_panel.add(set_panel1);
         
         JPanel set_panel2=new JPanel();
         set_panel2.setLayout(new FlowLayout());
         JComboBox everyday_set=new JComboBox();
         
         String[] t=new String[25];
         for(int i=0;i<25;i++)
        	 t[i]=i+" 시";
         everyday_set.setModel(new DefaultComboBoxModel(t));
         everyday_set.setPreferredSize(new Dimension(80,50));
         everyday_set.setFont(new Font("굴림체", Font.BOLD, 20));
         everyday_set.setBackground(Color.WHITE);
         set_panel2.add(everyday_set);
         
         String[] m=new String[25];
         for(int i=0;i<6;i++)
        	 m[i]=(i*10)+"분";
         JComboBox everyday_m=new JComboBox();
         everyday_m.setModel(new DefaultComboBoxModel(m));
         everyday_m.setPreferredSize(new Dimension(80,50));
         everyday_m.setFont(new Font("굴림체", Font.BOLD, 20));
         everyday_m.setBackground(Color.WHITE);
         set_panel2.add(everyday_m);
         
         JLabel label_set=new JLabel("시작 ="
         		+ "");
         label_set.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel2.add(label_set);
         
         JTextField T=new JTextField(2);
         T.setBackground(Color.WHITE);
         T.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel2.add(T);
         JLabel label_set1=new JLabel("시");
         label_set1.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel2.add(label_set1);
         
         JTextField M=new JTextField(2);
         M.setBackground(Color.WHITE);
         M.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel2.add(M);
         JLabel label_set2=new JLabel("분  동안 ");
         label_set2.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel2.add(label_set2);
         
         set_panel2.setBounds(200, 110,1000, 60);
         set_panel.add(set_panel2);
         
         JPanel set_panel3=new JPanel();
         
         JTextArea set_plan=new JTextArea(3,60);
         set_plan.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel3.add(set_plan);
         set_panel3.setBounds(100, 170,1200, 170);
         set_panel.add(set_panel3);
         
         JButton store=new JButton("저장");
         store.setBounds(1100, 340,100, 50);
         store.addActionListener(this);
         store.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel.add(store);
         
         drawJPanel set_panel4=new drawJPanel();
         set_panel4.setBounds(200, 370,1000, 1000);
         set_panel.add(set_panel4);
       
         
         
         tp.add("setting",set_panel);
         tp.setFont(new Font("굴림체", Font.BOLD, 20));
         
         
         add(tp);
	}
	
	
	 public void actionPerformed(ActionEvent e){
		 String what=e.getActionCommand();
		 if(what.matches(".*완료.*")) {
			 
		 }
		 else if(what.matches(".*저장.*")) {
			 
		 }
	 }
}

class drawJPanel extends JPanel{
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.drawOval(0,0,1000,1000);
	}
}
