package q15922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] lines = new int[n][2];
		int length = 0;
		int max;
		
		
		for (int i = 0; i < lines.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lines[i][0] = Integer.parseInt(st.nextToken());
			lines[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		
		max = lines[0][1];
//		for (int i = 0; i < lines.length; i++) {
//			length += lines[i][1] - lines[i][0];
//			
//			if (i != 0) {
//				if ((lines[i][0] < max) && (lines[i][1] > max)) {
//					length = length - (max - lines[i][0]);
//					max = lines[i][1];
//				} else if ((lines[i][0] <= max) && (lines[i][1] <= max)) {
//					length = length - (lines[i][1] - lines[i][0]);
//				}
//			}
//		}
		
		for (int i = 0; i < lines.length; i++) {
			if (i == 0 || lines[i][0] >= max) {
				length += lines[i][1] - lines[i][0];
				max = lines[i][1];
			} else if (lines[i][0] < max) {
				if (lines[i][1] > max) {
					length += lines[i][1] - max;
					max = lines[i][1];
				}
			}
		}
		
		System.out.println(length);
		
	}

}
