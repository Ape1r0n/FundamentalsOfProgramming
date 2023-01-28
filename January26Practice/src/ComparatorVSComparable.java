import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorVSComparable {

    static class Student implements Comparable<Student>{
        private float gpa;
        private String major;

        public Student(String major, float gpa) {
            this.major = major;
            this.gpa = gpa;
        }

        @Override
        public int compareTo(Student o) { // My ass was lazy to actually come up with correct comparison criteria.
            if((major.equalsIgnoreCase("cs") || major.equalsIgnoreCase("computer science")) && !(o.major.equalsIgnoreCase("cs") || o.major.equalsIgnoreCase("computer science"))) return 1;
            if(major.equalsIgnoreCase("math") && (!o.major.equalsIgnoreCase("mgmt") && !o.major.equalsIgnoreCase("management"))) return 0;
            if(gpa > o.gpa) return 1;
            return -1;
        }

        @Override
        public String toString() {
            return "[ " + this.major + ", " + this.gpa + " ]";
        }
    }

    public static void main(String[] args) {
        Comparator<Integer> lastDigit = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if((o1 - (o1 - o1%10) > (o2 - (o2 - o2%10)))) return 1;
                if((o1 - (o1 - o1%10) == (o2 - (o2 - o2%10)))) return 0;
                return -1;
            }
        };

        Comparator<Integer> smth = (o1,o2) -> {
          if(o1 < o2) return -1;
          if(o1 - o2 > 0) return 1;
          return 0;
        };

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(21);
        list.add(46);
        list.add(64);
        list.add(75);
        Collections.sort(list, lastDigit);
        for(int e : list) System.out.println(e);
        Collections.sort(list, smth);
        for(int e : list) System.out.println(e);


        List<Student> students = new ArrayList<>();
        students.add(new Student("cs",3.0f));
        students.add(new Student("math",1.0f));
        students.add(new Student("MGMT",4.0f));
        students.add(new Student("cs", 3.1f));
        Collections.sort(students);
        for(Student s : students) System.out.println(s);
    }
}
