package q11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < p.length; i++) { // 각 사람의 인출 시간 넣기
			p[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(p); // 시간순으로 정렬하기

		int sum = 0;
		for (int i = 0; i < p.length; i++) {
			if (i == 0)
				sum = p[i];
			else {
				p[i] = p[i] + p[i - 1]; // 전에 시간과 현재 시간 합쳐서 넣어주기
				sum += p[i]; // 그다음 sum에 바로 넣기
			}
		}
		System.out.print(sum);
	}
}
