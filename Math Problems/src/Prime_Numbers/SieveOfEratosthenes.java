package Prime_Numbers;
import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes {
    static int n=1000001;
    static ArrayList<Integer> primesList=new ArrayList<>();
    static Boolean sieve[]=new Boolean[n];
    public static void main(String[] args) {
        int num=30;
        createSieve();
        for(int i=0;i<=num;i++){
            System.out.printf("%d ",primesList.get(i));
        }
    }

    static void createSieve(){
        sieve[2]=true;
        Arrays.fill(sieve,false);
        for(int i=3;i<n;i++){
            if(i%2!=0)
                sieve[i]=true;
        }
        for(int i=2;i*i<=n;i++){
            for(int j=i*i;j<n;j+=i){
                if(sieve[j]){
                    sieve[j]=false;
                }
            }
        }

        for(int i=2;i<n;i++){
            if(sieve[i])
                primesList.add(i);
        }

    }

}
