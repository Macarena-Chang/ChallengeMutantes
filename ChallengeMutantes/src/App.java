import java.util.List;
import java.util.Scanner;

public class App {
    public static boolean isMutant(String[] dna) {

        int contadorFinal = 0;
       
            //check for horizontal matches.
            int contadorHorizontal = checkMat(getMatrix(dna));
            contadorFinal = contadorHorizontal; 
            if(contadorFinal>3){
                return true; 
            }

            //check for vertical matches.
            int contadorVertical =  checkMat(getMatrixTransposed(getMatrix(dna)));
            contadorFinal = contadorFinal + contadorVertical;
            if(contadorFinal>3){
                return true; 
            }

           
        
        System.out.println("Contador final: " + contadorFinal);

        
       
            return false;


    }

    public static char[][] getMatrix(String[] dna) {

        char[][] mat = new char[dna.length][dna.length]; // mismo num porque es cuadrada.
        char[] charArray = new char[0];

        for (int i = 0; i < dna.length; i++) {
            charArray = dna[i].toCharArray();

            for (int j = 0; j < dna.length; j++) {

                mat[i][j] = charArray[j];

            }

        }
        return mat;
    }

    public static char[][] getMatrixTransposed(char[][] mat) {

        char[][] transpose = new char[mat.length][mat.length];

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat.length; j++) {

                transpose[i][j] = mat[j][i];

            }
        }
        System.out.println(transpose);
        return transpose; 

    }

    public static int checkMat(char[][] mat){
        int contadorFinal = 0;

        for(int i = 0; i< mat.length ;i++){
            checkPattern(mat[i]);

            if(checkPattern(mat[i])){
                contadorFinal++;
            }
        }
       System.out.println(contadorFinal);
        return contadorFinal;

    }
    public static boolean checkPattern(char[] charArray) {        

        if (charArray.length > 3) {

            for (int i = 0; i < charArray.length - 3; i++) {

               

                if (charArray[i] == charArray[i + 1] && charArray[i + 1] == charArray[i + 2]
                        && charArray[i + 2] == charArray[i + 3]) {

                    return true;

                }

            }
            return false; 
        }

        return false;
    }

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };        
        isMutant(dna);
      

      
    }
}
