package com.whc.dictionary;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class MyFileReader {
	
	public static void buildIndex(Tire tire, String fileName) throws IOException{
		File file = new File(fileName);
		FileInputStream fr=new FileInputStream(file);
		Scanner scanner = new Scanner(fr, "UTF-8");
        while(scanner.hasNextLine()){
            String s=scanner.nextLine();
            if(s!=null){
            String [] strArray = s.split(" ");
            tire.insert(strArray[0], s);
            }
        
	}
        scanner.close();
        fr.close();
	
	}

}
