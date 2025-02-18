package q11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int div = 10007;
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long share[] = new long[n];
		long remainder[] = new long[n];
		
		long share2[] = new long[n];

		for (int i = 0; i < n; i++) {
			if (i == 0)
				remainder[i] = 1;
			else {
				remainder[i] = remainder[i - 1] * (i + 1);
				share[i] = share[i - 1] * (i + 1);
				share2[i] = share2[i - 1] * (i + 1);
				
				if (remainder[i] >= div) {
					if (share[i] == 0)
						share[i] = remainder[i] / div;
					remainder[i] %= div;
				}
				
				if (share[i] >= div) {
					if (share2[i] == 0)
						share2[i] = share[i] / div;
					share[i] %= div;
				}
			}
			System.out.println(remainder[i] + " " + share[i] + " " + share2[i]);
		}

//		if (k != 0 && k != n)
//			System.out.print(nums[n - 1] / (nums[n - k - 1] * nums[k - 1]));
//		else
//			System.out.print(1);
	}

}
