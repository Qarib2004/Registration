import java.util.ArrayList;
import java.util.List;

public class Student {
    String id;
    String name;
    String surname;
    private List<String> courseCodes ;

    public Student(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.courseCodes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<String> getCourseCodes() {
        return courseCodes;
    }
    public void registerCourse(String courseCode){
        if(!courseCodes.contains(courseCode)){
            courseCodes.add(courseCode);
        }
    }
    public void deletedCourse(String courseCode){

            courseCodes.remove(courseCode);

    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", courseCodes=" + courseCodes +
                '}';
    }
}