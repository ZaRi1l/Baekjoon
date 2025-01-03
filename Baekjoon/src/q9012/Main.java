package q9012;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String[] vps = new String[sc.nextInt()];
        String vpsStr;
        int n;

        for (int i = 0; i < vps.length; i++) {
            vps[i] = sc.next();
        }
        sc.close();

        
        for (int i = 0; i < vps.length; i++) {
        	vpsStr = vps[i];
        	n = 0;
        	for(int j = 0; j < vpsStr.length(); j++) {
        		if (vpsStr.charAt(j) == '(') n++;
        		else n--;
        		
        		if (n < 0) break;
        	}
        	if (n == 0) System.out.println("YES");
        	else System.out.println("NO");
        }
	}
}
