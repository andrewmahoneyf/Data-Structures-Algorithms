import java.util.*;

public class GraphTest {
	public static void main(String[] args) {
		List<Vertex> vertices = new ArrayList<Vertex>();
		List<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < 10; i++) {
			Vertex node = new Vertex("Node_" + i);
			vertices.add(node);
		}
		Edge A = new Edge(new Vertex("Node_3"), new Vertex("Node_4"), 3);
		Edge B = new Edge(new Vertex("Node_7"), new Vertex("Node_8"), 5);
		Edge C = new Edge(new Vertex("Node_4"), new Vertex("Node_5"), 2);
		Edge D = new Edge(new Vertex("Node_4"), new Vertex("Node_1"), 8);
		Edge E = new Edge(new Vertex("Node_4"), new Vertex("Node_1"), 8);
		edges = new ArrayList<Edge>(Arrays.asList(A, B, C, D, E));

		Graph testGraph = new MyGraph(vertices, edges);
		System.out.println("Vertices: " + testGraph.vertices());
		System.out.println("Edges: " + testGraph.edges());
		System.out.println("Adjacent: " + testGraph.adjacentVertices(new Vertex("Node_4")));
		System.out.println("No Adjacent Vertices: " + testGraph.adjacentVertices(new Vertex("Node_1")));
		// System.out.println(testGraph.adjacentVertices(new Vertex("Node_15")));
		System.out.println("Edge Cost: " + testGraph.edgeCost(new Vertex("Node_3"), new Vertex("Node_4")));
		System.out.println("Edge Cost, No Edge: " + testGraph.edgeCost(new Vertex("Node_1"), new Vertex("Node_4")));
		System.out.println(testGraph.edgeCost(new Vertex("Node_15"), new Vertex("Node_4")));
	}
}
