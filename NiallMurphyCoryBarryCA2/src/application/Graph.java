package application;

import java.util.List;

public class Graph {
	// Graph class
	private List<Node> nodes;

	public Graph(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Node> getNodes() {
		return nodes;
	}
}
