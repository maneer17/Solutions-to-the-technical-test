import java.util.InputMismatchException;
import java.util.Scanner;
public class Fibonacci {
    public static void main (String [] args){
        Scanner input=new Scanner(System.in);
        while(true){
            System.out.println("Enter a positive number or zero ");
            try{
            int n=input.nextInt();
            if(n>=0){
                System.out.println(fib(n));
                break;}
            }
            catch(InputMismatchException e) {
                System.out.println("Please Enter A positive integer or a zero DO not enter text!");
                input.next();
            }
        }

    }
    static int fib(int n){ // using recursion
        if(n==0|| n==1)
            return n;
        return fib(n-1)+fib(n-2);
    }
    static int fib2(int n){ // using iteration
        if(n==1||n==0)
            return n;
        int prev=0;
        int curr=1;
        int result=0;
        for(int i=2;i<=n;++i){
            result=prev+curr;
            prev=curr;
            curr=result;
        }
        return result;
    }
}
