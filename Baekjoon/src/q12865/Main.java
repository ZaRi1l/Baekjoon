package q12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 물품 수
		int k = Integer.parseInt(st.nextToken()); // 버틸수 있는 무게

		int[][] wv = new int[n][2]; // 물건 무게와 물건 가치

		for (int i = 0; i < wv.length; i++) {
			st = new StringTokenizer(br.readLine());
			wv[i][0] = Integer.parseInt(st.nextToken());
			wv[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(wv, (o1, o2) -> o1[0] - o2[0]); // 물건 무게순으로 정렬

		// 출력해보기
//		for (int i = 0; i < wv.length; i++) {
//			System.out.println(wv[i][0] + " " + wv[i][1]);
//		}

		// 무게 내에서 전에 가치와 합쳐서 얼마나 가치를 높일수 있는지 동적계획법으로
		HashMap<Integer, Integer> sumWv = new HashMap<Integer, Integer>();
		for (int i = 0; i < wv.length; i++) {
			int max = wv[i][1];
			sumWv.put(wv[i][0], wv[i][1]);
			for (int j = sumWv.size() - 1; j >= 0; j--) {
				if (wv[i][0] + wv[j][0] <= k) {
					max = max < sumWv.get(wv[i][0]) + sumWv.get(wv[j][0]) ? sumWv.get(wv[i][0]) + sumWv.get(wv[j][0])
							: max;

					if (sumWv.get(wv[i][0] + wv[j][0]) != null)
						sumWv.put(wv[i][0] + wv[j][0],
								sumWv.get(wv[i][0] + wv[j][0]) < max ? max : sumWv.get(wv[i][0] + wv[j][0]));
					else
						sumWv.put(wv[i][0] + wv[j][0], max);
				}
			}
		}

		// sumWv 출력해보기
		for (int i : sumWv.keySet()) {
			System.out.println(i + " " + sumWv.get(i));
		}

	}

}
