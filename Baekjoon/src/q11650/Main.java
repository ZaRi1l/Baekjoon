package q11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		HashMap<Integer, ArrayList<Integer>> coor = new HashMap<Integer, ArrayList<Integer>>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (coor.get(x) == null) {
				coor.put(x, new ArrayList<Integer>());
			}

			coor.get(x).add(y);
		}
		br.close();

		StringBuffer sb = new StringBuffer();

		ArrayList<Integer> coorKeys = new ArrayList<Integer>(coor.keySet());
		coorKeys.sort((o1, o2) -> o1 - o2);
		for (int i : coorKeys) {

			coor.get(i).sort((o1, o2) -> o1 - o2);

			for (int j = 0; j < coor.get(i).size(); j++) {
				sb.append(i).append(' ');
				sb.append(coor.get(i).get(j));
				sb.append('\n');
			}
		}

		System.out.print(sb);

	}

}
