package Qbik;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Input {
    Scanner scan = new Scanner(System.in);

    public String calculatorInput()
    {
        System.out.println("Input:");
        String input = scan.nextLine();

        return input;
    }

    public void closeScan()
    {
        scan.close();
    }
}
