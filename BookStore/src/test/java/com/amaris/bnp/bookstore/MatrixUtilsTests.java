package com.amaris.bnp.bookstore;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatrixUtilsTests {

    @Test
    void testGenerateMatrixA_SimpleUseCase() {
        List<int[]> results = MatrixUtils.generateMatrixA(3, 4);

        assertTrue(results.stream().anyMatch(a -> a[0] == 4 && a[1] == 0 && a[2] == 0));

        assertTrue(results.stream().anyMatch(a -> a[0] == 0 && a[1] == 2 && a[2] == 0));


        for (int[] a : results) {
            int sum = a[0]*1 + a[1]*2 + a[2]*3;
            assertEquals(4, sum);
        }

        assertTrue(results.size() > 2);
    }
}
