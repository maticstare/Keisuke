import java.util.*;

public class NovaIgra {
    int x;
    int y;
    static int matrix[][];

    NovaIgra(int x, int y){
        this.x = x;
        this.y = y;

        matrix = new int[x][y];
        Random random = new Random();

        //matrika se napolni s stevkami 1-9
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = random.nextInt(8)+1;
            }
        }

        //v matriko se na nakljucna mesta postavijo -1, ki predstavljajo osencena mesta
        for (int i = 0; i < x; i++) {
            int vrst = random.nextInt(x);
            int stol = random.nextInt(y);
            if(matrix[vrst][stol] != -1){
                matrix[vrst][stol] = -1;
            }else{
                i--;
            }
        }
        across();
        down();
    }


    public ArrayList<String> across(){
        //funkcija vrne premesan seznam vseh vodoravnih stevil
        ArrayList across = new ArrayList();
        String niz = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(matrix[i][j] == -1 && niz != ""){
                    across.add(niz);
                    niz = "";
                }else if (matrix[i][j] != -1){
                    niz += String.valueOf(matrix[i][j]);
                }
            }
            if(niz != ""){
                across.add(niz);
                niz = "";
            }
        }
        Collections.shuffle(across);
        return across;
    }

    public ArrayList<String> down(){
        //funkcija vrne premesan seznam vseh navpicnih stevil
        ArrayList down = new ArrayList();
        String niz = "";
        for (int j = 0; j < x; j++) {
            for (int i = 0; i < y; i++) {
                if(matrix[i][j] == -1 && niz != ""){
                    down.add(niz);
                    niz = "";
                }else if (matrix[i][j] != -1){
                    niz += String.valueOf(matrix[i][j]);
                }
            }
            if(niz != ""){
                down.add(niz);
                niz = "";
            }
        }
        Collections.shuffle(down);
        return down;
    }
}