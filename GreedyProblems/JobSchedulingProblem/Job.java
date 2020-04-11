
public class Job implements Comparable {
    private int start, end;

    public Job(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    @Override
    public String toString() {
        return "Job[" + getStart() + "," + getEnd() + "]";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Job) {
            Job job = (Job) o;
            if(this.getEnd() >= job.getEnd()) {
                return 1;
            }
            return -1;
        } else {
            return 0;
        }
    }
}