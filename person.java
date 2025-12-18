public class Person {

    String id;
    String name;
    String entryTime;

    public Person(String id, String name, String entryTime) {
        this.id = id;
        this.name = name;
        this.entryTime = entryTime;
    }

    public boolean validateID() {
        if (id.startsWith("ST") && id.length() == 8) return true;
        if (id.startsWith("SF") && id.length() == 7) return true;
        return false;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Entry Time: " + entryTime);
    }
}
