import java.util.ArrayList;

public class BFS {

    ReadFile readFile = new ReadFile();
    Graph graph;
    QueueOperations queueOperations = new QueueOperations();
    ArrayList<QueueNode> controlArraylist = new ArrayList<>();

    public BFS() {
        create();
    }

    private void create() {
        readFile.readerFromFile("input.txt");//dosyadan verileri alıp list yapısına ekledim
        graph = new Graph(readFile.getSize() + 1);//graph yapısını oluşturdum

        //matrix yapısını oluşturdum
        LinkedListNode walk = readFile.listOperations.getHead();
        while (walk != null) {

            graph.addEdge(walk.getFrom(), walk.getTo());
            walk = walk.getNext();
        }
    }

    public void bfsOperation() {

        String strOutput = "";

        queueOperations.enQueue(1);//!!!!!!!!ilk elemanı ekledim!!!!!!!!!!!
        controlArraylist.add(queueOperations.rear);

        while (queueOperations.getFront() != null) {
            int distance = queueOperations.front.getDistance();
            int box = queueOperations.deQueue();
            strOutput += box + " ";

            String str = graph.neighbors(box);//komşu vertexleri buldum
            String[] arraySplit = str.split(" ");

            for (String s : arraySplit) {
                if (comparisonOfElement(s)) {
                    queueOperations.enQueue(Integer.parseInt(s));
                    queueOperations.rear.setDistance((distance + 1));
                    controlArraylist.add(queueOperations.rear);
                }
            }
        }

        System.out.println("Output: " + strOutput);
    }

    private boolean comparisonOfElement(String str) {
        boolean control = true;
        for (QueueNode queueNode : controlArraylist) {

            if (queueNode.getNumber() == Integer.parseInt(str)) {
                control = false;
            }
        }

        return control;
    }

    public void print() {

        for (QueueNode queueNode : controlArraylist) {

            System.out.println("number: " + queueNode.getNumber() + ", distance: " + queueNode.getDistance() + ", state: " + queueNode.isControl());
        }
    }
}