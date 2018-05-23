import java.io.*;
import java.util.*;

public class StackWithMin2 extends Stack<Integer>{
    Stack<Integer> s2;
    public StackWithMin2(){
        s2 = new Stack<Integer>();
    }
    
    public void push(int value){
        if (value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }
    
    public Integer pop(){
        int value = super.pop();
        if (value == min()){
            s2.pop();
        }
        return value;
    }
    
    public int min(){
        if (s2.isEmpty()){
            return Integer.MAX_VALUE;
        }
        else {
            return s2.peek();
        }
    }
     public static void main(String []args){
        StackWithMin2 exStack = new StackWithMin2();
        exStack.push(5);
        exStack.push(1);
        exStack.pop();
        exStack.push(5);
        exStack.push(7);

        System.out.println("Minimum value is: " + exStack.min());
     }
}
