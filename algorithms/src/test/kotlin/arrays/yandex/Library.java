package arrays.yandex;

import org.junit.Test;

public class Library {
    public int calculate(int k, int m, int d) {
        var balance = m;
        var i = 1;
        var delta = 0;
        var weekDay = d;
        while (balance >= 0) {
            delta = switch (weekDay) {
                case 6, 7 -> 0;
                default -> k;
            };
            weekDay++;
            weekDay = weekDay == 8 ? 1 : weekDay;
            balance = balance + delta - i;
            i++;
        }
        return i - 2;
    }

    @Test
    public void _425() {
        var lib = new Library();
        var result = lib.calculate(4, 2, 5);
        assert result == 4;
    }

    @Test
    public void _435() {
        var lib = new Library();
        var result = lib.calculate(4, 3, 5);
        assert result == 5;
    }
}
