package arrays.yandex;

import org.junit.Test;

import java.util.*;
/*
    Вам задан набор пар городов: между каждой парой городов сотрудник компании совершил прямой перелёт,
но информация, в каком направлении был совершен перелёт, утеряна.
    Известно, что все указанные перелёты относятся к одному путешествию,
и что каждый следующий перелёт 5 сотрудник начинал из того города, в котором закончил предыдущий.
    Также вы знаете, что никакой б город не был посещён сотрудником дважды,
в том числе город е котором путешествие началось отличается от города, в котором оно закончилось.
    Выведите города в порядке следования по маршруту.
    Очевидно, что есть два возможных ответа, подойдёт любой.

    Примеры:
    [("Moscow", Belgrade")] -> ['Moscow","Belgrade"]
    [("Moscow", Belgrade")), ("Moscow","Еrеvап") ] -> ["Erevan", "Moscow", "Belgrade"]
 */

public class Route {

    public LinkedList<String> build(String[][] tickets) {
        HashMap<String, List<String>> sections = new HashMap<>();
        for (String[] t : tickets) {
            sections.putIfAbsent(t[0], new ArrayList<>());
            sections.putIfAbsent(t[1], new ArrayList<>());
            sections.get(t[0]).add(t[1]);
            sections.get(t[1]).add(t[0]);
        }
        String end = null;
        LinkedList<String> route = new LinkedList<>();

        var entryIterator = sections.entrySet().iterator();
        while (entryIterator.hasNext()) {
            var entry = entryIterator.next();
            if (entry.getValue().size() == 1) {
                if (route.isEmpty()) {
                    route.add(entry.getKey());
                } else {
                    end = entry.getKey();
                }
            }

            if (!route.isEmpty() && entry.getValue().contains(route.getLast())) {
                route.add(entry.getKey());
            }
            if (end != null && !end.isEmpty() && route.getLast().contentEquals(end)) {
                break;
            }

            if (!entryIterator.hasNext()) {
                entryIterator = sections.entrySet().iterator();
            }
        }
        return route;
    }


    @Test
    public void minsk_delhi_kathmandu() {
        String[][] tickets = {
                {"Minsk", "Delhi"},
                {"Delhi", "Kathmandu"},
                {"Kathmandu", "Lukla"}
        };
        var route = new Route().build(tickets);
        assert route.size() == 4;
        assert Objects.equals(route.get(0), "Lukla");
        assert Objects.equals(route.get(3), "Minsk");
    }
}
