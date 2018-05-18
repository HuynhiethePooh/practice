public class HelloWorld{

     public static void main(String []args){
        HelloWorld testing = new HelloWorld();
        int[] arrayOne = {1,4,52,33,8,9, 81, 72,4,1,6342,100};
        testing.mergesort(arrayOne);
        System.out.println("Hello World");
        for (int i = 0; i < arrayOne.length; i++){
            System.out.println(arrayOne[i]);
        }
     }
     
     //call mergesort and create a helper array to maintain the data when we sort
     public void mergesort(int[] a){
         int[] helper = new int[a.length];
         mergesort(a, helper, 0, a.length -1);
     }
     
     
     public void mergesort(int[] a, int[] helper, int low, int high){
         //check if low < high so we can stop when we are at the base case (when low = high aka lowest level)
         if (low < high){
         int middle = (low + high)/2;
         mergesort(a, helper, low, middle);
         mergesort(a, helper, middle + 1, high);
         merge(a, helper, low, middle, high);
        }
     }
     
     
     public void merge(int[] a, int[] helper, int low, int middle, int high){

        
        //copy array
        for( int i = low; i <= high; i++){
            helper[i] = a[i];
        }
        
        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;
        
        while (helperLeft <= middle && helperRight <= high){
            if (helper[helperLeft] <= helper[helperRight]){
                a[current] = helper[helperLeft];
                helperLeft++;
            }
            else{
                a[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++){
            a[current + i] = helper[helperLeft + i];
        }
     }
}
