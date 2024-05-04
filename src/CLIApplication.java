public class CLIApplication {
    public static void main(String[] args) {
        CourseRegistration cmd = new CourseRegistration();

        // Добавление курсов
        cmd.addCourse(new Course("JAVA", "Coders", "Teyub muellim","2/4/6 19:00-21:00"));
        cmd.addCourse(new Course("C#", "CodeAcademy", "Mr.Johns","1/3/5"));
        cmd.addCourse(new Course("C++", "CodeStar", "Ms.Smiths","1/5/7"));
//        Course course = new Course("JAVA", "Coders", "Teyub muellim","2/4/6 19:00-21:00");
//        Course course1 = new Course("C#", "CodeAcademy", "Mr.Johns","1/3/5");
//        Course course2 = new Course("C++", "CodeStar", "Ms.Smiths","1/5/7");

        // Добавление студентов
        cmd.addStudent(new Student("Q001", "Qarib","Alisultanov"));
        cmd.addStudent(new Student("S002", "Sabina","Alekberova"));
        cmd.addStudent(new Student("C003", "Adil","Subhanov"));
        cmd.addStudent(new Student("X020","Mursal","Babekzade"));
//        Student student = new Student("Q001", "Qarib","Alisultanov");
//        Student student1 = new Student("S001", "Sabina","Alekberova");
//        Student student2 = new Student("C003", "Adil","Subhanov");
//        Student student3 = new Student("X020","Mursal","Babekzade");


        // Запуск CLI-приложения
        cmd.run();
    }
}
