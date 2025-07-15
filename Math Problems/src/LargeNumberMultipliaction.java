class LargeNumberMultipliaction {
    public String multiplyStrings(String s1, String s2) {
        // code here
        boolean negative=false;
        if(s1.length()>0 && s1.charAt(0)=='-'){
            negative=!negative;
            s1=s1.substring(1);
        }
        if(s2.length()>0 && s2.charAt(0)=='-'){
            negative=!negative;
            s2=s2.substring(1);
        }
        s1=removeZero(s1);
        s2=removeZero(s2);
        int n=s1.length();
        int m=s2.length();
        int prod,num1,num2;
        if(s1=="0" || s2=="0")
            return "0";
        int result[]=new int[n+m];
        for(int i=n-1;i>=0;i--){
            num1=s1.charAt(i)-'0';
            for(int j=m-1;j>=0;j--){
                num2=s2.charAt(j)-'0';
                prod=num1*num2+result[i+j+1];
                result[i+j+1]=prod%10;
                result[i+j]+=prod/10;
            }
        }
        StringBuilder mul=new StringBuilder();
        int i=0;
        while(i<result.length && result[i]==0)
            i++;
        for(;i<result.length;i++){
            mul.append(result[i]);
        }
        if(negative){
            mul.insert(0,'-');
        }
        return mul.toString();
    }

    static String removeZero(String s){
        int i=0;
        while(i<s.length() && s.charAt(i)=='0'){
            i++;
        }
        return i==s.length()?"0":s.substring(i);
    }
}