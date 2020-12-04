package TransMatrix;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
	Read read = new Read();
	String path = "E:/input.txt"; // путь до файла с матрицей
        read.Matrix(path);
    }
}
