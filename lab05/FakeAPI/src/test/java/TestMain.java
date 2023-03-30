import org.example.Main;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/*
    https://agify.io/

    https://api.agify.io?name=michael
    {"age":62,"count":298219,"name":"michael"}

    https://api.agify.io?name[]=michael&name[]=matthew&name[]=jane
    [{"age":62,"count":298219,"name":"michael"},{"age":44,"count":53379,"name":"matthew"},{"age":68,"count":40935,"name":"jane"}]

    https://api.agify.io?name=michael&country_id=US
    {"age":55,"count":108496,"country_id":"US","name":"michael"}

    https://api.agify.io?name=peter&apikey=1234
    401 - Unauthorized
    { "error": "Invalid API key" }

    https://api.agify.io
    422 - Unprocessable Entity
    { "error": "Missing 'name' parameter" }

 */
public class TestMain {
    private String x;

    @Test
    public void simpleTest() {
        Main main = mock(Main.class);
        when(main.name("Jakub")).thenReturn("{\"age\":34,\"count\":36211,\"name\":\"Jakub\"}");
        x = main.name("Jakub");

        assertEquals(x, "{\"age\":34,\"count\":36211,\"name\":\"Jakub\"}");
    }

    @Test
    public void simpleTest3() {
        Main main = mock(Main.class);
        when(main.name("name[]=michael&name[]=matthew&name[]=jane")).thenReturn("[{\"age\":62,\"count\":298219,\"name\":\"michael\"},{\"age\":44,\"count\":53379,\"name\":\"matthew\"},{\"age\":68,\"count\":40935,\"name\":\"jane\"}]");
        x = main.name("name[]=michael&name[]=matthew&name[]=jane");

        assertEquals(x, "[{\"age\":62,\"count\":298219,\"name\":\"michael\"},{\"age\":44,\"count\":53379,\"name\":\"matthew\"},{\"age\":68,\"count\":40935,\"name\":\"jane\"}]");
    }

    @Test
    public void simpleTest5() {
        Main main = mock(Main.class);
        when(main.name("https://api.agify.io?name=michael&country_id=US")).thenReturn("{\"age\":55,\"count\":108496,\"country_id\":\"US\",\"name\":\"michael\"}");
        x = main.name("https://api.agify.io?name=michael&country_id=US");

        assertEquals(x, "{\"age\":55,\"count\":108496,\"country_id\":\"US\",\"name\":\"michael\"}");
    }

    @Test
    public void simpleTest4() {
        Main main = mock(Main.class);
        when(main.name("https://api.agify.io?name=peter&apikey=1234")).thenReturn("{\"error\":\"Invalid API key\"}");
        x = main.name("https://api.agify.io?name=peter&apikey=1234");

        assertEquals(x, "{\"error\":\"Invalid API key\"}");
    }

    @Test
    public void simpleTest2() {
        Main main = mock(Main.class);
        when(main.name("")).thenReturn("{ \"error\": \"Missing 'name' parameter\" }");
        x = main.name("");

        assertEquals(x, "{ \"error\": \"Missing 'name' parameter\" }");
    }
}
