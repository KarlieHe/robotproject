## Getting Started

This is a small Java program that controlling robot to move on a 5x5 units table by entering commands in terminal. 
You can enter any one command of the following forms each time. (Note: It is required that the first command to the robot is a PLACE command. And it's not case-sensitive program.)
PLACE X,Y,F
MOVE
LEFT
RIGHT
ROBOT <number>
REPORT

* PLACE: will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0) can be considered to be the SOUTH WEST most corner. 

* MOVE: will move the toy robot one unit forward in the direction it is currently facing.

* LEFT and RIGHT: will rotate the robot 90 degrees in the specified direction without changing the position of the robot.

* REPORT: will announce the X,Y and facing of the robots.

* ROBOT <number> (ex. ROBOT 1): will make the robot identified by active i.e. subsequent commands will affect that robot's position/direction.


## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
