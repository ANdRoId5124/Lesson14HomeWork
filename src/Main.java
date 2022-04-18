import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<File> contracts = new ArrayList<>();
        Set<String> chekedDocs = new HashSet<>();
        Map<Set, String> sortedDocs = new HashMap<>();
        BufferedWriter report = new BufferedWriter(new FileWriter("ChekedDocs.txt"));
        String coment = ": Wrong length or File don't start with docnum or contract";
        while (true) {
            System.out.println("Введите путь и название файла: ");
            String paths = scanner.next();

            if (paths.equals("0")) {
                scanner.close();
                break;
            }
            contracts.add(new File(paths));
            System.out.println(contracts);
        }
        //System.out.println(contracts);
        StringBuilder docs = new StringBuilder();
        String line = null;
        for (int i = 0; i < contracts.size(); i++) {
            while (((line = FilesReader.read(contracts.get(i)).readLine())) != null) {
                docs.append(line).append("\n");
            }

            FilesReader.read(contracts.get(i)).close();

            String[] documnets = docs.toString().split("\n");

            for (int j = 0; j < documnets.length; j++) {
                if (documnets[j].length() == 15 && (documnets[j].startsWith("docnum") || documnets[j].startsWith("contract"))) {
                    chekedDocs.add(documnets[j] + "\n");
                } else {
                    chekedDocs.add(documnets[j] + coment + "\n");
                }

            }


        }

        for(String docums : chekedDocs){
            sortedDocs.put(chekedDocs, coment);

        }

        for (int k = 0; k < sortedDocs.size(); k++){
            report.write(sortedDocs.get(k));
        }

        report.close();
    }


}


