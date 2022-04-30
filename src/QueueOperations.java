public class QueueOperations {

    public QueueNode front;
    public QueueNode rear;

    public QueueOperations() {
        front = null;
        rear = null;
    }

    public QueueNode getFront() {
        return front;
    }

    public void enQueue(int number) {

        QueueNode newNode = new QueueNode(number);

        if (front == null) {
            front = newNode;
        } else {
            QueueNode walk = front;

            while (walk.getNext() != null){
                walk = walk.getNext();
            }

            walk.setNext(newNode);
        }
        rear = newNode;
    }

    public int deQueue() {
        if (!isEmpty()) {
            return -1;
        } else {
            int box = front.getNumber();
            front = front.getNext();
            return box;
        }
    }

    public void print() {
        if (!isEmpty()) {
            System.out.println("Yazdırılacak eleman bulunamadı...");
        } else {

            QueueNode walk = front;
            System.out.println("front->");
            while (walk != null) {

                System.out.print(walk.getNumber() + "->");
                walk = walk.getNext();
            }
            System.out.println("rear");
        }
    }

    private boolean isEmpty() {
        return front != null;
    }
}