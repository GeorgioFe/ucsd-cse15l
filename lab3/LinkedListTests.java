import static org.junit.Assert.*;
import org.junit.*;

public class LinkedListTests {
    
    @Test
    public void testPrepend() {
        LinkedList list = new LinkedList();
        list.prepend(2);
        list.prepend(5);
        list.prepend(7);

        assertEquals("7 5 2 ", list.toString());
    }

    @Test
    public void testAppend() {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);

        assertEquals("1 2 3 ", list.toString());
    }
}
