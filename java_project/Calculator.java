import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 A simplified calculator. 
 The only operations are addition and subtraction.
*/
public class Calculator extends JFrame 
                        implements ActionListener
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 200;
    public static final int NUMBER_OF_DIGITS = 8;

    private JTextField ioField; 
    private JTextField ioField1; 
    private JTextField ioField2;
    private double result = 0.01;

    public static void main(String[] args)
    {
        Calculator aCalculator = new Calculator( );
        aCalculator.setVisible(true);
    }

    public Calculator( )
    {
        setTitle("���� ����");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout( ));

        JPanel textPanel = new JPanel( );
       // textPanel.setLayout(new FlowLayout( ));
        JLabel nameLabel = new JLabel("������ �Է��Ͻÿ�");
        textPanel.add(nameLabel, BorderLayout.CENTER);
        
        ioField = 
             new JTextField( NUMBER_OF_DIGITS);
        ioField.setBackground(Color.WHITE);
        
        textPanel.add(ioField);
        add(textPanel, BorderLayout.NORTH);
        
        JLabel nameLabel1 = new JLabel("������ �Է��Ͻÿ�");
        textPanel.add(nameLabel1, BorderLayout.CENTER);
        
        ioField1 = 
                new JTextField( NUMBER_OF_DIGITS);
           ioField1.setBackground(Color.WHITE);
           
           textPanel.add(ioField1);
           add(textPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel( );
    
        buttonPanel.setLayout(new FlowLayout( )); 

        JButton addButton = new JButton("��ȯ"); 
        addButton.addActionListener(this);
        buttonPanel.add(addButton); 

       add(buttonPanel, BorderLayout.CENTER);

       ioField2 = 
               new JTextField(15);
         // ioField2.setBackground(Color.WHITE);
          buttonPanel.add(ioField2);
          
          ioField2.setEditable(false);
    }


    public void actionPerformed(ActionEvent e)
    {
       
        try
        {
            assumingCorrectNumberFormats(e);
        }
        catch (NumberFormatException e2)
        {
            ioField.setText("Error: Reenter Number.");
        }
    }


    //Throws NumberFormatException.
    public void assumingCorrectNumberFormats(ActionEvent e)
    {
        String actionCommand = e.getActionCommand( );

        if (actionCommand.equals("��ȯ"))
        {
        	result=stringToDouble(ioField.getText( ))*(0.01*stringToDouble(ioField1.getText( )));
        	ioField2.setText("���ڴ� ��"+(int)result+"���� �Դϴ�.");
        }
     }
    
    private static double stringToDouble(String stringObject)
    {
        return Double.parseDouble(stringObject.trim());
    }

}
