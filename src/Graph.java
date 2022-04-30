public class Graph {

    private int numberOfVertices = 0;
    private int numberOfEdges = 0;
    private int[][] adjMatrix = null;

    public Graph(int size){
        if (size < 0){
            throw new IllegalArgumentException("Number of vertices must be positive");
        }

        adjMatrix = new int[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                adjMatrix[i][j] = 0;
            }
        }

        numberOfVertices = size;
    }

    public void addEdge(int from, int to){
        if (from < 0 && from > numberOfVertices){
            throw new IllegalArgumentException("Number must be in valid range (from vertex):" + from);
        }

        if (to < 0 && to > numberOfVertices){
            throw new IllegalArgumentException("Number must be in valid range (to vertex):" + to);
        }

        adjMatrix[from][to] = 1;
        adjMatrix[to][from] = 1;
        numberOfEdges++;
    }

    public int degree(int vertexNo){
        if (vertexNo < 0 && vertexNo > numberOfVertices){
            throw new IllegalArgumentException("Number must be in valid range (vertexNo):" + vertexNo);
        }

        int degree = 0;
        for(int i = 0; i < numberOfVertices; i++){

            if(adjMatrix[vertexNo][i] == 1){
                degree++;
            }
        }

        return degree;
    }

    public boolean isEdge(int v, int w){
        if (v < 0 && v > numberOfVertices){
            throw new IllegalArgumentException("Number must be in valid range (v vertex):" + v);
        }

        if (w < 0 && w > numberOfVertices){
            throw new IllegalArgumentException("Number must be in valid range (w vertex):" + w);
        }

        boolean result = false;

        if(adjMatrix[v][w] == 1 && adjMatrix[w][v] == 1){
            result = true;
        }

        return result;
    }

    public String neighbors(int v){
        if (v < 0 && v > numberOfVertices){
            throw new IllegalArgumentException("Number must be in valid range (v vertex):" + v);
        }

        String str = "";
        for(int i = 0; i < numberOfVertices; i++){

            if(adjMatrix[v][i] == 1){
                str += i + " ";
            }
        }

        return str;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public void setNumberOfVertices(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public void setNumberOfEdges(int numberOfEdges) {
        this.numberOfEdges = numberOfEdges;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }
}