package q10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<String> queue = new LinkedList<String>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "push":
				queue.add(st.nextToken());
				break;
			case "pop":
				if (queue.isEmpty())
					System.out.println(-1);
				else
					System.out.println(queue.poll());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println(queue.isEmpty() ? 1 : 0);
				break;
			case "front":
				if (queue.isEmpty())
					System.out.println(-1);
				else
					System.out.println(queue.peek());
				break;
			case "back":
				if (queue.isEmpty())
					System.out.println(-1);
				else
					System.out.println(((LinkedList<String>) queue).getLast());
				break;
			}
		}
	}
}
