package q9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cs = 0; // 경우의 수 더하기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		int[] qPos = new int[n]; // 각 행별 퀸 위치

		backTrack(qPos, 0);

		System.out.println(cs); // 경우의 수 출력

	}

	static void backTrack(int[] qPos, int idx) {

		for (int i = 0; i < qPos.length; i++) { // emp가 비어있을때만 그 행의 위치 넣고, 재귀함수 호출
			if (isEmpty(qPos, idx, i)) { // 현재 행에서 비어 있는지 확인
				if (idx == qPos.length - 1) {
					cs += 1;
				} else {
					qPos[idx] = i;
					backTrack(qPos, idx + 1);
				}
			}
		}

	}

	static boolean isEmpty(int[] qPos, int idx, int n) { // 원래는 배열로 했었는데, 배열을 새로 정의 할 경우 메모리 초과 걸림.

		for (int i = 0; i < idx; i++) { // idx 행에서 열 n 위치에 넣었을때 공격범위에 있는지 확인
			if (qPos[i] == n)
				return false;

			if (qPos[i] + (idx - i) == n || qPos[i] - (idx - i) == n) // 퀸의 대각선 에 false 넣기
				return false;
		}

		return true;
	}
}
