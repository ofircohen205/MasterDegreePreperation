/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        JobSchedulingProblem jsp = new JobSchedulingProblem(15);

        jsp.addJob(1,4);
        jsp.addJob(3,5);
        jsp.addJob(0,6);
        jsp.addJob(5,7);
        jsp.addJob(3,8);
        jsp.addJob(5,9);
        jsp.addJob(6,10);
        jsp.addJob(8,11);
        jsp.addJob(8,12);
        jsp.addJob(2,13);
        jsp.addJob(11,14);

        System.out.println(jsp.solve());
    }
}