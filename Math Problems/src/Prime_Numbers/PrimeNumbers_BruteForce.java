package Prime_Numbers;
public class PrimeNumbers_BruteForce {
    public static void main(String[] args) {
        int n=113;
        printPrimeNumbersBetterApproach(n);
    }

    static void printPrimeNumbersBetterApproach(int n){
        if(n<2){
            return;
        }
        for(int i=2;i<=n;i++){
            int flag=0;
            for(int j=2;j*j<i;j++){
                if(i%j==0){
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                System.out.printf("%d ",i);
        }
    }

    static void printPrimeNumbers(int n){
        if(n<2){
            return;
        }
        for(int i=2;i<=n;i++){
            int flag=0;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                System.out.printf("%d ",i);
        }
    }

    static Boolean checkPrime(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    static Boolean checkPrimeBetterApproach(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
