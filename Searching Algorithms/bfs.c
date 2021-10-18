// stdio.h
// stdlib.h
// stdbool.h
/***********************************************/

typedef struct vertex_struct {
	char Label;
	bool Visited;
} Vertex;

int _rear = -1;
int _front = 0;
int _queueItemCount = 0;
int _vertexCount = 0;

void Insert(int* queue, int data) {
	queue[++_rear] = data;
	_queueItemCount++;
}

int RemoveData(int* queue) {
	_queueItemCount--;
	return queue[_front++];
}

bool IsQueueEmpty() {
	return _queueItemCount == 0;
}

void AddVertex(Vertex** arrVertices, char label) {
	Vertex* vertex = (Vertex*)malloc(sizeof(Vertex));
	vertex->Label = label;
	vertex->Visited = false;
	arrVertices[_vertexCount++] = vertex;
}

void AddEdge(int** adjacencyMatrix, int start, int end) {
	adjacencyMatrix[start][end] = 1;
	adjacencyMatrix[end][start] = 1;
}

int** Create2DArray(int rowCount, int colCount) {
	int** rArray = (int**)malloc(sizeof(int*) * rowCount);

	for (int i = 0; i < rowCount; i++) {
		rArray[i] = (int*)malloc(sizeof(int) * colCount);
	}

	return rArray;
}

void DisplayVertex(Vertex** arrVertices, int vertexIndex) {
	printf("%c ", arrVertices[vertexIndex]->Label);
}

int GetAdjacentUnvisitedVertex(Vertex** arrVertices, int** adjacencyMatrix, int vertexIndex) {
	int i;

	for (i = 0; i<_vertexCount; i++) {
		if (adjacencyMatrix[vertexIndex][i] == 1 && arrVertices[i]->Visited == false)
			return i;
	}

	return -1;
}

void BreadthFirstSearch(Vertex** arrVertices, int** adjacencyMatrix, int* queue) {
	int i;
	arrVertices[0]->Visited = true;
	DisplayVertex(arrVertices, 0);
	Insert(queue, 0);
	int unvisitedVertex;

	while (!IsQueueEmpty()) {
		int tempVertex = RemoveData(queue);

		while ((unvisitedVertex = GetAdjacentUnvisitedVertex(arrVertices, adjacencyMatrix, tempVertex)) != -1) {
			arrVertices[unvisitedVertex]->Visited = true;
			DisplayVertex(arrVertices, unvisitedVertex);
			Insert(queue, unvisitedVertex);
		}
	}

	for (i = 0; i<_vertexCount; i++) {
		arrVertices[i]->Visited = false;
	}
}

int max = 5;
int* queue = (int*)malloc(sizeof(int) * max);
Vertex** arrVertices = (Vertex**)malloc(sizeof(Vertex*) * max);
int** adjacencyMatrix = Create2DArray(max, max);

for (int i = 0; i < max; i++)
	for (int j = 0; j < max; j++)
		adjacencyMatrix[i][j] = 0;

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

printf("Breadth First Search: ");
BreadthFirstSearch(arrVertices, adjacencyMatrix, queue);