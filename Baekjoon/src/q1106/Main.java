package q1106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] expense = new int[n];
		int[] client = new int[n];
//		int[] left = new int[n];
//		int[] charge = new int[n];
		
		double[] ratio = new double[n];
		
		for (int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			expense[i] = Integer.parseInt(st.nextToken());
			client[i] = Integer.parseInt(st.nextToken());
			ratio[i] = (double) client[i] / expense[i];
		}
		
		for (int i = 0; i < n ; i++) {
			System.out.println(expense[i] + " " + client[i] + " " + ratio[i]);
		}
		
		// 큰순으로 많이 나누기 그다음 한칸 남겨서 돌려보기		
	}
}



