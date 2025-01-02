package q1149;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] homes = new int[sc.nextInt()][3];	// 복사해서 정렬  써서 차이, 최소값구해보기
		
		int min, sec, diff, sum;
		
		for (int i = 0; i < homes.length; i++) {
			for (int j = 0; j < homes[i].length; j++) {
				homes[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
//		for (int i = 0; i < homes.length; i++) {
//			for (int j = 0; j < homes[i].length; j++) {
//				System.out.print(homes[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < homes.length; i++) {
			min = homes[i][0];
			for (int j = 0; j < homes[i].length; j++) {
				if (homes[i][j] < min) {
					min = homes[i][j];
					sec = j;
					
//					for (int k = 0; k < homes[i].length; k++) {
//						if ((homes[i][k] - min) != 0) {
//							diff = homes[i][k] - min;
//						}
//					} 
				}
			}
		}
		
		
	}

}

// 색깔이 위 아래와 안 겹칠때 최소값 구하면 됨