package Problems;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        String str="abc";
        List<StringBuilder> permutations=new ArrayList<>();
        //permutation(str,"",permutations);
//        System.out.println(permutations);
//        System.out.println(countPermutation(str,""));

//        List<List<Integer>> result=new ArrayList<>();
//        int nums[]={1,2,3};
//        permutationInteger(nums,new ArrayList<Integer>(),result);
//        System.out.println(result);

        permutationString(str,"ab",new StringBuilder(),permutations);
        System.out.println(permutations);
    }
    public static void permutation(String u,String p,List<String> result){
        if(u.isEmpty()){
            result.add(p);
            return;
        }
        char ch=u.charAt(0);
        List<Character> repeat=new ArrayList<Character>();
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i);
            permutation(u.substring(1),f+ch+s,result);
        }
    }

    public static void permutationString(String str,String target,StringBuilder subStr,List<StringBuilder> result){
        if(subStr.length()==str.length()){
            return;
        }
        for(int i=0;i<str.length();i++){
            if(subStr.indexOf(String.valueOf(str.charAt(i)))!=-1){
                continue;
            }
            subStr.append(str.charAt(i));
            //result.add(new StringBuilder(subStr));
            permutationString(str,target,subStr,result);
            subStr.deleteCharAt(subStr.length()-1);
        }
//        if(tempList.size()==nums.length){
//            result.add(new ArrayList<>(tempList));
//            return;
//        }
//        for(int i=0;i<nums.length;i++){
//            if(tempList.contains(nums[i]))
//                continue;
//            tempList.add(nums[i]);
//            permutationInteger(nums,tempList,result);
//            tempList.remove(tempList.size()-1);
//        }

    }



    public static void permutationInteger(int []nums,List<Integer> tempList,List<List<Integer>> result){
        if(tempList.size()==nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
            for(int i=0;i<nums.length;i++){
                if(tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                permutationInteger(nums,tempList,result);
                tempList.remove(tempList.size()-1);
            }

    }

    public static void allPermutationInteger(int []nums,List<Integer> tempList,List<List<Integer>> result){
        if(tempList.size()==nums.length){
            //result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(tempList.contains(nums[i]))
                continue;
            tempList.add(nums[i]);
            result.add(new ArrayList<>(tempList));
            permutationInteger(nums,tempList,result);
            tempList.remove(tempList.size()-1);
        }

    }

    public static int countPermutation(String u,String p){
        if(u.isEmpty()){
            return 1;
        }
        char ch=u.charAt(0);
        int count=0;
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i);
            count+=countPermutation(u.substring(1),f+ch+s);
        }
        return count;
    }
}
