package webScraperDemo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ClearFile {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter writer = new PrintWriter("/Users/Mike/Documents/testFile.txt");
		writer.print("");
		writer.close();

	}

}
