package robotproject;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RobotHelper {

    /**
     * Use this regex pattern to validate the command for robot place
     * @param position the second part of the PLACE command
     * @param row row of the table
     * @param col col of the table
     * @return if the subCommand is valid or not
     */
    public static boolean useRegexForPlace(final String position, int row, int col) {
        int maxRow = row - 1;
        int maxCol = col - 1;

        // Compile regular expression
        final Pattern pattern = Pattern.compile("^[0-" + maxCol + "],[0-" + maxRow + "],[a-zA-Z]+$", Pattern.CASE_INSENSITIVE);
        // Match regex against input
        final Matcher matcher = pattern.matcher(position);
        // Use results...
        if(matcher.matches() && isValidDirection(position)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validate the direction parameter
     * @param position
     * @return
     */
    public static boolean isValidDirection(String position){
        String locationParam[] = position.split(",", 3);
        String direction = locationParam[2];
        if(direction.equals("NORTH") || direction.equals("SOUTH") || direction.equals("EAST") || direction.equals("WEST")){
            return true;
        } else {
            System.out.println("There is a typo of the robot direction.");
            return false;
        }
    }
    
    /**
     * Validate the ROBOT command with valid number
     * @param input the second part of the ROBOT command
     * @param robSize the size of robots lists
     * @return
     */ 
    public static boolean isValidRobotNumber(final String input, int robSize) {
        if(Integer.parseInt(input) <= robSize){
            return true;
        } else {
            System.out.println("There is only " + robSize + "robots on the table.");
            return false;
        }
    }

    /**
     * command validation
     * @param arr     an arr of the SubCommands to the command
     * @param robSize the size of robots lists
     * @param row row of the table
     * @param column column of the table
     * @return
     */
    public static boolean isValidInput(String arr[], int robSize, final int row, final int column) {
        String firstCommand = arr[0];
        String secondCommand;

        if(robSize == 0 && !firstCommand.equals("PLACE")){
            System.out.println("There is no robot on the table.");
            return false;
        } else {
            if (firstCommand.equals("MOVE") || firstCommand.equals("RIGHT") || firstCommand.equals("LEFT")
                    || firstCommand.equals("REPORT")) {
                if (arr.length == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (firstCommand.equals("ROBOT")) {
                if (arr.length == 2) {
                    secondCommand = arr[1];
                    return isValidRobotNumber(secondCommand, robSize);
                } else {
                    return false;
                }
            } else if (firstCommand.equals("PLACE")) {
                if (arr.length == 2) {
                    secondCommand = arr[1];
                    return useRegexForPlace(secondCommand, row, column);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        
    }
}
