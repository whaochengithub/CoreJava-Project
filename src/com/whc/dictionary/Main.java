package com.whc.dictionary;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {

		String FilePath = "/Users/whaochen/Documents/workspaceJavaEE/MyDictory/dictionary.txt";
		Tire tire = new Tire();
		try {
			MyFileReader.buildIndex(tire, FilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SearchIndex index = new SearchIndex(tire);
		NewGUI awtControlDemo = new NewGUI(index);
		awtControlDemo.showTextAreaDemo();
		awtControlDemo.processWord();
	}
}
