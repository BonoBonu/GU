
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
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Scheduler extends JFrame implements ActionListener {
	public static int now_Week=1;
	public static int Today=0;
	public static int add=0;
	public static int W=0;
	private Color sampleColor=Color.LIGHT_GRAY;
	private Color sampleColor1=Color.LIGHT_GRAY;
	private Color sampleColor2=Color.LIGHT_GRAY;
	private Color sampleColor3=Color.LIGHT_GRAY;
	private Color sampleColor4=Color.LIGHT_GRAY;
	private Color sampleColor5=Color.LIGHT_GRAY;
	Color gauge=Color.green;
	String[] Day = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

	public static final int WIDTH =1400;
    public static final int HEIGHT =1500;
    String[][] str_set;
    int[][] chk_cnt;
    StringTokenizer st;
    
    JPanel panel;
    JPanel set_panel;
    JPanel set_color;
    
    JTabbedPane tp=new JTabbedPane(); 
    JTextField set_plan=new JTextField(60);
    JTextArea set_p=new JTextArea(60,60);
    Date today = new Date();
    
    JButton finish;
    JButton colorchange;
    JButton colorchange1;
    JButton colorchange2;
    JButton colorchange3;
    JButton colorchange4;
    JButton colorchange5;
    JButton complete;
    JButton[] s_2;
    JButton[] b_1;
    JButton[] b_2;
    JButton[] b_3;
    JButton all;
    JButton[] s_1;
    
    JPanel plan;
    JPanel panel_1;
    JPanel panel_2;
    JPanel panel_3;
    JPanel west;
    JPanel center;
    JPanel east;
    JPanel panel_4;
    JPanel set_panel4;
    JPanel west1;
    JPanel today_plan;
    JPanel set_panel1;   
    JPanel set_panel3;  
    JPanel center1;
    
    JLabel nickname;
    JLabel Progress;
    JLabel everyday;
    JLabel now;
    JLabel date=new JLabel();
    JLabel progress=new JLabel();
    
    JCheckBox[] chk;
    JTextArea comment;
    
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
         
		 Week set=new Week();
		 setTitle(g);
         setSize(WIDTH, HEIGHT);	
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         
         panel=new JPanel();
         panel.setLayout(null);
         
         panel_1=new JPanel();
         panel_1.setBackground(Color.WHITE);
         panel_1.setLayout(new FlowLayout());
         nickname=new JLabel(name+"의 "+w+" 주 계획표");
         nickname.setFont(new Font("굴림체", Font.BOLD, 70));        
         panel_1.add(nickname);
         panel_1.setBounds(40, 0,1300, 100);
         panel.add(panel_1);
         
         panel_2=new JPanel();
         panel_2.setBackground(Color.WHITE);
         panel_2.setLayout(new GridLayout(2,1));
         Progress=new JLabel("목표: "+g+"!!");
         Progress.setFont(new Font("굴림체", Font.BOLD, 50));
         panel_2.add(Progress);
         progress.setText(now_Week+"주차 "+Day[Today]+" 입니다. 현재까지 0% 완료했습니다");
         progress.setFont(new Font("굴림체", Font.BOLD, 40));
         panel_2.add(progress);
         panel_2.setBounds(40, 110,1300, 110);
         panel.add(panel_2);
         
         panel_3=new JPanel();
         panel_3.setLayout(new FlowLayout());
         panel_3.setBackground(Color.WHITE);
         west=new JPanel();
         west.setLayout(new GridLayout(w,1));
         b_1=new JButton[w];
         for(int i=0;i<w;i++) {
        	 b_1[i]=new JButton((i+1)+" WEEK");
        	 b_1[i].setFont(new Font("굴림체", Font.BOLD, 30));
        	 b_1[i].setPreferredSize(new Dimension(180,100));
        	 b_1[i].setForeground(Color.BLACK);
        	 west.add(b_1[i]);
         }
         panel_3.add(west);
         
         center=new JPanel();
         center.setLayout(new GridLayout(w,7));
         b_2=new JButton[w*7];
         for(int i=0;i<w*7;i++) {
        	 b_2[i]=new JButton("X");
        	 b_2[i].setFont(new Font("굴림체", Font.BOLD, 50));
        	 b_2[i].setPreferredSize(new Dimension(100,100));
        	 b_2[i].setForeground(Color.BLACK);
        	 center.add(b_2[i]);
         }
         panel_3.add(center);
         
         east=new JPanel();
         east.setLayout(new GridLayout(w,7));
         b_3=new JButton[w];
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
         
         panel_4=new JPanel();
         panel_4.setBackground(Color.WHITE);
         panel_4.setLayout(new GridLayout(2,1));
         comment=new JTextArea(1,15);
         comment.setText("시작이 반 이래~ 파이팅!! ");
         comment.setEditable(false);
         comment.setFont(new Font("굴림체", Font.BOLD, 40));
         panel_4.add(comment);
         
         date.setText("TODAY "+now_Week+" WEEK "+Day[Today]);
         date.setFont(new Font("굴림체", Font.BOLD, 20));
         panel_4.add(date);
         panel_4.setBounds(40, 800,1300, 100);
         panel.add(panel_4);
         
         today_plan=new JPanel();
         today_plan.setBackground(Color.WHITE);
         now =new JLabel("오늘 할 일");
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
    		 		b_2[day].setBackground(gauge);
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
	        	        	 comment.setText("저번주는 실천을 거의 안했어!! 정신 차려!");
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
         
         tp.add("Main",panel);
         tp.setFont(new Font("굴림체", Font.BOLD, 30));
         
         
         //Plan_set
         
         set_panel=new JPanel();
         set_panel.setLayout(null);
         
         
         set_panel1=new JPanel();
         set_panel1.setLayout(new FlowLayout());
         everyday=new JLabel("planner scheduler  ");
         everyday.setFont(new Font("굴림체", Font.BOLD, 40));
         set_panel1.add(everyday);
         set_panel1.setBounds(100, 20,1200, 60);
         
         finish=new JButton("Start");
         finish.addActionListener(this);
         finish.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel1.add(finish);
         set_panel.add(set_panel1);
         
         set_panel3=new JPanel();
         set_plan.setFont(new Font("굴림체", Font.BOLD, 30));
         set_panel3.add(set_plan);
         
         set_p.setFont(new Font("굴림체", Font.BOLD, 30));
         set_p.setEditable(false);
         JScrollPane j_set = new JScrollPane(set_p,
                 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         j_set.setPreferredSize(new Dimension(1020,200));

         set_panel3.add(j_set); 
         all=new JButton("Every day");
         all.setFont(new Font("굴림체", Font.BOLD, 30));
         all.addActionListener(this);
         set_panel3.add(all);
         set_panel3.setBounds(100, 80,1200, 300);
         set_panel.add(set_panel3);
         
        
         set_panel4=new JPanel();
         set_panel4.setLayout(new FlowLayout());
         west1=new JPanel();
         west1.setLayout(new GridLayout(w,1));
         s_1=new JButton[w];
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
         center1=new JPanel();
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
         
         tp.add("Plan_set",set_panel);
         tp.setFont(new Font("굴림체", Font.BOLD, 30));
         
         //set_color
         
         set_color=new JPanel();
         set_color.setLayout(null);
         
         colorchange=new JButton("background color");
         colorchange.setFont(new Font("굴림체", Font.BOLD, 30));
         colorchange.setBounds(500,100,500,50);
         colorchange.addActionListener(this);
         set_color.add(colorchange);
         
         colorchange1=new JButton("letter color");
         colorchange1.setFont(new Font("굴림체", Font.BOLD, 30));
         colorchange1.setBounds(500,200,500,50);
         colorchange1.addActionListener(this);
         set_color.add(colorchange1);
         
         colorchange2=new JButton("button color");
         colorchange2.setFont(new Font("굴림체", Font.BOLD, 30));
         colorchange2.setBounds(500,300,500,50);
         colorchange2.addActionListener(this);
         set_color.add(colorchange2);
         
         colorchange3=new JButton("gauge color");
         colorchange3.setFont(new Font("굴림체", Font.BOLD, 30));
         colorchange3.setBounds(500,400,500,50);
         colorchange3.addActionListener(this);
         set_color.add(colorchange3);
         
         colorchange4=new JButton("panel color");
         colorchange4.setFont(new Font("굴림체", Font.BOLD, 30));
         colorchange4.setBounds(500,500,500,50);
         colorchange4.addActionListener(this);
         set_color.add(colorchange4);
         
         colorchange5=new JButton("textBackground color");
         colorchange5.setFont(new Font("굴림체", Font.BOLD, 30));
         colorchange5.setBounds(400,600,700,50);
         colorchange5.addActionListener(this);
         set_color.add(colorchange5);
         
         tp.add("Color_set",set_color);
         tp.setFont(new Font("굴림체", Font.BOLD, 30));
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
		 else if(what.matches(".*color.*")) {
			 if(what.equals("background color")) {
				 sampleColor =JColorChooser.showDialog(this, "JColorChooser",sampleColor);
				 if(sampleColor !=null) {
					 panel.setBackground(sampleColor);
					 set_panel.setBackground(sampleColor);
					 set_color.setBackground(sampleColor);
				 }
			 }
			 else if(what.equals("letter color")) {
				 sampleColor1 =JColorChooser.showDialog(this, "JColorChooser",sampleColor1);
				 if(sampleColor1 !=null) {
					 nickname.setForeground(sampleColor1);
					 Progress.setForeground(sampleColor1);
					 comment.setForeground(sampleColor1);
					 date.setForeground(sampleColor1);
					 now.setForeground(sampleColor1);
					 complete.setForeground(sampleColor1);
					 tp.setForeground(sampleColor1);
					 everyday.setForeground(sampleColor1);
					 finish.setForeground(sampleColor1);
					 all.setForeground(sampleColor1);
					 plan.setForeground(sampleColor1);
					 set_plan.setForeground(sampleColor1);
					 set_p.setForeground(sampleColor1);
					 colorchange.setForeground(sampleColor1);
					 colorchange1.setForeground(sampleColor1);
					 colorchange2.setForeground(sampleColor1);
					 colorchange3.setForeground(sampleColor1);
					 colorchange4.setForeground(sampleColor1);
					 colorchange5.setForeground(sampleColor1);
					 for(int i=0;i<W;i++) {
						 b_1[i].setForeground(sampleColor1);
						 b_3[i].setForeground(sampleColor1);
						 s_1[i].setForeground(sampleColor1);
					 }
					 for(int i=0;i<W*7;i++) {
						 s_2[i].setForeground(sampleColor1);
						 b_2[i].setForeground(sampleColor1);
					 }
				 }
			 }
			 else if(what.equals("button color")) {
				 sampleColor2 =JColorChooser.showDialog(this, "JColorChooser",sampleColor2);
				 if(sampleColor2 !=null) {
					 for(int i=0;i<W;i++) {
						 b_1[i].setBackground(sampleColor2);
						 b_3[i].setBackground(sampleColor2);
						 s_1[i].setBackground(sampleColor2);
					 }
					 for(int i=0;i<W*7;i++) {
						 s_2[i].setBackground(sampleColor2);
						 b_2[i].setBackground(sampleColor2);
					 }
					 complete.setBackground(sampleColor2);
					 finish.setBackground(sampleColor2);
					 all.setBackground(sampleColor2);
					 colorchange.setBackground(sampleColor2);
					 colorchange1.setBackground(sampleColor2);
					 colorchange2.setBackground(sampleColor2);
					 colorchange3.setBackground(sampleColor2);
					 colorchange4.setBackground(sampleColor2);
					 colorchange5.setBackground(sampleColor2);
				 }
			 }
			 else if(what.equals("gauge color")) {
				 sampleColor3 =JColorChooser.showDialog(this, "JColorChooser",sampleColor3);
				 if(sampleColor3 !=null) {
					 gauge=sampleColor3;
				 }
			 }
			 else if(what.equals("panel color")) {
				 sampleColor4 =JColorChooser.showDialog(this, "JColorChooser",sampleColor4);
				 if(sampleColor4 !=null) {
					 panel_1.setBackground(sampleColor4);
					 panel_2.setBackground(sampleColor4);
					 panel_3.setBackground(sampleColor4);
					 panel_4.setBackground(sampleColor4);
					 west.setBackground(sampleColor4);
					 center.setBackground(sampleColor4);
					 east.setBackground(sampleColor4);
					 today_plan.setBackground(sampleColor4);
					 set_panel1.setBackground(sampleColor4);
					 set_panel3.setBackground(sampleColor4);
					 set_panel4.setBackground(sampleColor4);
					 west1.setBackground(sampleColor4);
					 comment.setBackground(sampleColor4);
					 center1.setBackground(sampleColor4);
				 }
			 }
			 else if(what.equals("textBackground color")) {
				 sampleColor5 =JColorChooser.showDialog(this, "JColorChooser",sampleColor5);
				 if(sampleColor5 !=null) {
					 plan.setBackground(sampleColor5);
					 set_panel4.setBackground(sampleColor5);
					 set_plan.setBackground(sampleColor5);
					 set_p.setBackground(sampleColor5);
					 panel_3.setBackground(sampleColor5);
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
