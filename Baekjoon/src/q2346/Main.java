package q2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		Integer balloon[] = new Integer[n];
		for (int i = 0; i < balloon.length; i++) { // 각 풍선에 숫자 넣어주기
			balloon[i] = Integer.parseInt(st.nextToken());
		}

		int seq[] = new int[n]; // 터지는 순서 배열
		int idx = 0; // 터지는 풍선 위치
		for (int k = 0; k < seq.length; k++) {
			int num = balloon[idx]; // 터진 풍선 안에 있는 숫자
			balloon[idx] = null; // 터지고 나면 null 값 넣어주기
			seq[k] = idx + 1; // 풍선 위치 + 1 값 넣어주기

			if (k == seq.length - 1) // seq의 배열의 마지막 값이면 나가기
				break;

			for (int i = 0; i < Math.abs(num);) { // 들어가 있는 숫자의 절대값만큼 반복문 반복
				idx = num > 0 ? idx + 1 : idx - 1; // 0보다 크면 1씩 더하고, 0보다 작으면 1씩 빼기
				if (idx < 0) // idx가 0보다 작아졌을 때 n더해주기
					idx = n + idx;
				idx %= n; // idx가 n보다 크면 나머지 넣어주기

				if (balloon[idx] != null) { // 해당 풍선이 null 이 아닌 경우에만
					i++; // 반복문 i 값 올려주기
				}
			}
		}

		StringBuffer sb = new StringBuffer(); // 출력
		for (int i = 0; i < seq.length; i++) {
			sb.append(seq[i]).append(' ');
		}

		System.out.print(sb);
	}

}
