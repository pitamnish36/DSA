package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandlingArray {
    public static List<Integer> result =new ArrayList<>();
    public static void main(String[] args) {
        int nums[]={1,5,4,7,5,14,9,4,52,4,8,4};
        int target=4;
        search(nums,0,target);
        System.out.println(result);
        List<Integer> indexList=new ArrayList<>();
        searchWithParameterList(nums,0,target,indexList);
        System.out.println(indexList);
        System.out.println(searchWithListInBody(nums,0,target));
    }
    public static void search(int[] nums,int i,int target){
        if(i==nums.length){
            return;
        }
        if(nums[i]==target){
            result.add(i);
        }
        search(nums,i+1,target);
    }

    public static void searchWithParameterList(int []nums,int i,int target,List<Integer> result){
        if(i==nums.length){
            return;
        }
        if(nums[i]==target){
            result.add(i);
        }
        searchWithParameterList(nums,i+1,target,result);
    }

    public static List<Integer> searchWithListInBody(int []nums, int i, int target){
        ArrayList<Integer> res=new ArrayList<>();
        if(i==nums.length){
            return res;
        }
        if(nums[i]==target){
            res.add(i);
        }
        List<Integer> internal=searchWithListInBody(nums,i+1,target);
        res.addAll(internal);
        return res;
    }
}
