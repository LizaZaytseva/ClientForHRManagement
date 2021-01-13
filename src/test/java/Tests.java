import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Tests {
    @Test
    public void manyRequests(){
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> command = new ArrayList<>();
        name.add("Alex");
        name.add("Maria");
        name.add("Anna");
        command.add("add");
        command.add("remove");
        for (int i = 0; i < 2000; i++){
            String str = command.get(i % 2) + " " + name.get(i % 3);
            Client.start(4004, str);
        }
        assertEquals(Client.start(4004, "check people"), "2");
        Client.start(4004, "stop");
    }
}
