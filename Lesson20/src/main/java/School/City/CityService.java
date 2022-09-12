package School.City;

import School.Student.StudentAndHisCity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityService {
    public boolean addCity(City city) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school",
                "root", "1234");
             Statement statement = connection.createStatement())
        {
            statement.execute("INSERT INTO city(city_name) " + "VALUES('" + city.getName() + "')");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return false;
    }

    public boolean deleteCity(City city) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school",
                "root", "1234");
             Statement statement = connection.createStatement())
        {
            statement.execute("DELETE FROM city WHERE city_name = " + "'" + city.getName() + "'");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return false;
    }
}
