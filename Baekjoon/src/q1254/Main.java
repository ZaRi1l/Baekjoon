package q1254;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		br.close();

		int[] cp = new int[str.length()];
		int[] cp2 = new int[str.length()];
		int max = 0;
		int max2 = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				int k = 2 * i - j;

				if (k >= str.length())
					break;
				if (str.charAt(j) == str.charAt(k))
					cp[i]++;
				else
					break;
			}
			for (int j = i - 1; j >= 0; j--) {
				int k = 2 * i - j - 1;

				if (k >= str.length())
					break;
				if (str.charAt(j) == str.charAt(k))
					cp2[i]++;
				else
					break;
			}
			max = max > cp[i] ? max : cp[i];
			max2 = max2 > cp2[i] ? max2 : cp2[i];
		}

		int lenMax = str.length() - (max * 2 + 1) + str.length();
		int lenMax2 = str.length() - (max2 * 2) + str.length();
		
		System.out.print(lenMax < lenMax2 ? lenMax : lenMax2);
	}

}
