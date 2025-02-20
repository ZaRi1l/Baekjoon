package q9251_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine(); // 값 넣어주기
		String str2 = br.readLine();
		br.close();

		int[][] met = new int[str1.length()][str2.length()]; // 문자 비교할 metrix 만들어주기

		for (int i = 0; i < met.length; i++) {
			for (int j = 0; j < met[0].length; j++) {
				if (str1.charAt(i) == str2.charAt(j)) { // 값이 같다면
					if (i == 0 || j == 0) { // 문자가 처음 단어 이면 1 넣어주기
						met[i][j] = 1;
					} else if (i != 0 && j != 0) { // 문자가 처음 단어가 아니라면 대각선에 있는 값 + 1
						met[i][j] = met[i - 1][j - 1] + 1;
					}

				} else { // 같지 않다면
					if (j != 0) // 한 문자열의 처음단어가 아니라면 그 전에 값 넣어주기
						met[i][j] = met[i][j - 1];
					if (i != 0)
						met[i][j] = met[i - 1][j];
					if (i != 0 && j != 0) // 두 문자열의 처음단어가 아니라면 두 문자열의 전에 값 비교해서 큰 값 넣어주기
						met[i][j] = Math.max(met[i - 1][j], met[i][j - 1]);
				}
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

		System.out.println(met[met.length - 1][met[0].length - 1]); // 출력
	}

}
