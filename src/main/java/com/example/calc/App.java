package com.example.calc;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner in = new Scanner(System.in);

        System.out.println("=== Simple Calculator (type 'q' to quit) ===");
        while (true) {
            System.out.print("\nEnter expression (e.g. 12 * 3): ");
            String line = in.nextLine().trim();
            if (line.equalsIgnoreCase("q")) break;

            String[] parts = line.split("\\s+");
            if (parts.length != 3) {
                System.out.println("Format: <number> <+|-|*|/> <number>");
                continue;
            }
            try {
                double a = Double.parseDouble(parts[0]);
                double b = Double.parseDouble(parts[2]);
                double result = switch (parts[1]) {
                    case "+" -> calc.add(a, b);
                    case "-" -> calc.subtract(a, b);
                    case "*" -> calc.multiply(a, b);
                    case "/" -> calc.divide(a, b);
                    default -> throw new IllegalArgumentException("Unknown operator: " + parts[1]);
                };
                System.out.println("= " + result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Bye!");
    }
}
