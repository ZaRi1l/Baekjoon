package q1931_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main { // 성공

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> mTime = new ArrayList<int[]>(); // linkedList로 정렬하면 시간초과 걸림

		for (int i = 0; i < n; i++) { // 회의 시간 넣기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			mTime.add(new int[] { s, f });
		}
		br.close();

		Collections.sort(mTime, new Comparator<int[]>() { // 회의 시간 정렬하기
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) { // 만약에 끝나는 시간이 같다면, 시작시간을 기준으로 오름차순 정렬
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1]; // 끝나는 시간 기준으로 정렬
			}
		});

//		for (int i = 0; i < mTime.size(); i++) {
//			int[] a = mTime.get(i);
//			System.out.println(a[0] + " " + a[1]);
//		}

		int count = 0; // 최종적인 최대 회의 개수
		int f1 = 0; // 앞에 회의 끝나는 시간

		for (int i = 0; i < n; i++) {
			int s2 = mTime.get(i)[0]; // 현재 회의 시작 시간
			int f2 = mTime.get(i)[1]; // 현재 회의 끝나는 시간

			if (s2 >= f1) { // 앞에 회의 시간과 곂치지 않는 다면
				count += 1;
				f1 = f2; // 현재 끝나는 시간을 앞에 끝나는 시간에 넣어줌
			}

		}

		System.out.print(count); // 출력
	}

}
