package q13015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		int height = 2 * n - 1;
		int emp = n - 2;
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < height; i++) {
			if (i == 0 || i == height - 1) {
				for (int j =0; j < n; j++) {
					sb.append('*');
				}
				
				int emp2 = i == 0 ? (height/2 - i) * 2 - 1 : (i - height/2) * 2 - 1;
				for (int j =0; j < emp2; j++) {
					sb.append(' ');
				}
				
				for (int j =0; j < n; j++) {
					sb.append('*');
				}
				sb.append("\n");
			} else if ( i == height/2 ) {
				for (int j =0; j < n-1; j++) {
					sb.append(' ');
				}
				
				sb.append('*');
				for (int j =0; j < emp; j++) {
					sb.append(' ');
				}
				sb.append('*');
				for (int j =0; j < emp; j++) {
					sb.append(' ');
				}
				sb.append('*');
				sb.append("\n");
			} else {
				int tab = i <= height/2 ? i : height - i - 1;
				for (int j =0; j < tab; j++) {
					sb.append(' ');
				}
				
				sb.append('*');
				for (int j =0; j < emp; j++) {
					sb.append(' ');
				}
				sb.append('*');
				
				int emp2 = i <= height/2 ? (height/2 - i) * 2 - 1 : (i - height/2) * 2 - 1;
				for (int j =0; j < emp2; j++) {
					sb.append(' ');
				}
				
				sb.append('*');
				for (int j =0; j < emp; j++) {
					sb.append(' ');
				}
				sb.append('*');
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
