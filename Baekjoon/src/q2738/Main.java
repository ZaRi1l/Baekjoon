package q2738;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] a = new int[n][m];

		// a 행렬 값 넣기
		for (int i = 0; i < a.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// a 행렬에 b행렬 값 더 해주고 문자열버퍼에 넣어주기
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] += Integer.parseInt(st.nextToken());
				sb.append(a[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);

	}

}
