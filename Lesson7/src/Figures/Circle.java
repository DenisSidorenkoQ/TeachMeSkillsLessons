package Figures;

public class Circle extends Figure
{
    private float R;

    public Circle()
    {
        name = "Круг";
    }

    public Circle(float r)
    {
        R = r;
        name = "Круг";
    }

    public float getR()
    {
        return R;
    }

    public void setR(float r)
    {
        R = r;
    }

    @Override
    public float getFigureArea()
    {
        return (float) Math.PI * R * R;
    }

    @Override
    public float getPerimeter()
    {
        return (float) (2 * Math.PI * R);
    }
}
