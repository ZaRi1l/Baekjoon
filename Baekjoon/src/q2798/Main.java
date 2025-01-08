package q2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] card = new int[n];
		int[] select = new int[3];
		
		st = new StringTokenizer(br.readLine());
		br.close();
		
		for (int i = 0 ; i < card.length; i ++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		
		int idx = 0;
		for (int i = card.length - 1; i >= 0; i--) {
			int diff = m - card[i];
			
			if (idx == 0 && diff < (card[0] + card[1])) {
				continue;
			}
			
			if (idx == 1 && diff < card[0]) {
				continue;
			}
			
			if (idx == 2 && diff < 0) {
				continue;
			}
			

			m = diff;
			select[idx] = card[i];
			idx++;
			if (idx == 3) break;
		}
		
		System.out.println(Arrays.stream(select).sum());	
	}

}
