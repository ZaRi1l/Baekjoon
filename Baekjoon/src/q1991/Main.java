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
		int idx = 1;

		for (int i = 0; i < nodes.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);

			if (nodes[i] == null)
				nodes[i] = new node(root);

			if (l != '.') {
				nodes[i].setL(new node(l));
				nodes[idx++] = nodes[i].getL();
			}
			if (r != '.') {
				nodes[i].setR(new node(r));
				nodes[idx++] = nodes[i].getR();
			}
		}
		
		for(int i = 0; i< nodes.length;i ++) {
			System.out.println(nodes[i].getRoot());
		}
		System.out.println(nodes[5].getRoot());
		System.out.println(nodes[5].getR().getRoot());
		
		

		preorder(nodes[0]);
		System.out.println();
		inorder(nodes[0]);
		System.out.println();
		postorder(nodes[0]);

	}

	private static void preorder(node root) {
		System.out.print(root.getRoot());

		if (root.getL() != null)
			preorder(root.getL());

		if (root.getR() != null)
			preorder(root.getR());
	}

	private static void inorder(node root) {
		if (root.getL() != null)
			inorder(root.getL());

		System.out.print(root.getRoot());

		if (root.getR() != null)
			inorder(root.getR());
	}

	private static void postorder(node root) {
		if (root.getL() != null)
			postorder(root.getL());

		if (root.getR() != null)
			postorder(root.getR());

		System.out.print(root.getRoot());
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
