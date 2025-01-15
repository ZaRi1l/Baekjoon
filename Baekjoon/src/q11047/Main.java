package q11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];
		for (int i = 0; i < coin.length; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		br.close();

		int count = 0;
		int remain = k;
		for (int i = coin.length - 1; i >= 0; i--) { // 큰 값부터 넣기
			if (remain / coin[i] == 0) // 안 나눠지면 다시 처음으로
				continue;
			count += remain / coin[i]; // 코인 개수
			remain = remain % coin[i]; // 남은 원

			if (remain == 0)
				break;
		}

		System.out.print(count);
	}

}
