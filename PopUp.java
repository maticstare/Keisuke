import javax.swing.*;
import java.awt.*;

public class PopUp extends JFrame {

    PopUp(){
        //prikaz frama z resitvijo
        JFrame popUp = new JFrame();
        popUp.setSize(400,400);
        popUp.setLocationRelativeTo(null);
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(Start.value, Start.value));

        for (int i = 0; i < Start.value; i++) {
            for (int j = 0; j < Start.value; j++) {
                if(NovaIgra.matrix[i][j] != -1){
                    JLabel label = new JLabel("" + NovaIgra.matrix[i][j]);
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    panel.add(label);
                }else{
                    JLabel label = new JLabel("");
                    label.setOpaque(true);
                    label.setBackground(Color.BLACK);
                    panel.add(label);
                }
            }
        }
        popUp.add(panel);
        popUp.setVisible(true);
    }
}
