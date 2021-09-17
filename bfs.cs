public struct Vertex
{
	public char Label;
	public bool Visited;
}

private static int _rear = -1;
private static int _front = 0;
private static int _queueItemCount = 0;
private static int _vertexCount = 0;

private static void Insert(int[] queue, int data)
{
	queue[++_rear] = data;
	_queueItemCount++;
}

private static int RemoveData(int[] queue)
{
	_queueItemCount--;
	return queue[_front++];
}

private static bool IsQueueEmpty()
{
	return _queueItemCount == 0;
}

public static void AddVertex(Vertex[] arrVertices, char label)
{
	Vertex vertex = new Vertex();
	vertex.Label = label;
	vertex.Visited = false;
	arrVertices[_vertexCount++] = vertex;
}

public static void AddEdge(int[,] adjacencyMatrix, int start, int end)
{
	adjacencyMatrix[start, end] = 1;
	adjacencyMatrix[end, start] = 1;
}

private static void DisplayVertex(Vertex[] arrVertices, int vertexIndex)
{
	Console.Write(arrVertices[vertexIndex].Label + " ");
}

private static int GetAdjacentUnvisitedVertex(Vertex[] arrVertices, int[,] adjacencyMatrix, int vertexIndex)
{
	int i;

	for (i = 0; i < _vertexCount; i++)
	{
		if (adjacencyMatrix[vertexIndex, i] == 1 && arrVertices[i].Visited == false)
			return i;
	}

	return -1;
}

public static void BreadthFirstSearch(Vertex[] arrVertices, int[,] adjacencyMatrix, int[] queue)
{
	int i;
	arrVertices[0].Visited = true;
	DisplayVertex(arrVertices, 0);
	Insert(queue, 0);
	int unvisitedVertex;

	while (!IsQueueEmpty())
	{
		int tempVertex = RemoveData(queue);

		while ((unvisitedVertex = GetAdjacentUnvisitedVertex(arrVertices, adjacencyMatrix, tempVertex)) != -1)
		{
			arrVertices[unvisitedVertex].Visited = true;
			DisplayVertex(arrVertices, unvisitedVertex);
			Insert(queue, unvisitedVertex);
		}
	}

	for (i = 0; i < _vertexCount; i++)
	{
	arrVertices[i].Visited = false;
	}
}

int max = 5;
int[] queue = new int[max];
Vertex[] arrVertices = new Vertex[max];
int[,] adjacencyMatrix = new int[max, max];

for (int i = 0; i < max; i++)
	for (int j = 0; j < max; j++)
		adjacencyMatrix[i, j] = 0;

AddVertex(arrVertices, 'S');
AddVertex(arrVertices, 'A');
AddVertex(arrVertices, 'B');
AddVertex(arrVertices, 'C');
AddVertex(arrVertices, 'D');

AddEdge(adjacencyMatrix, 0, 1);
AddEdge(adjacencyMatrix, 0, 2);
AddEdge(adjacencyMatrix, 0, 3);
AddEdge(adjacencyMatrix, 1, 4);
AddEdge(adjacencyMatrix, 2, 4);
AddEdge(adjacencyMatrix, 3, 4);

Console.Write("Breadth First Search: ");
BreadthFirstSearch(arrVertices, adjacencyMatrix, queue);