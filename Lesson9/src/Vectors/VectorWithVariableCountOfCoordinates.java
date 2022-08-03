package Vectors;

public class VectorWithVariableCountOfCoordinates
{
    private int[] vectorWithCoordinates;
    private String vectorType;

    public VectorWithVariableCountOfCoordinates(int count)
    {
        this.vectorType = "Вектор содержит " + count + " координат";
    }
    public VectorWithVariableCountOfCoordinates(final int... vectorWithCoordinates)
    {
        this.vectorWithCoordinates = vectorWithCoordinates;
        this.vectorType = "Вектор содержит " + vectorWithCoordinates.length + " координат";
    }

    public void setVectorWithCoordinates(final int vectorSize)
    {
        this.vectorWithCoordinates = new int[vectorSize];
    }

    public void setCoordinate(final int position, final int coordinate)
    {
        vectorWithCoordinates[position] = coordinate;
    }

    public int getCoordinate(final int position)
    {
        return vectorWithCoordinates[position];
    }

    public int getLength()
    {
        return vectorWithCoordinates.length;
    }

    @Override
    public String toString()
    {
        String str = "Тип вектора: " + vectorType + "\nКоординаты: ";
        for(int i = 0; i < vectorWithCoordinates.length; i++)
        {
            str += vectorWithCoordinates[i] + "\t";
        }
        return str;
    }
}
