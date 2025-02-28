package q11066_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int z = 0; z < t; z++) {

			int k = Integer.parseInt(br.readLine());
			Integer[] c = new Integer[k];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < c.length; i++) {
				c[i] = Integer.parseInt(st.nextToken());
			}

			int[][] x = new int[c.length][c.length];

			for (int i = 0; i < x.length; i++) {
				for (int j = i; j >= 0; j--) {
					if (i == 0 && j == 0) {
						x[j][i] = c[i];
					} else if (j == i) {
						x[j][i] = c[i];
					} else if (j == i - 1) {
						x[j][i] = x[j + 1][i] + x[j][i - 1];
					} else if (j == i - 2) {	// 0 2     
						int tmp1 = x[j + 1][i] * 2 + c[j];	// 1 2   0		160
						int tmp2 = x[j][i - 1] * 2 + c[i];	// 0 1   2		170
						x[j][i] = tmp1 < tmp2 ? tmp1 : tmp2;
					} else {
						int tmp1 = x[j + 1][i] * 2 + c[j];
						int tmp2 = x[j][i - 1] * 2 + c[i];

						int min = tmp1 < tmp2 ? tmp1 : tmp2;
						for (int l = 1; l < i - 1 || l < j - 1; l++) {	// ??
							int a = min;
							int b = min;
							if (j + l + 1 < x.length && l < x.length) {
								a = x[j][l];
								b = x[j + l + 1][i];
							} else if (j + l + 1 < x.length){
								b = x[j + l + 1][i];
								a = b;
							} else if (i + l + 1 < x.length) {
								a = x[j][l];
								b = a;
							}
							int tmp3 = a * 2 + b * 2;

							min = min < tmp3 ? min : tmp3;
						}
						x[j][i] = min;
					}
				}
			}

			for (int i = 0; i < x.length; i++) {
				for (int j = 0; j < x[i].length; j++) {
					System.out.print(x[i][j] + " ");
				}
				System.out.println();
			}

		}
		br.close();
	}

	static int find(Integer[] c, TreeSet<Integer> x, int sum) {
		for (int i = 0; i < c.length; i++) {
			if (i == 0) {
				x.add(c[i] + c[i + 1]);
				sum += c[i] + c[i + 1];
				i += 1;
			} else if (i == c.length - 1) {
				int first = x.first();
				x.remove(first);
				x.add(c[i] + first);
				sum += c[i] + first;
			} else {
				if (x.first() + c[i] < c[i] + c[i + 1]) {
					int first = x.first();
					x.remove(first);
					x.add(c[i] + first);
					sum += c[i] + first;
				} else {
					x.add(c[i] + c[i + 1]);
					sum += c[i] + c[i + 1];
					i += 1;
				}
			}

			// 출력 해보기
			for (int j : x) {
				System.out.print(j + " ");
			}
			System.out.println(": " + sum);
		}

		return sum;
	}

}
