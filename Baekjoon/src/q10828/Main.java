package q10828;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			switch (sc.next()) {
			case "push":
				stack.push(sc.nextInt());
				break;
			case "pop":
				if (stack.empty())
					System.out.println(-1);
				else
					System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.empty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "top":
				if (stack.empty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
				break;
			}
		}

		sc.close();
	}
}
