import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var list = getFillingList();

        var firstTime = System.nanoTime();
        getSortingList(list);
        var secondTime = System.nanoTime();

        System.out.println("Insertion sort");
        calculateAndOutputTimeForSort(firstTime, secondTime);

        var newList = getFillingList();
        firstTime = System.nanoTime();
        Collections.sort(newList);
        secondTime = System.nanoTime();

        System.out.println("\nDefault quick sort");
        calculateAndOutputTimeForSort(firstTime, secondTime);

    }

    public static void calculateAndOutputTimeForSort(long firstTime, long secondTime) {
        var milliseconds = (secondTime - firstTime) / 1_000_000;
        var seconds = (secondTime - firstTime) / 1_000_000_000;
        System.out.println("Sorting the sheet took " + seconds + " seconds and " + milliseconds + " milliseconds.");
    }

    public static List<Integer> getSortingList(List<Integer> list) {
        for (int left = 0; left < list.size(); left++) {
            int value = list.get(left);
            int i = left - 1;

            for (; i >= 0; i--) {
                if (value < list.get(i)) {
                    list.set(i + 1, list.get(i));
                } else {
                    break;
                }
            }
            list.set(i + 1, value);
        }
        return list;
    }

    public static List<Integer> getFillingList() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100_000; i++) {
            list.add(random.nextInt());
        }
        return list;
    }
}
