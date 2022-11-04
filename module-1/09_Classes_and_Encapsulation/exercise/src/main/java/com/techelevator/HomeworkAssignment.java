package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        double percentageGrade = (double) this.earnedMarks / this.possibleMarks;
        if (percentageGrade >= 0.90) {
            return "A";
        } else if (percentageGrade >= 0.80 && percentageGrade < 0.90) {
            return "B";
        } else if (percentageGrade >= 0.70 && percentageGrade < 0.80) {
            return "C";
        } else if (percentageGrade >= 0.60 && percentageGrade < 0.70) {
            return "D";
        }

        return "F";
    }
}
