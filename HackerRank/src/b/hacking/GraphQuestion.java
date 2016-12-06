package b.hacking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphQuestion {

	class Node {
		int index;
		boolean visited;
		ArrayList<Node> connections;

		public Node(int idx) {
			index = idx;
			connections = new ArrayList<Node>();
			visited = false;
		}

		public void findSP(Node[] graph) {
			int[] min_dist = new int[graph.length];
			for (int i = 0; i < min_dist.length; i++) {
				if (i != this.index)
					min_dist[i] = Integer.MAX_VALUE;
			}

			LinkedList<Node> queue = new LinkedList<Node>();
			for (Node connection : connections) {
				min_dist[connection.index]=6;
				queue.add(connection);
			}
			this.visited=true;
			Node prev = this;
			while (!queue.isEmpty()) {
				Node node = queue.remove();
				if(!node.visited){
					for (Node connection : node.connections) {
						if (!connection.visited){
							queue.add(connection);
							if (min_dist[connection.index] > min_dist[node.index] + 6) {
								min_dist[connection.index] = min_dist[node.index] + 6;
							}
						}
					}
				}
				node.visited = true;
				prev=node;
			}
			for (int i = 0; i < graph.length; i++) {
				if (i != this.index) {
					if (min_dist[i] == Integer.MAX_VALUE)
						System.out.print("-1 ");
					else
						System.out.print(min_dist[i] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		GraphQuestion qu = new GraphQuestion();

		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int n = in.nextInt();
			Node[] graph = new Node[n];
			for (int k = 0; k < n; k++) {
				graph[k] = qu.new Node(k);
			}
			int m = in.nextInt();
			for (int j = 0; j < m; j++) {
				int node1 = in.nextInt() - 1;
				int node2 = in.nextInt() - 1;
				graph[node1].connections.add(graph[node2]);
				graph[node2].connections.add(graph[node1]);
			}
			int s = in.nextInt() - 1;
			graph[s].findSP(graph);
		}

	}
}
