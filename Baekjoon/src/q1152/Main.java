package q1152;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().trim().split(" ");
		sc.close();
		
		System.out.print(str[0].equals("") ? 0 : str.length);
		
	}

}
