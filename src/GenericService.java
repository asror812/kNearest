import entity.VolkiISobaki;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class GenericService {

    static final String pathOfVolkiISobaki = "D:\\Java projects\\kNearestNeighbour\\kNearestNeighbour\\VolkiISobaki";
    static final String pathOfIris = "D:\\Java projects\\kNearestNeighbour\\kNearestNeighbour\\Iris";
    static final String pathOfABC = "D:\\Java projects\\kNearestNeighbour\\kNearestNeighbour\\ABC";
    static final String pathOfGiper147 = "D:\\Java projects\\kNearestNeighbour\\kNearestNeighbour\\";


    static final List<List<Double>> list = new ArrayList<>();


    public void read(String path) {
        Path p ;
        if(path.equals("volkiISobaki")) {
            p = Path.of(pathOfVolkiISobaki);
        }

        else if(path.equals("iris")) {
            p = Path.of(pathOfIris);
        }

        else if(path.equals("abc")) {
            p = Path.of(pathOfABC);
        }

        else p = Path.of(pathOfGiper147);

        try {
            if (Files.exists(p) && Files.size(p) != 0) {
                try (BufferedReader reader = new BufferedReader(new FileReader(p.toFile()))) {
                    String line;

                    while ((line = reader.readLine()) != null) {

                        List<String> split = List.of(line.split("\\s+"));
                        List<Double> nestedList = new ArrayList<>();

                        for (String str : split) {
                            nestedList.add(Double.parseDouble(str));
                        }
                        list.add(nestedList);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }




    public List<List<Double>> methodEvklida(List<Double> list1 , int k) {

        List<List<Double>> l = new ArrayList<>();

        double res = 0;
        int m = 0;
        for(int i = 0 ; i <  list.size(); i++) {
            List<Double> innerList = list.get(i);
            for (int j = 1; j < innerList.size(); j++) {
                res += Math.pow(innerList.get(j)  - list1.get(m), 2) ;
                m++;
            }
            List<Double> doubles = new ArrayList<>();
            doubles.add(list.get(i).get(0));
            doubles.add(Math.sqrt(res));

            l.add(doubles);
            res = 0;
            m = 0;
        }



        l.sort(Comparator.comparingDouble(o -> o.get(1)));


        l.forEach(System.out::println);
        System.out.println();


        return l.stream().limit(k).toList();
    }

    public List<List<Double>> methodChebisheva(List<Double> list1, int k1) {

        List<List<Double>> l = new ArrayList<>();


        int m = 0;
        for(int i = 0 ; i <  list.size(); i++) {
            List<Double> innerList = list.get(i);
            List<Double> res = new ArrayList<>();
            for (int j = 1; j < innerList.size(); j++) {
                res.add(Math.abs(innerList.get(j)  - list1.get(m))) ;
                m++;
            }
            List<Double> doubles = new ArrayList<>();
            doubles.add(list.get(i).get(0));

            double maxElement = 0;
            for (Double num : res) {
                if(num > maxElement) {
                    maxElement = num;
                }
            }
            doubles.add(maxElement);

            l.add(doubles);
            m = 0;
        }



        l.sort(Comparator.comparingDouble(o -> o.get(1)));

        l.forEach(System.out::println);

        System.out.println();



        return l.stream().limit(k1).toList();
    }


}

