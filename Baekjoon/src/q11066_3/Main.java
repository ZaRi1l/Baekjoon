package q11066_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int z = 0; z < t; z++) {

			int k = Integer.parseInt(br.readLine());
			ArrayList<Integer> c = new ArrayList<Integer>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++) {
				c.add(Integer.parseInt(st.nextToken()));
			}

			
			int sum = 0;
			while (c.size() != 1) {
				c.sort((o1, o2) -> o1 - o2);
				int first = c.get(0);
				c.remove(0);
				int twice = c.get(0);
				c.remove(0);
				
				sum += first + twice;
				c.add(first + twice);
				
//				System.out.println("남은 리스트: " + c.toString());
//				System.out.println(first + " + " + twice + " = " + (first + twice) + " : " + sum);
			}

			System.out.println(sum);

		}
		br.close();
	}

}
