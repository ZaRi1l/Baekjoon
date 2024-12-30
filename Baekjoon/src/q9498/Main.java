package q9498;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		sc.close();
		
		
		switch(score / 10) {
		case 10:
		case 9:
			System.out.println('A');
			break;
		case 8:
			System.out.println('B');
			break;
		case 7:
			System.out.println('C');
			break;
		case 6:
			System.out.println('D');
			break;
		default:
			System.out.println('F');	
			break;
		}
		
		
//		if (90 <= score && score <= 100) {
//			System.out.println('A');
//		} else if (80 <= score && score <= 89) {
//			System.out.println('B');
//		} else if (70 <= score && score <= 79) {
//			System.out.println('C');
//		} else if (60 <= score && score <= 69) {
//			System.out.println('D');
//		} else {
//			System.out.println('F');
//		}
	}

}
