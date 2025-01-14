package q1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int tmp = Integer.MIN_VALUE;
		while (st.hasMoreTokens()) {
			int curr = Integer.parseInt(st.nextToken());

			if (curr > curr + tmp) {
				tmp = curr;
			} else {
				tmp = curr + tmp;
			}
		}

		System.out.print(tmp);
	}

}
