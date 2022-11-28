package dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	
	private Set<Node> nodes = new HashSet<>();	
	
	public void addNode(Node n) {
		nodes.add(n);
	}
	
	public void printAll() {
		for (Node node : nodes) {
			System.out.print("¦WºÙ: " + node.key);
			System.out.print(" «e­Ó: " + node.predecessor.key);
			System.out.print(" ¶ZÂ÷: " + node.distance);
			System.out.println();
		}
	}
	
}
