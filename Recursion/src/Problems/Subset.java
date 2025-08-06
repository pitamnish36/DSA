package Problems;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int nums[]={1,2,3};
        System.out.println(subsetWithoutRecursion(nums));
    }
    static List<List<Integer>> subsetWithoutRecursion(int []nums){
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num:nums){
            int size=outer.size();
            for(int i=0;i<size;i++) {
                List<Integer> internal=new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
}
