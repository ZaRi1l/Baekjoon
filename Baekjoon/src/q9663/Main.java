package q9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cs = 0; // 경우의 수 더하기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		int[][] chess = new int[n][n]; // chess 판

//		for (int i = 0; i < chess.length; i++) {			// 출력 해보기
//			for (int j = 0; j < chess[i].length; j++) {
//				System.out.print(chess[i][j] + " ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < chess.length; i++) { // 1행의 모든 수를 대입해보기
			backTrack(chess, 0, i);
			chess = new int[n][n];
		}

//		for (int i = 0; i < chess.length; i++) {		// 출력해보기
//			for (int j = 0; j < chess[i].length; j++) {
//				System.out.print(chess[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(cs); // 경우의 수 출력

	}

	static void backTrack(int[][] chess, int x, int y) {
		if (chess[x][y] == 1) // 차 있으면 끝탬
			return;
		if (chess[x][y] == 0 && x == chess.length - 1) { // 안 차있고, 마지막 행이면 경우의 수 cs에 1 더하기
			cs += 1;
			return;
		}

		for (int i = 0; i < chess.length; i++) { // 해당 좌표에서 퀸이 갈수 있는 범위에 1 채우기
			chess[x][i] = 1;
			chess[i][y] = 1;

			if (x + i < chess.length && y + i < chess.length)
				chess[x + i][y + i] = 1;

			if (x + i < chess.length && y - i >= 0)
				chess[x + i][y - i] = 1;
		}

		int[][] chessBackUp = new int[chess.length - x][]; // 백업용 복사본 만들기	 행 아랫부분만 저장할 것
		for (int i = 0; i < chessBackUp.length; i++) {
			chessBackUp[i] = chess[i + x].clone();
		}

		for (int j = 0; j < chess.length; j++) {
			if (chess[x + 1][j] != 1) {
				backTrack(chess, x + 1, j); // 다음행으로 넘어가서 확인하기
				for (int i = 0; i < chessBackUp.length; i++) { // 다음행 가기 전으로 초기화 하기
					chess[i + x] = chessBackUp[i].clone();
				}
			}
		}
	}
}
