import java.awt.event.*;

public class PoslusalecNewGame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //poslusalec generira novo igro
        new GUI(Start.value, Start.value);
    }
}
