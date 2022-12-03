package bellmanFord;

import java.util.Map;

public class BellmanFord {
	
	public static void main(String[] args) {
		
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D"); 
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");

		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);
		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeF, 15);
		nodeC.addDestination(nodeE, 10);
		nodeD.addDestination(nodeE, 2);
		nodeD.addDestination(nodeF, 1);
		nodeF.addDestination(nodeE, 5);

		Graph graph = new Graph();
		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);
		
		BellmanFord.bellmanFord(graph, nodeA);
		graph.printAll();
	}
	
	
	public static Graph bellmanFord(Graph g, Node source) {
		
		source.distance = 0;
		source.predecessor = source;
		
		for(int i = 0; i < g.vertexCount()-1; ++i) {
			
			for(Node from : g.nodes) {
				
				// releax
				for(Map.Entry<Node, Integer> edge : from.adjacentNodes.entrySet()) {
					Node to = edge.getKey();
					if(to.distance > from.distance + edge.getValue() ) {
						to.distance = from.distance + edge.getValue();
						to.predecessor = from;
					}
				}
			}
		}
		
		// 檢查Graph中是否存在negative cycle
		for(Node from : g.nodes) {
			for(Map.Entry<Node, Integer> edge : from.adjacentNodes.entrySet()) {
				Node to = edge.getKey();
				if(to.distance > from.distance + edge.getValue() )
					throw new IllegalStateException("had negative cycle");
			}
		}
		
		return g;
	}
	
}


