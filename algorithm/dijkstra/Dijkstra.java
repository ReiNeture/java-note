package dijkstra;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
	
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
		
		Dijkstra.dijkstra(graph, nodeA);
		graph.printAll();
	}
	
	
	public static Graph dijkstra(Graph g, Node source) {
		
		PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
		Set<Node> settledNodes = new HashSet<>();
		
		source.distance = 0;
		source.predecessor = source;
		queue.add(source);
		
		while( !queue.isEmpty() ) {
			
			Node current = queue.poll();
			for( Map.Entry<Node, Integer> entry : current.adjacentNodes.entrySet() ) {
				
				Node adjNode = entry.getKey();
				if( !settledNodes.contains(adjNode) ) {
					
					if( current.distance + entry.getValue() < adjNode.distance ) {
						adjNode.distance = current.distance + entry.getValue();
						adjNode.predecessor = current;
					}
					queue.add(adjNode);
				}
			}
			settledNodes.add(current);
		}
		return g;
	}
}

class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
        return n1.distance.compareTo(n2.distance);
    }
}
