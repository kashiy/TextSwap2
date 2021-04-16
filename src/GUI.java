import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//todo this should be a singleton
public class GUI implements ActionListener {

    private TextSwap swapper;

    public GUI(){
        JFrame frame = new JFrame();

        JButton button = new JButton("Paste");
        swapper = new TextSwap();
        button.addActionListener(this);
        JLabel label = new JLabel("Swapped to Heb");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100,100,30,100));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TextSwap");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        swapper.getHebFromClip();
    }
}
