public class User {
    private int rank;
    private int progress;

    public User() {
        this.rank = -8;
        this.progress = 0;
    }

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }

    public void incProgress(int activity) {
        if (activity == 0 || activity > 8 || activity < -8) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }

        if (rank > activity){
            progress ++;
        }
        else if (activity == rank){
            progress += 3;
        }
        else if (activity+2 >= rank){
            int difference = activity-rank;
            if (activity>0 && rank<0) {
                difference--;
            }
            progress += difference * difference * 10;
        }
        changeProgress();
    }


    private void changeProgress() {
        while (progress >= 100) {
            if (rank == -1) {
                rank = 1;
            }
            else {
                rank ++;
            }
            progress -= 100;
        }
    }

    public String toString(){
        return "User{" + "rank=" + rank + ", progress=" + progress + "}";
    }
}
