import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//todo this should be a singleton
public class GUI implements ActionListener {

    private JFrame frame;
    private JButton button;
    private JLabel label;
    private JTextArea copiedTextArea, pastedTextArea;
    private JPanel panel;
    private TextSwap swapper;
    private String copiedFromBoard="";
    private String pastedToBoard="";


    public GUI(){

        frame = new JFrame();
        button = new JButton("Paste");
        swapper = new TextSwap();
        button.addActionListener(this);
        label = new JLabel("Swapped to Heb");

        //todo - check why width is stuck
        copiedTextArea = new JTextArea(copiedFromBoard);
        copiedTextArea.setBounds(250,250,250,200);
        copiedTextArea.setEditable(false);
        pastedTextArea = new JTextArea(copiedFromBoard);
        pastedTextArea.setBounds(20,75,250,200);
        pastedTextArea.setEditable(false);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,250,50,250));
        panel.setLayout(new GridLayout(0,1));

        panel.add(copiedTextArea);
        panel.add(button);
        panel.add(label);
        panel.add(pastedTextArea);


        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TextSwap");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        copiedFromBoard = swapper.getHebFromClip();
        copiedTextArea.setText(copiedFromBoard);
        pastedToBoard = swapper.setHebFromClip(copiedFromBoard);
        pastedTextArea.setText(pastedToBoard);
    }
}

//todo - add an optoin for text be shown with keyboard shorcuts combinations.