package q18870_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 좌표 개수
		int[] x = new int[n]; // 좌표들(배열)
		int[] sortX; // 오름차순 정렬용 좌표 배열
		HashMap<Integer, Integer> resX = new HashMap<Integer, Integer>();

		String[] input = br.readLine().split(" ");
		br.close();
		
		for(int i = 0; i < x.length; i ++) {
			x[i] = Integer.parseInt(input[i]);
		}
//		x = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

		
		sortX = Arrays.stream(x).distinct().toArray();		// 중복 제거
		Arrays.sort(sortX);		// 오름차순 정렬
		
	
		for(int i = 0; i < sortX.length; i++) {
			resX.put(sortX[i], i);
		}
		
		
		StringBuffer sb = new StringBuffer();
        for(int value : x){
            sb.append(resX.get(value)).append(' ');
        }
 
        System.out.println(sb);
        
//		for (int i = 0; i < x.length; i++) { // 출력
//			System.out.printf("%d ", resX.get(x[i]));
//		}
		
	}

}
