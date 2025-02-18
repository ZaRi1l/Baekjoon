package q11051_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int div = 3;
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> shares = new ArrayList<int[]>();
		shares.add(new int[n]);
		
		long share[] = new long[n];
		long remainder[] = new long[n];
		
		long share2[] = new long[n];

		for (int i = 0; i < n; i++) {
			if (i == 0)
				shares.get(0)[i] = 1;
			else {
				int c = shares.size();
				for(int j = 0; j < c; j++) {
					shares.get(j)[i] = shares.get(j)[i - 1] * (i + 1);
				}
				
//				remainder[i] = remainder[i - 1] * (i + 1);
//				share[i] = share[i - 1] * (i + 1);
//				share2[i] = share2[i - 1] * (i + 1);
				
				for(int j = 0; j < c; j++) {
					if (shares.get(j)[i] >= div) {
						if (j == c-1) {
							shares.add(new int[n]);
							shares.get(c)[i] = shares.get(j)[i] / div;
						}
						shares.get(j)[i] %= div;
					}
				}
				
//				if (remainder[i] >= div) {
//					if (share[i] == 0)
//						share[i] = remainder[i] / div;
//					remainder[i] %= div;
//				}
//				
//				if (share[i] >= div) {
//					if (share2[i] == 0)
//						share2[i] = share[i] / div;
//					share[i] %= div;
//				}
			}
			for(int j = 0; j < shares.size(); j++) {
				System.out.print(shares.get(j)[i] + " ");
			}
			System.out.println();
		}

//		if (k != 0 && k != n)
//			System.out.print(nums[n - 1] / (nums[n - k - 1] * nums[k - 1]));
//		else
//			System.out.print(1);
	}

}
