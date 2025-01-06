package q1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[][] homes = new int[n][3]; // 복사해서 정렬 써서 차이, 최소값구해보기
		int[][] sortHomes = new int[n][3];
		int[] pick = new int[n];
		int[] spick = new int[n];
		int sum = 0;
		
		


		for (int i = 0; i < homes.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < homes[i].length; j++) {
				homes[i][j] = Integer.parseInt(st.nextToken());
			}
			sortHomes[i] = homes[i].clone();
			Arrays.sort(sortHomes[i]);
		}
		bf.close();
		
		
		for (int i = 0; i < sortHomes.length; i++) {
			List<Integer> listHomes = Arrays.stream(homes[i]).boxed().collect(Collectors.toList());
			pick[i] = listHomes.indexOf(sortHomes[i][spick[i]]);
		}
		
		// 반복문으로 풀어보기
		for (int i = 0; i < homes.length; i++) {
			if (i != homes.length - 1 && pick[i] == pick[i+1]) {
				// 클때 작을때 해서
			} else if (i != 0 && pick[i] == pick[i-1]) {
				
			}
		}
		
		

//		print(homes);
//		print(sortHomes);
		
		
//		func(homes, sortHomes, pick, spick, 0);

		
		for (int i = 0; i < pick.length; i ++) {
//			System.out.println(pick[i]);
//			System.out.println(homes[i][pick[i]]);
			sum += homes[i][pick[i]];
		}
		
		System.out.println(sum);

	}
//
//	static void func(int[][] homes, int[][] sortHomes, int[] pick, int[] spick, int i) {
//	
//		List<Integer> listHomes = Arrays.stream(homes[i]).boxed().collect(Collectors.toList());
//		pick[i] = listHomes.indexOf(sortHomes[i][spick[i]]);
//		
//		if (i != 0 && pick[i] == pick[i-1]) {
//			if (spick[i] == 2) {
//				spick[i-1] = spick[i-1] == 2 ? spick[i-1] - 2 : spick[i-1] + 1;
//				func(homes, sortHomes, pick, spick, i - 1);
//			} else if (spick[i-1] == 2) {
//				spick[i] = spick[i] == 2 ? spick[i] - 2 : spick[i] + 1;
//				pick[i] = listHomes.indexOf(sortHomes[i][spick[i]]);
//			} else
//			if (sortHomes[i][spick[i] + 1] - sortHomes[i][spick[i]] < sortHomes[i - 1][spick[i-1] + 1] - sortHomes[i-1][spick[i-1]]) {
//				spick[i] = spick[i] == 2 ? spick[i] - 2 : spick[i] + 1;
//				pick[i] = listHomes.indexOf(sortHomes[i][spick[i]]);
//			} else {
//				spick[i-1] = spick[i-1] == 2 ? spick[i-1] - 2 : spick[i-1] + 1;
//				func(homes, sortHomes, pick, spick, i - 1);
//			}
//		}
//		
//		if (i == homes.length - 1) {
//			return;
//		}
//		func(homes, sortHomes, pick, spick, i + 1);
//		
//		// 같을때랑 안 같을때 뒤로 백하는 거 만들면 끝
//	}

	static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}

// 색깔이 위 아래와 안 겹칠때 최소값 구하면 됨
