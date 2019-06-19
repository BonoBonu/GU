
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Scheduler extends JFrame implements ActionListener {
	public static int now_Week=1;
	public static int Today=0;
	public static int add=0;
	public static int W=0;
	String[] Day = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday","every week"};

	public static final int WIDTH =1400;
    public static final int HEIGHT =1500;
    String[][] str_set;
    int[][] chk_cnt;
    StringTokenizer st;
    JTabbedPane tp=new JTabbedPane(); 
    JTabbedPane ts=new JTabbedPane(); 
    JTextField set_plan=new JTextField(60);
    JTextArea set_p=new JTextArea(60,60);
    Date today = new Date();
    JButton finish;
    JLabel date=new JLabel();
    JLabel progress=new JLabel();
    JButton complete;
    JCheckBox[] chk;
    JButton[] s_2;
    JPanel plan;
    
	public Scheduler(String g,String name,int w) {
		W=w;
		chk_cnt=new int[w][7];
		str_set=new String[w][7];
		for(int i=0;i<w;i++)
			for(int j=0;j<7;j++)
				str_set[i][j]="오늘 할일\n";
		double[] percent = new double[w];
         
         for(int i = 0 ; i <w; i++)
         {
        	 percent[i] = 0.0;
         }
         
		 int[][] day_arr=new int[w][7];
		 
		 Week set=new Week();
		 setTitle(g);
         setSize(WIDTH, HEIGHT);	
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         
         JPanel panel=new JPanel();
         panel.setLayout(null);
         
         JPanel panel_1=new JPanel();
         panel_1.setBackground(Color.WHITE);
         panel_1.setLayout(new FlowLayout());
         JLabel nickname=new JLabel(name+"의 "+w+" 주 계획표");
         nickname.setFont(new Font("굴림체", Font.BOLD, 70));        
         panel_1.add(nickname);
         panel_1.setBounds(40, 0,1300, 100);
         panel.add(panel_1);
         
         JPanel panel_2=new JPanel();
         panel_2.setBackground(Color.WHITE);
         panel_2.setLayout(new GridLayout(2,1));
         JLabel Progress=new JLabel("목표: "+g+"!!");
         Progress.setFont(new Font("굴림체", Font.BOLD, 50));
         panel_2.add(Progress);
         progress.setText(now_Week+"주차 "+Day[Today]+" 입니다. 현재까지 0% 완료했습니다");
         progress.setFont(new Font("굴림체", Font.BOLD, 40));
         panel_2.add(progress);
         panel_2.setBounds(40, 110,1300, 110);
         panel.add(panel_2);
         
         JPanel panel_3=new JPanel();
         panel_3.setLayout(new FlowLayout());
         panel_3.setBackground(Color.WHITE);
         JPanel west=new JPanel();
         west.setLayout(new GridLayout(w,1));
         JButton[] b_1=new JButton[w];
         for(int i=0;i<w;i++) {
        	 b_1[i]=new JButton((i+1)+" WEEK");
        	 b_1[i].setFont(new Font("굴림체", Font.BOLD, 30));
        	 b_1[i].setPreferredSize(new Dimension(180,100));
        	 b_1[i].setForeground(Color.BLACK);
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
        	 b_2[i].setForeground(Color.BLACK);
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
        	 b_3[i].setForeground(Color.BLACK);
        	 east.add(b_3[i]);
         }
         panel_3.add(east);
         
         JScrollPane js = new JScrollPane(panel_3,
                                         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         js.setBounds(40, 230,1300, 550);
         panel.add(js);
         
         JPanel panel_4=new JPanel();
         panel_4.setBackground(Color.WHITE);
         panel_4.setLayout(new GridLayout(2,1));
         JTextArea comment=new JTextArea(1,15);
         comment.setText("시작이 반 이래~ 파이팅!! ");
         comment.setEditable(false);
         comment.setFont(new Font("굴림체", Font.BOLD, 40));
         panel_4.add(comment);
         
         date.setText("TODAY "+now_Week+" WEEK "+Day[Today]);
         date.setFont(new Font("굴림체", Font.BOLD, 20));
         panel_4.add(date);
         panel_4.setBounds(40, 800,1300, 100);
         panel.add(panel_4);
         
         JPanel today_plan=new JPanel();
         JLabel now =new JLabel("오늘 할 일");
         now.setFont(new Font("굴림체", Font.BOLD, 30));
         today_plan.add(now);
         
         plan=new JPanel();
         plan.setBackground(Color.WHITE);
         plan.setLayout(new BoxLayout(plan,BoxLayout.Y_AXIS));
         
         JScrollPane j = new JScrollPane(plan,
                 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         j.setPreferredSize(new Dimension(1300,350));

         today_plan.add(j); 
         
         
         complete=new JButton("완료");
         complete.addActionListener(this);
         complete.setVisible(false);
         complete.setFont(new Font("굴림체", Font.BOLD, 30));
         today_plan.add(complete);
         today_plan.setBounds(40, 920,1300, 500);
         
         
    	 complete.addActionListener(new ActionListener(){
    		 	public void actionPerformed(ActionEvent arg0){
    		 		int nn=0;
    		 		for(int k=0;k<chk_cnt[now_Week-1][Today];k++) {
    					 if(!chk[k].isSelected())
    						 nn++;
    				 }
    		 		int day = 7*now_Week+Today-7;
    		 		if(b_2[day].getText() == "O")
    		 		{}
    		 		else if(nn==0){
    		 		b_2[day].setText("O");
    		 		b_2[day].setBackground(Color.green);
    		 		percent[day/7] += 100/7.0;
    		 		b_3[day/7].setText(Integer.toString((int)percent[day/7])+"% 완료");
    		 		}
    		 		add=0;
    		 		for(int i=0;i<W;i++) {
    		 			add+=Integer.parseInt(((String)b_3[i].getText()).replaceAll("[^0-9]", ""));
    		 		}
    		 		Today++;
	        		if(Today==7) {
	        			Today=0;
	        			int progress_percent=Integer.parseInt(((String)b_3[now_Week-1].getText()).replaceAll("[^0-9]", ""));
	    		 		
	        			now_Week++;
	        			
	        			if(progress_percent>0 && progress_percent<20)
	        	        	 comment.setText("저번주는 실천을 거의 안했어!! 혼 좀 나야해!");
	        	         else if(progress_percent>=20 && progress_percent<40)
	        	        	 comment.setText("저번주는 실천이 좀 부족해!! 힘내자!!");
	        	         else if(progress_percent>=40 && progress_percent<60)
	        	        	 comment.setText("이번주는 더 잘할 수 있어!!");
	        	         else if(progress_percent>=60 && progress_percent<80)
	        	        	 comment.setText("충분히 잘하고있어!!");
	        	         else if(progress_percent>=80)
	        	        	 comment.setText("완벽하게 해내고 있어!! 이번주도 파이팅!");
	        			if(now_Week==W+1) {
	        				comment.setText("오늘이 목표 한 날이야!");
	        				complete.setVisible(false);
	        			}
	        		}
	        		date.setText("TODAY "+now_Week+" WEEK "+Day[Today]);
	        		progress.setText("현재 "+now_Week+"주차 "+Day[Today]+"입니다.   목표까지 "+add/W+"% 완료했습니다");
	        		
    		 	}
    	 });
    	 
         panel.add(today_plan);
         
         tp.add("main",panel);
         tp.setFont(new Font("굴림체", Font.BOLD, 20));
         
         
         //setting
         
         JPanel set_panel=new JPanel();
         set_panel.setLayout(null);
         
         
         JPanel set_panel1=new JPanel();
         set_panel1.setLayout(new FlowLayout());
         JLabel everyday=new JLabel("planner scheduler  ");
         everyday.setFont(new Font("굴림체", Font.BOLD, 40));
         set_panel1.add(everyday);
         set_panel1.setBounds(200, 0,1000, 60);
         finish=new JButton("Start");
         finish.addActionListener(this);
         finish.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel1.add(finish);
         set_panel.add(set_panel1);
         
         JPanel set_panel3=new JPanel();
         set_plan.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel3.add(set_plan);
         
         set_p.setFont(new Font("굴림체", Font.BOLD, 30));
         set_p.setEditable(false);
         JScrollPane j_set = new JScrollPane(set_p,
                 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         j_set.setPreferredSize(new Dimension(1020,200));

         set_panel3.add(j_set); 
         JButton all=new JButton("Every day");
         all.setFont(new Font("굴림체", Font.BOLD, 30));
         all.addActionListener(this);
         set_panel3.add(all);
         set_panel3.setBounds(100, 60,1200, 300);
         set_panel.add(set_panel3);
         
        
        JPanel set_panel4=new JPanel();
         set_panel4.setLayout(new FlowLayout());
         JPanel west1=new JPanel();
         west1.setLayout(new GridLayout(w,1));
         JButton[] s_1=new JButton[w];
         for(int i=0;i<w;i++) {
        	 s_1[i]=new JButton((i+1)+" WEEK");
        	 s_1[i].setFont(new Font("굴림체", Font.BOLD, 30));
        	 s_1[i].setPreferredSize(new Dimension(180,100));
        	 s_1[i].addActionListener(this);
        	 west1.add(s_1[i]);
         }
         set_panel4.add(west1);
         
         int cnt=0;
         int cnt_w=1;
         JPanel center1=new JPanel();
         center1.setLayout(new GridLayout(w,7));
         s_2=new JButton[w*7];
         for(int i=0;i<w*7;i++) {
        	 s_2[i]=new JButton(cnt_w+"."+Day[cnt]);
        	 s_2[i].setFont(new Font("굴림체", Font.BOLD, 20));
        	 s_2[i].setPreferredSize(new Dimension(150,100));
        	 s_2[i].addActionListener(this);
        	 center1.add(s_2[i]);
        	 cnt++;
        	 if(cnt==7) {
        		 cnt=0;
        		 cnt_w++;
        		 }
         }
         set_panel4.add(center1);
         
         JScrollPane js_s = new JScrollPane(set_panel4,
                                         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                         JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
         js_s.setBounds(50, 400,1300, 900);
         set_panel.add(js_s);
         
       
      
         tp.add("setting",set_panel);
         tp.setFont(new Font("굴림체", Font.BOLD, 20));
         add(tp);
        
	}
	
	
	
	 public void actionPerformed(ActionEvent e){
		 String what=e.getActionCommand();
		 if(what.matches(".*완료.*")) {
			 if(W+1==now_Week) {
				 int to=Today;
				 int we=now_Week;
				 to--;
				 if(to==-1) {
					 to=6;
					 we--;
				 }
				 for(int k=0;k<chk_cnt[we-1][to];k++) {
					 chk[k].setVisible(false);
				 }
				 JCheckBox end;
				 if(add/W<=50) {
					 end=new JCheckBox("목표달성하기엔 부족해 !!");
					 end.setFont(new Font("굴림체", Font.BOLD, 50));
					 plan.add(end);
				 }else if(add/W>=90){
					 end=new JCheckBox("목표달성 치킨먹자!!");
					 end.setFont(new Font("굴림체", Font.BOLD, 50));
					 plan.add(end);
				 }
				 else {
					 end=new JCheckBox("운이 좋으면 목표달성?!!");
					 end.setFont(new Font("굴림체", Font.BOLD, 50));
					 plan.add(end);
				 }
				
				
			 }
			 else {
			 int to=Today;
			 int we=now_Week;
			 to--;
			 if(to==-1) {
				 to=6;
				 we--;
			 }
			 for(int k=0;k<chk_cnt[we-1][to];k++) {
				 chk[k].setVisible(false);
			 }
			 chk=new JCheckBox[chk_cnt[now_Week-1][Today]];
			 StringTokenizer tokens = new StringTokenizer(str_set[now_Week-1][Today]);
			 String one= tokens.nextToken("\n");
			 for(int k=0;k<chk_cnt[now_Week-1][Today];k++) {
				 String two=tokens.nextToken("\n");
				 chk[k]= new JCheckBox(two, false);
				 chk[k].setFont(new Font("굴림체", Font.BOLD, 40));
				 plan.add(chk[k]);
			 }
			 }
			 
		 }
		 else if(what.matches(".*WEEK.*")) {
			 int num=Integer.parseInt(what.replaceAll("[^0-9]", ""))-1;
				 String str_txt=set_plan.getText();
					 for(int i=0;i<7;i++) {
						 if(str_txt.length()>=2) {
							 str_set[num][i]=str_set[num][i]+str_txt+"\n";
							 chk_cnt[num][i]++;
						 }
					 }
		 }
		 else if(what.matches(".*Start.*")) {
			 finish.setVisible(false);
			 complete.setVisible(true);
			 chk=new JCheckBox[chk_cnt[0][0]];
			 StringTokenizer tokens = new StringTokenizer(str_set[0][0]);
			 String one= tokens.nextToken("\n");
			 for(int k=0;k<chk_cnt[0][0];k++) {
				 String two=tokens.nextToken("\n");
				 chk[k]= new JCheckBox(two, false);
				 chk[k].setFont(new Font("굴림체", Font.BOLD, 40));
				 plan.add(chk[k]);
			 }
			    
		 }
		 else if(what.matches(".*Every.*")) {
			 String str_txt=set_plan.getText();
			 for(int num=0;num<W;num++) {
				 for(int i=0;i<7;i++) {
					 if(str_txt.length()>=2) {
						 str_set[num][i]=str_set[num][i]+str_txt+"\n";
						 chk_cnt[num][i]++;
					 }
				 }
			 }
		 }
		 else{
				 int num=Integer.parseInt(what.replaceAll("[^0-9]", ""))-1;
				 String str_txt=set_plan.getText();
				 int c=(what.replaceAll("[^0-9]", "")).length();
					 for(int i=0;i<7;i++) {
						 if((what.substring(c+1)).equals(Day[i])) {
							 if(str_txt.length()>=2) {
								 str_set[num][i]= str_set[num][i]+str_txt+"\n";
								 chk_cnt[num][i]++;
							 }
							 set_p.setText(str_set[num][i]);
						 }
					 }
				 
				 }
		 set_plan.setText("");
		 
	 }
}
