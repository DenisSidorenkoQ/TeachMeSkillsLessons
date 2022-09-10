import School.City.City;
import School.City.CityService;
import School.Student.Student;
import School.Student.StudentService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        firstLesson();
        secondLesson();
    }

    public static void firstLesson() throws SQLException {
        StudentService studentService = new StudentService();

        studentService.getStudents().forEach(student -> System.out.println(student));
        System.out.println("\n");
    }

    public static void secondLesson() throws SQLException {
        StudentService studentService = new StudentService();

        studentService.getStudentsAndHisCity().forEach(studentAndHisCity -> System.out.println(studentAndHisCity));

        City city = new City();
        CityService cityService = new CityService();

        city.setName("Brest");
        cityService.addCity(city);
        cityService.deleteCity(city);

        Student student = new Student();
        student.setAge(19);
        student.setHeight(111);
        student.setSex("M");
        student.setFirstName("ll");
        student.setSecondName("ff");

        studentService.addStudent(student);
        studentService.deleteStudent(student);
    }
}
