package q9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int a, b, c; // 입력 값 3개
		W w = new W(); // 3개의 값을 키로한 값을 관리하는 클래스(구조체)

		// 모든 값 구하기
		for (int i = -50; i <= 20; i++) { // -50부터 20까지 확인하기
			for (int j = -50; j <= 20; j++) {
				for (int k = -50; k <= 20; k++) {
					if (w.isContain(i, j, k)) // 만약에 이미 키가 존재한다면 되돌아가기
						continue;

					if (i > 20 || j > 20 || k > 20) { // 만약 i,j,k가 20이 넘는다면 나중에 넣어줄 거임, 처음으로 가기
						continue;
					}

					if (i <= 0 || j <= 0 || k <= 0) { // 각 키에 맞는 조건들 대입하기
						w.setW(i, j, k, 1);
						continue;
					}

					if (i < j && j < k) {
						w.setW(i, j, k, w.getW(i, j, k - 1) + w.getW(i, j - 1, k - 1) - w.getW(i, j - 1, k));
						continue;
					}

					w.setW(i, j, k, w.getW(i - 1, j, k) + w.getW(i - 1, j - 1, k) + w.getW(i - 1, j, k - 1)
							- w.getW(i - 1, j - 1, k - 1));

				}
			}
		}

		while (true) {
			st = new StringTokenizer(br.readLine(), " "); // 입력값 3개씩 받기
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1) // 받은 값이 다 -1 이면 끝내기
				break;

			if (a <= 0 || b <= 0 || c <= 0) {			// 만약에 -10, 40, 50 인경우 우선순위가 0보다 작을때이기에 넣어줌
				w.setW(a, b, c, 1);
			} else if (a > 20 || b > 20 || c > 20) { // 만약 a,b,c가 20이 넘는다면 20이 키인값 넣어주기, 위에서 넘어간 거 지금 넣어줌
				w.setW(a, b, c, w.getW(20, 20, 20));
			}

			System.out.print((new StringBuffer()).append("w(").append(a).append(", ")
					.append(b).append(", ")
					.append(c).append(") = ")
					.append(w.getW(a, b, c)).append('\n'));
//			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w.getW(a, b, c)); // 출력
		}

		br.close();
	}

}

class W { // a, b, c를 키로 가지는 해쉬맵 다루는 클래스
	private HashMap<String, Integer> w;

	public W() {
		w = new HashMap<String, Integer>();
	}

	public Integer getW(int a, int b, int c) { // 키값 가져오기
		return w.get((new StringBuffer()).append(a).append(' ').append(b).append(' ').append(c).toString());
	}

	public void setW(int a, int b, int c, int n) { // 문자화 해서 키와 값 저장하기
		w.put((new StringBuffer()).append(a).append(' ').append(b).append(' ').append(c).toString(), n);
	}

	public boolean isContain(int a, int b, int c) { // 키가 존재하는 지 확인
		return w.containsKey((new StringBuffer()).append(a).append(' ').append(b).append(' ').append(c).toString());
	}

}
