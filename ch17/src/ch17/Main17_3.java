package ch17;

import java.io.*;

//ざっくりと例外を捕捉する
import java.io.*;

public class Main17_3 {
	public static void main(String[] args) {
		try (FileWriter fw = new FileWriter("data.txt");) {
			fw.write("hello");

		} catch (Exception e) {
			System.out.println("An error occurs!");
		}
	}
}
