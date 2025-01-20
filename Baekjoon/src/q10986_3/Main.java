package q10986_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		br.close();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) % m;
		}

//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}

		int[] count = new int[n];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int s = 0;
			for (int j = i; j >= 0; j--) {
				s += arr[j];
				if (s == m || s == 0) {
					if (j - 1 != -1)
						count[i] += count[j - 1] + 1;
					else
						count[i] += 1;
					break;
				}
			}
			sum += count[i];
		}
		System.out.print(sum);
	}

}
