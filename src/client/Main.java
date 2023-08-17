package client;

public class Main {

    public static void main(String[] args) throws Exception {
        String output = args[0];
        AskIn.friendlyInterface();
        CommandManager.whichCommand(output);
    }
}
