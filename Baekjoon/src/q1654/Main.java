package q1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[k];
		int[] arr2;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		arr2 = arr.clone();

		int idx = arr2.length - 1;
		int cm = 0;
		while (true) {
			int count = 0;

			cm = arr2[idx];
			for (int i = 0; i < arr.length; i++) {
				count += arr[i] / cm;
			}

			if (count >= n)
				break;

			arr2[idx] = arr2[idx] / 2;
			if (idx == 0) {
				idx = arr2.length - 1;
			} else {
				idx -= 1;
			}
		}

		System.out.println(cm);

//		for(int i = 0 ; i < arr.length; i++) {
//			System.out.println(arr[i]);
//			System.out.println(arr2[i]);
//		}

//		int max = arr[arr.length - 1];
//		while(true) {
//			
//		}

	}

}
