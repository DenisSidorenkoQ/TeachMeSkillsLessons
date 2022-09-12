package School.Student;

public class StudentAndHisCity extends Student {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "StudentAndHisCity{" +
                "city='" + city + '\'' +
                ", studentID=" + studentID +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                '}';
    }
}
