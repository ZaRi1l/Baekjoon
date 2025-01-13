package q2580_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] sudoku = new int[9][9];
		LinkedList<int[]> emp = new LinkedList<int[]>();

		// 입력
		for (int i = 0; i < sudoku.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < sudoku[i].length; j++) {
				int n = Integer.parseInt(st.nextToken());
				sudoku[i][j] = n;

				if (n == 0) {
					emp.add(new int[] { i, j });
				}

			}
		}
		br.close();

		fill(sudoku, emp);

		// 출력
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[i].length; j++) {
				sb.append(sudoku[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);

	}

	private static void fill(int[][] sudoku, LinkedList<int[]> emp) {
		while (true) {
			for (int i = 0; i < emp.size(); i++) {
				for (int j = 1; j < sudoku.length + 1; j++) {
					if (sudoku[emp.get(i)[0]][emp.get(i)[1]] == 0) {
						if (can(sudoku, emp.get(i)[0], emp.get(i)[1], j)) {
							sudoku[emp.get(i)[0]][emp.get(i)[1]] = j;
						}
					}
				}
			}

			boolean out = true;
			for (int i = 0; i < emp.size(); i++) {
				if (sudoku[emp.get(i)[0]][emp.get(i)[1]] == 0) {
					out = false;
				}
			}

			if (out)
				return;
		}

	}

	static boolean can(int[][] sudoku, int x, int y, int n) {

		for (int i = 0; i < 9; i++) {
			if (n == sudoku[x][i] || n == sudoku[i][y])
				return false;
		}

		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				int tmp1 = (x / 3) * 3 + k;
				int tmp2 = (y / 3) * 3 + j;

				if (n == sudoku[tmp1][tmp2])
					return false;
			}
		}

		return true;
	}

}
