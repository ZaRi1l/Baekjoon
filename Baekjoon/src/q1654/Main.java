package q1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[k];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int cm = 0;
		int max = 0;
		for (int idx = arr.length - 1; idx >= 0; idx--) {

			int a = 1;
			while (true) {
				int count = 0;

				cm = arr[idx] / a;
				for (int i = 0; i < arr.length; i++) {
					count += arr[i] / cm;
				}

				if (count >= n)
					break;
				a += 1;
			}
			max = (max < cm) ? cm : max;
		}

		System.out.println(max);

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
