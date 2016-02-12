package com.techelevator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Terminal {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private Terminal() { }
	
	public static String readLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
