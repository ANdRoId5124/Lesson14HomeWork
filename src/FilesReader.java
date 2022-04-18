import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FilesReader {

    public static BufferedReader read(File files) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(files));
        return bufferedReader;
    }
}
