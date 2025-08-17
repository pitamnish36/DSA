import java.util.ArrayList;
import java.util.PriorityQueue;

public class HeapSort {
    public static ArrayList<Integer> heap;

    public static void main(String[] args) {
        heap=createHeap();
        insert(5);
        insert(7);
        insert(4);
        insert(8);
        insert(2);
        insert(9);
        insert(10);
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        queue.add(5);
        queue.add(7);
        queue.add(4);
        queue.add(8);
        queue.add(2);
        queue.add(9);
        queue.add(10);
        for(int num:queue){
            System.out.println(num);
        }
        //heapSort();
    }
    public static ArrayList<Integer> createHeap() {
        ArrayList<Integer> heap = new ArrayList<>();
        return heap;
    }

    public static int getParent(int index) {
        return (index) / 2;
    }

    public static int getLeft(int index) {
        return 2 * index + 1;
    }

    public static int getRight(int index){
        return 2*index +2;
    }

    public static void insert(int node){
        heap.add(node);
        int index=heap.size()-1;
        upheap(index);
    }

    public static int remove(){
        int last=heap.size()-1;
        int el=heap.get(0);
        heap.set(0,heap.get(last));
        heap.remove(last);
        downheap(0);
        return el;
    }

    public static void heapSort(){
        while(!heap.isEmpty()){
            System.out.println(remove());
        }
    }

    public static void downheap(int index){
        int left=getLeft(index);
        int right=getRight(index);
        int size=heap.size()-1;
        if(left<=size && heap.get(left)>heap.get(index)){
            swap(left,index);
            downheap(left);
        }
        if(right<=size && heap.get(right)>heap.get(index)){
            swap(right,index);
            downheap(right);
        }
    }

    public static void upheap(int index){
        int parent=getParent(index);
        if(parent>=0 && heap.get(index)>heap.get(parent)){
            swap(index,parent);
            upheap(parent);
        }
    }

    public static void swap(int idx1,int idx2){
        int temp=heap.get(idx1);
        heap.set(idx1,heap.get(idx2));
        heap.set(idx2,temp);
    }
}


