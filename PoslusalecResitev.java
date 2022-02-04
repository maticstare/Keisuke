import java.awt.event.*;

public class PoslusalecResitev implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //poslusalec odpre nov frame z resitvijo
        new PopUp();
    }
}
