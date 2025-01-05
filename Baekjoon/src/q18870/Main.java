package q18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 좌표 개수
		int[] x = new int[n]; // 좌표들(배열)
		int[] sortX; // 오름차순 정렬용 좌표 배열
		int last; // 마지막 값 넣어놓기

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < x.length; i++) { // 배열에 좌표 넣기
			x[i] = Integer.parseInt(input[i]);
		}
		br.close();

		
		sortX = x.clone(); // 좌표 복사
		sort(sortX); // 좌표 오름차순 정렬, 중복값을 제외하고 빈공간은 가장 큰값으로 채우기

//		for (int i = 0; i < sortX.length; i++) {
//			System.out.print(sortX[i] + " ");
//		}
//		System.out.println();

		last = sortX[sortX.length - 1]; // 정렬된 마지막 값 넣기, (중복이 되든 안되었든 가장 큰값이 맨 뒤에 있음)
		for (int i = 0; i < sortX.length; i++) {
			if (i > 0 && last == sortX[i - 1])
				break;

			for (int j = 0; j < x.length; j++) {
				if (sortX[i] == x[j]) {
					x[j] = i; // 값이 같다면 그 순서에 해당하는 인덱스 넣어주기
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < x.length; i++) { // 출력
			sb.append(x[i]).append(' ');
		}
		System.out.print(sb);

	}

	static void sort(int[] sortX) {
		int tmp; // 교환용 변수

		for (int i = 0; i < sortX.length; i++) {
			for (int j = i + 1; j < sortX.length; j++) {
				if (sortX[i] == sortX[j]) { // 만약 값이 중복이라면 한칸 앞에 값하고 같게 만듦
					sortX[j] = sortX[j - 1];
				}

				if (sortX[i] > sortX[j]) { // 그리고 값 비교, 뒤에 값이 더 작으면 바꿔줌
					tmp = sortX[i];
					sortX[i] = sortX[j];
					sortX[j] = tmp;
				}
			}
		}
	}
}
