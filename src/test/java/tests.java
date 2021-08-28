import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class tests {

    @Test
    public void Req1() {
        String[] name = {"Bob"};
        String expected = "Hello, Bob";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }

    @Test
    public void Req2() {
        String[] name = null;
        String expected = "Hello, my friend.";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    @Test
    public void Req3() {
        String[] name = {"JERRY"};
        String expected = "HELLO, JERRY!";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    @Test
    public void Req4() {
        String[] name = {"Jill", "Jane"};
        String expected = "Hello, Jill and Jane.";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    @Test
    public void Req5() {
        String[] name = {"Amy","Brian","Charlotte"};
        String expected = "Hello, Amy, Brian, and Charlotte.";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    @Test
    public void Req6() {
        String[] name = {"Amy", "BRIAN", "Charlotte"};
        String expected = "Hello, Amy and Charlotte. AND HELLO BRIAN!";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    @Test
    public void Req7() {
        String[] name = {"Bob", "Charlie, Dianne"};
        String expected = "Hello, Bob, Charlie, and Dianne.";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
    @Test
    public void Req8() {
        String[] name = {"Bob", "\"Charlie, Dianne\""};
        String expected = "Hello, Bob and Charlie, Dianne.";
        String actual = Main.greet(name);
        assertEquals(expected, actual);
    }
}

