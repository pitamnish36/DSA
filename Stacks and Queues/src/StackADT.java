public class StackADT {
    private static final int DEFAULT_SIZE=5;
    protected int []stack;
    public int top=-1;

    public StackADT(){
        this(DEFAULT_SIZE);
    }

    public StackADT(int size){
        stack=new int[size];
    }

    protected boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }

    protected boolean isFull(){
        if(top==stack.length-1){
            return true;
        }
        return false;
    }

    protected int peek(){
        return stack[top];
    }

    protected boolean push(int element){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        this.stack[++top]=element;
        return true;
    }

    protected int pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }
        int removed=this.stack[top];
        top--;
        return removed;
    }
}
