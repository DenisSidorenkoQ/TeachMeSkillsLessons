package Vectors;

public class TwoDimensionalVector
{
    private String vectorType = "Это вектор для двумерной системы координат";
    private int coordinateX;
    private int coordinateY;

    public TwoDimensionalVector()
    {
    }

    public TwoDimensionalVector(final int coordinateX, final int coordinateY)
    {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public void getLength()
    {
        System.out.println(Math.sqrt(coordinateX * coordinateX + coordinateY * coordinateY));
    }

    public int getCoordinateX()
    {
        return coordinateX;
    }

    public void setCoordinateX(final int coordinateX)
    {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY()
    {
        return coordinateY;
    }

    public void setCoordinateY(final int coordinateY)
    {
        this.coordinateY = coordinateY;
    }

    @Override
    public String toString()
    {
        return "Тип вектора: " + vectorType + "\nX = " + coordinateX + ", Y = " + coordinateY;
    }
}
