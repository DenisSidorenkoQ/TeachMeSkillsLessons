package School.Student;

import School.City.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private StudentResultSetConverter studentConverter = new StudentResultSetConverter();
    private StudentAndHisCityConverter studentAndHisCityConverter = new StudentAndHisCityConverter();

    private final String SELECT_ALL_STUDENTS = "select * from student";
    private final String SELECT_ALL_WITH_CITY = "select student.studentID, student.firstname, student.secondname," +
            " student.age, student.sex, student.height, city.city_name " +
            "from student inner join city on student.city_city_id = city.city_id; ";

    private final int STANDARD_CITY_ID = 1;
    private final int STANDARD_SCHOOL_ID = 1;
    private final int STANDARD_CLASS_ID = 1;
    public List<Student> getStudents() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school",
                "root", "1234");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_STUDENTS))
        {
            while (resultSet.next())
            {
                studentList.add(studentConverter.convert(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            return null;
        }
        return studentList;
    }

    public List<StudentAndHisCity> getStudentsAndHisCity() throws SQLException {
        List<StudentAndHisCity> studentList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school",
                "root", "1234");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_WITH_CITY))
        {
            while (resultSet.next())
            {
                studentList.add(studentAndHisCityConverter.convert(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            return null;
        }
        return studentList;
    }

    public boolean addStudent(Student student) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school",
                "root", "1234");
             Statement statement = connection.createStatement())
        {
            statement.execute(
                    "INSERT INTO student(firstname, secondname, age, sex, height, "
                            + "school_schoolID, class_classID, city_city_id) "
                            + "VALUES('" + student.firstName + "','" + student.secondName + "','" + student.age
                    + "','" + student.sex + "','" + student.height + "','" + STANDARD_SCHOOL_ID + "','" + STANDARD_CLASS_ID + "','" + STANDARD_CITY_ID + "')");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return false;
    }

    public boolean deleteStudent(Student student) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school",
                "root", "1234");
             Statement statement = connection.createStatement())
        {
            statement.execute(
                    "DELETE FROM student WHERE student.firstname = " + "'" + student.getFirstName() + "' " +
                            "and student.secondname = " + "'" + student.getSecondName() + "'"
                            + "and student.age =" + "'" + student.getAge() + "'"
                            + "and student.sex =" + "'" + student.getSex() + "'"
                            + "and student.height =" + "'" + student.getHeight() + "'");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return false;
    }
}
