package com.lesson1;

import java.util.Scanner;

public class WriteToConsole {
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	System.out.println();
	System.out.println("Write some text!");
	String getScan = scan.nextLine();
	System.out.println();
	System.out.println("---------> " + getScan + " <---------");
	
	}
}