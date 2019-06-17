package disjointset;

public interface DisjointSet {
	int findSet(int nodo);
	void makeSet(int nodo);
	void union(int x, int y);
	int size();
}
