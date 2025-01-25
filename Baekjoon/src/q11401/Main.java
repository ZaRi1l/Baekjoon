package q11401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long[] nf = new long[n];
		int[] mult = new int[n];
//		int[] kf = new int[k];
//		int[] nkf = new int[n - k];

		for (int i = 1; i <= nf.length; i++) {
			if (i == 1)
				nf[i - 1] = 1;
			else {
				if ((nf[i - 2] * i) > 1000000007) {
					nf[i - 1] = (nf[i - 2] * i) % 1000000007;
//					mult[i - 1] = mult[i - 2] + 1; // 1 대신 i  넣어야 하나??
				} else {
					nf[i - 1] = (nf[i - 2] * i);
				}
			}
			System.out.println(nf[i - 1] + " " + mult[i - 1]);
		}

//		for (int i = 1; i <= kf.length; i++) {
//			if (i == 1)
//				kf[i - 1] = 1;
//			else {
//				kf[i - 1] = kf[i - 2] * i;
//			}
//		}
//
//		for (int i = 1; i <= nkf.length; i++) {
//			if (i == 1)
//				nkf[i - 1] = 1;
//			else {
//				nkf[i - 1] = nkf[i - 2] * i;
//			}
//		}

//		for (int i = 0; i < nf.length; i++) {
//			System.out.println(nf[i] + " ");
//		}

//		System.out.print(nf[nf.length - 1] / (kf[kf.length - 1] * nkf[nkf.length - 1]));
		System.out.println(nf[n - 1] + " " + nf[k - 1] + " " + nf[n - k - 1]);
		System.out.println(nf[k - 1] * nf[n - k - 1]);
		System.out.print(nf[n - 1] * 1000000007 / (nf[k - 1] * nf[n - k - 1]));
	}

}
