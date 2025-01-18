package q1931_2.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		int maxCount = 0; // 최종적인 최대 회의 개수
		int f1 = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s2 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());

			if (s2 >= f1) { // 앞에 회의 시간과 곂치지 않는 다면
				maxCount += 1;
				f1 = f2;
			}

		}
		System.out.print(maxCount); // 출력
	}

}
