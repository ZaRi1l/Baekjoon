package q2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public enum Direct {UP, DOWN, LEFT, RIGHT};
	public static int cnt = 0;
//	public static int [][] emp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int[][] cheezes = new int[x][y];
		int[][] before = cheezes.clone();
		int[][] after = cheezes.clone();
//		emp = new int[x][y];
		
		int hour = 0;

		for (int i = 0; i < cheezes.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cheezes[i].length; j++) {
				cheezes[i][j] = Integer.parseInt(st.nextToken());
			}
			before[i] = cheezes[i].clone();
			after[i] = cheezes[i].clone();
		}
		br.close();
		
//		Scanner sc = new Scanner(System.in);
//		int x = sc.nextint();
//		int y = sc.nextint();
//		int[][] cheezes = new int[x][y];
//		int[][] after = cheezes.clone();
//		//emp = new int[x][y];
//		
//		int hour = 0;
//
//		for (int i = 0; i < cheezes.length; i++) {
//			for (int j = 0; j < cheezes[i].length; j++) {
//				cheezes[i][j] = sc.nextint();
//			}
//			after[i] = cheezes[i].clone();
//		}
//		sc.close();
		

	
		while (true) {
			
			int cheeze = 0;
			for (int i = 1; i < cheezes.length - 1; i++) {
				for (int j = 1; j < cheezes[i].length - 1; j++) {
					if (cheezes[i][j] == 1) {
						cheeze += 1;
						
						int empty = 0;
						if (cheezes[i+1][j] == 0) {
							if (before[i+1][j] == 1) {
								empty = empty + 1;
							} else if (isEmpty(cheezes, i+1, j, Direct.DOWN)) {
								empty = empty + 1;
//								emp[i+1][j] = 1;
							}
						}
						if (cheezes[i-1][j] == 0) {
							if (before[i-1][j] == 1) {
								empty = empty + 1;
							} else if (isEmpty(cheezes, i-1, j, Direct.UP)) {
								empty = empty + 1;
//								emp[i-1][j] = 1;
							}
						} 
						if (cheezes[i][j+1] == 0) {
							if (before[i][j + 1] == 1) {
								empty = empty + 1;
							} else if (isEmpty(cheezes, i, j+1, Direct.RIGHT)) {
								empty = empty + 1;
//								emp[i][j + 1] = 1;
							}
						} 
						if (cheezes[i][j-1] == 0) {
							if (before[i][j-1] == 1) {
								empty = empty + 1;
							} else if (isEmpty(cheezes, i, j-1, Direct.LEFT)) {
								empty = empty + 1;
//								emp[i][j - 1] = 1;
							}
						}
						
						if (empty >= 2) {
							after[i][j] = 0;
						}
					}
				}
			}
			
			before = cheezes.clone();
			for (int i = 0; i < after.length; i++) {
				before[i] = cheezes[i].clone();
			}
			
			cheezes = after.clone();
			for (int i = 0; i < after.length; i++) {
				cheezes[i] = after[i].clone();
			}
			
			if (cheeze == 0) break;
			hour += 1;
		}
		
		System.out.println(hour);
//		System.out.println(cnt);
		
		
//		Runtime.getRuntime().gc();
//		long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//		System.out.print(usedMemory + " bytes");

	}

	static boolean isEmpty(int[][] cheezes, int x, int y, Direct d) {
		if (x == 0 || x == cheezes.length - 1 || y == 0 || y == cheezes[0].length - 1) {
//			cnt = cnt + 1;
			return true;
		}

		boolean empty = false;
		boolean e;
		if (cheezes[x + 1][y] == 0 && d != Direct.UP && empty == false) {
			e = isEmpty(cheezes, x + 1, y, Direct.DOWN);
			empty = empty || e;
//			emp[x+1][y] = e ?(int) 1 : 0;
		} else if (cheezes[x - 1][y] == 0 && d != Direct.DOWN) {
			e = isEmpty(cheezes,x - 1, y, Direct.UP);
			empty = empty || e;
//			emp[x+1][y] = e ?(int) 1 : 0;
		} else if (cheezes[x][y + 1] == 0 && d != Direct.LEFT) {
			e = isEmpty(cheezes, x, y + 1, Direct.RIGHT);
			empty = empty || e;
//			emp[x+1][y] = e ?(int) 1 : 0;
		} else if (cheezes[x][y - 1] == 0 && d != Direct.RIGHT) {
			e = isEmpty(cheezes, x, y - 1, Direct.LEFT);
			empty = empty || e;
//			emp[x+1][y] = e ?(int) 1 : 0;
		}

		return empty;
	}
}
