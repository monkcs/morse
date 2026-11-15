import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {

    private HashMap<String, String> asciiMap = new HashMap<>();
    private HashMap<String, String> morseMap = new HashMap<>();

    public Converter() {
        asciiMap.put("a", ".-");
        asciiMap.put("b", "-...");
        asciiMap.put("c", "-.-.");
        asciiMap.put("d", "-..");
        asciiMap.put("e", ".");
        asciiMap.put("f", "..-.");
        asciiMap.put("g", "--.");
        asciiMap.put("h", "....");
        asciiMap.put("i", "..");
        asciiMap.put("j", ".---");
        asciiMap.put("k", "-.-");
        asciiMap.put("l", ".-..");
        asciiMap.put("m", "--");
        asciiMap.put("n", "-.");
        asciiMap.put("o", "---");
        asciiMap.put("p", ".--.");
        asciiMap.put("q", "--.-");
        asciiMap.put("r", ".-.");
        asciiMap.put("s", "...");
        asciiMap.put("t", "-");
        asciiMap.put("u", "..-");
        asciiMap.put("v", "...-");
        asciiMap.put("w", ".--");
        asciiMap.put("x", "-..-");
        asciiMap.put("y", "-.--");
        asciiMap.put("z", "--..");

        morseMap = (HashMap<String, String>) asciiMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    public String toMorse(String ascii) {
        String result = "";

        return result;
    }

    public String fromMorse(String morse) {
        return morse;
    }
}
