package q1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] count = new int['Z' - 'A' + 1];

		str = str.toUpperCase();

		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'A']++;
		}

		int max = 0;
		int maxIdx = 0;
		boolean dup = false;
		for (int i = 0; i < count.length; i++) {
			if (max < count[i]) {
				max = count[i];
				maxIdx = i;
				dup = false;
			} else if (max == count[i]) {
				dup = true;
			}
		}

		if (dup)
			System.out.print('?');
		else
			System.out.print((char) (maxIdx + 'A'));
	}

}
