package example;

public class Student {
    private String name;
    private String group;
    private int course;
    private int algebraAssessment;
    private int physicsAssessment;
    private int biologyAssessment;

    public Student(String name, String group, int course, int algebraAssessment, int physicsAssessment, int biologyAssessment) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.algebraAssessment = algebraAssessment;
        this.physicsAssessment = physicsAssessment;
        this.biologyAssessment = biologyAssessment;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void upCourse() {
        course++;
    }

    public int getAlgebraAssessment() {
        return algebraAssessment;
    }

    public int getPhysicsAssessment() {
        return physicsAssessment;
    }

    public int getBiologyAssessment() {
        return biologyAssessment;
    }

    public double getAverage() {
        return (double) (algebraAssessment + physicsAssessment + biologyAssessment) / 3;
    }

    @Override
    public String toString() {
        return "\n" + name + " " +
                group + " " +
                course + "  " +
               "Оценки: " + algebraAssessment + " " + physicsAssessment + " " + biologyAssessment + " " +
                "Средняя оценка: " + getAverage();
    }
}
