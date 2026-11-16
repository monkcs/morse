import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestConverter {

    @Test
    public void toMorse() {
        final Converter converter = new Converter();
        assertEquals(".- -... -.-.   .- -... -.-.", converter.toMorse("abc abc"));
    }

    @Test
    public void fromMorse() {
        final Converter converter = new Converter();
        assertEquals("abc abc", converter.fromMorse(".- -... -.-.   .- -... -.-."));
    }

    @Test
    public void toMorseAndBack() {
        final Converter converter = new Converter();
        final var allCharacters = "abcdefghijklmnopqrstuvwxyz";
        assertEquals(allCharacters, converter.fromMorse(converter.toMorse(allCharacters)));
    }

    @Test
    public void fromMorseAndBack() {
        final Converter converter = new Converter();
        final var allCharacters = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
        assertEquals(allCharacters, converter.toMorse(converter.fromMorse(allCharacters)));
    }

    @Test
    public void leadingWhitespaceAscii() {
        final Converter converter = new Converter();
        assertEquals(".- -... -.-.", converter.toMorse("  abc"));
    }

    @Test
    public void leadingWhitespaceMorse() {
        final Converter converter = new Converter();
        assertEquals("abc", converter.fromMorse("  .- -... -.-."));
    }

    @Test
    public void trailingWhitespaceAscii() {
        final Converter converter = new Converter();
        assertEquals(".- -... -.-.", converter.toMorse("abc  "));
    }

    @Test
    public void trailingWhitespaceMorse() {
        final Converter converter = new Converter();
        assertEquals("abc", converter.fromMorse(".- -... -.-.  "));
    }

    @Test
    public void emptyAscii() {
        final Converter converter = new Converter();
        assertEquals("", converter.toMorse(""));
    }

    @Test
    public void emptyMorse() {
        final Converter converter = new Converter();
        assertEquals("", converter.fromMorse(""));
    }

    @Test
    public void invalidAscii() {
        final Converter converter = new Converter();
        assertThrows(IllegalArgumentException.class, () -> converter.toMorse("\t\n\råäö"));
    }

    @Test
    public void invalidMorse() {
        final Converter converter = new Converter();
        assertThrows(IllegalArgumentException.class, () -> converter.fromMorse("..... -----"));
    }

    @Test
    public void nullAscii () {
        final Converter converter = new Converter();
        assertThrows(NullPointerException.class, () -> converter.toMorse(null));
    }

    @Test
    public void nullMorse () {
        final Converter converter = new Converter();
        assertThrows(NullPointerException.class, () -> converter.fromMorse(null));
    }
}
