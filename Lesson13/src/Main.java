import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        secondLesson();
        firstLesson();
    }

    public static void firstLesson()
    {
        ServiceForReadDocuments serviceForReadDocuments = new ServiceForReadDocuments();
        Map<String, String> map = serviceForReadDocuments.fileDecompositionOfValidAndNotValidDocuments();
        System.out.println(map);
    }

    public static void secondLesson()
    {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.addToTheEnd("hi");
        stringArrayList.addToTheEnd("hello");
        stringArrayList.addToTheEnd("privet");
        stringArrayList.addToTheEnd("poka");
        stringArrayList.add(2, "HiHello");

        stringArrayList.remove(3);
        stringArrayList.check("hello");

        System.out.println(stringArrayList);

        stringArrayList.clear();

        System.out.println(stringArrayList.getLength());
    }

}
