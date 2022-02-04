import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class PoslusalecLoad implements ActionListener {
    File myObj;
    int velikost;

    @Override
    public void actionPerformed(ActionEvent e) {
        //generiranje shranjene igre iz datoteke
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text datoteke", "txt");
        chooser.setFileFilter(filter);
        int ret = chooser.showOpenDialog(null);
        if(ret == JFileChooser.APPROVE_OPTION) {
            myObj = chooser.getSelectedFile();
        }

        try {
            Scanner myReader = new Scanner(myObj);
            String prvaVrstica = myReader.nextLine();

            String[] buttonstring = prvaVrstica.split(" ");

            velikost = (int) Math.sqrt(buttonstring.length);
            Start.value = velikost;
            new GUI(velikost,velikost);

            String[][] buttons = new String[velikost][velikost];

            for (int i = 0; i < velikost; i++) {
                for (int j = 0; j < velikost; j++) {
                    String text = buttonstring[i*velikost+j];
                    if(!text.equals("b")){
                        GUI.polje[i][j].setBackground(null);
                        GUI.polje[i][j].setText(text);
                        GUI.polje[i][j].setEnabled(true);
                    }else{
                        GUI.polje[i][j].setBackground(Color.black);
                        GUI.polje[i][j].setText("");
                        GUI.polje[i][j].setEnabled(false);
                    }

                }
            }

            String drugaVrstica = myReader.nextLine();
            String[] matrixString = drugaVrstica.split(" ");



            for (int i = 0; i < velikost; ++i) {
                for (int j = 0; j < velikost; ++j) {
                    if(!matrixString[i * velikost + j].equals("b")){
                        NovaIgra.matrix[i][j] = Integer.parseInt(matrixString[i * velikost + j]);
                    }else{
                        NovaIgra.matrix[i][j] = -1;
                    }

                }
            }

            GUI.panelAcross.removeAll();
            GUI.panelDown.removeAll();


            JLabel across = new JLabel(""+myReader.nextLine());
            JLabel down = new JLabel(""+myReader.nextLine());



            GUI.panelAcross.setPreferredSize(new Dimension(1920, 50));
            JLabel acrossLabel = new JLabel("Across →");
            acrossLabel.setForeground(Color.RED);
            acrossLabel.setFont(new Font("Consolas", Font.BOLD, 18));
            GUI.panelAcross.add(acrossLabel);
            across.setFont(new Font("Consolas", Font.PLAIN, 20));
            GUI.panelAcross.add(across);


            GUI.panelDown.setPreferredSize(new Dimension(1920, 50));
            JLabel downLabel = new JLabel("Down ↓");
            downLabel.setForeground(Color.RED);
            downLabel.setFont(new Font("Consolas", Font.BOLD, 18));
            GUI.panelDown.add(downLabel);
            down.setFont(new Font("Consolas", Font.PLAIN, 20));
            GUI.panelDown.add(down);


            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }
}
