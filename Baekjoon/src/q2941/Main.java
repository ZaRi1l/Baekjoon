package q2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] cr = { "c=", "c-", "d-", "lj", "nj", "s=", "z=" };
		String str = br.readLine();
		br.close();

		int len = str.length();
		for (int i = 0; i < str.length() - 1; i++) {
			String sub = str.substring(i, i + 2);

			for (int j = 0; j < cr.length; j++) {
				if (sub.equals(cr[j])) {
					len -= 1;
					break;
				}
			}

			if (i < str.length() - 2) {
				sub = str.substring(i, i + 3);
				if (sub.equals("dz=")) {
					len -= 1;
					continue;
				}
			}
		}

		System.out.print(len);

	}

}
