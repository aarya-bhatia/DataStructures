package com.aarya.heaps;

import java.util.Scanner;

public class Heap {

    private static MinHeap<Integer> heap = new MinHeap<>();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            LOOP: do {
                System.out.println("Heap : " + heap.toString());
                System.out.print("Enter command: ");
                String[] command = sc.nextLine().toUpperCase().split("\\s+");

                switch (command[0]) {
                    case "ADD":
                        int val = Integer.parseInt(command[1]);
                        heap.add(Integer.valueOf(val));
                        break;
                    case "PEEK":
                        System.out.println(heap.peek().intValue());
                        break;
                    case "POLL":
                        System.out.println(heap.poll().intValue());
                        break;
                    case "EXIT":
                        break LOOP;
                    default:
                        throw new Exception("command not recognized");

                }
            } while (true);
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}