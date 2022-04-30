import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {

    LinkedListOperations listOperations = new LinkedListOperations();
    private int size = 0;

    public ReadFile() {

    }

    public void readerFromFile(String fileName) {

        try {
            String line = "";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {

                String[] arraySplit = line.split(" ");

                if (line.length() == 1) {
                    if (size < Integer.parseInt(arraySplit[0])) {
                        size = Integer.parseInt(arraySplit[0]);
                    }
                } else {
                    int from = Integer.parseInt(arraySplit[0]);
                    int to = Integer.parseInt(arraySplit[1]);

                    listOperations.add(from, to);

                    int max = Math.max(from, to);

                    if (size < max) {
                        size = max;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(fileName + " dosyası okunurken hata çıktı...");
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}