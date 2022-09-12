package School.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentResultSetConverter {
    public Student convert(ResultSet resultSet) {
        Student student = new Student();

        try {
            student.setStudentID(resultSet.getInt("studentID"));
            student.setFirstName(resultSet.getString("firstname"));
            student.setSecondName(resultSet.getString("secondname"));
            student.setAge(resultSet.getInt("age"));
            student.setSex(resultSet.getString("sex"));
            student.setHeight(resultSet.getInt("height"));
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            return null;
        }
        return student;
    }
}
