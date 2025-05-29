package com.SpringWithoutBootDemo.SpringApp;

public class Laptop implements Computer {
	public Laptop() {
		System.out.println("Laptop initialized");
	}
	
	public void compile() {
		System.out.println("Compiling in Laptop");
	}
}
