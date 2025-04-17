package q2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = 0, y = 0;
		int max = 0;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num > max) {
					max = num;
					x = i;
					y = j;
				}
			}
		}
		br.close();

		StringBuilder sb = new StringBuilder();
		sb.append(max).append('\n');
		sb.append(x + 1).append(' ').append(y + 1);

		System.out.println(sb);
	}

}
