package robotproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Table table = new Table();
        int robSize = 0;
        boolean repeat = true;
        
        Scanner scanner = new Scanner(System.in);

        while(repeat){
            robSize = table.getRobots().size();
            System.out.println("Please enter your command:");
            String command = scanner.nextLine().toUpperCase();
            String subCommands[] = command.split(" ", 2);

            if (RobotHelper.isValidInput(subCommands, robSize, table.getRow(), table.getCol()) == true){
                int index = getIndexOfActiveRobot(table.getRobots(), robSize);
                table.action(index, subCommands);

                if(subCommands[0].equals("REPORT")){
                    repeat = false;
                }  
            } else {
                System.out.println("The command is invalid. Please try again.");
                System.out.println("");
            }
            
        }
        scanner.close();
            
        

    }

    /**
    * get index of the active robot on the table
    * @param lists robots ArrayList
    * @param size the number of the robots on the table
    * @return if there is no robot on the table, return -1; if there is an robot on the table, return it's index; 
    * if there is one or more robots on the table but without active robot, return -2
    * */
    public static int getIndexOfActiveRobot(ArrayList<Robot> lists, int size){
        if (size == 0){
            return -1;
        } else {
            for (int i = 0; i < size; i++) {
                if (lists.get(i).getActive() == true) {
                    return i;
                }
            }
            return -2;
        }
        
    }
}
