import Vectors.Services.ThreeDimensionalVectorService;
import Vectors.Services.TwoDimensionalVectorService;
import Vectors.ThreeDimensionalVector;
import Vectors.TwoDimensionalVector;

public class MainForFirstLesson
{
    public static void main(String[] args)
    {
        LessonWithTwoDimensionalVector();
        System.out.println("\n\n\n");
        LessonWithThreeDimensionalVector();
    }

    public static void LessonWithTwoDimensionalVector()
    {
        //Первое задание 2D вектор
        TwoDimensionalVector firstTwoDimensionalVector = new TwoDimensionalVector(10, 20);
        TwoDimensionalVector secondTwoDimensionalVector = new TwoDimensionalVector(5, 10);

        System.out.println(firstTwoDimensionalVector);
        System.out.println(secondTwoDimensionalVector);

        System.out.println("\nДлина вектора: " + TwoDimensionalVectorService.getLength(firstTwoDimensionalVector));

        System.out.println("\nСкалярное произведение: " +
                TwoDimensionalVectorService.getScalarProduct(firstTwoDimensionalVector,
                        firstTwoDimensionalVector));

        System.out.println("\nСложение векторов: ");
        TwoDimensionalVectorService.outputVectorAdditions(firstTwoDimensionalVector, secondTwoDimensionalVector);
        System.out.println("\nРазность векторов: ");
        TwoDimensionalVectorService.outputVectorDifference(firstTwoDimensionalVector, secondTwoDimensionalVector);

        System.out.println();
        TwoDimensionalVectorService.vectorComparison(firstTwoDimensionalVector, secondTwoDimensionalVector); // Сравнение векторов

        System.out.println("\n" + firstTwoDimensionalVector + "\n" + secondTwoDimensionalVector);

        TwoDimensionalVector[] arrayWithTwoDimensionalVectors =
                TwoDimensionalVectorService.getArrayWithRandomVectors(4);

        System.out.println("\n\nРандомные вектора: ");
        for(TwoDimensionalVector vector : arrayWithTwoDimensionalVectors)
        {
            System.out.println(vector);
        }
    }

    public static void LessonWithThreeDimensionalVector()
    {
        //Первое задание 3D вектор
        ThreeDimensionalVector firstThreeDimensionalVector = new ThreeDimensionalVector(10, 20, 30);
        ThreeDimensionalVector secondThreeDimensionalVector = new ThreeDimensionalVector(5, 10, 15);

        System.out.println(firstThreeDimensionalVector);
        System.out.println(secondThreeDimensionalVector);

        System.out.println("\nДлина вектора: " + ThreeDimensionalVectorService.getLength(firstThreeDimensionalVector));

        System.out.println("\nСкалярное произведение: " +
                ThreeDimensionalVectorService.getScalarProduct(firstThreeDimensionalVector,
                        secondThreeDimensionalVector));

        System.out.println("\nСложение векторов: ");
        ThreeDimensionalVectorService.outputVectorAdditions(firstThreeDimensionalVector, secondThreeDimensionalVector);
        System.out.println("\nРазность векторов: ");
        ThreeDimensionalVectorService.outputVectorDifference(firstThreeDimensionalVector, secondThreeDimensionalVector);

        System.out.println();
        ThreeDimensionalVectorService.vectorComparison(firstThreeDimensionalVector, secondThreeDimensionalVector); // Сравнение векторов

        System.out.println("\n" + firstThreeDimensionalVector + "\n" + secondThreeDimensionalVector);

        ThreeDimensionalVector[] arrayWithThreeDimensionalVectors =
                ThreeDimensionalVectorService.getArrayWithRandomVectors(4);

        System.out.println("\n\nРандомные вектора: ");
        for(ThreeDimensionalVector vector : arrayWithThreeDimensionalVectors)
        {
            System.out.println(vector);
        }
    }
}
