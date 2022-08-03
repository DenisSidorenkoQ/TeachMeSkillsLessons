package Vectors.Services;

import Vectors.TwoDimensionalVector;

public final class TwoDimensionalVectorService
{
    private static final int MAX_ANGLE_DEGREE = 180;
    private static final int MIN_ANGLE_DEGREE = 0;
    private static final int SQUARE = 2;
    private static final String X_IS = "X = ";
    private static final String Y_IS = "Y = ";
    private static final int RANDOM_LIMIT = 50;
    public static double getLength(final TwoDimensionalVector twoDimensionalVector)
    {
        return Math.sqrt(
                Math.pow(twoDimensionalVector.getCoordinateX(), SQUARE) +
                        Math.pow(twoDimensionalVector.getCoordinateY(), SQUARE));
    }

    public static double getScalarProduct(final TwoDimensionalVector firstTwoDimensionalVector,
                                              final TwoDimensionalVector secondTwoDimensionalVector)
    {
        return firstTwoDimensionalVector.getCoordinateX() * secondTwoDimensionalVector.getCoordinateX() +
                firstTwoDimensionalVector.getCoordinateY() * secondTwoDimensionalVector.getCoordinateY();
    }

    public static void outputVectorAdditions(final TwoDimensionalVector firstTwoDimensionalVector,
                                            final TwoDimensionalVector secondTwoDimensionalVector)
    {
        System.out.println(X_IS +
                (firstTwoDimensionalVector.getCoordinateX() + secondTwoDimensionalVector.getCoordinateX()));
        System.out.println(Y_IS +
                (firstTwoDimensionalVector.getCoordinateY() + secondTwoDimensionalVector.getCoordinateY()));
    }

    public static void outputVectorDifference(final TwoDimensionalVector firstTwoDimensionalVector,
                                              final TwoDimensionalVector secondTwoDimensionalVector)
    {
        System.out.println(X_IS +
                (firstTwoDimensionalVector.getCoordinateX() - secondTwoDimensionalVector.getCoordinateX()));
        System.out.println(Y_IS +
                (firstTwoDimensionalVector.getCoordinateY() - secondTwoDimensionalVector.getCoordinateY()));
    }

    public static TwoDimensionalVector[] getArrayWithRandomVectors(final int arraySize)
    {
        TwoDimensionalVector[] arrayOfVectors = new TwoDimensionalVector[arraySize];

        for (int i = 0; i < arraySize; i++)
        {
            arrayOfVectors[i] = new TwoDimensionalVector();
            arrayOfVectors[i].setCoordinateX((int) (Math.random() * RANDOM_LIMIT));
            arrayOfVectors[i].setCoordinateY((int) (Math.random() * RANDOM_LIMIT));
        }
        return arrayOfVectors;
    }

    public static void vectorComparison(final TwoDimensionalVector firstTwoDimensionalVector,
                                        final TwoDimensionalVector secondTwoDimensionalVector)
    {
        if (getLength(firstTwoDimensionalVector) == getLength(secondTwoDimensionalVector))
        {
            System.out.println("Вектора равны");
        }
        else if (getLength(firstTwoDimensionalVector) > getLength(secondTwoDimensionalVector))
        {
            System.out.println("Перывй вектор больше второго");
        }
        else
        {
            System.out.println("Второй вектор больше первого");
        }
    }
}
