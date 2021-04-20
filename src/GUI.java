import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//public class GUI implements ActionListener, KeyListener {
public class GUI implements ActionListener {

    private JFrame frame;
    private JButton button;
    private JLabel label;
    private JTextArea copiedTextArea, pastedTextArea;
    private JPanel panel;
    private TextSwap swapper;
    private String copiedFromBoard="";
    private String pastedToBoard="";

    //this should be a singleton
    private static class SingletonHolder {
        private static GUI instance = new GUI();
    }

    public static GUI getInstance() {
        return GUI.SingletonHolder.instance;
    }

    private GUI(){

        frame = new JFrame();
        button = new JButton("Paste");
        swapper = new TextSwap();
        button.addActionListener(this);
        //alt+c add an optoin for text be shown with keyboard shorcuts combinations.
        button.setMnemonic('c');
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
/*
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);
        if(key == KeyEvent.VK_N){
            copiedFromBoard = swapper.getHebFromClip();
            copiedTextArea.setText(copiedFromBoard);
            pastedToBoard = swapper.setHebFromClip(copiedFromBoard);
            pastedTextArea.setText(pastedToBoard);
        }
    }

 */
}

