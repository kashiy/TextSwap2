import java.awt.*;
import java.awt.datatransfer.*;

//added -cp to arguments to stop classnotfound exception
//        java -cp "c:/location/of/file" YourProgram


public class TextSwap {

    public static void main(String[] args) {
        GUI a = new GUI();
    }


    public String getHebFromClip(){
        String text= "";
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        try {
            if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                text = (String)t.getTransferData(DataFlavor.stringFlavor);
                System.out.println("copied: " + text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return text;
    }

    public String setHebFromClip(String hebText){
        String newText= "";
        try {
                newText = Swap.toHeb(hebText);
                System.out.println("pasted: " + newText);
                //paste to clipboard
                StringSelection ss = new StringSelection(newText);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            }
         catch (Exception ex) {
            ex.printStackTrace();
        }
        return newText;
    }

}



//nv eurv ht nkl vmkj, kf,uc ,ufbh, aknv annhrv?
//fh; kepu. kcrhfv farumho kgu; k,ul vnho vgnueho


/*
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        int i=1;
        while(i != 0) {
            Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            try {
                if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    String text = (String)t.getTransferData(DataFlavor.stringFlavor);
                    System.out.println(text);
                    String newtext = Swap.toHeb(text);
                    System.out.println(newtext);
                    //paste to clipboard
                    StringSelection ss = new StringSelection(newtext);
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            Scanner myScanner= new Scanner(System.in);
            i= myScanner.nextInt();
*/