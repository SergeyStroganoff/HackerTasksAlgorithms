package com.fb;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhotographyMaxEffectiveTest {
    static class TestData {
        int N;
        String string;
        int X;
        int Y;

        public TestData(int n, String string, int x, int y) {
            N = n;
            this.string = string;
            X = x;
            Y = y;
        }
    }

    @Test
    void testGetArtisticPhotographCount() {
        int result = PhotographyMaxEffective.getArtisticPhotographCount(0, "C", 0, 0);
        assertEquals(0, result);
    }

    @Test
    public void testBasicCases() {
        assertEquals(1, PhotographyMaxEffective.getArtisticPhotographCount(5, "PAB..", 1, 2));
        assertEquals(2, PhotographyMaxEffective.getArtisticPhotographCount(6, "PABPAB", 1, 2));
    }


    @Test
    public void testEdgeCases() {
        assertEquals(1, PhotographyMaxEffective.getArtisticPhotographCount(7, "P..A..B", 2, 3));
        assertEquals(0, PhotographyMaxEffective.getArtisticPhotographCount(7, "P..A..B", 4, 5));
        assertEquals(0, PhotographyMaxEffective.getArtisticPhotographCount(7, "P..A..B", 1, 1));
    }

    @Test
    public void testBoundaryCases() {
        assertEquals(0, PhotographyMaxEffective.getArtisticPhotographCount(1, "P", 1, 2));
        assertEquals(1, PhotographyMaxEffective.getArtisticPhotographCount(3, "PAB", 1, 1));
        assertEquals(0, PhotographyMaxEffective.getArtisticPhotographCount(5, "A...P", 1, 3));
        assertEquals(0, PhotographyMaxEffective.getArtisticPhotographCount(5, "AAAAA", 1, 3));
    }

    @Test
    public void testCasesWithEmptyCells() {
        assertEquals(0, PhotographyMaxEffective.getArtisticPhotographCount(7, "P...A..B", 1, 3));
        assertEquals(1, PhotographyMaxEffective.getArtisticPhotographCount(7, "P.A.B.P", 1, 3));
    }

    //Auto test.
    @Test
    public void testComplexCases() {
        TestData testData = new TestData(10, "P.A.B.P.A.B", 1, 3);
        assertEquals(Photography.getArtisticPhotographCount(testData.N, testData.string, testData.X, testData.Y), PhotographyMaxEffective.getArtisticPhotographCount(testData.N, testData.string, testData.X, testData.Y));
    }

    @Test
    public void testEmptyString() {
        TestData testData = new TestData(10, "", 1, 3);
        assertEquals(Photography.getArtisticPhotographCount(testData.N, testData.string, testData.X, testData.Y), PhotographyMaxEffective.getArtisticPhotographCount(testData.N, testData.string, testData.X, testData.Y));
    }

    @Test
    public void testBlankString() {
        TestData testData = new TestData(10, "BAPPPPPPPPPP", 1, 0);
        assertEquals(Photography.getArtisticPhotographCount(testData.N, testData.string, testData.X, testData.Y), PhotographyMaxEffective.getArtisticPhotographCount(testData.N, testData.string, testData.X, testData.Y));
    }

    @Test
    public void testLargeInput() {
        String largeInput = "PABBAP........................................B".repeat(100); // 3000 characters long
        TestData testData = new TestData(3000, largeInput, 1, 100);
        assertEquals(Photography.getArtisticPhotographCount(testData.N, testData.string, testData.X, testData.Y), PhotographyMaxEffective.getArtisticPhotographCount(testData.N, testData.string, testData.X, testData.Y));
    }

    @Test
    public void testMinimalString() {
        assertEquals(0, PhotographyMaxEffective.getArtisticPhotographCount(2, "PB", 1, 1));
    }

    @Test
    public void testAllEmptyCells() {
        assertEquals(0, PhotographyMaxEffective.getArtisticPhotographCount(10, "..........", 1, 3));
    }

    @Test
    public void randomStringAndRange() {
        char[] chars = {'.', 'P', 'B', 'A'};
        Random random = new Random();
        int count = 1000;
        while (count > 0) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < random.nextInt(100); i++) {
                stringBuilder.append(chars[random.nextInt(3)]);
            }
            String test = stringBuilder.toString();
            System.out.println(test);
            TestData testData = new TestData(test.length(), test, x, y);
            assertEquals(Photography.getArtisticPhotographCount(testData.N, testData.string, testData.X, testData.Y), PhotographyMaxEffective.getArtisticPhotographCount(testData.N, testData.string, testData.X, testData.Y));
            count--;
        }
    }
}
