package b.hacking;

import java.util.ArrayList;
import java.util.Scanner;

public class WalkingLongestPath {
	public class Node {
		public int value;
		public ArrayList<Node> children;
		boolean visited;

		public Node(int val) {
			value = val;
		}
	}

	public class Graph {
		public ArrayList<Node> nodes;
	}

	public Graph graph = new Graph();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();// number of cities
		int m = in.nextInt();// number of roads
		int[] x = new int[m];
		int[] y = new int[m];
		for (int i = 0; i < m; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		WalkingLongestPath longestPath = new WalkingLongestPath();
		longestPath.solution(n, m, x, y);

	}

	private void solution(int n, int m, int[] x, int[] y) {
		for (int i = 0; i < m; i++) {
			Node nx = new Node(x[i]);
			Node ny = new Node(y[i]);
			nx.children.add(ny);
			ny.children.add(nx);
			graph.nodes.add(nx);
			graph.nodes.add(ny);
		}
		int d = 0;
		int idx = 0;
		ArrayList<Node> orderedList;
		while (idx < m) {
			ArrayList<Node> ordered=new ArrayList<Node>();
			resetNodes();
			int nodesVisited=visitNodes(idx,ordered);
			if(nodesVisited>d){
				d=nodesVisited;
				orderedList=ordered;
			}
		}

	}

	private int visitNodes(int idx, ArrayList<Node> ordered) {
		return 0;
	}

	private void resetNodes() {
		for (Node node : graph.nodes) {
			node.visited = false;
		}
	}

}
