package Vectors.Services;

import Vectors.ThreeDimensionalVector;

public final class ThreeDimensionalVectorService
{
    private static final int MAX_ANGLE_DEGREE = 180;
    private static final int MIN_ANGLE_DEGREE = 0;
    private static final int SQUARE = 2;
    private static final String X_IS = "X = ";
    private static final String Y_IS = "Y = ";
    private static final String Z_IS = "Z = ";
    private static final int RANDOM_LIMIT = 50;

    public static double getLength(final ThreeDimensionalVector threeDimensionalVector)
    {
        return Math.sqrt(
                Math.pow(threeDimensionalVector.getCoordinateX(), SQUARE) +
                        Math.pow(threeDimensionalVector.getCoordinateY(), SQUARE) +
                        Math.pow(threeDimensionalVector.getCoordinateZ(), SQUARE));
    }

    public static double getScalarProduct(final ThreeDimensionalVector firstThreeDimensionalVector,
                                                final ThreeDimensionalVector secondThreeDimensionalVector,
                                                final int angleBetweenVectors)
    {
        if (angleBetweenVectors >= MIN_ANGLE_DEGREE && angleBetweenVectors <= MAX_ANGLE_DEGREE)
        {
            return getLength(firstThreeDimensionalVector) * getLength(secondThreeDimensionalVector) *
                    Math.cos(angleBetweenVectors);
        }
        else
        {
            System.out.println("Косинус должен быть больше 0 и меньше 180 градусов");
            return 0;
        }
    }

    public static void outputVectorAdditions(final ThreeDimensionalVector firstThreeDimensionalVector,
                                           final ThreeDimensionalVector secondThreeDimensionalVector)
    {
        System.out.println(X_IS +
                (firstThreeDimensionalVector.getCoordinateX() + secondThreeDimensionalVector.getCoordinateX()));
        System.out.println(Y_IS +
                (firstThreeDimensionalVector.getCoordinateY() + secondThreeDimensionalVector.getCoordinateY()));
        System.out.println(Z_IS +
                (firstThreeDimensionalVector.getCoordinateZ() + secondThreeDimensionalVector.getCoordinateZ()));
    }

    public static void outputVectorDifference(final ThreeDimensionalVector firstThreeDimensionalVector,
                                              final ThreeDimensionalVector secondThreeDimensionalVector)
    {
        System.out.println(X_IS +
                (firstThreeDimensionalVector.getCoordinateX() - secondThreeDimensionalVector.getCoordinateX()));
        System.out.println(Y_IS +
                (firstThreeDimensionalVector.getCoordinateY() - secondThreeDimensionalVector.getCoordinateY()));
        System.out.println(Z_IS +
                (firstThreeDimensionalVector.getCoordinateZ() - secondThreeDimensionalVector.getCoordinateZ()));
    }

    public static ThreeDimensionalVector[] getArrayWithRandomVectors(final int arraySize)
    {
        ThreeDimensionalVector[] arrayOfVectors = new ThreeDimensionalVector[arraySize];

        for (int i = 0; i < arraySize; i++)
        {
            arrayOfVectors[i] = new ThreeDimensionalVector();
            arrayOfVectors[i].setCoordinateX((int) (Math.random() * RANDOM_LIMIT));
            arrayOfVectors[i].setCoordinateY((int) (Math.random() * RANDOM_LIMIT));
            arrayOfVectors[i].setCoordinateZ((int) (Math.random() * RANDOM_LIMIT));
        }
        return arrayOfVectors;
    }

    public static void vectorComparison(final ThreeDimensionalVector firstThreeDimensionalVector,
                                        final ThreeDimensionalVector secondThreeDimensionalVector)
    {
        if (getLength(firstThreeDimensionalVector) == getLength(secondThreeDimensionalVector))
        {
            System.out.println("Вектора равны");
        }
        else if (getLength(firstThreeDimensionalVector) > getLength(secondThreeDimensionalVector))
        {
            System.out.println("Перывй вектор больше второго");
        }
        else
        {
            System.out.println("Второй вектор больше первого");
        }
    }
}
