package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestDemo {

	@Test
	public void test1() {
		assertTrue(1==1);
	}
	@Test
	public void test2() {
		assertTrue(2==2);
	}
	@Test
	public void test3() {
		assertTrue(1==2);
	}
	@Test
	public void test4() {
		assertTrue(1==3);
	}
}
