package q10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		int[] num = new int[k];
		int idx = 0;

		for (int i = 0; i < num.length; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				num[--idx] = 0;
			} else {
				num[idx++] = n;
			}
		}

		int sum = 0;
		for (int i : num) {
			if (i == 0)
				break;
			sum += i;
		}

		System.out.print(sum);
	}

}
