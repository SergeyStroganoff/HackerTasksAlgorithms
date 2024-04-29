package org.yandex_handbook.meeting_room_reservation;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MeetingRoomReservationSolutionV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        PriorityQueue<TimeWindowV2> timeWindowPriorityQueue = new PriorityQueue<>(n);
        while (n != 0) {
            String nextString = scanner.nextLine();
            String[] startEndArray = nextString.split(" ");
            n--;
            timeWindowPriorityQueue.add(new TimeWindowV2(Integer.parseInt(startEndArray[0]), Integer.parseInt(startEndArray[1])));
        }

        ArrayList<TimeWindowV2> list = new ArrayList<>();
        list.add(timeWindowPriorityQueue.poll());
        while (timeWindowPriorityQueue.peek() != null) {
            if (timeWindowPriorityQueue.peek().getStartTime() <= list.get(list.size() - 1).getEndTime()) {
                timeWindowPriorityQueue.remove();
            } else {
                list.add(timeWindowPriorityQueue.poll());
            }

        }
        // list.forEach(System.out::println);
        System.out.println(list.size());
    }
    public static class TimeWindowV2 implements Comparable<TimeWindowV2> {
        private int startTime;
        private int endTime;

        public TimeWindowV2(int startTime, int endTime) {
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
        public int compareTo(TimeWindowV2 o) {
            return this.endTime - o.endTime;
        }

        @Override
        public String toString() {
            return "TimeWindow{" + "startTime=" + startTime + ", endTime=" + endTime + '}';
        }
    }
}
