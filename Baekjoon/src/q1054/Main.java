package q1054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] p = new String[n];
		
		for (int i = 0; i < p.length; i++) {
			p[i] = br.readLine();
		}
		br.close();
		
		
	}

}
