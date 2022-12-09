import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SampleWindow3 implements ActionListener, Runnable
{
    JFrame frame;
    JPanel mainPanel;
    JButton openButton;
    JLabel label;
    
    public void run()
    {
        // Create top-level container
        frame = new JFrame();
        frame.setSize(300, 200);
        frame.setLocation(100,100);
        frame.setTitle("First Window");
        frame.setResizable(false);
        
        // Create content panel without a layout manager
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);
        
        // Setup label
        Font font1 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
        label = new JLabel();
        label.setFont(font1);
        label.setHorizontalAlignment(JLabel.CENTER);
        
        // Setup button
        openButton = new JButton("Open");
        openButton.addActionListener(this);

        label.setLocation(50, 50);
        openButton.setLocation(100, 120);
        label.setSize(200, 30);
        openButton.setSize(100, 30);
        
        mainPanel.add(label);
        mainPanel.add(openButton);
        
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == openButton)
        {
            // Open another window
            new PopUpWindow(this);
            openButton.setEnabled(false);
        }
    }
    
    public void closePopUp(String toDisplay)
    {
        label.setText(toDisplay);
        openButton.setEnabled(true);
    }
    
    public static void start() {
        SwingUtilities.invokeLater(new SampleWindow3());
    }
}