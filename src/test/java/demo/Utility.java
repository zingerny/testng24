package demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {

    public static Object[][] readFromCSV(String path) throws FileNotFoundException {
        List<List<String>> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            reader.readLine();
            list = reader.lines()
                    .map(s-> new ArrayList<>(Arrays.asList(s.split(","))))
                    .collect(Collectors.toList());
        }
        catch (IOException e){
            System.out.println("File does not exist");
        }


        Object[][] arr = new Object[list.size()][list.get(0).size()];
        for (int i = 0; i< arr.length; i++){
            for (int j = 0; j <arr[i].length; j++){
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Object [] [] objects = readFromCSV("invalid.csv");
        System.out.println(Arrays.deepToString(objects));
    }
}
