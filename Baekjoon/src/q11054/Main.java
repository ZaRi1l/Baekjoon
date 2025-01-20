package q11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int[] a = new int[n]; // 수열 가져오기
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int[] arrf = new int[n]; // 앞에 기준으로 바이토닉 수열 개수
		int[] arrb = new int[n]; // 뒤에 기준

		for (int i = 0; i < a.length; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) { // 갚이 앞에 있던 수보다 클때
					if (max < arrf[j] + 1) // 해당 갚에서 수열의 개수랑 비교후
						max = arrf[j] + 1; // 최대값을 넣어줌
				}
			}
			arrf[i] = max;
		}

		for (int i = a.length - 1; i >= 0; i--) {
			int max = 1;
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[i]) {
					if (max < arrb[j] + 1)
						max = arrb[j] + 1;
				}
			}
			arrb[i] = max;
		}

//		for (int i = 0; i < a.length; i++) {
//			System.out.print(arrf[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(arrb[i] + " ");
//		}

		int max = 0;
		for (int i = 0; i < a.length; i++) {
			int tmp = arrb[i] + arrf[i]; // 앞뒤 수열을 다 합친것중에 최대값을 가져옴
			max = max > tmp ? max : tmp;
		}
		System.out.print(max - 1); // 자기 자신이 겹치기에 -1

	}

}
