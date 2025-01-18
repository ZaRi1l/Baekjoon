package q1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// 1 1
		// 2 00 11
		// 3 001 100 111
		// 4 0000 1001 1100 0011 1111
		// 5 00000 10000 11111 11001
		// 00001 00111 11100 10011

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		long[] seq = new long[n];

		for (int i = 0; i < seq.length; i++) {
			if (i == 0 || i == 1)
				seq[i] = i + 1;
			else {
				seq[i] = seq[i - 1] + seq[i - 2];

				if (seq[i] > 15746 && seq[i - 2] > 15746 && seq[i - 2] > 15746) {
					seq[i] = seq[i] % 15746; // 중간 중간에 15746 보다 커질때 나머지 안 구해주면 값이 기하급수적으로 커짐
					seq[i - 1] = seq[i - 1] % 15746; // 오버플로우 일어남
					seq[i - 2] = seq[i - 2] % 15746;
				}
			}
		}

		System.out.print(seq[seq.length - 1] % 15746);

	}

}
