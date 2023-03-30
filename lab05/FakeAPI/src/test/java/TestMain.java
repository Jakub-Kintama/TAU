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

    https://api.agify.io?name=michael&country_id=US

    401 - Unauthorized
    { "error": "Invalid API key" }

    402 - Payment Required
    { "error": "Subscription is not active" }

    422 - Unprocessable Entity
    { "error": "Missing 'name' parameter" }

    422 - Unprocessable Entity
    { "error": "Invalid 'name' parameter" }

    429 - Too Many Requests
    { "error": "Request limit reached" }

    429 - Too Many Requests
    { "error": "Request limit too low to process request" }

 */
public class TestMain {
    private String x;

    @Test
    public void simpleTest() {
        Main main = mock(Main.class);
        when(main.name("Jakub")).thenReturn("Kuba");
        x = main.name("Jakub");

        assertEquals(x, "Kuba");
    }

    @Test
    public void simpleTest2() {
        Main main = mock(Main.class);
        when(main.name("Jakub")).thenReturn("Kuba");
        x = main.name("Jakub");

        assertEquals(x, "Kuba");
    }
}
