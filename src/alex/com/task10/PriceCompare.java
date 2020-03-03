package alex.com.task10;

import java.util.Comparator;

public class PriceCompare implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Book price1 = (Book) o1;
        Book price2 = (Book) o2;
        if (price1.getPrice() > price2.getPrice()) return -1;
        if (price1.getPrice() < price2.getPrice()) return 1;
        return 0;
    }
}
