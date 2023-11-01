package org.hanhtrd.christmaslights;

public class ChristmasLightSystem {

    public int turnOn(int bottomLeftXAsix, int bottomLeftYAsix, int topRightXAsix, int topRightYAsix) {
        return noOfLightInRectangle(bottomLeftXAsix, bottomLeftYAsix, topRightXAsix, topRightYAsix);
    }

    public int turnOff(int bottomLeftXAsix, int bottomLeftYAsix, int topRightXAsix, int topRightYAsix) {
        return noOfLightInRectangle(bottomLeftXAsix, bottomLeftYAsix, topRightXAsix, topRightYAsix);
    }

    private static int noOfLightInRectangle(int bottomLeftXAsix, int bottomLeftYAsix, int topRightXAsix, int topRightYAsix) {
        int noOfLightOnEachLine = topRightXAsix - bottomLeftXAsix + 1;
        int noOfLine = topRightYAsix - bottomLeftYAsix + 1;
        return noOfLightOnEachLine * noOfLine;
    }

    public int toggle(int bottomLeftXAsix, int bottomLeftYAsix, int topRightXAsix, int topRightYAsix) {
        return 0;
    }
}
