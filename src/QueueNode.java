public class QueueNode {

    private int number;
    private int distance;
    private boolean control;
    private QueueNode next;

    public QueueNode(int number) {
        this.setNumber(number);
        setDistance(0);
        setControl(false);
        setNext(null);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isControl() {
        return control;
    }

    public void setControl(boolean control) {
        this.control = control;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}