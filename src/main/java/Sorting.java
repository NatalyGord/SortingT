import java.util.ArrayList;

public class Sorting {
    public static void main(String[] args) {
        int len = args.length;
        String sort = "-a"; //по умолчанию по возрастанию
        String type = "";
        String nameOut = "";
        int numberOfFiles = len - 2; //количество исходных файлов
        String[] namesIn = new String[numberOfFiles]; //массив исходных файлов
        ArrayList<Integer> mergerInt1 = new ArrayList<>();
        ArrayList<Integer> mergerInt2 = new ArrayList<>();
        ArrayList<Integer> mergerIntSort = new ArrayList<>();
        ArrayList<String> mergerString1 = new ArrayList<>();
        ArrayList<String> mergerString2 = new ArrayList<>();
        ArrayList<String> mergerStringSort = new ArrayList<>();

        //парсинг аргументов командной строки
        if (args[0].equals("-d") || args[0].equals("-a") || args[0].equals("-s") || args[0].equals("-i")) {
            if (args[0].equals("-d")) {
                sort = "-d";
            } else if (args[0].equals("-a")) {
                sort = "-a";
            } else if (args[0].equals("-s")) {
                type = "-s";
            } else if (args[0].equals("-i")) {
                type = "-i";
            }
            if (args[1].equals("-d") || args[1].equals("-a") || args[1].equals("-s") || args[1].equals("-i")) {

                if (args[1].equals("-d")) {
                    sort = "-d";
                } else if (args[1].equals("-a")) {
                    sort = "-a";
                } else if (args[1].equals("-s")) {
                    type = "-s";
                } else if (args[1].equals("-i")) {
                    type = "-i";
                }
                nameOut = args[2];
                numberOfFiles = len - 3;
                namesIn = new String[numberOfFiles];
                for (int i = 3, j = 0; i < len; i++, j++) {
                    namesIn[j] = args[i];
                }
            } else {
                nameOut = args[1];
                for (int i = 2, j = 0; i < len; i++, j++) {
                    namesIn[j] = args[i];
                }
            }
        } else {
            System.out.println("Ошибочные параметры");
        }

//        System.out.println();
//        System.out.println("Сортировка: " + sort);
//        System.out.println("Тип данных: " + type);
//        System.out.println("Итоговый файл: " + nameOut);
//        System.out.print("Исходные файлы: ");
//        for (String a : namesIn) {
//            System.out.print(a + " ");
//        }

// чтение файлов
        if (type.equals("-i")) {
            FileSort.readFile(namesIn, type, mergerInt1, mergerInt2, numberOfFiles);
        }
        else {
            FileSort.readFile(namesIn, type, mergerString1, mergerString2, numberOfFiles);
        }
        for (int i = 1; i < numberOfFiles; i++) {
            if (type.equals("-i")) {
                FileSort.readFile2(namesIn, type, mergerInt1, mergerInt2, numberOfFiles, i);
            }
            else {
                FileSort.readFile2(namesIn, type, mergerString1, mergerString2, numberOfFiles, i);
            }

            // Сортировка
            if (type == "-i" && sort == "-a") {
            // Сортировка по возрастанию числа
                FileSort.sortNumAsc(mergerInt1, mergerInt2, mergerIntSort);
            } else if (type == "-i" && sort == "-d") {
            // Сортировка по убыванию числа
                FileSort.sortNumDes(mergerInt1, mergerInt2, mergerIntSort);
            } else if (type == "-s" && sort == "-a") {
            // Сортировка по возрастанию строки
                FileSort.sortStrAsc(mergerString1, mergerString2, mergerStringSort);
            } else if (type == "-s" && sort == "-d") {
            // Сортировка по убыванию строки
                FileSort.sortStrDes(mergerString1, mergerString2, mergerStringSort);
            }

//            System.out.println();
//            System.out.println("mergerString1 " + mergerString1);
//            System.out.println("mergerString2 " + mergerString2);
//            System.out.println("mergerStringSort" + mergerStringSort);
//            System.out.println("mergerInt1 " + mergerInt1);
//            System.out.println("mergerInt2 " + mergerInt2);
//            System.out.println("mergerIntSort " + mergerIntSort);
//

            mergerInt1 = new ArrayList<>();
            mergerInt1.addAll(mergerIntSort);
            mergerInt2.clear();
            mergerIntSort.clear();

            mergerString1 = new ArrayList<>();
            mergerString1.addAll(mergerStringSort);
            mergerString2.clear();
            mergerStringSort.clear();

//            System.out.println("mergerInt1 " + mergerInt1);
//            System.out.println("mergerInt2 " + mergerInt2);
//            System.out.println("mergerIntSort " + mergerIntSort);
//            System.out.println("mergerString1 " + mergerString1);
//            System.out.println("mergerString2 " + mergerString2);
//            System.out.println("mergerStringSort " + mergerStringSort);
        }

            // Запись в файл
            if (type == "-i") {
                FileSort.writerFile(type, nameOut, mergerInt1);
            } else {
                FileSort.writerFile(type, nameOut, mergerString1);
            }
    }
}
