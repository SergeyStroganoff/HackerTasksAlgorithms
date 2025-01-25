package algo.yandex_handbook.meeting_room_reservation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomReservationSolutionV3 {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Interval> intervals = new ArrayList<>();

        while (n != 0) {
            String nextString = scanner.nextLine();
            String[] startEndArray = nextString.split(" ");
            n--;
            intervals.add(new Interval(Integer.parseInt(startEndArray[0]), Integer.parseInt(startEndArray[1])));
        }
        System.out.println(maxNonOverlappingIntervals(intervals));
    }

    public static int maxNonOverlappingIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        // Сортировка интервалов по правому концу
        intervals.sort(Comparator.comparingInt(a -> a.end));

        int count = 1; // Первый интервал всегда входит
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > end) {
                // Найден интервал, который не пересекается с предыдущим
                count++;
                end = intervals.get(i).end;
            }
        }

        return count;
    }
}
