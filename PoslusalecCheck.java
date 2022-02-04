import java.awt.*;
import java.awt.event.*;

public class PoslusalecCheck implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //poslusalec preveri, ali se resitev na polju ujema z resitvijo nove igre
        boolean pravilno = true;
        for (int i = 0; i < Start.value; i++) {
            for (int j = 0; j < Start.value; j++) {
                String vrednostResitve = String.valueOf(NovaIgra.matrix[i][j]);
                if(!GUI.polje[i][j].getText().equals(vrednostResitve) && !GUI.polje[i][j].getText().equals("")){
                    //ce pride do tega se saj eno polje ne ujema
                    //panel se obarva rdece
                    pravilno = false;
                    GUI.meni.setBackground(Color.RED);
                    break;
                }
            }
        }
        if(pravilno){
            //resitev je pravilna, panel se obarva zeleno, ce je endlessMode
            // prizgan se odpre nov frame z velikostjo +1
            GUI.meni.setBackground(Color.GREEN);
            if(Start.endlessMode){
                Start.value++;
                new GUI(Start.value, Start.value);
            }
        }
        //izpise se ali je resitev pravilna ali ne
        System.out.println(pravilno);
    }
}
