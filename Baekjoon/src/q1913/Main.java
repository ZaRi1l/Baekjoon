package q1913;

import java.util.Scanner;

public class Main {
	static int popNum = 0;
	static int[] nums;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sec = sc.nextInt();
		int num = sc.nextInt();
		
		int x = sec/2;
		int y = sec/2;
		int op = 0;
		
		int resX = 0, resY = 0;
		
		int[][] table = new int[sec][sec];
		nums = new int[sec*sec];
		
		for(int i = 1; i <= nums.length; i++) {
			nums[i-1] = i;
		}
		
		
		table[x][y] = numsPop();
		
		for(int i = 0; i < table.length; i++) {
			
			
			for (int j = 0; j <= i; j++) {
				if (op == 0) {
					x -= 1;
					table[x][y] = numsPop();
					
					if(x == 0 && y == 0) {
						break;
					}
				} else {
					x += 1;
					table[x][y] = numsPop();
				}
			}
			
			if(x == 0 && y == 0) {
				break;
			}
			
			for (int j = 0; j <= i; j++) {
				if (op == 0) {
					y += 1;
					table[x][y] = numsPop();
				} else {
					y -= 1;
					table[x][y] = numsPop();
				}
			}
			
			if (op == 0) {
				op = -1; 
			} else {
				op = 0;
			}
			
		}
		
		
		
		
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table.length; j++) {
				System.out.print(table[i][j] + " ");
				
				if (table[i][j] == num) {
					resX = i + 1;
					resY = j + 1;
				}
			}
			System.out.println();
		}
		
		System.out.print(resX + " " + resY);
		
		
	}
	
	static int numsPop() {
		return nums[popNum++];
	}
	
	

}
