package com.andytrann.projectc;

import java.io.IOException;

public class Launcher {

	public static void main(String[] args) throws IOException {
		Game g = new Game("Project C", 1280, 720);
		g.run();
	}

}
