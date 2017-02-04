package elementary;

class Student {
    private String firstName;
    private String lastName;
    private float gradesAverage;

    public Student(String firstName, String lastName, float gradesAverage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradesAverage = gradesAverage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getGradesAverage() {
        return gradesAverage;
    }

    public void setGradesAverage(float gradesAverage) {
        this.gradesAverage = gradesAverage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gradesAverage=" + gradesAverage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (Float.compare(student.gradesAverage, gradesAverage) != 0) return false;
        if (!firstName.equals(student.firstName)) return false;
        return lastName.equals(student.lastName);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (gradesAverage != +0.0f ? Float.floatToIntBits(gradesAverage) : 0);
        return result;
    }
}