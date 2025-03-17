package q25192;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<String> names = new TreeSet<String>();
		int n = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			switch (name) {
			case "ENTER":
				names.clear();
				break;
			default:
				if (!names.contains(name)) {
					names.add(name);
					count += 1;
				}
			}
		}
		br.close();

		System.out.print(count);
	}

}
