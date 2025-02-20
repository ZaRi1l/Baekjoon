package q9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		br.close();

		int[][] met = new int[str1.length()][str2.length()];

		for (int i = 0; i < met.length; i++) {
			for (int j = 0; j < met[0].length; j++) {
				if (str1.charAt(i) == str2.charAt(j))
					met[i][j] = 1;
			}
		}

		// 출력 해보기
//		for (int i = 0; i < met.length; i++) {
//			for (int j = 0; j < met[0].length; j++) {
//				System.out.print(met[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		// 값 더하기
		int[] lineMax = new int[str2.length()];
		for (int i = 0; i < met.length; i++) {
			for (int j = 0; j < met[0].length; j++) {
				if (met[i][j] == 1) {
					if (j != 0)
						met[i][j] += lineMax[j - 1];
					else
						met[i][j] = 1;
					lineMax[j] = met[i][j];
				}

				if (j != 0 && lineMax[j] < lineMax[j - 1]) {
					lineMax[j] = lineMax[j - 1];
				}

				if (i != 0 && j != 0)
					lineMax[j] = met[i - 1][j - 1] > lineMax[j] ? met[i - 1][j - 1] : lineMax[j];

				System.out.print(lineMax[j] + " ");
			}
			System.out.println();
		}

		// 출력 해보기
//		for (int i = 0; i < met.length; i++) {
//			for (int j = 0; j < met[0].length; j++) {
//				System.out.print(met[i][j] + " ");
//			}
//			System.out.println();
//		}

		// 뒤집었을때 버전도 만들어야할 듯

//		int[][] met2 = new int[str2.length()][str1.length()];
//
//		for (int i = 0; i < met2.length; i++) {
//			for (int j = 0; j < met2[0].length; j++) {
//				if (str1.charAt(j) == str2.charAt(i))
//					met2[i][j] = 1;
//			}
//		}
//
//		int[] lineMax2 = new int[str1.length()];
//		for (int i = 0; i < met2.length; i++) {
//			for (int j = 0; j < met2[0].length; j++) {
//				if (met2[i][j] == 1) {
//					if (j != 0)
//						met2[i][j] += lineMax2[j - 1];
//					else
//						met2[i][j] = 1;
//					lineMax2[j] = met2[i][j];
//				}
//
//				if (j != 0 && lineMax2[j] < lineMax2[j - 1]) {
//					lineMax2[j] = lineMax2[j - 1];
//				}
//
//				if (i != 0)
//					lineMax2[j] = met2[i - 1][j] > lineMax2[j] ? met2[i - 1][j] : lineMax2[j];
//			}
//		}
//
//		System.out.print(lineMax[lineMax.length - 1] < lineMax2[lineMax2.length - 1] ? lineMax2[lineMax2.length - 1]
//				: lineMax[lineMax.length - 1]);

		System.out.print(lineMax[lineMax.length - 1]);
	}

}
