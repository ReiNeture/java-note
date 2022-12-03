package bellmanFord;

import java.util.HashMap;
import java.util.Map;

public class Node {
	
	String key;
    public Integer distance = Integer.MAX_VALUE;
    public Node predecessor;
    
    public Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, int width) {
        adjacentNodes.put(destination, width);
    }	
	
	public Node(String key) {
		this.key = key;
	}
	
}
