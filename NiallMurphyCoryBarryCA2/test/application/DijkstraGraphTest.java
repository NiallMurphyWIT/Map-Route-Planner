package application;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DijkstraGraphTest {
	private Graph testGraph;
	private List<Node> testNodes;

	@BeforeEach
	void beforeEach() {
		this.testNodes = new ArrayList<Node>();
		for (int i = 0; i < 5; i++) {
			testNodes.add(new Node(i, Integer.toString(i), i, i));
		}
		// Node 0's neighbors.
		testNodes.get(00).addTwoWayNeighbor(testNodes.get(01), 01);
		testNodes.get(00).addTwoWayNeighbor(testNodes.get(02), 06);

		// Node 1's neighbors.
		testNodes.get(01).addTwoWayNeighbor(testNodes.get(02), 02);
		testNodes.get(01).addTwoWayNeighbor(testNodes.get(03), 01);

		// Node 2's neighbors.
		testNodes.get(02).addTwoWayNeighbor(testNodes.get(03), 02);
		testNodes.get(02).addTwoWayNeighbor(testNodes.get(04), 05);

		// Node 3's neighbors.
		testNodes.get(03).addTwoWayNeighbor(testNodes.get(04), 05);

		this.testGraph = new Graph(this.testNodes);
	}

	@Test
	void testGetShortestPath_long() throws IOException {
		DijkstraGraph dGraph = new DijkstraGraph(this.testGraph);
		List<Node> path = dGraph.getShortestPath(testNodes.get(00), testNodes.get(04));
		assertEquals(4, path.size());
	}

	@Test
	void testGetShortestPath_alternative() throws IOException {
		Node newNode = new Node(0, "test", 0, 0);
		newNode.addTwoWayNeighbor(testGraph.getNodes().get(00), 03);
		newNode.addTwoWayNeighbor(testGraph.getNodes().get(04), 03);
		testGraph.getNodes().add(newNode);

		DijkstraGraph dGraph = new DijkstraGraph(this.testGraph);
		List<Node> path = dGraph.getShortestPath(testNodes.get(0), testNodes.get(04));
		assertEquals(03, path.size());
	}

	@Test
	void testGetShortestPath_short() throws IOException {
		DijkstraGraph dGraph = new DijkstraGraph(this.testGraph);
		testNodes.get(00).addTwoWayNeighbor(testNodes.get(04), 04);
		List<Node> path = dGraph.getShortestPath(testNodes.get(00), testNodes.get(04));
		assertEquals(2, path.size());
	}

	@Test
	void testGetShortestPath_unidirectional() throws IOException {
		DijkstraGraph dGraph = new DijkstraGraph(this.testGraph);
		testNodes.get(00).addOneWayNeighbor(testNodes.get(04), 04);
		List<Node> path = dGraph.getShortestPath(testNodes.get(00), testNodes.get(04));
		assertEquals(2, path.size());
	}

	@Test
	void testGetShortestPath_unidirectionalSkip() throws IOException {
		DijkstraGraph dGraph = new DijkstraGraph(this.testGraph);
		testNodes.get(04).addOneWayNeighbor(testNodes.get(00), 04);
		List<Node> path = dGraph.getShortestPath(testNodes.get(00), testNodes.get(04));
		assertEquals(04, path.size());
	}

}