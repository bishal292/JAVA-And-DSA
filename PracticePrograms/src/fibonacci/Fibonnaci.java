package fibonacci;

public class Fibonnaci {
	static int fibnocciNthTerm(int n) {

        // if(n<=1){
        //     return n;
        // }else{
        //     return fib(n-1)+fib(n-2);
        // }
        
        // The above one is recursive approach but below one is more efficient.

        if(n<=0){
            return n;
        }
        int[] fibseq=new int[n+1];
        fibseq[0] =0;
        fibseq[1] =1;
        for(int i=2;i<=n;i++){
            fibseq[i]=fibseq[i-1]+fibseq[i-2];
        }
        return fibseq[n];
        
	}
	
	
    public static void main(String[] args) {
    	
    }
}
