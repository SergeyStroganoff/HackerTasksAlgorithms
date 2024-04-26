package org.yandex_handbook.meeting_room_reservation;

import java.util.*;
import java.util.stream.Collectors;

public class MeetingRoomReservationSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTimeWindows = scanner.nextInt();
        scanner.nextLine();
        TreeSet<TimeWindow> treeSet = new TreeSet<>();
        //  PriorityQueue<TimeWindow> timeWindowPriorityQueue = new PriorityQueue<>(numberOfTimeWindows);
        int n = numberOfTimeWindows;
        while (n != 0) {
            String nextString = scanner.nextLine();
            String[] startEndArray = nextString.split(" ");
            n--;
            treeSet.add(new TimeWindow(Integer.parseInt(startEndArray[0]), Integer.parseInt(startEndArray[1])));
        }
        if (treeSet.isEmpty()) {
            System.out.println(0);
            throw new IllegalArgumentException("wrong input");
        }

        ArrayList<TimeWindow> list = new ArrayList<>();
        list.add(treeSet.first());
        while (numberOfTimeWindows != 0) {
            treeSet.removeIf(x -> x.getStartTime() <= list.get(list.size() - 1).getEndTime());
            treeSet.remove(list.get(list.size() - 1));
            numberOfTimeWindows = treeSet.size();
            if (!treeSet.isEmpty()) {
                list.add(treeSet.first());
            }
        }
        list.forEach(System.out::println);
        System.out.println(list.size());
    }

    public static class TimeWindow implements Comparable<TimeWindow> {
        private int startTime;
        private int endTime;

        public TimeWindow(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public int compareTo(TimeWindow o) {
            return this.startTime - o.startTime;
        }

        @Override
        public String toString() {
            return "TimeWindow{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}
