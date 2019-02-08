package com.virtusa.bt;

import java.io.ByteArrayInputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.virtusa.bt.TicTacToe;



public class TicTacToeTest {

	private TicTacToe o;
	
    @Before
	public void initialize() {
		o = new TicTacToe();
	}
	@Test
	public void xWinsTest() {
		ByteArrayInputStream in = new ByteArrayInputStream("0 1 1 1 0 2 1 0 0 0".getBytes());
		System.setIn(in);
		System.setIn(System.in);
		TicTacToe o = new TicTacToe();
		String expected =  " X wins...!!";
		Assert.assertEquals(expected, o.play());
	}
	
	@Test
	public void oWinsTest() {
		ByteArrayInputStream in = new ByteArrayInputStream("0 0 1 1 0 1 1 0 2 1 1 2".getBytes());
		System.setIn(in);
		System.setIn(System.in);
		TicTacToe o = new TicTacToe();
		String expected =  " O wins...!!";
		Assert.assertEquals(expected, o.play());
	}
	
	@Test
	public void tiesTest() {
		ByteArrayInputStream in = new ByteArrayInputStream("0 0 1 1 0 1 1 0 2 1 2 2 1 2 0 2 2 0".getBytes());
		System.setIn(in);
		System.setIn(System.in);
		TicTacToe o = new TicTacToe();
		String expected =  "its a tie";
		Assert.assertEquals(expected, o.play());
	}
}
