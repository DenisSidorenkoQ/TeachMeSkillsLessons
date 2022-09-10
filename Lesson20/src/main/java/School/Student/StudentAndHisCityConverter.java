package School.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentAndHisCityConverter {
    public StudentAndHisCity convert(ResultSet resultSet) {
        StudentAndHisCity student = new StudentAndHisCity();

        try {
            StudentResultSetConverter studentResultSetConverter = new StudentResultSetConverter();
            student.setStudentID(resultSet.getInt("studentID"));
            student.setFirstName(resultSet.getString("firstname"));
            student.setSecondName(resultSet.getString("secondname"));
            student.setAge(resultSet.getInt("age"));
            student.setSex(resultSet.getString("sex"));
            student.setHeight(resultSet.getInt("height"));
            student.setCity(resultSet.getString("city_name"));
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            return null;
        }
        return student;
    }
}
