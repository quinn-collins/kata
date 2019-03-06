package net.qcollins;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class DivisibleNbTest {

	@Test
	public void test1() {
		assertEquals(true, DivisibleNb.isDivisible(12,4,3));
	}
	@Test
	public void test2() {
		assertEquals(false, DivisibleNb.isDivisible(3,3,4));
	}	
		
}

