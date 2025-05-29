package com.SpringWithoutBootDemo.SpringApp;

public class Desktop implements Computer {
	public Desktop() {
		System.out.println("Desktop initialized");
	}
	
	public void compile() {
		System.out.println("Compiling in Desktop");
	}
}
