public class Staff extends Person {

    String department;
    String shift;

    public Staff(String id, String name, String entryTime,
                 String department, String shift) {

        super(id, name, entryTime);
        this.department = department;
        this.shift = shift;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Shift: " + shift);
    }
}
