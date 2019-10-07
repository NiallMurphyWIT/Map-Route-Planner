package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NodeTest {
	@Test
	void testConstructor() {
		String testName = "testName";
		Node node = new Node(0, testName, 0, 0);
		assertEquals(testName, node.getName());
		assertEquals(0, node.getEdges().size());
	}

	@Test
	void testAddOneWayNeighbor() {
		String nodeOneName = "nodeOne";
		String nodeTwoName = "nodeTwo";
		int testNodeWeight = 10;

		Node nodeOne = new Node(testNodeWeight, nodeOneName, testNodeWeight, testNodeWeight);
		Node nodeTwo = new Node(testNodeWeight, nodeTwoName, testNodeWeight, testNodeWeight);

		nodeOne.addOneWayNeighbor(nodeTwo, testNodeWeight);
		assertEquals(1, nodeOne.getEdges().size());
		assertEquals(1, nodeOne.getNeighbors().size());
		assertEquals(testNodeWeight, nodeOne.getEdges().get(0).getWeight());
		assertEquals(nodeTwoName, nodeOne.getNeighbors().get(0).getName());
	}

	@Test
	void testAddTwoWayNeighbor() {
		String nodeOneName = "nodeOne";
		String nodeTwoName = "nodeTwo";
		int testNodeWeight = 10;

		Node nodeOne = new Node(testNodeWeight, nodeOneName, testNodeWeight, testNodeWeight);
		Node nodeTwo = new Node(testNodeWeight, nodeTwoName, testNodeWeight, testNodeWeight);

		nodeOne.addTwoWayNeighbor(nodeTwo, testNodeWeight);
		assertEquals(1, nodeOne.getEdges().size());
		assertEquals(1, nodeOne.getNeighbors().size());
		assertEquals(1, nodeTwo.getEdges().size());
		assertEquals(1, nodeTwo.getNeighbors().size());
	}
}