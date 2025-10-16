package com.amaris.bnp.bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MatrixUtils {

    //The goal here is to create a Matrix A such as A * X= Y
    // with Y column Matrix with each element equal basket size

    //X size is equal to the number of different book size

    // the matrix A is all the different composition we ca do
    public static List<int[]> generateMatrixA(int vectorSize, int target) {
        int[] X= IntStream.rangeClosed(1,vectorSize).toArray();
        List<int[]> results = new ArrayList<>();
        int[] current = new int[X.length];
        backtrack(X, 0, target, current, results);
        return results;
    }

    private static void backtrack(int[] X, int index, int remaining, int[] currentLine, List<int[]> resultsMatrix) {
        // condition d'arrêt
        if (index == X.length) {
            if (remaining == 0) {
                // une seule copie finale
                resultsMatrix.add(currentLine.clone());
            }
            return;
        }
        // bornage pour limiter les combinaisons inutiles
        int Xi = X[index];
        int maxAi = remaining / Xi;

        // exploration des coefficients possibles à cet index
        for (int Ai = 0; Ai <= maxAi; Ai++) {
            currentLine[index] = Ai;
            backtrack(X, index + 1, remaining - Ai * Xi, currentLine, resultsMatrix);
        }

    }
}
