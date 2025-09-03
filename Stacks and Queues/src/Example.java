public class Example {
    public static void main(String[] args) throws Exception {
        //StackADT dynamicStack=new StackADT();
//        System.out.println(dynamicStack.push(5));
//        System.out.println(dynamicStack.push(4));
//        System.out.println(dynamicStack.push(3));
//        System.out.println(dynamicStack.peek());

        DynamicStack dynamicStack=new DynamicStack();
        System.out.println(dynamicStack.push(5));
        System.out.println(dynamicStack.push(4));
        System.out.println(dynamicStack.push(3));
        System.out.println(dynamicStack.push(2));
        System.out.println(dynamicStack.push(1));
        System.out.println(dynamicStack.push(0));
        System.out.println(dynamicStack.peek());

    }
}
