package q3009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] x = new int[2][2]; // x 좌표 종류 + x좌표 위치 , 개수(1~2)
		int[][] y = new int[2][2];

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int xv = Integer.parseInt(st.nextToken());
			int yv = Integer.parseInt(st.nextToken());

			if (i == 0) {
				x[0][0] = xv;
				x[0][1] += 1;
				y[0][0] = yv;
				y[0][1] += 1;
			} else {
				if (x[0][0] == xv) {
					x[0][1] += 1; // 하나 더 있으면 1 더해주기
				} else {
					x[1][0] = xv;
					x[1][1] += 1;
				}

				if (y[0][0] == yv) {
					y[0][1] += 1;
				} else {
					y[1][0] = yv;
					y[1][1] += 1;
				}
			}

		}
		br.close();

		int tmpX = x[0][1] == 1 ? x[0][0] : x[1][0]; // 개수가 하나 밖에 없으면 하나 더 필요함
		int tmpY = y[0][1] == 1 ? y[0][0] : y[1][0];

		System.out.print(tmpX + " " + tmpY);
	}

}
