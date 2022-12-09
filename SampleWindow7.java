import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
import java.nio.charset.StandardCharsets;

public class SampleWindow7 implements ActionListener, Runnable
{
    JFrame frame;
    JPanel mainPanel;
    JLabel fileNameLabel;
    JButton selectFileButton;
    File theFile;

    public void run()
    {
        // Create top-level container
        frame = new JFrame();
        frame.setSize(300, 200);
        frame.setLocation(100,100);
        frame.setTitle("Window Title");
        frame.setResizable(false);

        // Create content panel without a layout manager
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);

        // Setup button
        selectFileButton = new JButton("Select File");
        selectFileButton.setMnemonic(KeyEvent.VK_P);
        selectFileButton.addActionListener(this);

        // Setup text fields and labels
        Font font1 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

        fileNameLabel = new JLabel("Selected: none");
        fileNameLabel.setFont(font1);
        fileNameLabel.setHorizontalAlignment(JLabel.LEFT);

        fileNameLabel.setLocation(10, 10);
        selectFileButton.setLocation(100, 100);

        fileNameLabel.setSize(250, 30);
        selectFileButton.setSize(100, 30);

        mainPanel.add(fileNameLabel);
        mainPanel.add(selectFileButton);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == selectFileButton)
        {
            theFile = selectFile();
            if (theFile != null)
            {
                fileNameLabel.setText("Selected: " + theFile.getName());                
            }
        }
    }

    private File selectFile()
    {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));

        File chosenFile = null;
        
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            chosenFile = fc.getSelectedFile();
        }
        return chosenFile;
    }

    public static void start() {
        SwingUtilities.invokeLater(new SampleWindow7());
    }
}
