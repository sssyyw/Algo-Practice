package chapter4;

public class FindARoute {
	private boolean[] marked;
	
	public FindARoute(Graph G, Node s, Node d){
		marked = new int[G.V()];
		isRoute(G, s, d);
	}
	
	public boolean isRoute(Graph G, int s, int d){
		marked[s] = true;
		for (int w: G.adj(s))
			if (w == d)
				return true;
		    if (!marked[w]){	    	
			    return isRoute(G, w, d);
		    }
		return false;
	}
	
	// reference
	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	public static boolean search(Graph G, Node start, Node end){
		LinkedList<Node> q = new LinkedList<Node>();
		for (Node u: g.getNodes()){
			u.state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while(!q.isEmpty()){
			u = q.removeFirst();
			if (u!=null){
				for (Node v : u.getAdjacent()){
					if (v == end){
						return true;
					} else {
						v.state = State.Visiting;
						q.add(v)
					}
				}
			}
			u.state = State.Visited;
		}
	}
	return false;
}
