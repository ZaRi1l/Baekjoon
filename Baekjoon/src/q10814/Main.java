package q10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeMap<Integer, ArrayList<String>> tm = new TreeMap<Integer, ArrayList<String>>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			if (tm.get(age) == null) {
				tm.put(age, new ArrayList<String>());
			}

			tm.get(age).add(name);
		}
		br.close();

		StringBuffer sb = new StringBuffer();
		for (int i : tm.keySet()) {
			Iterator it = tm.get(i).iterator();

			while (it.hasNext()) {
				sb.append(i).append(' ').append(it.next()).append('\n');
			}
		}

		System.out.print(sb);
	}

}
