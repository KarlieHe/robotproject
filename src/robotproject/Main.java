package robotproject;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Table table = new Table();
        int robSize = 0;
        boolean isRepeat = true;

        Scanner scanner = new Scanner(System.in);

        while (isRepeat) {
            robSize = table.getRobots().size();
            System.out.println("Please enter your command:");
            String command = scanner.nextLine().toUpperCase();
            String subCommands[] = command.split(" ", 2);

            if (RobotHelper.isValidInput(subCommands, robSize, table.getRow(), table.getCol()) == true) {
                int index = table.getIndexOfActiveRobot();
                table.action(index, subCommands);

                if (subCommands[0].equals("REPORT")) {
                    isRepeat = false;
                }
            } else {
                System.out.println("The command is invalid. Please try again.");
                System.out.println("");
            }

        }
        scanner.close();

    }
}
