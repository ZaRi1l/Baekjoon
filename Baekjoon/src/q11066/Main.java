package q11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int z = 0; z < t; z++) {

			int k = Integer.parseInt(br.readLine());
			int[] ka = new int[k];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < ka.length; i++) {
				ka[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(ka);

			int[] x = new int[k - 1];
			int idx = 0;
			int idxX = 0;
			int sum = 0;
			for (int i = 0; i < x.length; i++) {
				if (i == 0) {
					x[i] = ka[idx] + ka[idx + 1];
					idx = 2;
				} else {
					if (idx + 1 < k) {
						int a = x[i - 1] + ka[idx];
						int b = ka[idx] + ka[idx + 1];

						if (a < b) {
							x[i] = a;
							idx += 1;
						} else {
							x[i] = b;
							idx += 2;
						}
						
						System.out.print(x[i] + ":k ");
					} else {
						if(idxX + 1 < k - 1) {
							x[i] = x[idxX] + x[idxX + 1];
							idxX += 2;
						}
						System.out.print(x[i] + ":x ");
					}
				}
				sum += x[i];
			}

			System.out.println(sum);

		}
		br.close();
	}

}
