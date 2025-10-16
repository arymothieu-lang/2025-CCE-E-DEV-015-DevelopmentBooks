package com.amaris.bnp.bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MatrixUtils {

    private final static double[] discountVector={0,0.05,0.1,0.2,0.25};

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
        // stopping condition
        if (index == X.length) {
            if (remaining == 0) {
                resultsMatrix.add(currentLine.clone());
            }
            return;
        }
        // uper bound to limit the number of combinason
        int Xi = X[index];
        int maxAi = remaining / Xi;

        // exploration of different coefficient for each index after the given one
        for (int Ai = 0; Ai <= maxAi; Ai++) {
            currentLine[index] = Ai;
            backtrack(X, index + 1, remaining - Ai * Xi, currentLine, resultsMatrix);
        }

    }


    public static double  getMinPrice(Order order){
        return generateMatrixA(order.getAvailableBookSize(),order.getBooks().size())
                .stream()
                .map(MatrixUtils::getPriceVector)
                .min(Double::compareTo)
                .orElse(0d);
    }

    static double getPriceVector(int[] vector){
        if (null==vector){
            return 0d;
        }
        var sum=0d;
        for (int i = 0; i < vector.length; i++) {
            sum=sum+vector[i]*(i+1)*(1-discountVector[i]);
        }
        return sum;
    }
}
