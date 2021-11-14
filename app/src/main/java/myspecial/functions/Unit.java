package myspecial.functions;

public class Unit {
    public String name;
    public Float coeff;

    public Unit(String name, float coeff)
    {
        this.name = name;
        this.coeff = coeff;
    }

    public String toString()
    {
        return name;
    }
}
