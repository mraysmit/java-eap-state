package mars.dev;

public class Main {
    public static void main(String[] args) {

        Operation op = new Operation();
        System.out.println(op.getStatus());

        op.nextState();
        System.out.println(op.getStatus());

        op.nextState();
        System.out.println(op.getStatus());

        op.nextState();
        System.out.println(op.getStatus());

    }
}