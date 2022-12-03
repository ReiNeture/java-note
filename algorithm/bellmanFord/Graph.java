package bellmanFord;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	public List<Node> nodes = new LinkedList<>();	
	private int size = 0;
	
	public void addNode(Node n) {
		nodes.add(n);
		++size;
	}
	
	public int vertexCount() {
		return size;
	}
	
	public void printAll() {
		for (Node node : nodes) {
			System.out.print("節點名稱=" + node.key);
			System.out.print(" 前節點名=" + node.predecessor.key);
			System.out.print(" 最短距離=" + node.distance);
			System.out.println();
		}
	}
	
}
