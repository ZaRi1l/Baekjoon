package q2587;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[5];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		br.close();

		Arrays.sort(arr);

		StringBuffer sb = new StringBuffer();
		sb.append(sum / arr.length).append('\n');
		sb.append(arr[2]);

		System.out.print(sb);
	}

}
