package q11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			if (i == 0)
				arr[i] = Integer.parseInt(st.nextToken());
			else
				arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
		}

//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 2;
			int b = Integer.parseInt(st.nextToken()) - 1;

			if (a == -1)
				sb.append(arr[b] - 0).append('\n');
			else
				sb.append(arr[b] - arr[a]).append('\n');
		}
		System.out.println(sb);

	}

}
