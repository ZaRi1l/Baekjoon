package q12865_2;

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
			sumWv.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Integer[] keys = sumWv.keySet().toArray(new Integer[0]);

		for (int i = 0; i < keys.length; i++) {
			int max = sumWv.get(keys[i]);
			for (int j = i - 1; j >= 0; j--) {
				if (keys[i] + keys[j] <= k) {
					max = max < sumWv.get(keys[i]) + sumWv.get(keys[j]) ? sumWv.get(keys[i]) + sumWv.get(keys[j]) : max;

					if (sumWv.get(keys[i] + keys[j]) != null) {
						if ((keys[i] + keys[j]) * 2 <= k)
							sumWv.put((keys[i] + keys[j]) * 2, sumWv.get(keys[i] + keys[j]) + max);

						max = sumWv.get(keys[i] + keys[j]) < max ? max : sumWv.get(keys[i] + keys[j]);
						sumWv.put(keys[i] + keys[j], max);
					}

					else {
						sumWv.put(keys[i] + keys[j], max);
					}
					
					max = sumWv.get(keys[i] + keys[j]) < max ? max : sumWv.get(keys[i] + keys[j]);
					System.out.println(keys[i] + " " + sumWv.get(keys[i]) + " : "+ keys[j] + " " + sumWv.get(keys[j]) + " : " + (keys[i] + keys[j]) + " " + max);
				}
				
			}
			
		}

		// sumWv 출력해보기
		for (int i : sumWv.keySet()) {
			System.out.println(i + " " + sumWv.get(i));
		}

	}

}
