public class Grade {
    private String dayOfWeek;
    private int score;

    public Grade(String dayOfWeek, int score) {
        this.dayOfWeek = dayOfWeek;
        if(score>0 && score<=10){
        this.score = score;
        }else{
            System.out.println("score not exist");
        }
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", score=" + score +
                '}';
    }
}
