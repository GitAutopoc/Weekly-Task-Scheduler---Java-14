package com.task.assessment;

import java.util.Scanner;

public class WeekScheduler {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String[] tasks = new String[7];
    public static final String[] locations = new String[7];

    public static void main(String[] args) {
        inputTasksAndLocations();
        int day = scanner.nextInt();
        if (day < 1 || day > 7) {
            System.out.println("Invalid day. Please enter a number from 1 to 7.");
            return;
        }
        displayTaskForDay(day);
    }

    public static void inputTasksAndLocations() {
        for (int i = 0; i < 7; i++) {
            tasks[i] = scanner.nextLine();
            locations[i] = scanner.nextLine();
        }
    }

    public static void displayTaskForDay(int day) {
        try {
            String taskDetail = getTaskForDay(day);
            System.out.println("Task for " + getDayName(day) + ": " + taskDetail);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage() + ". No task or location provided for this day.");
        }
    }

    public static String getDayName(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
    }

    public static String getTaskForDay(int day) {
        String task = tasks[day - 1];
        String location = locations[day - 1];
        if (task == null || task.isBlank()) {
            throw new NullPointerException("Task is null");
        }
        if (location == null || location.isBlank()) {
            return task + " - No location specified";
        }
        return task + " - Location: " + location;
    }
}
