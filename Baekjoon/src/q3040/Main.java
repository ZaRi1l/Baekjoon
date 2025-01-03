package q3040;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9]; 	// 가짜 아홉난쟁이
		int[] trueArr = new int[7];	// 진짜 일곱난쟁이
		int trueArrSum = 0;			// 총합
		
		for (int i = 0; i < arr.length ; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		for (int i = 0; i < arr.length ; i++) {
			for (int j = i + 1; j < arr.length ; j++) {
				int trueArrIndex = 0;	// 진짜 일곱난쟁이 넣는 순서
				for (int k = 0; k < arr.length; k++) {
					if (arr[k] != arr[i] && arr[k] != arr[j]) {	// 두명 i랑 j에 있는 친구들을 제외하고 trueArr에 넣음
						trueArr[trueArrIndex] = arr[k];
						trueArrIndex++;
					}
				}
				trueArrSum = Arrays.stream(trueArr).sum();	// trueArr(일곱난쟁이)의 모자 숫자 총합을 구함
				if (100 == trueArrSum ) break;				// 총합이 100이면 반복을 끝냄
			}
			if (100 == trueArrSum ) break;
		}
		
		for (int i = 0; i < trueArr.length ; i++) {		// trueArr 일곱난쟁이 출력
			System.out.println(trueArr[i]);
		}		
	}
}
