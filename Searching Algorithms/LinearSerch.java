import java.util.*;

public class LinearSerch {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in); 
        System.out.println("Enter Array Size");
        int size = input.nextInt();
        int [] List=  new int[size];
        System.out.println("Enter what value to look for");
        int val = input.nextInt();
        System.out.println("Fill the array with values, do not exceed the size limit");

        for(int i = 0; i < size; ++i){
            int elements = input.nextInt(); 
            List[i] = elements;
        }
        System.out.println("This is the list: " + Arrays.toString(List)); 
        LinearSearch(List, val);

    }

    public static int LinearSearch(int [] arr, int value){

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == value){
                System.out.println("Found at index " + i);
            } 
        }
        return value;
    }
}
