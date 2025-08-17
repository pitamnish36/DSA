package Problems;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int nums[]={1,2,2};
        //System.out.println(subsetWithoutRecursion(nums));
        System.out.println(stringSubset("aab",""));
        List<List<Integer>> subsets=new ArrayList<>();
        List<Integer> subList=new ArrayList<>();
        subsetWithDuplicates(nums,0,subList,subsets);
        System.out.println(subsets);
    }

    static void subset(int []nums,int start,List<Integer> subList,List<List<Integer>> subsets){
        if(start==nums.length){
            subsets.add(subList);
            return;
        }
        subset(nums,start+1,new ArrayList<Integer>(subList),subsets);
        subList.add(nums[start]);
        subset(nums,start+1,new ArrayList<Integer>(subList),subsets);
    }

    static void subsetWithDuplicates(int []nums,int index,List<Integer> subList,List<List<Integer>> subsets){
        if(index==nums.length){
            subsets.add(subList);
            return;
        }
        List<Integer> include=new ArrayList<>(subList);
        include.add(nums[index]);
        subset(nums,index+1,include,subsets);
        int nextIndex=index+1;
        while(nextIndex<nums.length && nums[nextIndex]==nums[index]){
            nextIndex++;
        }

        List<Integer> exclude=new ArrayList<>(subList);
        subset(nums,nextIndex+1,exclude,subsets);
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

    static List<String> stringSubset(String u,String p){
        List<String> list=new ArrayList<>();
        if(u.length()==0){
            list.add(p);
            return list;
        }
        char ch=u.charAt(0);
        List<String> left=stringSubset(u.substring(1),p);
        List<String> right =stringSubset(u.substring(1),p+ch);
        right.addAll(left);
        return right;
    }

    static List<String> stringSubsetWithDuplicates(String u,String p){
        List<String> list=new ArrayList<>();
        if(u.length()==0){
            list.add(p);
            return list;
        }
        char ch=u.charAt(0);
        List<String> left=stringSubset(u.substring(1),p);
        List<String> right =stringSubset(u.substring(1),p+ch);
        right.addAll(left);
        return right;
    }

}
