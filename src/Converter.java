import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {

    private final HashMap<String, String> asciiMap = new HashMap<>();
    private final HashMap<String, String> morseMap;

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

    public String toMorse(@NonNull String ascii) {

        ascii = ascii.trim();
        StringBuilder result = new StringBuilder();

        if (!ascii.isEmpty()) {
            for (final var word : ascii.toLowerCase().split(" ")) {
                for (final var character : word.toCharArray()) {
                    if (asciiMap.containsKey(String.valueOf(character))) {
                        result.append(asciiMap.get(String.valueOf(character)));
                        result.append(" ");
                    } else {
                        throw new IllegalArgumentException("Ascii character '" + character + "' not convertible to morse");
                    }
                }
                result.append("  ");
            }
        }

        return result.toString().trim();
    }

    public String fromMorse(@NonNull String morse) {

        morse = morse.trim();
        StringBuilder result = new StringBuilder();

        if (!morse.isEmpty()) {
            for (final var word : morse.split(" {3}")) {
                for (final var character : word.split(" ")) {
                    if (morseMap.containsKey(character)) {
                        result.append(morseMap.get(character));
                    } else {
                        throw new IllegalArgumentException("Morse character '" + character + "' not convertible to ascii");
                    }
                }
                result.append(" ");
            }
        }

        return result.toString().trim();
    }
}
