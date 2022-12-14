import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConversionCalculator implements ActionListener, Runnable
{
    JFrame frame;
    JPanel mainPanel;
    JLabel label1, label2;
    JTextField initialUnitField, finalUnitField;
    JComboBox initialUnitBox;
    JComboBox finalUnitBox;
    JButton convertButton;
    
    public void run()
    {
        // Create top-level container
        frame = new JFrame();
        frame.setSize(500, 170);
        frame.setLocation(100,100);
        frame.setTitle("Conversion Calculator");
        frame.setResizable(false);
        
        // Create content panel without a layout manager
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);
        
        // Setup button
        convertButton = new JButton("Convert");
        convertButton.setMnemonic(KeyEvent.VK_P);
        convertButton.addActionListener(this);

        // Setup text fields and labels
        Font font1 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
        
        initialUnitField = new JTextField();
        label1 = new JLabel("From:");
        label1.setFont(font1);
        label1.setHorizontalAlignment(JLabel.RIGHT);

        finalUnitField = new JTextField();
        label2 = new JLabel("To:");
        label2.setFont(font1);
        label2.setHorizontalAlignment(JLabel.RIGHT);
        
        
        // Setup combobox
        String[] unitStrings = {"Select Unit", "Kilometers", "Meters", "Centimeters", "Millimeters", "Miles", "Yards", "Feet", "Inches", "Light Years"};
        initialUnitBox = new JComboBox(unitStrings);
        initialUnitBox.setSelectedIndex(0);
        finalUnitBox = new JComboBox(unitStrings);
        finalUnitBox.setSelectedIndex(0);
        

        label1.setLocation(-30, 10);
        label2.setLocation(235, 10);
        initialUnitField.setLocation(30, 40);
        finalUnitField.setLocation(310, 40);
        initialUnitBox.setLocation(30, 70);
        finalUnitBox.setLocation(310,70);
        convertButton.setLocation(195, 40);
        
        label1.setSize(100, 30);
        label2.setSize(100, 30);
        initialUnitField.setSize(150, 20);
        finalUnitField.setSize(150, 20);
        initialUnitBox.setSize(150, 20);
        finalUnitBox.setSize(150, 20);
        convertButton.setSize(100, 30);
        
        mainPanel.add(label1);
        mainPanel.add(label2);
        mainPanel.add(initialUnitField);
        mainPanel.add(finalUnitField);
        mainPanel.add(convertButton);
        mainPanel.add(initialUnitBox);
        mainPanel.add(finalUnitBox);
        
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {   
        int meterValue = 0;
        String[] units = {"Select Unit", "Kilometers", "Meters", "Centimeters", "Millimeters",
            "Miles", "Yards", "Feet", "Inches", "Light Years"};
        double[] meterConversionFactor = { 0.0 , 1000.0, 1.0, 0.01,0.001,
            1609.334, 0.9144, 0.3048, 0.0254,9460700000000000.0};
        if (event.getSource() == convertButton)
        {
        }
    }
    public static void start() {
        SwingUtilities.invokeLater(new ConversionCalculator());
    }
}