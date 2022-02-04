import java.awt.event.*;

public class PoslusalecPomanjsaj implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //poslusalec zmanjsa igralno polje za 1; minimalna vrednost je 2
        if (Start.value > 2){
            Start.value--;
            new GUI(Start.value, Start.value);
        }
    }
}
