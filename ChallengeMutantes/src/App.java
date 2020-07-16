import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static boolean isMutant(String[] dna) {
        int contadorFinal = 0;


        int contadorHorizontal = checkMat(getMatrix(dna));
        contadorFinal = contadorFinal + contadorHorizontal;
        if (contadorFinal > 3) {
            return true;
        }

        int contadorVertical = checkMat(getMatrixTransposed(getMatrix(dna)));
        contadorFinal = contadorFinal + contadorVertical;
        if (contadorFinal > 3) {
            return true;
        }

        // Check for diagonal matches
        int contadorDiag = diagonals(getMatrix(dna));
        contadorFinal = contadorFinal + contadorDiag;
        if (contadorFinal > 3) {
            return true;
        }

        int contadorDiag2 = diagonals2(getMatrix(dna));
        contadorFinal = contadorFinal + contadorDiag2;
        if (contadorFinal > 3) {
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

        char[][] transposed = new char[mat.length][mat.length];

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat.length; j++) {

                transposed[i][j] = mat[j][i];

            }
        }
        return transposed;

    }

    public static int diagonals(char[][] mat) {
        int contador = 0;
        char[][] matrix = mat;

        // -3 xq min 4 caracteres
        for (int k = 0; k <= matrix.length - 4; k++) {
            List diag = new ArrayList<>();
            int i = k;
            int j = 0;

            while (i < matrix.length && j <= matrix.length) {

                diag.add(matrix[i][j]);
                i = i + 1;
                j = j + 1;
            }
            checkPattern(diag);
            if (checkPattern(diag)) {
                contador++;
            }
           // System.out.println("Diagonal: " + diag);
            // empty list
            diag.removeAll(diag);
          //  System.out.println("Proxima diagonal...");

        }
       // System.out.println("Saliendo del primero ciclo for");

        // anti diag inferiores
        for (int k = 1; k < matrix.length - 3; k++) {

            List diag = new ArrayList<>();
            int i = 0;
            int j = k;

            while (j <= matrix.length - 1 && i >= 0) {

                // System.out.println(matrix[i][j]);
                diag.add(matrix[i][j]);
                i = i + 1;
                j = j + 1;

            }

            checkPattern(diag);
            if (checkPattern(diag)) {
                contador++;
            }
          //  System.out.println("Diagonal: " + diag);
            // empty list
            diag.removeAll(diag);
           // System.out.println("Proxima diagonal...");

        }

        return contador;
    }

    public static int diagonals2(char[][] mat) {
        int contador = 0;
        char[][] matrix = mat;

        // anti diag superiores
        // K=3 porque el pattern tiene al menos 4 letras por lo tanto la diagonal debe
        // ser como minimo de 4 caracteres.
        for (int k = 3; k <= matrix.length - 1; k++) {
            List diag = new ArrayList<>();
            int i = k;
            int j = 0;

            while ((i >= 0 && j <= matrix.length - 1)) {

              //  System.out.println(matrix[i][j]);
                diag.add(matrix[i][j]);
                i = i - 1;
                j = j + 1;
            }

            checkPattern(diag);
            if (checkPattern(diag)) {
                contador++;
            }
          //  System.out.println("Diagonal: " + diag);
            // empty list
            diag.removeAll(diag);
           // System.out.println("Proxima diagonal...");

        }

        // anti diag inferiores
        // length - 3 porque minimo necesitamos una diag de 4 caracteres
        for (int k = 1; k < matrix.length - 3; k++) {

            List diag = new ArrayList<>();
            int i = matrix.length - 1;
            int j = k;

            while (j <= matrix.length - 1 && i >= 0) {

                // System.out.println(matrix[i][j]);
                diag.add(matrix[i][j]);
                i = i - 1;
                j = j + 1;

            }

            checkPattern(diag);
            if (checkPattern(diag)) {
                contador++;
            }
            //System.out.println("Diagonal: " + diag);
            // empty list
            diag.removeAll(diag);
           // System.out.println("Proxima diagonal...");

        }

        return contador;
    }

    public static int checkMat(char[][] mat) {
        int contadorFinal = 0;

        for (int i = 0; i < mat.length; i++) {
            checkPattern(mat[i]);

            if (checkPattern(mat[i])) {
                contadorFinal++;
            }
        }
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

    public static boolean checkPattern(List list) {

        if (list.size() > 3) {

            for (int i = 0; i < list.size() - 3; i++) {

                if (list.get(i) == list.get(i + 1) && list.get(i + 1) == list.get(i + 2)
                        && list.get(i + 2) == list.get(i + 3)) {

                    return true;

                }

            }
            return false;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
        isMutant(dna);

    }
}
