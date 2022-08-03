import Vectors.Services.VectorWithVariableCountOfCoordinatesService;
import Vectors.VectorWithVariableCountOfCoordinates;

public class MainForSecondLesson
{
    public static void main(String[] args)
    {
        LessonWithVectorOfVariableCountOfCoordinates();
    }

    public static void LessonWithVectorOfVariableCountOfCoordinates()
    {
        VectorWithVariableCountOfCoordinates firstVectorWithVariableCountOfCoordinates =
                new VectorWithVariableCountOfCoordinates(1, 2, 3, 4, 5, 6);
        VectorWithVariableCountOfCoordinates secondVectorWithVariableCountOfCoordinates =
                new VectorWithVariableCountOfCoordinates(7, 8, 9, 10, 11, 12);

        System.out.println(firstVectorWithVariableCountOfCoordinates);
        System.out.println(secondVectorWithVariableCountOfCoordinates);

        System.out.println("\nДлина вектора: " +
                VectorWithVariableCountOfCoordinatesService.getLength(firstVectorWithVariableCountOfCoordinates));

        System.out.println("\nСкалярное произведение: " +
                VectorWithVariableCountOfCoordinatesService.getScalarProduct(firstVectorWithVariableCountOfCoordinates,
                        secondVectorWithVariableCountOfCoordinates));

        System.out.println("\nСложение векторов: ");
        VectorWithVariableCountOfCoordinatesService.outputVectorAdditions(firstVectorWithVariableCountOfCoordinates, secondVectorWithVariableCountOfCoordinates);
        System.out.println("\nРазность векторов: ");
        VectorWithVariableCountOfCoordinatesService.outputVectorDifference(secondVectorWithVariableCountOfCoordinates, firstVectorWithVariableCountOfCoordinates);

        System.out.println();
        VectorWithVariableCountOfCoordinatesService.vectorComparison(firstVectorWithVariableCountOfCoordinates,
                secondVectorWithVariableCountOfCoordinates); // Сравнение векторов

        System.out.println("");

        VectorWithVariableCountOfCoordinates[] vectorWithVariableCountOfCoordinates =
                VectorWithVariableCountOfCoordinatesService.getArrayWithRandomVectors(4, 6);

        for (int i = 0; i < 4; i++)
        {
            System.out.println(vectorWithVariableCountOfCoordinates[i]);
        }
    }
}
