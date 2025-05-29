package com.SpringWithoutBootDemo.SpringApp;

public class Dev {
	private Computer comp;
	
	public void build() {
		comp.compile();
		System.out.println("Building spring application");
	}

	public Computer getComp() {
		return comp;
	}

	public void setComp(Computer comp) {
		this.comp = comp;
	}
}
