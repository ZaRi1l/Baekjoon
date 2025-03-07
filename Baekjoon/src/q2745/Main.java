package q2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());

		int nums = 0;

		for (int i = 0; i < n.length(); i++) {
			int num = n.charAt(i);
			if ('A' <= num && num <= 'Z') {
				num = num - 'A' + 10;
			} else {
				num = num - '0';
			}

			for (int j = 1; j < n.length() - i; j++) {
				num *= b;
			}
			nums += num;
		}

		System.out.print(nums);
	}

}
