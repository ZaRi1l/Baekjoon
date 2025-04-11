package q1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static node[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		nodes = new node[n];

		for (int i = 0; i < nodes.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);

			for (int k = 0; k < nodes.length; k++) {
				if (nodes[k] == null)
					break;
				if (nodes[k].getRoot() == root) {
					nodes[i] = nodes[k];
					break;
				}
			}

			if (nodes[i] == null)
				nodes[i] = new node(root);

			if (l != '.') {
				nodes[i].setL(new node(l));
				nodes[i + 1] = nodes[i].getL();
			}
			if (r != '.') {
				nodes[i].setR(new node(r));
				nodes[i + 2] = nodes[i].getR();
			}
		}
		
		preorder(nodes[0]);

	}

	private static void preorder(node root) {
		System.out.print(root.getRoot());

		if (root.getL() != null)
			preorder(root.getL());

		if (root.getR() != null)
			preorder(root.getR());
	}

}

class node {
	char root;
	node r;
	node l;

	public node(char root) {
		this.root = root;
	}

	public char getRoot() {
		return root;
	}

	public void setRoot(char root) {
		this.root = root;
	}

	public node getR() {
		return r;
	}

	public void setR(node r) {
		this.r = r;
	}

	public node getL() {
		return l;
	}

	public void setL(node l) {
		this.l = l;
	}
}
