package org.stroganov;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrefixSumArrayTest {
    @Test
    void testBasicSum() {
        PrefixSumArray arr = new PrefixSumArray(List.of(1, 2, 3, 4, 5));
        assertEquals(15, arr.getSumArray(0, 4)); // сумма всего массива
        assertEquals(6, arr.getSumArray(0, 2));  // 1+2+3
        assertEquals(9, arr.getSumArray(1, 3));  // 2+3+4
        assertEquals(3, arr.getSumArray(2, 2));  // одиночный элемент
    }

    @Test
    void testAddAndSum() {
        PrefixSumArray arr = new PrefixSumArray();
        arr.add(5);
        arr.add(10);
        arr.add(-2);
        assertEquals(13, arr.getSumArray(0, 2));
        arr.add(7);
        assertEquals(20, arr.getSumArray(0, 3));
        assertEquals(15, arr.getSumArray(1, 3));
    }

    @Test
    void testRemoveAndSum() {
        PrefixSumArray arr = new PrefixSumArray(List.of(3, 6, 9, 12));
        arr.remove(1); // удаляем 6 -> [3,9,12]
        assertEquals(24, arr.getSumArray(0, 2));
        assertEquals(21, arr.getSumArray(1, 2));
        arr.remove(0); // теперь [9,12]
        assertEquals(21, arr.getSumArray(0, 1));
    }

    @Test
    void testEdgeCases() {
        PrefixSumArray arr = new PrefixSumArray(List.of(10));
        assertEquals(10, arr.getSumArray(0, 0));
        arr.add(20);
        assertEquals(30, arr.getSumArray(0, 1));
    }

    @Test
    void testInvalidIndices() {
        PrefixSumArray arr = new PrefixSumArray(List.of(1, 2, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.getSumArray(-1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.getSumArray(0, 3));
    }

}