package q11066_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int z = 0; z < t; z++) {

			int k = Integer.parseInt(br.readLine());
			Integer[] c = new Integer[k];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < c.length; i++) {
				c[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(c);

			TreeSet<Integer> x = new TreeSet<Integer>();

			int sum = 0;
			sum = find(c, x, sum);
			
			while(true) {
				c = x.toArray(new Integer[0]);
				x = new TreeSet<Integer>();
				
				if (c.length == 1) {
					break;
				} else {
					sum = find(c, x, sum);
				}
			}

			
			System.out.println(sum);

		}
		br.close();
	}
	
	
	static int find(Integer[] c, TreeSet<Integer> x, int sum) {
		for (int i = 0; i < c.length; i++) {
			if (i == 0) {
				x.add(c[i] + c[i + 1]);
				sum += c[i] + c[i + 1];
				i += 1;
			} else if (i == c.length - 1) {
				int first = x.first();
				x.remove(first);
				x.add(c[i] + first);
				sum += c[i] + first;
			} else {
				if (x.first() + c[i] < c[i] + c[i + 1]) {
					int first = x.first();
					x.remove(first);
					x.add(c[i] + first);
					sum += c[i] + first;
				} else {
					x.add(c[i] + c[i + 1]);
					sum += c[i] + c[i + 1];
					i += 1;
				}
			}
			
			// 출력 해보기
			for (int j: x) {
				System.out.print(j + " ");
			}
			System.out.println(": " + sum);
		}
		
		return sum;
	}

}
