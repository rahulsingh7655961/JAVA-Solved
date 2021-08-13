import java.util.ArrayList;

class array_list{
    public static void main(String[] args) {
        ArrayList<Integer> AL = new  ArrayList<>();
        var AL1 = new  ArrayList<Integer>();

        AL.add(1);
        AL.add(2);
        AL.add(3);
        AL.add(4);
        AL.set(3,44);
        AL.remove(3);

        AL1.add(10);
        AL1.add(20);
        AL1.add(30);
        AL1.add(40);
        
        AL.addAll(AL1);
        System.out.println(AL.containsAll(AL1));

        //AL.remove(5);
        //AL.set(5,30);

       // AL.toArray();

        //AL.removeAll(AL1);
        
        System.out.println(AL.get(2));
        System.out.println(AL);
        System.out.println(AL.size());
       // AL.clear();
       


    }
}