package Qbik.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {
    private Map<String, Value> values = new HashMap<>();

    public Parser()
    {
        create();
    }

    private void create()
    {
        String[] rimNumbers = getRimNumbers().split(" ");

        for (int i = -11; i < 101; i++) {
            if(i > 0){
                values.put(Integer.toString(i), new Value(rimNumbers[i - 1], i, Type.ARAB));
                values.put(rimNumbers[i - 1], new Value(rimNumbers[i - 1],i, Type.RIM));
            }
            else
            if(i < 0)
            {
                values.put(Integer.toString(i), new Value("-" + rimNumbers[-i - 1], i, Type.ARAB));
                values.put("-" + rimNumbers[-i - 1], new Value("-" + rimNumbers[-i - 1],i, Type.RIM));
            }
            else
            {
                values.put("0", new Value("0", 0, Type.RIM));
                values.put("0", new Value("0", 0, Type.ARAB));
            }
        }

    }

    private String getRimNumbers()
    {
        File file = new File("src\\Qbik\\Resources\\RIM.txt");
        String numbers;

        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        numbers = scan.nextLine();

        scan.close();

        return numbers;
    }

    public int parse(String key)
    {
        return values.get(key).getValue();
    }

    public String parseResult(int result, String a, String b) throws Exception {
        if(!(values.get(a).getType() == values.get(b).getType()))
            throw new Exception("Не корректные значения!");

        if(values.get(a).getType() == Type.ARAB)
            return Integer.toString(result);
        else
            return values.get(Integer.toString(result)).getValueRim();
    }
}
