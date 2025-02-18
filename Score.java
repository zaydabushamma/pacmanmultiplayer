/*!
This class is responsible for keeping track of a current score counter, updating that counter depending on different stimuli, and reporting the current count when it is requested. Some of the methods in this class are only partially defined, as we ran out of time to implement the features that would have utilized some of them.
*/

public class Score {

    private int score = 0;

    public void eatPellet(Pellet p) {
        score += p.getPoints();
    }

    public void eatGhost(int multiply) {
        int properCount = Math.min(Math.max(1, multiply), 4);
        score += (int) Math.pow(200, properCount);
    }

    public void eatFruit(int level) {
        switch(level){
            case 1:
                score += 100;
            case 2:
                score += 300;
            case 3:
                score += 500;
            case 4:
                score += 500;
            case 5:
                score += 700;
            case 6:
                score += 700;
            case 7:
                score += 1000;
            case 8:
                score += 1000;
            case 9:
                score += 2000;
            case 10:
                score += 2000;
            case 11:
                score += 3000;
            case 12:
                score += 3000;
            default:
                score += 5000;
        }
    }

    public void resetScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

}