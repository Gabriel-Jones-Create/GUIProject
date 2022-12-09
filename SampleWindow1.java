import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SampleWindow1 implements ActionListener, Runnable
{
    JFrame frame;
    JPanel mainPanel;
    JPanel radioPanel;
    JPanel buttonPanel;
    JRadioButton boldButton;
    JRadioButton italicsButton;
    JRadioButton plainButton;
    JButton smallerButton;
    JButton largerButton;
    JLabel label1;
    
    public void run()
    {
        // Create top-level container
        frame = new JFrame();
        frame.setSize(300, 200);
        frame.setLocation(100,100);
        frame.setTitle("Window Title");
        frame.setResizable(false);
        
        // Create content panel
        mainPanel = new JPanel(new BorderLayout(20, 20));
        frame.setContentPane(mainPanel);
        
        // Setup radio buttons
        ButtonGroup bGroup = new ButtonGroup();
        
        boldButton = new JRadioButton("Bold");
        boldButton.setMnemonic(KeyEvent.VK_B);
        boldButton.addActionListener(this);
        bGroup.add(boldButton);
        
        italicsButton = new JRadioButton("Italics");
        italicsButton.setMnemonic(KeyEvent.VK_I);
        italicsButton.addActionListener(this);
        bGroup.add(italicsButton);

        plainButton = new JRadioButton("Plain");
        plainButton.setSelected(true);
        plainButton.setMnemonic(KeyEvent.VK_P);
        plainButton.addActionListener(this);
        bGroup.add(plainButton);
        
        // Place radio buttons on their own panel.
        // Then place on main panel.
        radioPanel = new JPanel(new GridLayout(0,1));
        radioPanel.add(plainButton);
        radioPanel.add(boldButton);
        radioPanel.add(italicsButton);
        mainPanel.add(radioPanel, BorderLayout.WEST);
        
        // Setup buttons
        largerButton = new JButton("Larger");
        largerButton.setMnemonic(KeyEvent.VK_L);
        largerButton.addActionListener(this);

        smallerButton = new JButton("Smaller");
        smallerButton.setMnemonic(KeyEvent.VK_S);
        smallerButton.addActionListener(this);
        
        // Place buttons on their own panel.
        // Then place on main panel.
        buttonPanel = new JPanel(new GridLayout(0, 1, 20, 20));
        buttonPanel.add(largerButton);
        buttonPanel.add(smallerButton);
        mainPanel.add(buttonPanel, BorderLayout.EAST);
        
        // Setup label and place on panel.
        Font font1 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
        
        label1 = new JLabel("This is a label.");
        label1.setFont(font1);
        label1.setHorizontalAlignment(JLabel.CENTER);
        
        mainPanel.add(label1, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == boldButton)
        {
            label1.setFont(new Font(label1.getFont().getFamily(),
                                    Font.BOLD,
                                    label1.getFont().getSize()));
        }

        if (event.getSource() == italicsButton)
        {
            label1.setFont(new Font(label1.getFont().getFamily(),
                                    Font.ITALIC,
                                    label1.getFont().getSize()));
        }
        
        if (event.getSource() == plainButton)
        {
            label1.setFont(new Font(label1.getFont().getFamily(),
                                    Font.PLAIN,
                                    label1.getFont().getSize()));
        }

        if (event.getSource() == smallerButton)
        {
            label1.setFont(new Font(label1.getFont().getFamily(),
                                    label1.getFont().getStyle(),
                                    label1.getFont().getSize()-1));
        }

        if (event.getSource() == largerButton)
        {
            label1.setFont(new Font(label1.getFont().getFamily(),
                                    label1.getFont().getStyle(),
                                    label1.getFont().getSize()+1));
        }
    }
    
    public static void start() {
        SwingUtilities.invokeLater(new SampleWindow1());
    }
}