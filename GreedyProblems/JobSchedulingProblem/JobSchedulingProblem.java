import java.util.*;

public class JobSchedulingProblem {
    private ArrayList<Job> board;
    private int boardLength;

    public JobSchedulingProblem(int length) {
        board = new ArrayList<Job>();
        boardLength = length;
    }

    public int getBoardLength() {
        return this.boardLength;
    }

    public ArrayList<Job> getBoard() {
        return this.board;
    }

    public void addJob(int start, int end) {
        getBoard().add(new Job(start, end));
    }

    @Override
    public String toString() {
        String retVal = "Scheduling Board:\n";
        for (Job job : board) {
            retVal += job.toString() + "\n";
        }
        return retVal;
    }

    public ArrayList<Job> solve() {
        ArrayList<Job> selected = new ArrayList<Job>();

        Collections.sort(getBoard(), new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j1.compareTo(j2);
            }
        });

        ArrayList<Job> cloned = new ArrayList<>(getBoard());
        ArrayList<Job> toRemove =new ArrayList<>();
        
        int index = 0;
        while(cloned.size() > 0) {
            Job jobToAdd = cloned.get(index);
            selected.add(jobToAdd);
            cloned.remove(jobToAdd);
            for (Job job : cloned) {
                if(job.getStart() < jobToAdd.getEnd()) {
                    System.out.println(job + " " + jobToAdd);
                    toRemove.add(job);
                }
            }

            for (Job job : toRemove) {
                cloned.remove(job);
            }
        }

        return selected;
    }
}