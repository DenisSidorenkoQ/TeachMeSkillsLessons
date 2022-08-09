package Vectors;

public class ThreeDimensionalVector
{
    private String vectorType = "Это вектор для трехмерной системы координат";
    private int coordinateX;
    private int coordinateY;
    private int coordinateZ;

    public ThreeDimensionalVector()
    {
    }

    public ThreeDimensionalVector(final int coordinateX, final int coordinateY, final int coordinateZ)
    {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
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

    public int getCoordinateZ()
    {
        return coordinateZ;
    }

    public void setCoordinateZ(final int coordinateZ)
    {
        this.coordinateZ = coordinateZ;
    }

    @Override
    public String toString()
    {
        return "Тип вектора: " + vectorType + "\nX = " + coordinateX + ", Y = " + coordinateY +
                ", Z = " + coordinateZ;
    }
}
