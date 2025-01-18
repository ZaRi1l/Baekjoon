package q1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<int[]> mTime = new LinkedList<int[]>(); // 리스트로 각각의 회의 시간 받기

		for (int i = 0; i < n; i++) { // 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			mTime.add(new int[] { s, f });
		}
		br.close();

//		for (int i = 0; i < mTime.size(); i++) {		// 출력해보기
//			System.out.println(mTime.get(i)[0] + " " + mTime.get(i)[1]);
//		}

		int[] count = new int[mTime.size()]; // 각 단계별 최대 회의 개수
		int maxCount = 0; // 최종적인 최대 회의 개수
		for (int i = 0; i < mTime.size(); i++) {
			int upCount = 0; // 더할 최대 회의 개수
			
			for (int j = 0; j < i; j++) {
				if (mTime.get(i)[0] >= mTime.get(j)[1]) { // 앞에 회의 시간과 곂치지 않는 다면
					if (upCount < count[j]) { // 최대 회의 개수를 비교하여
						upCount = count[j]; // 더할 최대 회의 개수를 구한다.
					}
				}
			}
			count[i] = upCount + 1; // 1 더해서 해당 단계의 최대 회의 개수 넣어주기

			if (maxCount < count[i]) { // 최종적인 최대 회의 개수보다 큰지 비교하고 넣어주기
				maxCount = count[i];
			}

		}

		System.out.print(maxCount); // 출력

	}

}
