package q2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		TreeMap<Integer, Integer> arr = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Collection<Integer> values = arr.values();
		Iterator<Integer> it = values.iterator();
		int num[] = new int[values.size()];
		int count[] = new int[values.size()];
		int fcount = 0;
		for (int i = 0; i < values.size(); i++) {
			num[i] = it.next();

			if (i == 0) {
				count[i] = 1;
			} else {
				int max = 0;
				for (int j = i - 1; j >= 0; j--) {
					if (num[j] < num[i]) {
						if (max < count[j]) {
							max = count[j];
						}
					}
				}
				count[i] = max + 1;
			}
			if (fcount < count[i]) {
				fcount = count[i];
			}
		}

//		System.out.println(values);
//		for (int i = 0; i < count.length; i++) {
//			System.out.print(count[i] + " ");
//		}
//		System.out.println();

		System.out.print(n - fcount);

	}

}
