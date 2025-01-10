package q9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cs = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		int[][] chess = new int[n][n];
		int[][] chessBackUp = new int[n][n];

		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[i].length; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < chess.length; i++) {
			backTrack(chess, 0, i);
			chess = new int[n][n];
		}

		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[i].length; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(cs);

	}

	static boolean backTrack(int[][] chess, int x, int y) {
		if (chess[x][y] == 1)
			return false;
		if (chess[x][y] == 0 && x == chess.length - 1) {
			cs += 1;
			return true;
		}

		int[][] chessBackUp = chess.clone();
		for (int i = 0; i < chess.length; i++) {
			chessBackUp[i] = chess[i].clone();
		}

		for (int i = 0; i < chess.length; i++) {
			chess[x][i] = 1;
			chess[i][y] = 1;

			if (x + i < chess.length && y + i < chess.length)
				chess[x + i][y + i] = 1;

//			if (x - i >= 0 && y - i >= 0)
//				chess[x - i][y - i] = 1;

			if (x + i < chess.length && y - i >= 0)
				chess[x + i][y - i] = 1;

//			if (x - i >= 0 && y + i < chess.length)
//				chess[x - i][y + i] = 1;
		}

		boolean success = false;
		for (int j = 0; j < chess.length; j++) {
			if (chess[x + 1][j] != 1) {
				if (backTrack(chess, x + 1, j)) {
					success = true;
				} else {
					for (int i = 0; i < chess.length; i++) {
						chess[i] = chessBackUp[i].clone();
					}
				}
			}
		}

		return success;
	}

}
