package Qbik;

public class Main {
    public static void main(String[] args) {
        program();
    }

    private static void program()
    {
        Input input = new Input();
        Calculate calculate = new Calculate();

        try {
            calculate.calculator(input.calculatorInput());
        } catch (Exception e) {
            e.printStackTrace();
            input.closeScan();
            return;
        }

        program();
    }
}
