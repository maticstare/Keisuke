import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;


public class GUI extends JFrame{
    static NovaIgra novaIgra;
    static JTextField polje[][];
    static JPanel meni;
    static JButton endlessMode;
    static JPanel panelAcross;
    static JPanel panelDown;



    GUI(int x, int y){
        //postavitev okna
        this.setTitle("Keisuke");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(1920,1080);

        //zagon nove igre
        novaIgra = new NovaIgra(Start.value, Start.value);


        JPanel gridPanel = new JPanel();
        gridPanel.setPreferredSize(new Dimension(1080,1080));
        gridPanel.setLayout(new GridLayout(x,y));


        //postavitev igralnega polja (polj) glede na novo igro
        polje = new JTextField[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                polje[i][j] = new JTextField();
                polje[i][j].setFont(new Font("Consolas", Font.PLAIN, 50));
                polje[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                polje[i][j].addKeyListener(new KeyListener());
                JTextField poljeIJ = polje[i][j];
                polje[i][j].addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        if (poljeIJ.getText().length() >= 1 )
                            e.consume();
                    }
                });


                if(novaIgra.matrix[i][j] == -1) {
                    polje[i][j].setBackground(Color.black);
                    polje[i][j].setText("keisuke");
                    polje[i][j].setEnabled(false);
                }
                gridPanel.add(polje[i][j]);
            }
        }


        //meni igre
        meni = new JPanel();
        meni.setPreferredSize(new Dimension(720,360));
        meni.setLayout(new GridLayout(5,2));


        JButton save = new JButton("Save");
        save.addActionListener(new PoslusalecSave());

        JButton load = new JButton("Load");
        load.addActionListener(new PoslusalecLoad());

        JButton check = new JButton("Check");
        check.addActionListener(new PoslusalecCheck());

        JButton resitev = new JButton("Pokazi resitev!");
        resitev.addActionListener(new PoslusalecResitev());

        JButton povecaj = new JButton("+");
        povecaj.addActionListener(new PoslusalecPovecaj());

        JButton pomanjsaj = new JButton("-");
        pomanjsaj.addActionListener(new PoslusalecPomanjsaj());

        JButton newGame = new JButton("New game");
        newGame.addActionListener(new PoslusalecNewGame());

        //implementacija endlessModa
        endlessMode = new JButton("Endless Mode");
        if(Start.endlessMode){
            endlessMode.setBackground(Color.GREEN);
        }else{
            endlessMode.setBackground(Color.RED);
        }
        endlessMode.addActionListener(new PoslusalecEndlessMode());



        meni.add(save);
        meni.add(load);
        meni.add(check);
        meni.add(resitev);
        meni.add(povecaj);
        meni.add(pomanjsaj);
        meni.add(newGame);
        meni.add(endlessMode);

        //prikaz funkcij across in down
        JLabel across = new JLabel(""+novaIgra.across());
        JLabel down = new JLabel(""+novaIgra.down());


        JPanel bottomPanel = new JPanel();
        panelAcross = new JPanel();
        panelDown = new JPanel();


        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(1920, 100));


        panelAcross.setPreferredSize(new Dimension(1920, 50));
        JLabel acrossLabel = new JLabel("Across →");
        acrossLabel.setForeground(Color.RED);
        acrossLabel.setFont(new Font("Consolas", Font.BOLD, 18));
        panelAcross.add(acrossLabel);
        across.setFont(new Font("Consolas", Font.PLAIN, 20));
        panelAcross.add(across);


        panelDown.setPreferredSize(new Dimension(1920, 50));
        JLabel downLabel = new JLabel("Down ↓");
        downLabel.setForeground(Color.RED);
        downLabel.setFont(new Font("Consolas", Font.BOLD, 18));
        panelDown.add(downLabel);
        down.setFont(new Font("Consolas", Font.PLAIN, 20));
        panelDown.add(down);




        //dodajanje panelov na frame
        this.add(gridPanel, BorderLayout.EAST);
        this.add(meni, BorderLayout.WEST);
        this.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(panelAcross, BorderLayout.NORTH);
        bottomPanel.add(panelDown, BorderLayout.SOUTH);


        this.setVisible(true);
    }
}