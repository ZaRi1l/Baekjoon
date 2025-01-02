package q10828;

import java.util.Scanner;

public class Main {
	static int[] stack = new int[10000];
	static int sp = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			switch (sc.next()) {
			case "push":
				push(sc.nextInt());
				break;
			case "pop":
				System.out.println(pop());
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "top":
				System.out.println(top());
				break;
			}
		}
		
		sc.close();
	}
	
	static void push(int a) {
		stack[sp] = a;
		sp++;
	}
	
	static int pop() {
		if (empty() == 1) return -1;
		else return stack[--sp];
	}
	
	static int size() {
		return sp;
	}
	
	static int empty() {
		if (sp == 0) return 1;
		else return 0;
	}
	
	static int top() {
		if (empty() == 1) return -1;
		else return stack[(sp-1)];
	}

}
