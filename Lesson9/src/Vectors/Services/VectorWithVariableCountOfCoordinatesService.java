package Vectors.Services;

import Vectors.VectorWithVariableCountOfCoordinates;

public final class VectorWithVariableCountOfCoordinatesService
{
    private static final int MAX_ANGLE_DEGREE = 180;
    private static final int MIN_ANGLE_DEGREE = 0;
    private static final int SQUARE = 2;
    private static final int RANDOM_LIMIT = 50;

    public static double getLength(final VectorWithVariableCountOfCoordinates VectorWithVariableCountOfCoordinates)
    {
        int sumOfSquares = 0;
        for (int i = 0; i < VectorWithVariableCountOfCoordinates.getLength(); i++)
        {
            sumOfSquares += Math.pow(VectorWithVariableCountOfCoordinates.getCoordinate(i), SQUARE);
        }
        return Math.sqrt(sumOfSquares);
    }

    public static double getScalarProduct(
            final VectorWithVariableCountOfCoordinates firstVectorWithVariableCountOfCoordinates,
            final VectorWithVariableCountOfCoordinates secondVectorWithVariableCountOfCoordinates,
            int angleBetweenVectors)
    {
        if (angleBetweenVectors >= MIN_ANGLE_DEGREE && angleBetweenVectors <= MAX_ANGLE_DEGREE)
        {
            return getLength(firstVectorWithVariableCountOfCoordinates) *
                    getLength(secondVectorWithVariableCountOfCoordinates) *
                    Math.cos(angleBetweenVectors);
        }
        else
        {
            System.out.println("Косинус должен быть больше 0 и меньше 180 градусов");
            return 0;
        }
    }

    public static void outputVectorAdditions(
            final VectorWithVariableCountOfCoordinates firstVectorWithVariableCountOfCoordinates,
            final VectorWithVariableCountOfCoordinates secondVectorWithVariableCountOfCoordinates)
    {
        if (firstVectorWithVariableCountOfCoordinates.getLength() == secondVectorWithVariableCountOfCoordinates.getLength())
        {
            for (int i = 0; i < firstVectorWithVariableCountOfCoordinates.getLength(); i++)
            {
                System.out.println(firstVectorWithVariableCountOfCoordinates.getCoordinate(i) +
                        secondVectorWithVariableCountOfCoordinates.getCoordinate(i) + "\t");
            }
        }
        else
        {
            System.out.println("Разное кол-во координат!");
        }
    }

    public static void outputVectorDifference(
            final VectorWithVariableCountOfCoordinates firstVectorWithVariableCountOfCoordinates,
            final VectorWithVariableCountOfCoordinates secondVectorWithVariableCountOfCoordinates)
    {
        if (firstVectorWithVariableCountOfCoordinates.getLength() == secondVectorWithVariableCountOfCoordinates.getLength())
        {
            for (int i = 0; i < firstVectorWithVariableCountOfCoordinates.getLength(); i++)
            {
                System.out.println(firstVectorWithVariableCountOfCoordinates.getCoordinate(i) -
                        secondVectorWithVariableCountOfCoordinates.getCoordinate(i) + "\t");
            }
        }
        else
        {
            System.out.println("Разное кол-во координат!");
        }
    }

    public static VectorWithVariableCountOfCoordinates[] getArrayWithRandomVectors(final int arraySize,
                                                                                   final int coordinateCount)
    {
        VectorWithVariableCountOfCoordinates[] arrayOfVectors = new VectorWithVariableCountOfCoordinates[arraySize];

        for (int i = 0; i < arraySize; i++)
        {
            arrayOfVectors[i] = new VectorWithVariableCountOfCoordinates(coordinateCount);
            arrayOfVectors[i].setVectorWithCoordinates(coordinateCount);

            for (int j = 0; j < coordinateCount; j++)
            {
                arrayOfVectors[i].setCoordinate(j, (int) (Math.random() * RANDOM_LIMIT));
            }
        }
        return arrayOfVectors;
    }

    public static void vectorComparison(
            final VectorWithVariableCountOfCoordinates firstVectorWithVariableCountOfCoordinates,
            final VectorWithVariableCountOfCoordinates secondVectorWithVariableCountOfCoordinates)
    {
        if (getLength(firstVectorWithVariableCountOfCoordinates) ==
                getLength(secondVectorWithVariableCountOfCoordinates))
        {
            System.out.println("Вектора равны");
        }
        else if (getLength(firstVectorWithVariableCountOfCoordinates) >
                getLength(secondVectorWithVariableCountOfCoordinates))
        {
            System.out.println("Перывй вектор больше второго");
        }
        else
        {
            System.out.println("Второй вектор больше первого");
        }
    }
}
