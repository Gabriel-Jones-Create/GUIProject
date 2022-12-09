import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PopUpWindow implements ActionListener
{
    SampleWindow3 parentWindow;
    JFrame frame;
    JPanel mainPanel;
    JLabel label1, label2;
    JTextField firstNameField, lastNameField;
    JCheckBox driverButton;
    JButton saveButton;
    
    public PopUpWindow(SampleWindow3 aParentWindow)
    {
        // Keep track of previous window
        parentWindow = aParentWindow;
        
        // Create top-level container
        frame = new JFrame();
        frame.setSize(300, 200);
        frame.setLocation(300,300);
        frame.setTitle("Window Title");
        frame.setResizable(false);
        
        // Create content panel without a layout manager
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);
        
        // Setup button
        saveButton = new JButton("Save");
        saveButton.setMnemonic(KeyEvent.VK_P);
        saveButton.addActionListener(this);

        // Setup text fields and labels
        Font font1 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
        
        firstNameField = new JTextField();
        label1 = new JLabel("First Name:");
        label1.setFont(font1);
        label1.setHorizontalAlignment(JLabel.RIGHT);

        lastNameField = new JTextField();
        label2 = new JLabel("Last Name:");
        label2.setFont(font1);
        label2.setHorizontalAlignment(JLabel.RIGHT);
        
        // Setup checkbox and label
        driverButton = new JCheckBox("Driver");
        driverButton.setFont(font1);

        label1.setLocation(10, 10);
        label2.setLocation(10, 40);
        firstNameField.setLocation(120, 15);
        lastNameField.setLocation(120, 45);
        driverButton.setLocation(120, 75);
        saveButton.setLocation(120, 120);
        
        label1.setSize(100, 30);
        label2.setSize(100, 30);
        firstNameField.setSize(150, 20);
        lastNameField.setSize(150, 20);
        driverButton.setSize(150, 20);
        saveButton.setSize(100, 30);
        
        mainPanel.add(label1);
        mainPanel.add(label2);
        mainPanel.add(firstNameField);
        mainPanel.add(lastNameField);
        mainPanel.add(driverButton);
        mainPanel.add(saveButton);
        
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == saveButton)
        {
            String toDisplay = firstNameField.getText() + " " 
                    + lastNameField.getText() + " ";
            if (driverButton.isSelected())
            {
                toDisplay = toDisplay + "is a driver";
            }
            else
            {
                toDisplay = toDisplay + "is not a driver";
            }
            
            JOptionPane.showMessageDialog(frame, "Data saved.");
            parentWindow.closePopUp(toDisplay);
            frame.dispose();
        }
    }
}