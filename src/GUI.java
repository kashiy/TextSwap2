import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//public class GUI implements ActionListener, KeyListener {
public class GUI implements ActionListener {

    private JFrame frame;
    private JButton swap_Button;
    private JButton swapAndPaste_Button;
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

        swapper = new TextSwap();

        swap_Button = new JButton("swap on clipboard");
        swap_Button.addActionListener(this);
        //alt+c will act like the button and paste
        swap_Button.setMnemonic('c');

        swapAndPaste_Button = new JButton("swap and paste on spot");
        SwapAndPaste listener = new SwapAndPaste();
        swapAndPaste_Button.addActionListener(listener);
        //alt+v will act like the button and paste
        swapAndPaste_Button.setMnemonic('v');

        label = new JLabel("Swapped to Heb");


        copiedTextArea = new JTextArea(50,50);
        copiedTextArea.setEditable(false);

        pastedTextArea = new JTextArea(50,50);
        pastedTextArea.setEditable(false);

        //todo - check why button is the same as area
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setLayout(new GridLayout(0,1));

        panel.add(copiedTextArea);
        panel.add(swap_Button);
        panel.add(swapAndPaste_Button);
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
        System.out.println("swap");
        copiedFromBoard = swapper.getHebFromClip();
        copiedTextArea.setText(copiedFromBoard);
        pastedToBoard = swapper.setHebFromClip(copiedFromBoard);
        pastedTextArea.setText(pastedToBoard);
    }

    //new ActionListener for the swapAndPaste_Button
    public class SwapAndPaste implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("SwapAndPaste");
            try
            {
                //todo- the robot is a problem because i am not in the same program and this is not working underground
//                Robot r = new Robot();
//                r.keyPress(KeyEvent.VK_CONTROL);
//                r.keyPress(KeyEvent.VK_C);
//                r.keyRelease(KeyEvent.VK_CONTROL);
//                r.keyRelease(KeyEvent.VK_C);
                copiedFromBoard = swapper.getHebFromClip();
                copiedTextArea.setText(copiedFromBoard);
                pastedToBoard = swapper.setHebFromClip(copiedFromBoard);
                pastedTextArea.setText(pastedToBoard);
//                r.keyPress(KeyEvent.VK_CONTROL);
//                r.keyPress(KeyEvent.VK_V);
//                r.keyRelease(KeyEvent.VK_CONTROL);
//                r.keyRelease(KeyEvent.VK_V);

            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
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

