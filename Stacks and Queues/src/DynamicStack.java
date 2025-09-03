public class DynamicStack extends StackADT{
    DynamicStack(){
        super();
    }

    DynamicStack(int size){
        super(size);
    }

    @Override
    protected boolean push(int element){
        if (isFull()){
            int temp[]=new int[stack.length*2];
            for(int i=0;i< stack.length;i++){
                temp[i]=stack[i];
            }
            stack=temp;
        }
        return super.push(element);
    }
}
