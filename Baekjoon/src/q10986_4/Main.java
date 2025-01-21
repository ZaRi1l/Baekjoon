package q10986_4;

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
		int[] remain = new int[m];

		st = new StringTokenizer(br.readLine(), " ");
		br.close();

		for (int i = 0; i < remain.length; i++) {
			remain[i] = -1;
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int idx = Integer.parseInt(st.nextToken()) % m;

			remain[idx] = i;

			if (idx == 0) {
				if (remain[idx] - 1 >= 0)
					arr[i] += arr[remain[idx] - 1] + 1;
				else
					arr[i] += 1;

			} else if (remain[m - idx] >= 0)
				if (remain[m - idx] - 1 >= 0)
					arr[i] += arr[remain[m - idx] - 1] + 1;
				else
					arr[i] += 1;

			sum += arr[i];
//			System.out.print(arr[i] + " ");
		}

		System.out.print(sum);
	}

}
