package net.qcollins;

public class ArrayPacking {
    public static long arrayPacking(int[] arr) {
        String eightBitsString = "";
        for(int i : arr) {
            String bitsString = Integer.toBinaryString(i);
            eightBitsString = ("00000000" + bitsString).substring(bitsString.length()) + eightBitsString;
        }
        return Long.parseUnsignedLong(eightBitsString,2);
    }
}
