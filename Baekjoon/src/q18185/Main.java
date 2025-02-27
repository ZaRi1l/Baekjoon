package q18185;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int cost = 0;

		for (int i = 0; i + 2 < a.length; i++) {
			while (a[i] > 0 && a[i + 1] > 0 && a[i + 2] > 0) {
				if (a[i + 1] > a[i + 2] && a[i + 1] > a[i]) {
					a[i] -= 1;
					a[i + 1] -= 1;
					cost += 5;
				} else {
					a[i] -= 1;
					a[i + 1] -= 1;
					a[i + 2] -= 1;
					cost += 7;
				}
			}
		}

		for (int i = 0; i + 1 < a.length; i++) {
			while (a[i] > 0 && a[i + 1] > 0) {
				a[i] -= 1;
				a[i + 1] -= 1;
				cost += 5;
			}
		}

		for (int i = 0; i < a.length; i++) {
			while (a[i] > 0) {
				a[i] -= 1;
				cost += 3 * 1;
			}
		}

		System.out.print(cost);
	}

}
