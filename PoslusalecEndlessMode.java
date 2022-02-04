import java.awt.*;
import java.awt.event.*;

public class PoslusalecEndlessMode implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //poslusalec prizge ali ugasne endlessMode
        if(Start.endlessMode){
            Start.endlessMode = false;
            GUI.endlessMode.setBackground(Color.RED);
        }else{
            Start.endlessMode = true;
            GUI.endlessMode.setBackground(Color.GREEN);
        }

    }
}
