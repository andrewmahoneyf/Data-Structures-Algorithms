import java.util.*;

/**
 * A representation of a graph. Assumes that we do not have negative cost edges
 * in the graph.
 */
public class MyGraph implements Graph {
	private Collection<Vertex> vertices;
	private Collection<Edge> edges;
	private Map<Vertex, Collection<Vertex>> adjacents;

	/**
	 * Creates a MyGraph object with the given collection of vertices and the
	 * given collection of edges.
	 * @param v a collection of the vertices in this graph
	 * @param e a collection of the edges in this graph
	 */
	public MyGraph(Collection<Vertex> v, Collection<Edge> e) {
		this.vertices = v;
		this.edges = e;

		for (Edge edge : e) {
			if (!vertices.contains(edge.getSource()) || !vertices.contains(edge.getDestination())) {
				throw new IllegalArgumentException("All Edges should only involve vertices from list");
			}
			for (Edge check : edges) {
				if (edge.getSource().equals(check.getSource()) && 
					edge.getDestination().equals(check.getDestination()) && 
					edge.getWeight() != check.getWeight()) {
					throw new IllegalArgumentException("Duplicate edges must have same weights");
				}
			}
		}
		this.adjacents = new HashMap<Vertex, Collection<Vertex>>();
	}

	/**
	 * Return the collection of vertices of this graph
	 * @return the vertices as a collection (which is anything iterable)
	 */
	public Collection<Vertex> vertices() {
		return vertices;
	}

	/**
	 * Return the collection of edges of this graph
	 * @return the edges as a collection (which is anything iterable)
	 */
	public Collection<Edge> edges() {
		return edges;
	}

	/**
	 * Return a collection of vertices adjacent to a given vertex v. i.e., the
	 * set of all vertices w where edges v -> w exist in the graph. Return an
	 * empty collection if there are no adjacent vertices.
	 * @param v one of the vertices in the graph
	 * @return an iterable collection of vertices adjacent to v in the graph
	 * @throws IllegalArgumentException if v does not exist.
	 */
	public Collection<Vertex> adjacentVertices(Vertex v) {
		if (!vertices.contains(v)) {
			throw new IllegalArgumentException("Vertex Doesn't Exist");
		} else if (adjacents.containsKey(v)) {
			return adjacents.get(v);
		} else {
			Collection<Vertex> adj = new ArrayList<Vertex>();
			for (Edge edge : edges) {
				if (edge.getSource().equals(v)) {
					adj.add(edge.getDestination());
				}
			}
			adjacents.put(v, adj);
			return adj;
		}
	}

	/**
	 * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed
	 * graph. Assumes that we do not have negative cost edges in the graph.
	 * @param a one vertex
	 * @param b another vertex
	 * @return cost of edge if there is a directed edge from a to b in the
	 *         graph, return -1 otherwise.
	 * @throws IllegalArgumentException if a or b do not exist.
	 */
	public int edgeCost(Vertex a, Vertex b) {
		if (!vertices.contains(a) || !vertices.contains(b)) {
			throw new IllegalArgumentException("Vertex Doesn't Exist");
		}
		for (Edge edge : edges) {
			if (edge.getSource().equals(a) && edge.getDestination().equals(b)) {
				return edge.getWeight();
			}
		}
		return -1;
	}
}
