package q2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] sudoku = new int[9][9];
		int[][] inSudoku = sudoku.clone();

		for (int i = 0; i < sudoku.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < sudoku[i].length; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
			inSudoku[i] = sudoku[i].clone();
		}

//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < sudoku.length; i++) {
//			for (int j = 0; j < sudoku[i].length; j++) {
//				sb.append(sudoku[i][j]).append(' ');
//			}
//			sb.append('\n');
//		}
//	
//		System.out.print(sb);

//		inSudoku[0][0] = 3;
//		System.out.println(inSudoku[0][0]);
//		System.out.println(sudoku[0][0]);

		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[i].length; j++) {
				if (inSudoku[i][j] == 0) {

					int n = isFill(inSudoku, i, j);
					if (n == -1) {
						backTrack(inSudoku, i, j);
					} else {
						inSudoku[i][j] = n;
					}
				}
			}

//			System.out.print(sb +"\n"  + i + "\n");
//			StringBuffer sb = new StringBuffer();
//			for (int k = 0; k < inSudoku.length; k++) {
//				for (int j = 0; j < inSudoku[k].length; j++) {
//					sb.append(inSudoku[k][j]).append(' ');
//				}
//				sb.append('\n');
//			}

		}
//		backTrack(inSudoku, x, y);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < inSudoku.length; i++) {
			for (int j = 0; j < inSudoku[i].length; j++) {
				sb.append(inSudoku[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);

	}

	private static int isFill(int[][] inSudoku, int x, int y) {
		int a;
		int sum = 0;

		boolean can = true;
		for (int i = 0; i < 9; i++) {
			if (i != y) {
				if (inSudoku[x][i] == 0)
					can = false;
				sum += inSudoku[x][i];
			}
		}

		if (can) {
			a = 45 - sum;
			return a;
		}

		can = true;
		for (int i = 0; i < 9; i++) {
			if (i != x) {
				if (inSudoku[i][y] == 0)
					can = false;
				sum += inSudoku[i][y];
			}
		}

		if (can) {
			a = 45 - sum;
			return a;
		}

		can = true;
		for (int i = 0; i < 9; i++) {
			if (i != x) {
				if (inSudoku[i][y] == 0)
					can = false;
			}
		}

		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				if (x != k && y != j) {
					if (0 == inSudoku[(x / 3) * 3 + j][(y / 3) * 3 + k]) {
						can = false;
					}
				}
			}
		}

		if (can) {
			a = 45 - sum;
			return a;
		}

		return -1;

	}

	static boolean backTrack(int[][] inSudoku, int x, int y) {

		boolean success = false;

		for (int i = 1; i <= 9; i++) {
			if (success)
				break;

			inSudoku[x][y] = i;

			boolean exist = false;

			// 가로줄
			for (int j = 0; j < 9; j++) {
				if (y != j) {
					if (inSudoku[x][y] == inSudoku[x][j]) {
						exist = true;
						break;
					} else if (inSudoku[x][j] == 0) {
						exist = !backTrack(inSudoku, x, j);

					}
				}
			}
			if (exist)
				continue;

			// 세로줄
			for (int j = 0; j < 9; j++) {
				if (x != j) {
					if (inSudoku[x][y] == inSudoku[j][y]) {
						exist = true;
						break;
					} else if (inSudoku[j][y] == 0) {
						exist = !backTrack(inSudoku, j, y);

					}
				}
			}
			if (exist)
				continue;

			// 9 정사각형
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (x != k && y != j) {
						if (inSudoku[x][y] == inSudoku[(x / 3) * 3 + j][(y / 3) * 3 + k]) {
							exist = true;
							break;
						} else if (inSudoku[(x / 3) * 3 + j][(y / 3) * 3 + k] == 0) {
							exist = !backTrack(inSudoku, (x / 3) * 3 + j, (y / 3) * 3 + k);

						}
					}
				}
			}
			if (exist)
				continue;

			success = true;
		}

		if (!success) {
			inSudoku[x][y] = 0;
		}

		return success;
	}

}
