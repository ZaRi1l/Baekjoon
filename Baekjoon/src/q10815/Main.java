package q10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeSet<Integer> tr = new TreeSet<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tr.add(Integer.parseInt(st.nextToken()));
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		br.close();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < m; i++) {
			int mv = Integer.parseInt(st.nextToken());

			if (tr.contains(mv))
				sb.append(1).append(' ');
			else
				sb.append(0).append(' ');
		}

		System.out.print(sb);
	}

}
