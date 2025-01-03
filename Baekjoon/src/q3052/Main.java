package q3052;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[10];
		Arrays.fill(nums, -1);
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			int n = sc.nextInt() % 42;
			if (!contain(nums, n)) {
				nums[i] = n;
				count++;
			}
		}

		System.out.print(count);

	}
	
	static boolean contain(int[] nums, int n) {
		
		for (int i : nums) {
			if (i == n) return true;
		}
		
		return false;
	}
	
}
