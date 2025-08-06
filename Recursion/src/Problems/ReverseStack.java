package Problems;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("stack before reverse: "+s);
        StkReverse(s);
        System.out.println("stack after reverse: "+s);
    }
    static void StkReverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int removed=s.pop();
        StkReverse(s);
        insertAtBottom(s,removed);
    }

    static void insertAtBottom(Stack<Integer> s, int tmp)
    {
        if(s.isEmpty())
        {
            s.push(tmp);
            return ;
        }
        int top = s.pop();
        insertAtBottom(s, tmp);
        s.push(top);
        String str="111";
    }
}
