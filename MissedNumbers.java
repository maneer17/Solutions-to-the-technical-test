import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.*;
public class MissedNumbers {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^(\\d+)(,\\d+)*$");
        // regular expression on the form of a series of number
        Scanner input=new Scanner(System.in);
        while(true) {
            System.out.println("Enter a series of numbers like this format : 1,3,4,2,...");
            String series = input.next(); // taking an input form the user
            Matcher matcher = pattern.matcher(series);
            // checking if the user input matches the regular expression
            if (matcher.matches()) {
                // if it matches create an arraylist to store these numbers
                String[] stringArray = series.split(",");
                ArrayList<Integer> arr = new ArrayList<Integer>();
                for (String s : stringArray)
                    arr.add(Integer.parseInt(s));
                ArrayList<Integer>missednumbers=missingnumbers(arr); // call the missing numbers function
                if(missednumbers.isEmpty())
                    System.out.println("there's no missing numbers");
                else{
                System.out.println("missing numbers are : ");
                for(int num:missednumbers)
                    System.out.println(num);
                }

                break;
            }
            // if it isn't not on the right format make the user to enter again
            System.out.println("please Enter a series of numbers in the right format ");

        }
           }
public static ArrayList<Integer> missingnumbers(ArrayList<Integer> arr){
        // sort the arraylist
        Collections.sort(arr);
        ArrayList<Integer> missednumbers=new ArrayList<>();
        for(int i=0,j=1;j<=arr.size()-1;++i,++j){
            int prev=arr.get(i); // get the current element and the next element in the list
            int next=arr.get(j);
            for(int l=prev+1;next>l;++l)
                // if the next is actually the next number meaning next-pre equals 1 or zero " if they're the same num"
                // the inner loop won't be excuted
                missednumbers.add(l); // add the missing number to the list of missing numbers 
        }
        return missednumbers;
}
    }
