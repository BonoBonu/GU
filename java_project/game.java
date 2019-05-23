
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class game extends JFrame
                          implements ActionListener
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    JLabel storyLabel1;
    //private JTextArea story;

    public static void main(String[] args)
    {
    	game gui = new game( );
        gui.setVisible(true);
    }

    public game( )
    {
        setTitle("가위, 바위, 보");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        
        JLabel storyLabel = new JLabel("아래의 버튼 중에서 하나를 클릭하시오!");
        

        add(storyLabel, BorderLayout.NORTH);

       
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,3));
        
        JButton actionButton = new JButton("0: 가위");
        actionButton.addActionListener(this);
        buttonPanel.add(actionButton);

        JButton clearButton = new JButton("1: 바위");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        JButton paperButton = new JButton("2: 보");
        paperButton.addActionListener(this);
        buttonPanel.add(paperButton);
        
               
        add(buttonPanel, BorderLayout.CENTER);
        
        
        storyLabel1 = new JLabel("good luck!");
        add(storyLabel1, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e)
    {
    	Random r = new Random();
    	int n;
    	n=r.nextInt(3);
        String actionCommand = e.getActionCommand( );

        if (actionCommand.equals("0: 가위"))
        {
        	if(n==0) {
        		storyLabel1.setText("인간:0 컴퓨터:0 무승부");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        		}
        	else if(n==1) {
        		storyLabel1.setText("인간:0 컴퓨터:1 컴퓨터 승리");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        	else {
        		storyLabel1.setText("인간:0 컴퓨터:2 인간 승리");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        
        }
        else if (actionCommand.equals("1: 바위")) {
        	if(n==0) {
        		storyLabel1.setText("인간:1 컴퓨터:0 인간승리");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        		}
        	else if(n==1) {
        		storyLabel1.setText("인간:1 컴퓨터:1 무승부");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        	else {
        		storyLabel1.setText("인간:1 컴퓨터:2 컴퓨터 승리");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        }
        else {
        	if(n==0) {
        		storyLabel1.setText("인간:2 컴퓨터:0 컴퓨터승리");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        		}
        	else if(n==1) {
        		storyLabel1.setText("인간:2 컴퓨터:1 인간승리");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        	else {
        		storyLabel1.setText("인간:2 컴퓨터:2 무승부");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        }
           
    }

   
}
