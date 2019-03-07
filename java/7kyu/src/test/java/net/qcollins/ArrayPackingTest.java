package net.qcollins;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArrayPackingTest{

    @Test
    public void exampleTests() {
        assertEquals(21784, ArrayPacking.arrayPacking(new int[] {24, 85, 0}));
        assertEquals(2567447, ArrayPacking.arrayPacking(new int[] {23, 45, 39}));
        assertEquals(257, ArrayPacking.arrayPacking(new int[] {1, 1}));
        assertEquals(0, ArrayPacking.arrayPacking(new int[] {0}));
        assertEquals(4294967295L, ArrayPacking.arrayPacking(new int[] {255, 255, 255, 255}));
    }
}
