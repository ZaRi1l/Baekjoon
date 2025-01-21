package q1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k];
		
		for(int i = 0 ; i < arr.length; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int sum = 0;
		for(int i = 0 ; i < arr.length; i++) {
			System.out.println(arr[i]);
			sum += arr[i];
		}
		System.out.println(sum);
		
//		int max = arr[arr.length - 1];
//		while(true) {
//			
//		}
	
	}

}
