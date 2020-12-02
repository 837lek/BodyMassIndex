import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 79218 on 12/1/2020
 */
public class BMIGUI {
    public static final int TEXT_FIELD_WIDTH_COLUMNS = 5;
    public static final int FRAME_WIDTH = 150;
    public static final int FRAME_HEIGHT = 250;

    public BMIGUI() {
        final JFrame jFrame = new JFrame("Body Mass Index.");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        final JLabel usrnameLbl = new JLabel("Username");
        jFrame.add(usrnameLbl);

        final JTextField usernameFld = new JTextField(TEXT_FIELD_WIDTH_COLUMNS);
        jFrame.add(usernameFld);

        final JLabel heightLbl = new JLabel("Height");
        jFrame.add(heightLbl);

        final JTextField heightFld = new JTextField(TEXT_FIELD_WIDTH_COLUMNS);
        jFrame.add(heightFld);

        final JLabel weightLbl = new JLabel("Weight");
        jFrame.add(weightLbl);

        final JTextField weightFld = new JTextField(TEXT_FIELD_WIDTH_COLUMNS);
        jFrame.add(weightFld);

        final BMI bmi = new BMI();

        final JButton processBtn = new JButton("Process");
        processBtn.addActionListener(new ActionListener() {
            final JLabel resultLbl = new JLabel();
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.add(resultLbl);
                final double height = Double.parseDouble(heightFld.getText());
                final double weight = Double.parseDouble(weightFld.getText());
                final String username = usernameFld.getText();
                bmi.init(usernameFld.getText(), height, weight);
                final String result = bmi.process();
                resultLbl.setText("The Body Mass Index for " + username + " is " + result + ".");
            }
        });
        jFrame.add(processBtn);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BMIGUI();
            }
        });
    }
}