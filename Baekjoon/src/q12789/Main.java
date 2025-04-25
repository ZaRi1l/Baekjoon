package q12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> s = new Stack<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int seq = 1;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (seq == num) {
				seq++;
				continue;
			}
			while (!s.empty() && s.peek() == seq) {
				seq++;
				s.pop();
			}

			s.push(num);
		}

		String feel = "Nice";
		for (int i = 0; i < s.size(); i++) {
			if (seq == s.pop())
				seq++;
			else {
				feel = "Sad";
				break;
			}
		}

		System.out.print(feel);
	}

}
