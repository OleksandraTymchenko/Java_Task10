package alex.com.task10;
import java.util.Comparator;

public class PublisherNamesCompare implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String name1 = ((Book) o1).getPublisher();
        String name2 = ((Book) o2).getPublisher();
        return name1.compareTo(name2);
    }
}

