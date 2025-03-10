package q2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] arr2 = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();

		// 출력
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}

		for (int i = 0; i < arr2.length; i++) {
			if (i == 0) {
				arr2[0] = arr[0];
			} else if (i == 1) {
				arr2[1] = arr[1] + arr2[0];
				if (arr2.length == 3) {
					arr2[2] = arr[2] + Math.max(arr[1], arr[0]);
					break;
				}
			} else if (arr2[i - 1] - arr2[i - 2] == arr[i - 1]) {
				arr2[i] = arr2[i - 2] + arr[i];
			} else {
				arr2[i] = arr[i] + Math.max(arr2[i - 1], arr2[i - 2]);
			}
		}

		// 출력
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr2[i]);
//		}
		System.out.print(arr2[arr2.length - 1]);
	}
}
