package q2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] paper; // 종이
	static int whiteCount = 0; // 하얀색 정사각형 개수
	static int blueCount = 0; // 파란색 정사각형 개수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		paper = new int[n][n];

		StringTokenizer st;
		for (int i = 0; i < paper.length; i++) { // 값 넣기
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < paper[i].length; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

//		for (int i = 0; i < paper.length; i++) {		// 출력해보기
//			for (int j = 0; j < paper[i].length; j++) {
//				System.out.print(paper[i][j] + " ");
//			}
//			System.out.println();
//		}

		dfs(0, n, 0, n); // 재귀함수 호출

		StringBuffer sb = new StringBuffer();
		sb.append(whiteCount).append('\n').append(blueCount);

		System.out.print(sb); // 출력
	}

	static void dfs(int x1, int x2, int y1, int y2) { // 행 범위, 열 범위
		int white = 0; // 하얀색 개수
		int blue = 0; // 파란색 개수

		// 검사
		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				if (paper[i][j] == 0)
					white += 1;
				else
					blue += 1;
			}
		}

		// 하나라도 0이면 다른 색깔로 꽉차있다는 뜻
		if (blue == 0) {
			whiteCount += 1;
			return; // 함수 나오기
		}
		if (white == 0) {
			blueCount += 1;
			return;
		}

		// 범위를 4등분해서 다시 재귀함수 호출
		dfs(x1, x1 + (x2 - x1) / 2, y1, y1 + (y2 - y1) / 2);
		dfs(x1 + (x2 - x1) / 2, x2, y1, y1 + (y2 - y1) / 2);
		dfs(x1, x1 + (x2 - x1) / 2, y1 + (y2 - y1) / 2, y2);
		dfs(x1 + (x2 - x1) / 2, x2, y1 + (y2 - y1) / 2, y2);
	}

}
