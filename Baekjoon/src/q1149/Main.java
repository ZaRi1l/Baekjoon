package q1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[][] homes = new int[n+1][3]; // 복사해서 정렬 써서 차이, 최소값구해보기
		


		for (int i = 1; i < homes.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < homes[i].length; j++) {
				homes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bf.close();
		
//		print(homes);
		
		// 반복문으로 풀어보기
		for (int i = 1; i < homes.length; i++) {
			homes[i][0] = Math.min(homes[i-1][1], homes[i-1][2]) + homes[i][0];
			homes[i][1] = Math.min(homes[i-1][0], homes[i-1][2]) + homes[i][1];
			homes[i][2] = Math.min(homes[i-1][0], homes[i-1][1]) + homes[i][2];
		}

		System.out.print(Arrays.stream(homes[n]).min().getAsInt());
		
	}

	static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}

