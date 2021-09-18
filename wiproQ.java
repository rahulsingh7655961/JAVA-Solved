import java.util.*;

class wiproQ{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input1 = sc.nextInt();
        int input2 = sc.nextInt();
        int input3 = sc.nextInt();

        int ans = findkey(input1,input2,input3);
        System.out.println(ans);

        sc.close();
    }

    private static int findkey(int input1, int input2, int input3) {
        String[] arr = new String[3];

        arr[0] = String.valueOf(input1);
        arr[1] = String.valueOf(input2);
        arr[2] = String.valueOf(input3);

        
        int m1 = 10, m2 = 10 ,m3 = 10 ,m4 = 10;
        for(int i=0;i<3;i++){
            m1 = Math.min(m1,Character.getNumericValue(arr[i].charAt(0)));
            m2 = Math.min(m2,Character.getNumericValue(arr[i].charAt(1)));
            m3 = Math.min(m3,Character.getNumericValue(arr[i].charAt(2)));
            m4 = Math.min(m4,Character.getNumericValue(arr[i].charAt(3)));
        }
        String ans = String.valueOf(m1) + String.valueOf(m2) + String.valueOf(m3) + String.valueOf(m4);
        return Integer.parseInt(ans);
    }
}