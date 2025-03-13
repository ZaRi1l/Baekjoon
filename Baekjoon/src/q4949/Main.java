package q4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();

			if (str.length() == 1 && str.charAt(0) == '.') // 길이가 1인데 .이면 무한 반복 종료
				break;

			boolean balance = true;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				switch (c) {
				case '(': // ( , [ 는 스택에 넣기
				case '[':
					Stack.push(c);
					break;
				case ')':
					if (Stack.pop() != '(') // ) 일때 스택에서 pop해서 나온 문자가 (가 아니면 균형x
						balance = false;
					break;
				case ']':
					if (Stack.pop() != '[') // ] 일때 스택에서 pop해서 나온 문자가 [가 아니면 균형x
						balance = false;
					break;
				}
			}

			if (!Stack.isEmpty()) // 끝나고 나서 Stack이 안 비어져 있으면 균형x
				balance = false;

			System.out.println(balance ? "yes" : "no");

			Stack.clear(); // 스택 초기화
		}
		br.close();

	}

}

class Stack { // 스택 정의 하기
	static char[] p = new char[101];
	static int idx = 0;

	static boolean isEmpty() { // idx 가 0이면 비어있는 것.
		if (idx == 0) {
			return true;
		} else
			return false;
	}

	static void push(char c) { // push하면 인덱스 idx에 값 넣고 idx를 1 올려주기
		p[idx] = c;
		idx++;
	}

	static char pop() { // pop하면 idx에 1빼고 값 리턴하기
		if (!isEmpty()) {
			idx--;
			return p[idx];
		} else
			return ' ';
	}

	static void clear() { // idx를 0으로 바꾸기
		idx = 0;
	}
}
