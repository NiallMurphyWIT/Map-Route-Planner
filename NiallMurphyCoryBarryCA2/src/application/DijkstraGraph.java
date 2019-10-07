package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraGraph {
	private Graph graph;

	public DijkstraGraph(Graph graph) {
		this.graph = graph;
	}

	public Graph getGraph() {
		return graph;
	}

	
	// calculates shortest path for two nodes
	public List<Node> getShortestPath(Node from, Node to) throws IOException {

		Map<Node, Integer> nodeDistanceMapping = getNodeDistanceMapping(from);
		Map<Node, Node> previousNodeMapping = getPreviousNodeMapping();
		Set<Node> unsettled = new HashSet<Node>();
		unsettled.add(from);
		Set<Node> settled = new HashSet<Node>();

		while (unsettled.size() != 0) {

			Node currentNode = getLowestUnsettledNode(unsettled, nodeDistanceMapping);

			int currentDistance = nodeDistanceMapping.get(currentNode);
			unsettled.remove(currentNode);
			
			// for each node in currentnode : skips if settled, gets distance val to node on other side of edge, 
			// if distance is lower than in nodeDistanceMapping it gets updated, then adds node to unsettled so neighbors checked in another loop
			for (final Edge e : currentNode.getEdges()) {
				int currentNeighorDistance = nodeDistanceMapping.get(e.getTo());
				int newNeighborDistance = currentDistance + e.getWeight();
				if (!settled.contains(e.getTo()) && newNeighborDistance < currentNeighorDistance) {
					nodeDistanceMapping.put(e.getTo(), newNeighborDistance);
					previousNodeMapping.put(e.getTo(), currentNode);
					unsettled.add(e.getTo());
				}
			}
			// Adds current node to settled set so it does not get checked again
			settled.add(currentNode);
		}

		// Gives a list that will be the path reversed
		List<Node> path = new ArrayList<Node>();
		for (Node n = to; n != null; n = previousNodeMapping.get(n)) {

			path.add(n);
		}
		Collections.reverse(path);
		return path;
	}

	private Map<Node, Node> getPreviousNodeMapping() {
		Map<Node, Node> mappings = new HashMap<>();
		for (Node n : getGraph().getNodes()) {
			mappings.put(n, null);
		}
		return mappings;
	}

	private Node getLowestUnsettledNode(Set<Node> unsettled, Map<Node, Integer> distanceMapping) {
		Iterator<Node> iter = unsettled.iterator();
		if (!iter.hasNext()) {
			return null;
		}
		Node selected = iter.next();
		while (iter.hasNext()) {
			Node n = iter.next();
			if (distanceMapping.get(n) < distanceMapping.get(selected)) {
				selected = n;
			}
		}
		return selected;
	}

	private Map<Node, Integer> getNodeDistanceMapping(Node from) {
		Map<Node, Integer> mappings = new HashMap<Node, Integer>();
		for (Node n : getGraph().getNodes()) {
			mappings.put(n, Integer.MAX_VALUE);
		}
		mappings.put(from, 0);
		return mappings;
	}
}
