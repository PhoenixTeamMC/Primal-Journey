package phoenixTeam.map;

import java.util.LinkedList;
import java.util.Queue;

import phoenixTeam.map.simplex.SimplexNoise;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;

public class MapGenerator{

	private final Array<ILayer> generators;
	private final Array<float[][]> map;

	private final SimplexNoise s;
	public final int size;

	public MapGenerator(int size) {

		s = new SimplexNoise();
		this.size = size;

		map = new Array<float[][]>();
		generators = new Array<ILayer>();

	}

	public void addLayer(ILayer layer){
		map.add(new float[size][size]);
		generators.add(layer);
	}

	public void generate(){

		sortGenerators();

		for (int i = 0; i < generators.size; i++){
			for (int x = 0; x < size; x++){
				for (int y = 0; y < size; y++){
					map.get(i)[x][y] = generators.get(i).getPoint(s, x, y, size);
				}
			}
		}

		scale(0, 1);

		for (int i = 0; i < map.size; i++){
			map.set(i, generators.get(i).transformGraph(map.get(i)));
		}
	}

	class Vertex{
		public char label;

		public Vertex(char lab) {
			label = lab;
		}
	}

	public class GraphTS{
		private final int MAX_VERTS = 20;

		private Vertex vertexList[]; // list of vertices

		private int matrix[][]; // adjacency matrix

		private int numVerts; // current number of vertices

		private char sortedArray[];

		public GraphTS() {
			vertexList = new Vertex[MAX_VERTS];
			matrix = new int[MAX_VERTS][MAX_VERTS];
			numVerts = 0;
			for (int i = 0; i < MAX_VERTS; i++)
				for (int k = 0; k < MAX_VERTS; k++)
					matrix[i][k] = 0;
			sortedArray = new char[MAX_VERTS]; // sorted vert labels
		}

		public void addVertex(char lab){
			vertexList[numVerts++] = new Vertex(lab);
		}

		public void addEdge(int start, int end){
			matrix[start][end] = 1;
		}

		public void displayVertex(int v){
			System.out.print(vertexList[v].label);
		}

		public void topo() // toplogical sort
		{
			int orig_nVerts = numVerts;

			while (numVerts > 0) // while vertices remain,
			{
				// get a vertex with no successors, or -1
				int currentVertex = noSuccessors();
				if (currentVertex == -1) // must be a cycle
				{
					System.out.println("ERROR: Graph has cycles");
					return;
				}
				// insert vertex label in sorted array (start at end)
				sortedArray[numVerts - 1] = vertexList[currentVertex].label;

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

			for (int row = 0; row < numVerts; row++){
				isEdge = false; // check edges
				for (int col = 0; col < numVerts; col++){
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
			if (delVert != numVerts - 1) // if not last vertex, delete from
											// vertexList
			{
				for (int j = delVert; j < numVerts - 1; j++)
					vertexList[j] = vertexList[j + 1];

				for (int row = delVert; row < numVerts - 1; row++)
					moveRowUp(row, numVerts);

				for (int col = delVert; col < numVerts - 1; col++)
					moveColLeft(col, numVerts - 1);
			}
			numVerts--; // one less vertex
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
			GraphTS g = new GraphTS();
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
	}

	private void sortGenerators(){

	}

	public Color getColor(int x, int y){
		Color color = generators.get(0).colorPoints(x, y, size, map.get(0)[x][y], map.get(0));

		for (int i = 1; i < generators.size; i++){
			color.lerp(generators.get(i).colorPoints(x, y, size, map.get(i)[x][y], map.get(i)), 1);
		}

		return color;
	}

	private void scale(float min, float max){
		for (int g = 0; g < map.size; g++){

			float[][] toScale = map.get(g);

			float tmp = amplitude2(toScale) / (max - min);
			for (float[] item : toScale){
				for (int i = 0; i < item.length; i++){
					item[i] /= tmp;
				}
			}
			tmp = min - min(toScale);
			for (float[] item : toScale){
				for (int i = 0; i < item.length; i++){
					item[i] += tmp;
				}
			}
		}
	}

	private static float amplitude2(float[][] items){
		return max(items) - min(items);
	}

	private static float max(float[][] items){
		float max = Float.NEGATIVE_INFINITY;

		for (float[] item : items){
			for (float f : item){
				if (f > max)
					max = f;
			}
		}
		return max;
	}

	private static float min(float[][] items){
		float min = Float.POSITIVE_INFINITY;

		for (float[] item : items){
			for (float f : item){
				if (f < min)
					min = f;
			}
		}
		return min;
	}

}
