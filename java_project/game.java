
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
        setTitle("����, ����, ��");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        
        JLabel storyLabel = new JLabel("�Ʒ��� ��ư �߿��� �ϳ��� Ŭ���Ͻÿ�!");
        

        add(storyLabel, BorderLayout.NORTH);

       
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,3));
        
        JButton actionButton = new JButton("0: ����");
        actionButton.addActionListener(this);
        buttonPanel.add(actionButton);

        JButton clearButton = new JButton("1: ����");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        JButton paperButton = new JButton("2: ��");
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

        if (actionCommand.equals("0: ����"))
        {
        	if(n==0) {
        		storyLabel1.setText("�ΰ�:0 ��ǻ��:0 ���º�");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        		}
        	else if(n==1) {
        		storyLabel1.setText("�ΰ�:0 ��ǻ��:1 ��ǻ�� �¸�");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        	else {
        		storyLabel1.setText("�ΰ�:0 ��ǻ��:2 �ΰ� �¸�");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        
        }
        else if (actionCommand.equals("1: ����")) {
        	if(n==0) {
        		storyLabel1.setText("�ΰ�:1 ��ǻ��:0 �ΰ��¸�");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        		}
        	else if(n==1) {
        		storyLabel1.setText("�ΰ�:1 ��ǻ��:1 ���º�");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        	else {
        		storyLabel1.setText("�ΰ�:1 ��ǻ��:2 ��ǻ�� �¸�");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        }
        else {
        	if(n==0) {
        		storyLabel1.setText("�ΰ�:2 ��ǻ��:0 ��ǻ�ͽ¸�");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        		}
        	else if(n==1) {
        		storyLabel1.setText("�ΰ�:2 ��ǻ��:1 �ΰ��¸�");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        	else {
        		storyLabel1.setText("�ΰ�:2 ��ǻ��:2 ���º�");
        		//storyPanel.add(storyLabel1, BorderLayout.CENTER);
        	}
        }
           
    }

   
}
