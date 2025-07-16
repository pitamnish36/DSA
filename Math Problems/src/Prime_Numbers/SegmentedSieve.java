package Prime_Numbers;

import java.util.ArrayList;
import java.util.Arrays;

public class SegmentedSieve {
    static int n=1000000;
    static Boolean sieve[]=new Boolean[n+1];
    static ArrayList<Integer> primeList=new ArrayList<>();

    public static void main(String[] args) {
        int l=100_000_000;
        int r=100_060_000;
        createSieve();
        segmentedSieve(l,r);

    }

    static void segmentedSieve(int l,int r){
        ArrayList<Integer> primes=generatePrime((int)Math.sqrt(r));

        int dummy[]=new int[r-l+1];
        for(int i=0;i<r-l+1;i++){
            dummy[i]=1;
        }

        for(int prime:primes){
            int firstMultiple =(int)(l/prime)*prime;
            if(firstMultiple<l)
                firstMultiple+=prime;
            for(int j=Integer.max(firstMultiple,prime*prime);j<=r;j+=prime){
                dummy[j-l]=0;
            }
        }

        for(int i=l;i<=r;i++){
            if(dummy[i-l]==1){
                System.out.printf("%d ",i);
            }
        }

    }

    static ArrayList<Integer> generatePrime(int n){
        ArrayList<Integer> primes=new ArrayList<>();
        for (int i=2;i<=n;i++) {
            if(sieve[i]){
                primes.add(i);
            }
        }
        return primes;
    }

    static void createSieve(){
        Arrays.fill(sieve,false);
        sieve[2]=true;
        for(int i=3;i<=n;i++){
            if(i%2!=0)
            sieve[i]=true;
        }
        for(int i=2;i*i<=n;i++){
            for(int j=i*i;j<=n;j+=i){
                if(sieve[j]){
                    sieve[j]=false;
                }
            }
        }
    }
}
