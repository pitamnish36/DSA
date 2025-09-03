public class QueueADT {
    protected int queue[];

    protected int front;
    private static final int DEFAULT_SIZE=5;
    public QueueADT(){
        this(DEFAULT_SIZE);
    }
    public QueueADT(int size){
        queue=new int[DEFAULT_SIZE];
    }


}
