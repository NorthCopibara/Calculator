package Qbik;

import Qbik.Math.Math;
import Qbik.Parser.Parser;

import java.util.HashSet;
import java.util.Set;

public class Calculate {
    public void calculator(String input) throws Exception {
        Parser parser = new Parser();
        String result = "0";

        if(input.contains("+"))
        {
            String[] line = input.split("\\+");

            int a = parser.parse(line[0]);
            int b = parser.parse(line[1]);

            if(!criterion(a, b))
                throw new Exception("Значения не соответствуют ограничению [1, 10]");

            result = parser.parseResult(Math.sum(a, b), line[0], line[1]) ;
        }
        else
        if(input.contains("-"))
        {
            String[] line = input.split("-");

            int a = parser.parse(line[0]);
            int b = parser.parse(line[1]);

            if(!criterion(a, b))
                throw new Exception("Значения не соответствуют ограничению [1, 10]");

            result = parser.parseResult(Math.subtraction(a, b), line[0], line[1]) ;
        }
        else
        if(input.contains("*"))
        {
            String[] line = input.split("\\*");

            int a = parser.parse(line[0]);
            int b = parser.parse(line[1]);

            if(!criterion(a, b))
                throw new Exception("Значения не соответствуют ограничению [1, 10]");

            result = parser.parseResult(Math.multiplication(a, b), line[0], line[1]) ;
        }
        else
        if(input.contains("/"))
        {
            String[] line = input.split("/");

            int a = parser.parse(line[0]);
            int b = parser.parse(line[1]);

            if(!criterion(a, b))
                throw new Exception("Значения не соответствуют ограничению [1, 10]");

            result = parser.parseResult(Math.division(a, b), line[0], line[1]);
        }

        printResult(result);
    }

    private boolean criterion(int a, int b)
    {
        if(a > 0 && a < 11 && b > 0 && b < 11)
            return true;
        else
            return false;
    }

    private void printResult(String result)
    {
        System.out.println("Output:\n" + result);
    }
}
