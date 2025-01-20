package q1463_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		int num = 1;
		int count = 0;
		while (num != n) {
			if (n >= num * 3) {
				num *= 3;
			} else if (n >= num * 2) {
				num *= 2;
			} else {
				num += 1;
			}
			count += 1;
		}

		System.out.print(count);
	}

}
