//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    final var converter = new Converter();
    final Scanner input = new Scanner(System.in);

    while (true) {
        try {
            System.out.print("Convert from ascii, morse or exit program [a/m/e]: ");
            switch (input.nextLine()) {
                case "a": {

                    System.out.print("Enter ascii string: ");
                    System.out.println("Converted to morse: " + converter.toMorse(input.nextLine()));
                    break;
                }

                case "m": {
                    System.out.print("Enter morse string: ");
                    System.out.println("Converted to ascii: " + converter.fromMorse(input.nextLine()));
                    break;
                }

                case "e": {
                    return;
                }

                default: {
                    continue;
                }
            }
        } catch (IllegalArgumentException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
}
