package b.hacking;

import java.util.Queue;
import java.util.Scanner;

public class Delivery {
	public class TNode {
		TNode left;
		TNode right;
		TNode parent;
		int value;
		int distance;
		boolean visited;

		public TNode(int val) {
			value = val;
		}
	}

	public class Food {
		int food_id;
		int[] restaurants;

		public Food(int id, int rest[]) {
			food_id = id;
			restaurants = rest.clone();
		}
	}

	public static void main(String[] args) {
		Delivery solution = new Delivery();

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();// number of intersections
		int m = in.nextInt();// number of type of foods
		int q = in.nextInt();// number of delivery requests
		Food[] foods = new Food[m+1];
		int[] orders_f = new int[q+1];
		int[] orders_p = new int[q+1];
		TNode[] nodes=new TNode[n+1];
		TNode root;

		for (int f_id = 1; f_id <= m; f_id++) {
			int f_c = in.nextInt();
			int[] rest = new int[f_c+1];
			for (int j = 1; j <= f_c; j++) {
				// gett the restaurants making this food
				rest[j] = in.nextInt();
				foods[f_id] = solution.new Food(f_id, rest);
			}
		}
		// get order requests
		for (int ord_id = 1; ord_id <= q; ord_id++) {
			// food-person
			orders_f[ord_id] = in.nextInt();
			orders_p[ord_id] = in.nextInt();
		}
		// build the tree
		root = solution.new TNode(1);
		nodes[1]=root;
		solution.buildBinaryTree(root, n,nodes);
		//
		TNode curr_node = root;
		int sum = 0;
		for (int i = 1; i <= q; i++) {
			Food curr_food = foods[orders_f[i]];
			int nearest_r;
			int dist_to_rest = solution.findNearestRest(curr_food.restaurants, curr_food.food_id, curr_node,nodes);
			resetTreeNodes(nodes);
			solution.findNearestPath(orders_p[i], curr_node,new Boolean(false));
			int dist_to_pers = nodes[orders_p[i]].distance;
			curr_node=nodes[orders_p[i]];
			sum = sum + dist_to_pers + dist_to_rest;
		}
		System.out.println(sum);
	}

	private static void resetTreeNodes(TNode[] nodes) {
		for(int i=1;i<nodes.length;i++){
			nodes[i].visited=false;
			nodes[i].distance=0;
		}
	}

	private void findNearestPath(int i, TNode curr_node,Boolean found) {
		if(curr_node.value==i){
			found=true;
			return;
		}
		int dist=0;
		if(!curr_node.visited && !found){
			curr_node.visited=true;
			if(curr_node.parent!=null) {
				if(!curr_node.parent.visited && (curr_node.parent.distance>curr_node.distance+1 || curr_node.parent.distance==0))
					curr_node.parent.distance=curr_node.distance+1;
				findNearestPath(i,curr_node.parent,found);
			}
			if (curr_node.left!=null) {
				if(!curr_node.left.visited && (curr_node.left.distance>curr_node.distance+1 || curr_node.left.distance==0))
				curr_node.left.distance=curr_node.distance+1;
				findNearestPath(i,curr_node.left,found);
			}
			if(curr_node.right!=null) {
				if(!curr_node.right.visited && (curr_node.right.distance>curr_node.distance+1 || curr_node.right.distance==0))
				curr_node.right.distance=curr_node.distance+1;
				findNearestPath(i,curr_node.right,found);
			}
		} 
	}

	private int findNearestRest(int[] restaurants, int food_id, TNode curr_node,TNode[] nodes) {
		int result=0;
		TNode tmpNode=null;
		int min=Integer.MAX_VALUE;
		for(int i=1;i<restaurants.length;i++){
			resetTreeNodes(nodes);
			findNearestPath(restaurants[i], curr_node,new Boolean(false));
			int dist=nodes[restaurants[i]].distance;
			if(dist<min){
				min=dist;
				tmpNode=nodes[restaurants[i]];
			}
		}
		return min;
	}


	private void buildBinaryTree(TNode root, int n,TNode[] nodes) {
		TNode[] queue = new TNode[1];
		int nodeCount=2;
		int level = 0;
		int nodecount = (int) Math.pow(2, level);
		queue[0] = root;
		int value = 2;
		int index = 0;
		while (value <= n) {
			int qidx = 0;
			int nodecount_tmp = (int) Math.pow(2, ++level);
			TNode[] queue_tmp = new TNode[nodecount_tmp];
			for (int i = 0; i < queue.length; i++) {
				if (value <= n) {
					TNode nl = new TNode(value++);
					nodes[nodeCount++]=nl;
					nl.parent = queue[i];
					queue[i].left = nl;
					queue_tmp[qidx++] = nl;
				}
				if (value <=n) {
					TNode nr = new TNode(value++);
					nodes[nodeCount++]=nr;
					nr.parent = queue[i];
					queue[i].right = nr;
					queue_tmp[qidx++] = nr;
				}
			}
			nodecount = nodecount_tmp;
			queue = queue_tmp;
		}

	}

}
