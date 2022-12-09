import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConversionCalculator implements ActionListener, Runnable
{
    JFrame frame;
    JPanel mainPanel;
    JLabel label1, label2;
    JTextField firstNameField, lastNameField;
    JComboBox initialUnitBox;
    JComboBox finalUnitBox;
    JButton printButton;
    
    public void run()
    {
        // Create top-level container
        frame = new JFrame();
        frame.setSize(700, 400);
        frame.setLocation(100,100);
        frame.setTitle("Conversion Calculator");
        frame.setResizable(false);
        
        // Create content panel without a layout manager
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);
        
        // Setup button
        printButton = new JButton("Convert");
        printButton.setMnemonic(KeyEvent.VK_P);
        printButton.addActionListener(this);

        // Setup text fields and labels
        Font font1 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
        
        firstNameField = new JTextField();
        label1 = new JLabel("From:");
        label1.setFont(font1);
        label1.setHorizontalAlignment(JLabel.RIGHT);

        lastNameField = new JTextField();
        label2 = new JLabel("To:");
        label2.setFont(font1);
        label2.setHorizontalAlignment(JLabel.RIGHT);
        
        
        // Setup combobox
        String[] unitStrings = {"Select Unit", "Kilometers", "Meters", "Centimeters", "Millimeters", "Miles", "Yards", "Feet", "Inches", "Light Years"};
        initialUnitBox = new JComboBox(unitStrings);
        initialUnitBox.setSelectedIndex(0);
        finalUnitBox = new JComboBox(unitStrings);
        finalUnitBox.setSelectedIndex(0);
        

        label1.setLocation(60, 10);
        label2.setLocation(325, 10);
        firstNameField.setLocation(120, 40);
        lastNameField.setLocation(400, 40);
        initialUnitBox.setLocation(120, 70);
        finalUnitBox.setLocation(400,70);
        printButton.setLocation(275, 40);
        
        label1.setSize(100, 30);
        label2.setSize(100, 30);
        firstNameField.setSize(150, 20);
        lastNameField.setSize(150, 20);
        initialUnitBox.setSize(150, 20);
        finalUnitBox.setSize(150, 20);
        printButton.setSize(100, 30);
        
        mainPanel.add(label1);
        mainPanel.add(label2);
        mainPanel.add(firstNameField);
        mainPanel.add(lastNameField);
        mainPanel.add(printButton);
        mainPanel.add(initialUnitBox);
        mainPanel.add(finalUnitBox);
        
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == printButton)
        {
        }
    }
    
    public static void start() {
        SwingUtilities.invokeLater(new ConversionCalculator());
    }
}