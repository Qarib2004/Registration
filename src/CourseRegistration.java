import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CourseRegistration {
    static HashMap<String,Course> courses = new HashMap<>();
    static HashMap<String,Student> students = new HashMap<>();
    static Student student;
    static Course course;
    static Scanner console = new Scanner(System.in);

    static void menu(){
        System.out.println("\tWelcome to the course registration system!");
        System.out.println("1. Show available courses");
        System.out.println("2. Registration for the course");
        System.out.println("3. Exit from the course");
        System.out.println("4. Show schedule");
        System.out.println("5. Show on going courses student");
        System.out.println("6. Show student on going course");
        System.out.println("7. Add grade to student");
        System.out.println("8. Get grade for student");
        System.out.println("9. Show student");
        System.out.println("S. Stop");
        System.out.print("Enter option: ");

    }
    public static void run(){
        boolean flag = true;

        while(flag){
            menu();
            char option = console.nextLine().charAt(0);
            switch (option){
                case '1':
                   showCourses();
                   break;
                case '2':
                    registerCourse();
                    break;
                case '3':
                    exitCourse();
                    break;
                case '4':
                    showSchedule();
                    break;
                case '5':
                    searchCourse();
                    break;
                case '6':
                    searchStudent();
                    break;
                case '7':
                    addGradeStudents();
                    break;
                case '8':
                    getGradeStudent();
                    break;
                case '9':
                    showStudents();
                    break;
                case 'S':
                    flag=false;
                    System.out.println("Exit program");
                    break;
                default:
                    System.out.println("Option not exist");
                    break;
            }
        }
    }

    public static void addStudent(Student student){
        students.put(student.getId(), student);
    }
    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
    }

//    public static void deleteCourse(){
//        courses.put(course.getCode(), course);
//    }

    public static void showCourses(){
        for(Course course: courses.values()){
            System.out.println(course.toString());
        }
    }
    public static void showStudents(){
        for(Student student : students.values()){
            System.out.println(student.toString());
        }
    }
    public static void registerCourse(){
        System.out.print("Enter ID student: ");
        String studentID = console.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = console.nextLine();
        if(students.containsKey(studentID) && courses.containsKey(courseCode)){
            students.get(studentID).registerCourse(courseCode);
            courses.get(courseCode).addStudent(studentID);
            System.out.println("The student has successfully registered for the course.");
        }else{
            System.out.println("The student has not successfully registered for the course.");
        }
    }
    public static void exitCourse(){
        System.out.print("Enter ID student: ");
        String studentID = console.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = console.nextLine();
        if(students.containsKey(studentID) && courses.containsKey(courseCode)){
            students.get(studentID).deletedCourse(courseCode);
            courses.get(courseCode).deleteStudent(studentID);
            System.out.println("The student has successfully deregistered for the course.");
        }else{
            System.out.println("The student has not successfully deregistered for the course.");
        }
    }

   public static void showSchedule(){
       System.out.print("Enter ID student: ");
       String studentId = console.nextLine();
       if(students.containsKey(studentId)){
           List<String> courseCodes = students.get(studentId).getCourseCodes();
           System.out.println("Schedule courses for student " + students.get(studentId).getName() + " "+students.get(studentId).getSurname()+ ": ");
           for (String code:courseCodes){
               Course course = courses.get(code);
               System.out.println(course.getTitle() + " - " + course.getTeacher()+" - "+course.getShedule());
           }
       }else{
           System.out.println("Student not found");
       }
   }
   public static void  searchCourse(){
       System.out.print("Enter code course: ");
       String codeCourse = console.nextLine();
       Course course = courses.get(codeCourse);
       if(course != null){
           System.out.println("Student for which the courses is registered "+course.getTitle()+" :");
           for(String studentID:course.getStudentIDs()){
               Student student  = students.get(studentID);
                   System.out.println("Name: "+student.getName()+" ID: "+student.getId());
               }
           } else {
           System.out.println("Courses not exist");
       }
       }

   public static void searchStudent(){
       System.out.print("Enter id student: ");
       String studentID = console.nextLine();
       Student student = students.get(studentID);
       if(student!=null){
           System.out.println("Courses for which the student is registered "+student.getName()+" :");
           for(String courseID:student.getCourseCodes()){
               Course course = courses.get(courseID);
               System.out.println("Code: "+course.getCode()+" Title: "+course.getTitle());
           }
       }else{
           System.out.println("Student not courses");
       }
   }

   public static void addGradeStudents(){
       System.out.print("Enter student id: ");
       String studentId = console.nextLine();
       System.out.print("Enter course code: ");
       String courseCode = console.nextLine();
       System.out.print("Enter day of week: ");
       String dayOfWeek = console.nextLine();
       System.out.print("Enter score: ");
       int score = console.nextInt();
       console.nextLine();
       Course course = courses.get(courseCode);
       if(course!=null && course.getStudentIDs().contains(studentId)){
        Grade grade = new Grade(dayOfWeek,score);
        course.addGrade(studentId,dayOfWeek,grade);
           System.out.println("Grade success added");
       }else{
           System.out.println("Student or course  not found");
       }
   }
   public static void getGradeStudent(){
       System.out.print("Enter id student: ");
       String studentID = console.nextLine();
       System.out.print("Enter code course: ");
       String courseCode = console.nextLine();
       Course course = courses.get(courseCode);
       if(course!=null && course.getStudentIDs().contains(studentID)){
           Map<String,Grade> grades = course.getGrades(studentID);
           if(grades.isEmpty()){
               System.out.println("Is empty");
           }else{
               System.out.println("Grades student: ");
               for (Map.Entry<String, Grade> entry:grades.entrySet()){
                   System.out.println("Day: "+entry.getKey()+" Grade: "+entry.getValue().getScore());
               }
           }
       }else{
           System.out.println("Student or course not found");
       }
   }
}