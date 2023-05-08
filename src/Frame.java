import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame extends JFrame {


    public Frame() {
        super("Awe");
        Cracker cracker = new Cracker();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        JButton button = new JButton("Enter");
        JLabel Answer = new JLabel();
        JLabel pass = new JLabel();

        JTextField textField = new JTextField(60);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = textField.getText();
                Answer.setText(RandomPassGen.CreatePass());

                try {
                    cracker.crack(text);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        JLabel label = new JLabel("Enter the zip Path: ");

        JList<String> RandomPass = new JList<>(cracker.potentialPasswords);
        JScrollPane jScrollPane = new JScrollPane(RandomPass);
        jScrollPane.setPreferredSize(new Dimension(300,400));
        System.out.println(jScrollPane.getMaximumSize());


        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(Answer);
        panel.add(jScrollPane);

        getContentPane().add(panel);

        setVisible(true);


    }


}
