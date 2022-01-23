import java.io.*;
import java.util.ArrayList;

public class FileSort {

    // Сортировка по убыванию числа
    public static void sortNumDes(ArrayList<Integer> mergerInt1, ArrayList<Integer> mergerInt2, ArrayList<Integer> mergerIntSort){
        for (int j = 0, k = 0, n = 0; n < mergerInt1.size() + mergerInt2.size(); ) {
            if (j >= mergerInt1.size()) {
                mergerIntSort.add(mergerInt2.get(k));
                k++;
            } else if (k >= mergerInt2.size()) {
                mergerIntSort.add(mergerInt1.get(j));
                j++;
            } else {
                if (mergerInt1.get(j) > mergerInt2.get(k)) {
                    mergerIntSort.add(mergerInt1.get(j));
                    j++;
                } else {
                    mergerIntSort.add(mergerInt2.get(k));
                    k++;
                }
            }
            n = j + k;
        }
    }
    // Сортировка по возрастанию числа
    public static void sortNumAsc(ArrayList<Integer> mergerInt1, ArrayList<Integer> mergerInt2, ArrayList<Integer> mergerIntSort){
        for (int j = 0, k = 0, n = 0; n < mergerInt1.size() + mergerInt2.size(); ) {

            if (j >= mergerInt1.size()) {
                mergerIntSort.add(mergerInt2.get(k));
                k++;
            } else if (k >= mergerInt2.size()) {
                mergerIntSort.add(mergerInt1.get(j));
                j++;
            } else {
                if (mergerInt1.get(j) < mergerInt2.get(k)) {
                    mergerIntSort.add(mergerInt1.get(j));
                    j++;
                } else {
                    mergerIntSort.add(mergerInt2.get(k));
                    k++;
                }
            }
            n = j + k;
        }
    }

    // Сортировка по убыванию строки
    public static void sortStrDes(ArrayList<String> mergerString1, ArrayList<String> mergerString2, ArrayList<String> mergerStringSort){
        for (int j = 0, k = 0, n = 0; n < mergerString1.size() + mergerString2.size(); ) {
            if (j >= mergerString1.size()) {
                mergerStringSort.add(mergerString2.get(k));
                k++;
            } else if (k >= mergerString2.size()) {
                mergerStringSort.add(mergerString1.get(j));
                j++;
            } else {
                if ((mergerString1.get(j)).compareTo(mergerString2.get(k)) > 0) { //.compareTo если больше нуля, то первая строка больше второй
                    mergerStringSort.add(mergerString1.get(j));
                    j++;
                } else {
                    mergerStringSort.add(mergerString2.get(k));
                    k++;
                }
            }
            n = j + k;
        }
    }

    // Сортировка по возрастанию строки
    public static void sortStrAsc(ArrayList<String> mergerString1, ArrayList<String> mergerString2, ArrayList<String> mergerStringSort){
        for (int j = 0, k = 0, n = 0; n < mergerString1.size() + mergerString2.size(); ) {
            if (j >= mergerString1.size()) {
                mergerStringSort.add(mergerString2.get(k));
                k++;
            } else if (k >= mergerString2.size()) {
                mergerStringSort.add(mergerString1.get(j));
                j++;
            } else {
                if ((mergerString1.get(j)).compareTo(mergerString2.get(k)) < 0) { //.compareTo если больше нуля, то первая строка больше второй
                    mergerStringSort.add(mergerString1.get(j));
                    j++;
                } else {
                    mergerStringSort.add(mergerString2.get(k));
                    k++;
                }
            }
            n = j + k;
        }
    }

    // Запись в файл
    public static void writerFile(String type, String nameOut, ArrayList merger) {
        try {
            PrintWriter writer = new PrintWriter(nameOut, "UTF-8");

            if (type == "-s") {
                for (Object s : merger) {
                    writer.println(s);
                }
            } else if (type == "-i") {
                for (Object s : merger) {
                    writer.println(s);
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    // чтение файлов
    public static void readFile(String[] namesIn, String type, ArrayList merger, ArrayList merger2, int numberOfFiles) {
        try {
            File file = new File(namesIn[0]);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            if (type.equals("-i")) {
                merger.add(Integer.parseInt(line));
            } else {
                merger.add(line);
            }
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null) {
                    if (type.equals("-i")) {
                        merger.add(Integer.parseInt(line));
                    } else {
                        merger.add(line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void readFile2(String[] namesIn, String type, ArrayList merger, ArrayList merger2, int numberOfFiles, int i) {

//        for (int i = 1; i < numberOfFiles; i++) {
//
            try {
                File file = new File(namesIn[i]);
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                if (type.equals("-i")) {
                    merger2.add(Integer.parseInt(line));

                } else {
                    merger2.add(line);
                }
                while (line != null) {
                    // считываем остальные строки в цикле
                    try {
                        line = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (line != null) {
                        if (type.equals("-i")) {
                            merger2.add(Integer.parseInt(line));

                        } else {
                            merger2.add(line);
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}
