package phoenixTeam.util;

import com.badlogic.gdx.utils.Array;
import phoenixTeam.util.TopologicalSort.Dependent;


public class TopologicalSort<E extends Dependent>{

	private Array<Vertex<E>> vertexList; // list of vertices

	private int matrix[][]; // adjacency matrix

	private char sortedArray[];

	private TopologicalSort() {
		vertexList = new Array<Vertex<E>>();
		matrix = new int[MAX_VERTS][MAX_VERTS];
		sortedArray = new char[MAX_VERTS]; // sorted vert labels
	}

	public void addVertex(E lab){
		vertexList[vertexList.size++] = new Vertex(lab);
	}

	public void addEdge(int start, int end){
		matrix[start][end] = 1;
	}

	public void topo() // toplogical sort
	{
		int orig_nVerts = vertexList.size;

		while (vertexList.size > 0) // while vertices remain,
		{
			// get a vertex with no successors, or -1
			int currentVertex = noSuccessors();
			if (currentVertex == -1) // must be a cycle
			{
				System.out.println("ERROR: Graph has cycles");
				return;
			}
			// insert vertex label in sorted array (start at end)
			sortedArray[vertexList.size - 1] = vertexList[currentVertex].label;

			deleteVertex(currentVertex); // delete vertex
		}

		// vertices all gone; display sortedArray
		System.out.print("Topologically sorted order: ");
		for (int j = 0; j < orig_nVerts; j++)
			System.out.print(sortedArray[j]);
		System.out.println("");
	}

	public int noSuccessors() // returns vert with no successors (or -1 if
								// no such verts)
	{
		boolean isEdge; // edge from row to column in adjMat

		for (int row = 0; row < vertexList.size; row++){
			isEdge = false; // check edges
			for (int col = 0; col < vertexList.size; col++){
				if (matrix[row][col] > 0) // if edge to another,
				{
					isEdge = true;
					break; // this vertex has a successor try another
				}
			}
			if (!isEdge) // if no edges, has no successors
				return row;
		}
		return -1; // no
	}

	public void deleteVertex(int delVert){
		if (delVert != vertexList.size - 1) // if not last vertex, delete from
										// vertexList
		{
			for (int j = delVert; j < vertexList.size - 1; j++)
				vertexList[j] = vertexList[j + 1];

			for (int row = delVert; row < vertexList.size - 1; row++)
				moveRowUp(row, vertexList.size);

			for (int col = delVert; col < vertexList.size - 1; col++)
				moveColLeft(col, vertexList.size - 1);
		}
		vertexList.size--; // one less vertex
	}

	private void moveRowUp(int row, int length){
		for (int col = 0; col < length; col++)
			matrix[row][col] = matrix[row + 1][col];
	}

	private void moveColLeft(int col, int length){
		for (int row = 0; row < length; row++)
			matrix[row][col] = matrix[row][col + 1];
	}

	public static void main(String[] args){
		TopologicalSort<Character> g = new TopologicalSort<Character>();
		g.addVertex('A'); // 0
		g.addVertex('B'); // 1
		g.addVertex('C'); // 2
		g.addVertex('D'); // 3
		g.addVertex('E'); // 4
		g.addVertex('F'); // 5
		g.addVertex('G'); // 6
		g.addVertex('H'); // 7

		g.addEdge(0, 3); // AD
		g.addEdge(0, 4); // AE
		g.addEdge(1, 4); // BE
		g.addEdge(2, 5); // CF
		g.addEdge(3, 6); // DG
		g.addEdge(4, 6); // EG
		g.addEdge(5, 7); // FH
		g.addEdge(6, 7); // GH

		g.topo(); // do the sort
	}
	
	
	private static class Vertex<E extends Dependent>{
		public E label;

		public Vertex(E lab) {
			label = lab;
		}
	}
	
	public static interface Dependent{
		
		Class[] getDependencies();
		
	}

	
}
