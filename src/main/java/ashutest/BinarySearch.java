package ashutest;

public class BinarySearch {

    public int binarySearch(int [] arr,int value)
    {
        int low =  0;
        int high =  arr.length - 1;
        while(low<high)
        {
            int mid = (low + (high -low) )/2;
            if(arr[mid] == value)
                return mid + 1;
            else if( arr[mid] < value)
                low = mid +1;
            else
                high = mid -1;


        }
        return -1;
    }

    public static void main(String [] args)
    {
        int arr [] = { 1,5,7,10,15,20,25};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(arr,10));
    }
}
