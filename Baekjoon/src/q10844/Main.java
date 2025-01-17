package q10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		ArrayList<Integer>[] arr = new ArrayList[n];

		long count = 0;
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j < arr.length; j++) {
				ArrayList<Integer> arr2 = new ArrayList<Integer>();
				if (j == 0) {
					arr2.add(i);
					arr[j] = arr2;

				} else {
					for (int k = 0; k < arr[j - 1].size(); k++) {
						int f = arr[j - 1].get(k);
						if (f == 0) {
							arr2.add(f + 1);
						} else if (f == 9) {
							arr2.add(f - 1);
						} else {
							arr2.add(f + 1);
							arr2.add(f - 1);
						}
					}
					arr[j] = arr2;
				}

				if (j == arr.length - 1) {
//					System.out.println(i + " " + arr[arr.length - 1].size());
					count += arr[arr.length - 1].size();
					count = count % 1000000000;
				}
			}
		}

		System.out.println(count);
	}

}
