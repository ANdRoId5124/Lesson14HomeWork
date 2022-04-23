import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> paths = new ArrayList<>(); // ArrayList with paths for Files
        List<String> infoFromDocs = new ArrayList<>(); // ArrayList with info from Files(paths)
        Set<String> sortedInfoDocs = new HashSet<>();
        Map<String, String> checkedDocs = new HashMap<>();
        System.out.println("Введите путь и название файла: ");
        String path = scanner.next();
        paths.add(path);
        System.out.println(paths);
        while (!path.equals("0")) {
            System.out.println("Введите путь и название файла: ");
            path = scanner.next();
            paths.add(path);
        }

        paths.remove("0");

        System.out.println(paths);

        for (String s : paths) {

            BufferedReader reader = FilesReader.read(s);
            String line = null;

            while ((line = reader.readLine()) != null) {
                infoFromDocs.add(line);
            }

            reader.close();
        }
        System.out.println(infoFromDocs);

        sortedInfoDocs.addAll(infoFromDocs);
        System.out.println(sortedInfoDocs);

        String comment = null;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ChekedDocs.txt"));
        for (String str : sortedInfoDocs) {
            if (str.length() == 15 && (str.startsWith("docnum") ||
                    str.startsWith("contract"))) {
                comment = "valid document";
                checkedDocs.put(str, comment);
            } else {
                comment = "not valid document, length not == 15 or doc do not start with docnum or contract";
                checkedDocs.put(str, comment);

            }
            bufferedWriter.write(str + " : " + checkedDocs.get(str) + "\n");
        }

        bufferedWriter.close();

    }
}

