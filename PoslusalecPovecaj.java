import java.awt.event.*;

public class PoslusalecPovecaj implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //poslusalec poveca igralno polje za 1
        // pri prevelikih velikostih zacne prihajati do problemov s prikazom
        Start.value++;
        new GUI(Start.value, Start.value);

    }
}
