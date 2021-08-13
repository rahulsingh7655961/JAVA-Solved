package MyImplimentation;
import LinkedList.MyLinkedList;

public class MyLLImplimentation {
    public static void main(String[] args) {
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.addAt(0,5);
        ll.addAt(3,25);
        ll.remove();
        ll.removeAt(1);
        ll.deleteAt(2);
        ll.print();
        ll.reversePrint();
       
    }
}
