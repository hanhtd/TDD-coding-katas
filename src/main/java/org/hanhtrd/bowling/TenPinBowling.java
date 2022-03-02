package org.hanhtrd.bowling;

public class TenPinBowling {

    public static final String MISSING_ROLL = "-";

    public static int calculateScore(String frameResults) {
        int scoringTotal = 0;
        for (int index = 0; index < frameResults.length(); index++) {
            String rollResultAsString = String.valueOf(frameResults.charAt(index));
            int rollScore;
            if (rollResultAsString.equals(MISSING_ROLL)) {
                rollScore = 0;
            } else {
                rollScore = Integer.parseInt(rollResultAsString);
            }
            scoringTotal += rollScore;
        }
        return scoringTotal;
    }
}
