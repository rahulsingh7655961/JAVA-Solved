package Collections;
import java.util.*;
public class MainClass {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(56, "Raj"));
        students.add(new Student(93, "Rahul"));
        students.add(new Student(87, "Aman"));
        students.add(new Student(33, "Raj"));
        students.add(new Student(33, "Subham"));

        //Collections.sort(students,new SortByNameThenMarks());

        /*Collections.sort(students,new Comparator<Student>(){
            public int compare(Student o1,Student o2){
                if(o1.name.equals(o2.name))
                    return o1.marks - o2.marks;
                else 
                return o1.name.compareTo(o2.name);
            }
        });*/
       /* Collections.sort(students,( o1, o2)->{
                if(o1.name.equals(o2.name))
                    return o1.marks - o2.marks;
                else 
                return o1.name.compareTo(o2.name);
        });*/
        //Collections.sort(students,( o1, o2)->o1.name.compareTo(o2.name));
        Collections.sort(students,Comparator.comparing(Student::getName).thenComparing(Student::getMarks).reversed());
        students.forEach(System.out::println);//Lambda method
    }
}
/*class SortByNameThenMarks implements Comparator<Student>{

    public int compare(Student o1,Student o2){
        if(o1.name.equals(o2.name))
            return o1.marks - o2.marks;
        else 
        return o1.name.compareTo(o2.name);
    }
}*/