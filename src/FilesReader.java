import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilesReader {

    public static BufferedReader read(String paths) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(paths));
        return bufferedReader;
    }
}
