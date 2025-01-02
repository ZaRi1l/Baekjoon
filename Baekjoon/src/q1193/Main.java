package q1193;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sel = sc.nextInt();
		int curr = 1;
		int x = 0, y = 0, tmp;
		sc.close();
		
		for (int i = 1; i <sel + 1; i++) {
			for (int j = 1; j <= i; j++) {
				if (curr == sel) {
					x = j;
					y = (i+1)-j;
					
					if ((i+1) % 2 == 0) {
						tmp = x;
						x = y;
						y = tmp;
					}
					
					break;
				}
				
				curr += 1;
			}
			
			if (x != 0 || y != 0) {
				break;
			}
		}
		
		System.out.print(x +"/" + y);
		
	}

}
