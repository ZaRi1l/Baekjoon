package q2580_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] sudoku = new int[9][9];
		ArrayList<int[]> emp = new ArrayList<int[]>();

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

//		// 시작 시간----------------------------------------
//		long timeStart = System.nanoTime() / 1000000;

//		for (int i = 0; i < emp.size(); i++) {
//			int[] e = emp.get(i);
//			System.out.println(e[0] + " " + e[1]);
//		}

		boolean isFill = false;

		while (!isFill) {
			isFill = true;

			for (int i = 0; i < emp.size(); i++) {
				int[] e = emp.get(i);
				if (sudoku[e[0]][e[1]] == 0) {
					int n = fill(sudoku, e[0], e[1]);
					sudoku[e[0]][e[1]] = n;
					if (n == 0)
						isFill = false;
				}

			}
		}

//		Iterator<Integer> iter = empty.keySet().iterator();
//		while(iter.hasNext()) {
//			Integer key = iter.next();
//		    System.out.print(key + ", " + empty.get(key).toString() + "\n");
//		}

		// 출력
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[i].length; j++) {
				sb.append(sudoku[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);

//		// 종료 시간 ----------------------------------------
//		long timeEnd = System.nanoTime() / 1000000;
//		System.out.println("ArrayList 걸린 시간 : " + (timeEnd - timeStart) + "ms");

	}

	private static int fill(int[][] sudoku, int x, int y) {
		int a = 0;
		int sum = 0;

		boolean can = true;
		for (int i = 0; i < 9; i++) {
			if (i != y) {
				if (sudoku[x][i] == 0)
					can = false;
				sum += sudoku[x][i];
			}
		}

		if (can) {
			a = 45 - sum;
			return a;
		}

		can = true;
		sum = 0;
		for (int i = 0; i < 9; i++) {
			if (i != x) {
				if (sudoku[i][y] == 0)
					can = false;
				sum += sudoku[i][y];
			}
		}

		if (can) {
			a = 45 - sum;
			return a;
		}

		can = true;
		sum = 0;
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				int tmp1 = (x / 3) * 3 + k;
				int tmp2 = (y / 3) * 3 + j;

				if (!(x == tmp1 && y == tmp2)) {
					if (0 == sudoku[tmp1][tmp2]) {
						can = false;
					}
					sum += sudoku[tmp1][tmp2];
				}
			}
		}

		if (can) {
			a = 45 - sum;
			return a;
		}

		return 0;

	}

}
