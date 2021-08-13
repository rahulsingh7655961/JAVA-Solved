import java.util.Scanner;

class array{
    public static void main(String[] args) {
       //int[] a = {1,2,3,4,5};
       Scanner sc = new Scanner(System.in);
       int a[] = new int[sc.nextInt()];
       for(int i=0;i<a.length;i++)
        a[i] = sc.nextInt();
        for (int element : a)
            System.out.print(element+"::");
        System.out.println();
        for(int i:a)
        System.out.print(i+"==");
        sc.close();
       
    }
}