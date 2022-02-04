import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.*;

public class PoslusalecSave implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        String fields = "";
        String matrix = "";

        //trenutna postavitev polja in resitev se shranita v dva stringa za zapis v datoteko
        for (int i = 0; i < Start.value; i++) {
            for (int j = 0; j < Start.value; j++) {
                if(GUI.polje[i][j].getText().equals("keisuke")){
                    fields = fields.concat("b ");
                }else if(GUI.polje[i][j].getText().equals("")){
                    fields = fields.concat("0 ");
                }else{
                    fields = fields.concat(GUI.polje[i][j].getText() + " ");
                }


                if(NovaIgra.matrix[i][j] == -1){
                    matrix = matrix.concat("b ");
                }else{
                    matrix = matrix.concat(String.valueOf(NovaIgra.matrix[i][j]) + " ");
                }

            }
        }

        //v .txt datoteko se zapise trenutna postavitev, resitev in zgenerirani funkciji across in down
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text datoteke", "txt");
        chooser.setFileFilter(filter);
        int ret = chooser.showSaveDialog(null);
        if(ret == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            //izpise se pot do datoteke v konzolo
            System.out.println(file.getAbsolutePath());
            try{
                //program zapise vrednosti v .txt
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(fields + "\n" + matrix + "\n" + GUI.novaIgra.across() + "\n" + GUI.novaIgra.down());
                writer.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
