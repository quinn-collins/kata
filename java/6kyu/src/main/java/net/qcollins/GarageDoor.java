package net.qcollins;

public class GarageDoor {
    private static final char NOTHING = '.';
    private static final char BUTTON_PRESS = 'P';
    private static final char OBSTACLE = 'O';

    private static boolean doorInOpenDirection;
    private static int doorLevel;
    private static boolean doorMoving;
    private static boolean doorPaused;
    private static String returnString;

    public static String run(String events) {
        doorInOpenDirection = false;
        doorLevel = 0;
        doorMoving = false;
        doorPaused = false;
        returnString = "";
        char[] eventsArray = events.toCharArray();
        for (int i = 0; i <= eventsArray.length - 1; i++) {
            char event = eventsArray[i];
            if (event == NOTHING) {
                decideDoorAction("nothing");
            } else if (event == BUTTON_PRESS) {
                decideDoorAction("button");
            } else if (event == OBSTACLE) {
                decideDoorAction("obstacle");
            }
            addToReturnString(String.valueOf(doorLevel));
        }
        return returnString;
    }

    private static void addToReturnString(String doorAction) {
        returnString = returnString + doorAction;
    }

    private static void openDoor() {
        if (doorLevel < 5) {
            doorLevel += 1;
            doorMoving = true;
            doorInOpenDirection = true;
        } else {
            doorMoving = false;
        }
    }

    private static void closeDoor() {
        if (doorLevel > 0) {
            doorLevel -= 1;
            doorMoving = true;
            doorInOpenDirection = false;
        } else {
            doorMoving = false;
        }
    }

    private static void pauseDoor() {
        doorMoving = false;
        doorPaused = true;
    }

    private static void decideDoorAction(String trigger) {
        if (doorPaused) {
            doorInOpenDirection = !doorInOpenDirection;
            doorPaused = false;
        }
        if (doorMoving && trigger.equalsIgnoreCase("nothing")) {
            if (doorInOpenDirection) {
                openDoor();
            } else {
                closeDoor();
            }

        } else if (!doorMoving && trigger.equalsIgnoreCase("button") || trigger.equalsIgnoreCase("obstacle")) {
            if (doorInOpenDirection) {
                closeDoor();
            } else {
                openDoor();
            }
        } else if (doorMoving && trigger.equalsIgnoreCase("button")) {
            pauseDoor();
        }
    }
}

/*

    If the door is closed, a push starts opening the door, and vice-versa
    It takes 5 seconds for the door to open or close completely
    While the door is moving, one push pauses movement, another push resumes movement in the same direction

 */