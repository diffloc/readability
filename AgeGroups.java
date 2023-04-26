package readability;

public enum AgeGroups {

    ONE(1, "5-6", "Kindergarten"),
    TWO(2, "6-7", "First Grade"),
    THREE(3, "7-8", "Second Grade"),
    FOUR(4, "8-9", "Third Grade"),
    FIVE(5, "9-10", "Fourth Grade"),
    SIX(6, "10-11", "Fifth Grade"),
    SEVEN(7, "11-12", "Sixth Grade"),
    EIGHT(8, "12-13", "Seventh Grade"),
    NINE(9, "13-14", "Eighth Grade"),
    TEN(10, "14-15", "Ninth Grade"),
    ELEVEN(11, "15-16", "Tenth Grade"),
    TWELVE(12, "16-17", "Eleventh Grade"),
    THIRTEEN(13, "17-18", "Twelfth Grade"),
    FOURTEEN(14, "18-22", "College");

    private int score;
    private String ageRange;
    private String gradeLevel;

    AgeGroups(int score, String ageRange, String gradeLevel) {
        this.score = score;
        this.ageRange = ageRange;
        this.gradeLevel = gradeLevel;

    }

    public static String findAgeRange(int scoreCalc) {
        int score = (int) Math.ceil(scoreCalc);
        for (AgeGroups value: values()) {
            if (value.score == score) {
                return value.ageRange;
            }
        }
        return "NaN";
    }
}
