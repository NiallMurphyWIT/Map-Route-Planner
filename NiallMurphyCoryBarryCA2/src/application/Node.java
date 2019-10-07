package application;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private int index;
	private String name;
	private int x, y;
	private List<Edge> edges;

	public Node(int index, String name, int x, int y) {
		this.index = index;
		this.name = name;
		this.x = x;
		this.y = y;
		this.edges = new ArrayList<Edge>();
	}

	public int getIndex() {
		return index;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getName() {
		return name;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	
	public List<Node> getNeighbors() {
		List<Node> neighbors = new ArrayList<Node>(getEdges().size());
		for (Edge e : getEdges()) {
			neighbors.add(e.getTo());
		}
		return neighbors;
	}

	// Adds an edge in one direction
	public void addOneWayNeighbor(Node neighbor, int weight) {
		this.edges.add(new Edge(this, neighbor, weight));

	}

	// Add an edge in two directions by calling addOneWayNeighbor for both directions
	public void addTwoWayNeighbor(Node neighbor, int weight) {
		addOneWayNeighbor(neighbor, weight);
		neighbor.addOneWayNeighbor(this, weight);

	}

}
