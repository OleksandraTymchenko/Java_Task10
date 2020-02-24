package alex.com.task10;

import java.io.*;

public class Serializator {
    public void serialization(Books books) {

        File file = new File("D:/book.txt");
        ObjectOutputStream oos = null;
        try {
            FileOutputStream foa = new FileOutputStream(file);
            if (foa != null) {
                oos = new ObjectOutputStream(foa);
                oos.writeObject(books);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Books deseralization() throws InvalidObjectException {
        File file = new File("D:/book.txt");
        ObjectInputStream ois = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            if (fis != null) {
                ois = new ObjectInputStream(fis);
                Books books = (Books) ois.readObject();
                return books;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new InvalidObjectException("object fail");
    }
}