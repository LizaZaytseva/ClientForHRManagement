import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    private static void start() {
        Runnable task = () -> {
            Client.start(5555, "add Masha");
            Client.start(5555, "remove Liza");
            Client.start(5555, "add Mila");
            Client.start(5555, "remove Nikita");
            Client.start(5555, "check people");
        };
        Thread thread = new Thread(task);
        thread.start();
        Runnable task2 = () -> {
            Client.start(5555, "remove Alex");
            Client.start(5555, "add Nasta");
            Client.start(5555, "check people");
            Client.start(5555, "remove Sasha");
        };
        Thread thread2 = new Thread(task2);
        thread2.start();
    }
    public static final void main(String[] arg) throws InterruptedException {
    start();
        TimeUnit.SECONDS.sleep(30);
        Client.start(5555, "stop");
    }
}
