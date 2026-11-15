import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestConverter {

    @Test
    public void toMorse() {
        Converter converter = new Converter();
        assertEquals("... --- ...", converter.toMorse("sos"));
    }

    @Test
    public void fromMorse() {
        Converter converter = new Converter();
        assertEquals("sos", converter.fromMorse("... --- ..."));
    }
}
