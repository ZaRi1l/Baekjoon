package q1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 사실 안 써도 됨
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int tmp = -1001;
		int max = -1001; // Integer.MIN_VALUE 쓰니까 값이 양수가됨 이유는 모름
		while (st.hasMoreTokens()) {
			int curr = Integer.parseInt(st.nextToken());

			if (curr > curr + tmp) {
				tmp = curr;
			} else {
				tmp = curr + tmp;
			}
			max = max > tmp ? max : tmp;
		}
		System.out.print(max);
	}
}
