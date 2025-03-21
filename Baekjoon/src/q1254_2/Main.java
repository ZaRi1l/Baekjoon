package q1254_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		br.close();

		StringBuffer sb;
		int min = str.length() * 2;
		for (int i = str.length(); i >= 0; i--) {
			sb = new StringBuffer(str.substring(i, str.length()));
			sb.reverse();
			sb.append(str);

			int p = 1;
			for (int j = 0; j < sb.length() / 2; j++) {
				if (sb.charAt(j) != sb.charAt(sb.length() - j - 1)) {
					p = 0;
					break;
				}
			}

			if (p == 1) {
				min = min < sb.length() ? min : sb.length();
			}
		}

		for (int i = 0; i < str.length(); i++) {
			sb = new StringBuffer(str);
			sb.append(new StringBuffer(str.substring(0, i)).reverse());

			int p = 1;
			for (int j = 0; j < sb.length() / 2; j++) {
				if (sb.charAt(j) != sb.charAt(sb.length() - j - 1)) {
					p = 0;
					break;
				}
			}

			if (p == 1) {
				min = min < sb.length() ? min : sb.length();
			}
		}

		System.out.print(min);

	}

}
