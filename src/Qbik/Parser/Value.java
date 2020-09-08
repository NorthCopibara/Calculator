package Qbik.Parser;

enum Type
{
    RIM, ARAB
}

public class Value {
    private int value;
    private String valueRim; //Для обратного преобразования
    private Type type;

    public Value(String valueRim, int value, Type type)
    {
        this.type = type;
        this.valueRim = valueRim;
        this.value = value;
    }

    public String getValueRim() {
        return valueRim;
    }

    public int getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }
}
