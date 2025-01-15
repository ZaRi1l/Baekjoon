package q1931_2.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<int[]> counts = new LinkedList<int[]>();

		int maxCount = 1; // 최종적인 최대 회의 개수
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());

//			if (i == 0) {
//				counts.add(new int[] { s, f, 1 });
//			}

			int idx = 0;
			int count = 0;
			boolean exist = false;
			for (int j = 0; j < counts.size(); j++) {
				if (s >= counts.get(j)[1]) { // 앞에 회의 시간과 곂치지 않는 다면
					if (count < counts.get(j)[2]) {
						exist = true;
						count = counts.get(j)[2] + 1;
						idx = j;
					}
				}
			}
			if (exist) {
				counts.get(idx)[1] = f;
				counts.get(idx)[2] = count;

				if (count > maxCount) {
					maxCount = count;
				}
			} else {
				counts.add(new int[] { s, f, 1 });
			}

		}
		System.out.print(maxCount); // 출력
	}
}
