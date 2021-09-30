package robotproject;

public class Robot {
    private int x;
    private int y;
    private boolean active = false;

    public enum RobotDirection {
        NORTH, SOUTH, EAST, WEST
    };

    private RobotDirection robotState;

    public Robot(int initX, int initY, String initDirection) {
        this.x = initX;
        this.y = initY;
        this.robotState = RobotDirection.valueOf(initDirection);
        setActive(true);
    }

    public String getDirection(){
        return String.valueOf(this.robotState);
    }
    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Determine if the robot will fall off the table when it moves one step
     */
    public boolean isFall() {
        switch (this.robotState) {
            case NORTH:
                if (this.y < 4) {
                    return false;
                }
                break;
            case SOUTH:
                if (this.y > 0) {
                    return false;
                }
                break;
            case WEST:
                if (this.x > 0) {
                    return false;
                }
                break;
            case EAST:
                if (this.x < 4) {
                    return false;
                }
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * Control robot to move one step
     */
    public void move() {
        if(!isFall()){
            switch (this.robotState) {
                case NORTH:
                    this.y = this.y + 1;
                    break;
                case SOUTH:
                    this.y = this.y - 1;
                    break;
                case EAST:
                    this.x = this.x + 1;
                    break;
                case WEST:
                    this.x = this.x - 1;
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("The command is invalid. The robot will fall off the table.");
        }
           
    }

    /**
     * Control robot to change direction
     * @param direction previous direction
     */
    public void turn(String direction) {
        if (direction == "LEFT"){
            switch (this.robotState) {
                case NORTH:
                    this.robotState = RobotDirection.WEST;
                    break;
                case SOUTH:
                    this.robotState = RobotDirection.EAST;
                    break;
                case EAST:
                    this.robotState = RobotDirection.NORTH;
                    break;
                case WEST:
                    this.robotState = RobotDirection.SOUTH;
                    break;
                default:
                    break;
            }
        } else if (direction == "RIGHT"){
            switch (this.robotState) {
                case NORTH:
                    this.robotState = RobotDirection.EAST;
                    break;
                case SOUTH:
                    this.robotState = RobotDirection.WEST;
                    break;
                case EAST:
                    this.robotState = RobotDirection.SOUTH;
                    break;
                case WEST:
                    this.robotState = RobotDirection.NORTH;
                    break;
                default:
                    break;
            }
        }
        
    }
}