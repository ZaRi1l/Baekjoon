package q5582;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String str1 = br.readLine();
		
		StringBuffer str1 = new StringBuffer(br.readLine());
		String str2 = br.readLine();
//		StringBuffer str2 = new StringBuffer(br.readLine());
		br.close();

//		StringBuffer sb = new StringBuffer("");
		int max = 0;

//		for (int i = 0; i < str1.length(); i++) {
//			for (int j = 0; j < str2.length(); j++) {
//				if (str1.charAt(i) == str2.charAt(j)) {
//					for (int k = 1;; k++) {
//						if (max < k) {
////							sb.delete(0, sb.length());
////							sb.append(str1.substring(i, i+k));
////							max = sb.length();
//							max = k;
//						}
//						
//						if (k + i == str1.length() || k + j == str2.length()) {
//							break;
//						}
//						if (max + i >= str1.length() || max + j >= str2.length()) {
//							break;
//						}
//						if (str1.charAt(i + k) != str2.charAt(j + k)) {
//							break;
//						}
//
//					}
//				}
//			}
//		}
	
		
		
		for (int i = 0; i < str1.length(); i++) {
			if(i + max >= str1.length()) break;
			for (int j = i + max; j < str1.length(); j++) {
				String subStr = str1.substring(i, j);
				if (str2.contains(subStr)) {
					max = max < subStr.length() ? subStr.length() : max;
				}
			}
		}
	
		
		System.out.print(max);
	}

}
