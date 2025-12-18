public class Student extends Person {

    String department;
    int semester;
    int marks[];
    double cgpa;

    public Student(String id, String name, String entryTime,
                   String department, int semester, int marks[]) {

        super(id, name, entryTime);
        this.department = department;
        this.semester = semester;
        this.marks = marks;

        computeCGPA();
    }

    public void computeCGPA() {
        int total = 0;
        for (int m : marks) total += m;
        cgpa = (total / marks.length) / 10.0;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Semester: " + semester);
        System.out.println("CGPA: " + cgpa);
    }
}
