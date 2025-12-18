package campus;
import java.util.Scanner;
public class CampusSystem { static Person logs[] = new Person[300]; static int logCount = 0; public static void main(String[] args) { Scanner sc = new Scanner(System.in);
while (true) {
System.out.println("\n----- CAMPUS MENU -----");
System.out.println("1. Enter Campus"); System.out.println("2. Add Student");
System.out.println("3. View Logs");
System.out.println("4. View Late Entries");
System.out.println("5. Exit"); System.out.print("Enter choice: ");
int ch = sc.nextInt(); sc.nextLine();
if (ch == 1) enterCampus(sc); else if (ch == 2) addStudent(sc); else if (ch == 3) viewLogs(); else if (ch == 4) viewLate(); else if (ch == 5) break;
else System.out.println("Invalid Choice!");
} } public static void enterCampus(Scanner sc) {
System.out.print("Enter ID: ");
String id = sc.nextLine();
System.out.print("Enter Name: ");
String name = sc.nextLine();
System.out.print("Enter Entry Time (HH:MM): ");
String time = sc.nextLine();
Person p;
if (id.startsWith("ST"))
p = new Student(id, name, time, "CS", 1, new int[]{80, 85, 90});
else if (id.startsWith("SF"))
p = new Staff(id, name, time, "CS", "Morning"); else {
System.out.println("Access Denied: Invalid Role"); return; }
if (!p.validateID()) {
System.out.println("Invalid ID Format!"); return; } logs[logCount++] = p;
System.out.println("Entry Recorded!");
} public static void addStudent(Scanner sc) {
System.out.print("ID: ");
String id = sc.nextLine();
System.out.print("Name: ");
String name = sc.nextLine();
System.out.print("Entry Time: ");
String et = sc.nextLine();
System.out.print("Department: ");
String dept = sc.nextLine();
System.out.print("Semester: "); int sem = sc.nextInt();
sc.nextLine();
int marks[] = new int[3]; System.out.println("Enter 3 marks:");
for (int i = 0; i < 3; i++)
marks[i] = sc.nextInt(); sc.nextLine();
Student s = new Student(id, name, et, dept, sem, marks);
logs[logCount++] = s;
System.out.println("Student Record Added!");
} public static void viewLogs() { if (logCount == 0) {
System.out.println("\nNo entries found!"); return;
}
System.out.println("\n--- All Campus Entries ---");
for (int i = 0; i < logCount; i++) {
System.out.println("\n--- Entry " + (i + 1) + " ---");
logs[i].displayInfo();
} } public static void viewLate() { if (logCount == 0) {
System.out.println("\nNo entries found!"); return; } boolean lateFound = false;
System.out.println("\n--- Late Entries ---");
for (int i = 0; i < logCount; i++) {
Person p = logs[i]; String time = p.entryTime;
if (p instanceof Student && time.compareTo("09:30") > 0) {
p.displayInfo();
System.out.println("Status: Late Student\n"); lateFound = true;
} if (p instanceof Staff && time.compareTo("08:45") > 0) {
p.displayInfo();
System.out.println("Status: Late Staff\n");
lateFound = true;
} }
if (!lateFound) {
System.out.println("No late entries found!");
}
}
}
