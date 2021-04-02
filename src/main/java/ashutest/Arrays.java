package ashutest;

public class Arrays {

    public static void main(String [] args) {
        int[] arr = new int[]{4, 2, 5, 7, 8, 9,10};

        int max[] = new int[7];
        int min[] = new int[7];
        max[0] = arr[0];
        min[6] = arr[6];
        for (int i = 1; i < 7; i++) {
            if (arr[i] < max[i - 1]) {
                max[i] = max[i - 1];
            } else {
                max[i] = arr[i];

            }
        }
        for (int i = 5; i >= 0; i--) {
            if (arr[i] < min[i + 1]) {
                min[i] = arr[i];
            } else {
                min[i] = min[i + 1];

            }
        }

        for (int elem:max) {
            System.out.println(elem);

        }
        System.out.println("min elem");


        for (int elem:min) {
            System.out.println(elem);

        }

        for(int i =1 ;i < 7;i++){
            if(arr[i] >= max[i-1] && arr[i] <= min[i+1])
            {
                System.out.println("Number is :" + arr[i]);
                break;
            }

        }

        }
    }

