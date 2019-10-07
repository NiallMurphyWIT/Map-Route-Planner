package application;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {
	private List<Node> testNodes;

	@BeforeEach
	void beforeEach() {
		testNodes = new ArrayList<Node>();
		for (int i = 0; i < 10; i++) {
			testNodes.add(new Node(i, Integer.toString(i), i, i));
		}
	}

	@Test
	void testConstructor() {
		Graph testGraph = new Graph(testNodes);
		assertEquals(10, testGraph.getNodes().size());
	}

}