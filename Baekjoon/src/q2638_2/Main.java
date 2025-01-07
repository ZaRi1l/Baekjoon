package q2638_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] step;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());		// x
		int y = Integer.parseInt(st.nextToken());		// y
		int[][] cheezes = new int[x][y];				// 치즈 위치
		int[][] wall = new int[x][y];					// 공기 접촉 벽
		step = new int[x][y];							// 지나온 공간
		int hour = 1;									// 시간

		for (int i = 0; i < cheezes.length; i++) {		// 치즈 위치 값 받아오기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cheezes[i].length; j++) {
				cheezes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		

		
		while (true) {
			
			func(cheezes, wall, step, 0, 0);		// 재귀함수 (치츠 위치, 공기 닿는 벽 개수, 지나온 발자국
													// x, y 현재 위치)
			
			
			int sum = 0;
			for (int k = 0; k < wall.length; k++) {
				for (int j = 0; j < wall[k].length; j++) {
					if (cheezes[k][j] == 1 && wall[k][j] > 1) {		// 벽이 존재하며, 벽이 공기랑 접촉한 면적이 2이상이면 0대입
						cheezes[k][j] = 0;
					}
					sum += cheezes[k][j];
				}
			}
			
//			System.out.println("cheezes");
//			System.out.println(sum);
//			for (int i = 0; i < cheezes.length; i++) {
//				for (int j = 0; j < cheezes[i].length; j++) {
//					System.out.print(cheezes[i][j] + " ");
//				}
//				System.out.println();
//			}
			

			
			if(sum == 0) break;				//치즈의 개수를 다 더해서 0이면 프로그램 끝냄
			hour += 1;						// 시간 1더하기

			// 지나갔던 곳 초기화
			for (int j = 0; j < step.length; j++) {			// 지나온 걸음 step 와 공기와 닿는 벽 개수 0으로 초기화
				Arrays.fill(step[j], 0);
				Arrays.fill(wall[j], 0);
			}
		}
		
		System.out.print(hour);

	}

	static void func(int[][] cheezes, int[][] wall, int[][] step, int x, int y) {
		step[x][y] = 1;				// 지나온 발자국 표시

		
		if (x != cheezes.length - 1) {			// x가 끝값보다 작을때
			
			if (cheezes[x + 1][y] == 0) {			// 아무것도 없고, 지나온 길이 아니면 
				if (step[x + 1][y] == 0) {
					func(cheezes, wall, step, x + 1, y);		// 그 좌표로 재귀함수 호출
				}
			} 
			if (cheezes[x + 1][y] == 1) {			// 만약 벽이 존재한다면 해당 좌표에 있는 벽에 +1
				wall[x + 1][y] += 1;
			}
		}

		if (x != 0) {
			if (cheezes[x - 1][y] == 0) {
				if (step[x - 1][y] == 0) {
					func(cheezes, wall, step, x - 1, y);
				}
			} 
			if (cheezes[x - 1][y] == 1) {
				wall[x - 1][y] += 1;
			}
		}

		if (y != cheezes[0].length - 1) {
			if (cheezes[x][y + 1] == 0) {
				if (step[x][y + 1] == 0) {
					func(cheezes, wall, step, x, y + 1);
				}
			} 
			if (cheezes[x][y + 1] == 1) {
				wall[x][y + 1] += 1;
			}
		}

		if (y != 0) {
			if (cheezes[x][y - 1] == 0) {
				if (step[x][y - 1] == 0) {
					func(cheezes, wall, step, x, y - 1);
				}
			} 
			if (cheezes[x][y - 1] == 1) {
				wall[x][y - 1] += 1;
			}
		}

	}

}
