import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    String code;
    String title;
    String teacher;
    String schedule;
    private List<String> studentIDs ;
    private Map<String,Map<String,Grade>> studentGrades;

    public Course(String code, String title, String teacher,String schedule) {
        this.code = code;
        this.title = title;
        this.teacher = teacher;
        this.studentIDs = new ArrayList<>();
        this.schedule=schedule;
        this.studentGrades = new HashMap<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getTeacher() {
        return teacher;
    }

    public List<String> getStudentIDs() {
        return studentIDs;
    }

    public String getShedule() {
        return schedule;
    }

    public void addStudent(String studentID){
        studentIDs.add(studentID);
        studentGrades.put(studentID,new HashMap<>());
    }
     public void addGrade(String studentId,String dayOfWeek,Grade grade){
      if(studentGrades.containsKey(studentId)){
          studentGrades.get(studentId).put(dayOfWeek,grade);
      }else{
          System.out.println("Student with id not exist");
      }
     }
     public Map<String, Grade> getGrades(String studentID){
        return studentGrades.getOrDefault(studentID,new HashMap<>());
     }
    public void deleteStudent(String studentID){
        studentIDs.remove(studentID);
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", teacher='" + teacher + '\'' +
                ", schedule='" + schedule + '\'' +
                ", studentIDs=" + studentIDs +
                '}';
    }
}