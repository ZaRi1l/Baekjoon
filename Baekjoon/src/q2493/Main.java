package q2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int[] tops = new int[n];	// 탑 크기
		int[] r = new int[n];		// 레이저가 닿는 탑 번호
		for (int i = 0; i < tops.length; i++) {
			tops[i] = Integer.parseInt(st.nextToken());

			for (int j = i - 1; j >= 0; j--) {
				if (tops[j] >= tops[i]) {
					r[i] = j + 1;		// 나보다 큰 탑 번호 넣기
					break;
				}
				
				// 해당 탑 보다 큰 곳으로 바로 이동
				j = r[j];
			}
		}

		StringBuffer sb = new StringBuffer();	// 출력
		for (int i : r) {
			sb.append(i).append(' ');
		}
		System.out.print(sb);

	}

}
