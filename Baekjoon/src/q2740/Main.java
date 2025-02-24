package q2740;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] a = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

		for (int i = 0; i < a.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int[][] b = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

		for (int i = 0; i < b.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		int[][] mult = new int[a.length][b[0].length];

		for (int i = 0; i < mult.length; i++) {
			for (int j = 0; j < mult[i].length; j++) {
				for (int k = 0; k < b.length; k++) {
					mult[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mult.length; i++) {
			for (int j = 0; j < mult[i].length; j++) {
				sb.append(mult[i][j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.print(sb);

	}

}
