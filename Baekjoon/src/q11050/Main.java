package q11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int nums[] = new int[n];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				nums[i] = 1;
			else
				nums[i] = nums[i - 1] * (i + 1);
		}

		if (k != 0 && k != n)
			System.out.print(nums[n - 1] / (nums[n - k - 1] * nums[k - 1]));
		else
			System.out.print(1);
	}

}
