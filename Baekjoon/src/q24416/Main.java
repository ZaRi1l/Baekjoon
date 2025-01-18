package q24416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnRe = 0;
	static int cnDy = 1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		fib(n);
		fib2(new int[n]);

		System.out.printf("%d %d", cnRe, cnDy);
	}

	static int fib(int n) {
		if (n == 1 || n == 2) {
			cnRe += 1;
			return 1; // 코드1
		} else
			return (fib(n - 1) + fib(n - 2));
	}

	static int fib2(int[] f) {
		f[1] = f[2] = 1;
		for (int i = 3; i < f.length; i++) {
			f[i] = f[i - 1] + f[i - 2]; // 코드2
			cnDy += 1;
		}

		return f[f.length - 1];
	}

}
