package example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов Иван Иванович", "П-11", 1, 4, 3, 5));
        students.add(new Student("Чехов Антон Павлович", "П-11", 1, 4, 4, 5));
        students.add(new Student("Сидоров Петр Степанович", "Э-13", 1, 3, 2, 2));
        students.add(new Student("Пучков Сергей Анатольевич", "П-22", 2, 3, 4, 5));
        System.out.println(students);
        studentRemove(students);
        System.out.println(students);
        upCourse(students);
        System.out.println(students);
        System.out.println();
        printStudents(students, 2);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact(456123, "Иванов");
        phoneBook.addContact(789654, "Петров");
        phoneBook.addContact(456789, "Иванов");
        phoneBook.addContact(321654, "Чайкин");

        System.out.println(phoneBook.getNumber("Иванов"));
    }

    private static void studentRemove(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverage() < 3) {
                students.remove(i);
                i--;
            }
        }
    }

    private static void upCourse(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverage() >= 3) {
                students.get(i).upCourse();
            }
        }
    }

    private static void printStudents(List<Student> students, int course) {
        System.out.println("Список студентов " + course + "-го курса:");
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCourse() == course) {
                System.out.println(students.get(i).getName());
            }
        }
    }
}
