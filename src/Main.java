import entity.ABS;
import entity.Giper147;
import entity.Iris;
import entity.VolkiISobaki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    private static final GenericService genericService = new GenericService();
    static Scanner SCANNER_NUM = new Scanner(System.in);
    static Scanner SCANNER_STRING = new Scanner(System.in);

    public static void main(String[] args) {

        int k = 0;
        while (true) {

            if (k > 0) {
                System.out.println("Invalid input");
            }

            System.out.println("""
                    Choose database
                    1.Волки и собаки
                    2.Ирис
                    3.ABC
                    4.Giper147""");

            int option0 = SCANNER_NUM.nextInt();
            if (option0 == 1) {
                genericService.read("volkiISobaki");

                int m = getKValue("volkiISobaki");
                if (m == 0) {
                    System.out.println();
                }

                List<Double> l = getParameters1("volkiISobaki");

                System.out.println("1.Метод эвклида");
                System.out.println("2.Метод чебышева");

                int option = SCANNER_NUM.nextInt();

                if (option == 1) {

                    List<List<Double>> doubles = genericService.methodEvklida(l, m);
                    doubles.forEach(System.out::println);

                } else if (option == 2) {
                    List<List<Double>> doubles = genericService.methodChebisheva(l, m);
                    doubles.forEach(System.out::println);

                } else
                    return;

            } else if (option0 == 2) {
                genericService.read("iris");

                GenericService.list.forEach(System.out::println);
                int m = getKValue("iris");
                if (m == 0)
                    return;

                List<Double> l = getParameters1("iris");
                System.out.println("1.Метод эвклида");
                System.out.println("2.Метод чебышева");

                int option = SCANNER_NUM.nextInt();
                if (option == 1) {
                    List<List<Double>> doubles = genericService.methodEvklida(l, m);
                    doubles.forEach(System.out::println);

                } else if (option == 2) {
                    List<List<Double>> doubles = genericService.methodChebisheva(l, m);
                    doubles.forEach(System.out::println);
                    return;
                } else
                    return;
            } else if (option0 == 3) {
                genericService.read("abc");
                int m = getKValue("abc");
                if (m == 0)
                    return;

                List<Double> l = getParameters1("abc");

                System.out.println("1.Метод эвклида");
                System.out.println("2.Метод чебышева");

                int option = SCANNER_NUM.nextInt();
                if (option == 1) {
                    List<List<Double>> doubles = genericService.methodEvklida(l, m);
                    doubles.forEach(System.out::println);

                    double k1 = classIdentifier(doubles);
                    System.out.println(k1 + " класс ");
                    return;
                } else if (option == 2) {
                    List<List<Double>> doubles = genericService.methodChebisheva(l, m);
                    doubles.forEach(System.out::println);

                    return;
                }
            } else if (option0 == 4) {
                genericService.read("giper147");
                int m = getKValue("giper147");
                if (m == 0)
                    return;

                List<Double> l = getParameters1("giper147");

                System.out.println("1.Метод эвклида");
                System.out.println("2.Метод чебышева");

                int option = SCANNER_NUM.nextInt();
                if (option == 1) {
                    List<List<Double>> doubles = genericService.methodEvklida(l, m);
                    doubles.forEach(System.out::println);

                    return;
                } else if (option == 2) {
                    List<List<Double>> doubles = genericService.methodChebisheva(l, m);
                    doubles.forEach(System.out::println);

                    return;
                }
            } else
                k++;
        }
    }

    private static Double classIdentifier(List<List<Double>> doubles) {

        List<Double> list = new ArrayList<>();

        for (List<Double> aDouble : doubles) {
            Double firstElement = aDouble.get(0);
            list.add(firstElement);
        }

        Map<Double, Integer> frequencyMap = new HashMap<>();

        for (double num : list) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the number with maximum occurrence
        Double mostOccurredNumber = null;
        int maxFrequency = Integer.MIN_VALUE;
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostOccurredNumber = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return mostOccurredNumber;
    }

    private static List<Double> getParameters1(String path) {

        System.out.println("Какой  объект выбрать");

        Integer index = SCANNER_NUM.nextInt();

        Path p;
        if (path.equals("volkiISobaki")) {
            p = Path.of(GenericService.pathOfVolkiISobaki);
        }

        else if (path.equals("iris")) {
            p = Path.of(GenericService.pathOfIris);
        }

        else if (path.equals("abc")) {
            p = Path.of(GenericService.pathOfABC);
        }

        else
            p = Path.of(GenericService.pathOfGiper147);

        List<Double> doubles = new ArrayList<>();

        try {
            if (Files.exists(p) && Files.size(p) != 0) {
                String line = Files.readAllLines(p).get(index - 1);

                List<String> split = List.of(line.split("\\s+"));

                for (String s : split) {
                    doubles.add(Double.parseDouble(s.trim()));
                }

                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return doubles;
    }

    private static int getKValue(String db) {

        int k = 0;
        while (true) {
            if (k > 0) {
                System.out.println("Invalid input");
            }

            System.out.println("Напиши значение K");

            int size = 0;
            if (db == "iris") {
                size = 25 * 2 - 1;
            } else if (db == "volkiISobaki") {
                size = 12 * 2 - 1;
            } else if (db == "abc") {
                size = 2 * 28 - 1;
            } else if (db == "giper147") {
                size = 36 * 2 - 1;
            }

            int k1 = SCANNER_NUM.nextInt();

            if (k1 <= size) {
                return k1;
            }
            k++;
        }
    }
}
