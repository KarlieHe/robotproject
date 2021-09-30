package robotproject;

import java.util.ArrayList;

public class Table {
    private final int row;
    private final int column;
    private ArrayList<Robot> robots;

    public Table() {
        this.row = 5;
        this.column = 5;
        robots = new ArrayList<Robot>();
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.column;
    }

    public ArrayList<Robot> getRobots() {
        return this.robots;
    }

    /**
     * Handle the valid command. Tell wether it is the first valid command entered
     * by user. If it is the first one, new a robot on the table. If not, execute
     * another method or print error.
     * 
     * @param indexOfActiveRobot the index of active robot or represent a state of
     *                           the table.
     * @param subCommands[]      the array of subCommands to the command entered by
     *                           user.
     */
    public void action(int indexOfActiveRobot, String subCommands[]) {

        if (indexOfActiveRobot == -1) {
            this.newRobot(subCommands[1]);
        } else if (indexOfActiveRobot == -2) {
            System.out.println("There is no active robot on the table.");
        } else {
            this.handleCommand(indexOfActiveRobot, subCommands);
        }

    }

    /**
     * Analyze valid command to specific action.
     * 
     * @param i             the index of active robot.
     * @param subCommands[] the array of subCommands to the command entered by user.
     */
    public void handleCommand(int i, String subCommands[]) {
        String mainCommand = subCommands[0];

        switch (mainCommand) {
            case "PLACE":
                this.robots.get(i).setActive(false);
                this.newRobot(subCommands[1]);
                break;
            case "MOVE":
                this.robots.get(i).move();
                break;
            case "RIGHT":
                this.robots.get(i).turn("RIGHT");
                break;
            case "LEFT":
                this.robots.get(i).turn("LEFT");
                break;
            case "ROBOT":
                int activeIndex = Integer.parseInt(subCommands[1]) - 1;
                this.robots.get(i).setActive(false);
                this.robots.get(activeIndex).setActive(true);
                break;
            case "REPORT":
                this.handleReport();
                break;
            default:
                break;
        }

    }

    /**
     * Report the list of robot and its position
     */
    public void handleReport() {
        int robotNum;
        System.out.println("");
        System.out.println("ROBOTS REPORT");
        System.out.println("**********************");

        if (this.robots.size() > 0) {

            for (int j = 0; j < this.robots.size(); j++) {
                robotNum = j + 1;
                System.out.println("Robot " + robotNum + "'s position is " + this.robots.get(j).getX() + ","
                        + this.robots.get(j).getY() + "," + this.robots.get(j).getDirection());
            }
        } else {
            System.out.println("There is no robot on the table.");
        }

        System.out.println("***************************************");
    }

    /**
     * Instant a new robot with XY coordinates and direction
     * 
     * @param the second part of the PLACE command
     */
    public void newRobot(String position) {
        int x;
        int y;
        String direction;

        String locationParam[] = position.split(",", 3);
        x = Integer.valueOf(locationParam[0]);
        y = Integer.valueOf(locationParam[1]);
        direction = locationParam[2];

        Robot r = new Robot(x, y, direction);
        this.robots.add(r);
    }

    /**
     * get index of the active robot on the table
     * 
     * @return if there is no robot on the table, return -1; if there is an robot on
     *         the table, return it's index; if there is one or more robots on the
     *         table but without active robot, return -2
     */
    public int getIndexOfActiveRobot() {
        if (this.robots.size() == 0) {
            return -1;
        } else {
            for (int i = 0; i < this.robots.size(); i++) {
                if (this.robots.get(i).getActive() == true) {
                    return i;
                }
            }
            return -2;
        }

    }

}
