import java.util.ArrayList;
import java.util.List;

public class SortingManager {
    private List<Integer> list;
    private List<Integer> sortedList;

    public SortingManager(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getSortedList () {
        sortedList = new ArrayList<>();
        sortedList.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int j = getPositionForValue(list.get(i));
            insertValue(list.get(i), j);
        }
        return sortedList;
    }

    private void insertValue(Integer value, int pos) {
        if (pos < sortedList.size() - 1) {
            sortedList.add(sortedList.get(sortedList.size() - 1));
            for (int i = sortedList.size() - 1; i > pos; i--) {
                sortedList.set(i, sortedList.get(i-1));
            }
            sortedList.set(pos, value);
        } else {
            sortedList.add(value);
        }
    }

    private int getPositionForValue(Integer value) {
        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i) > value) {
                return i;
            }
        }
        return sortedList.size();
    }
}
