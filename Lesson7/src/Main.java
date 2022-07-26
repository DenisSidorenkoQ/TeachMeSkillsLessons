import DocumentAccountingSystem.Documents.ContractForTheSupply;
import Employees.*;
import Figures.*;

import java.util.Date;


public class Main
{
    public static void main(String[] args)
    {
        System.out.println(getSumOfThePerimeterOfFigures() + "\n");
        outputJobTitle();


    }

    public static float getSumOfThePerimeterOfFigures()
    {
        Figure figures[] = { new Triangle(12, 9, 10), new Rectangle(10, 5), new Circle(12),
                new Rectangle(8, 4), new Circle(8) };
        float Sum = 0f;
        for (Figure figure : figures)
        {
            Sum += figure.getPerimeter();
        }
        return Sum;
    }

    public static void outputJobTitle()
    {
        Namenable[] namenables = {new Director(), new Worker(), new Accountant() };
        for (Namenable namenable : namenables)
        {
            System.out.println(namenable.getJobTitle());
        }
    }
}

