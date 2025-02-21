package q12865_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 물품 수
		int k = Integer.parseInt(st.nextToken()); // 버틸수 있는 무게

		TreeMap<Integer, Integer> sumWv = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (sumWv.get(w) == null)
				sumWv.put(w, v);
			else {
				sumWv.put(w * 2, v + sumWv.get(w));
				sumWv.put(w, Math.max(v, sumWv.get(w)));
			}
		}

		int max = 0;
		while (true) {
			Integer[] keys = sumWv.keySet().toArray(new Integer[0]);

			boolean upperK = false;
			int i = 1;
			for (; i < keys.length; i++) {

				for (int j = 0; j < i; j++) {
					if (keys[i] + keys[j] > k) {
						upperK = true;
						break;
					}

					if (sumWv.get(keys[i] + keys[j]) == null)
						sumWv.put(keys[i] + keys[j], sumWv.get(keys[i]) + sumWv.get(keys[j]));
					else {
						sumWv.put(keys[i] + keys[j],
								Math.max(sumWv.get(keys[i]) + sumWv.get(keys[j]), sumWv.get(keys[i] + keys[j])));
					}
					max = Math.max(sumWv.get(keys[i] + keys[j]), max);
				}
				if (upperK)
					break;
			}
			if (upperK)
				break;
		}

		// sumWv 출력해보기
		for (int i : sumWv.keySet()) {
			System.out.println(i + " " + sumWv.get(i));
		}
		System.out.print(max);

	}

}
