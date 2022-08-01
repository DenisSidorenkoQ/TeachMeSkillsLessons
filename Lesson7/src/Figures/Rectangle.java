package Figures;

public class Rectangle extends Figure
{
    private float firstSide;
    private float secondSide;

    public Rectangle()
    {
        name = "Прямоугольник";
    }

    public Rectangle(float firstSide, float secondSide)
    {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        name = "Прямоугольник";
    }

    public float getFirstSide()
    {
        return firstSide;
    }

    public void setFirstSide(float firstSide)
    {
        this.firstSide = firstSide;
    }

    public float getSecondSide()
    {
        return secondSide;
    }

    public void setSecondSide(float secondSide)
    {
        this.secondSide = secondSide;
    }

    @Override
    public float getFigureArea()
    {
        return firstSide * secondSide;
    }

    @Override
    public float getPerimeter()
    {
        return firstSide * 2 + secondSide * 2;
    }
}
