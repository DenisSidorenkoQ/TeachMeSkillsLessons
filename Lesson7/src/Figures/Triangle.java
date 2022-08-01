package Figures;
import java.lang.Math;

public class Triangle extends Figure
{
    private float firstSide;
    private float secondSide;
    private float thirdSide;

    public Triangle(float firstSide, float secondSide, float thirdSide)
    {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
        this.name = "Треугольник";
    }

    public Triangle()
    {
        this.name = "Треугольник";
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

    public float getThirdSide()
    {
        return thirdSide;
    }

    public void setThirdSide(float thirdSide)
    {
        this.thirdSide = thirdSide;
    }

    @Override
    public float getFigureArea()
    {
        float p = 0.5f * (firstSide + secondSide + thirdSide);
        return (float) Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
    }

    @Override
    public float getPerimeter()
    {
        return firstSide + secondSide + thirdSide;
    }
}
