class Calc {
    private String str;
    private int pos = -1, ch;

    //ties an index position integer to the corresponding char, and allows you to advance that index position
    //Works through the string one character at a time
    private void nextChar() {
        ch = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    //Checks to see if the current character is one that we are looking for.
    //If it is, go to the next character and return true
    //used to figure out which operator symbol we're on
    private boolean eat(int charToEat) {
        if (ch == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }

    //method to be called, starts the whole calculator process
    int parse (String str) {
        this.str = str;
        nextChar();
        int x = parseExpression();
        if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
        return x;
    }

    //adds or subtracts the next two numbers
    //done separately from multiplication in order to provide proper order of operations
    private int parseExpression() {
        int x = parseTerm();
        while (true) {
            if      (eat('+')) x += parseTerm(); // addition
            else if (eat('-')) x -= parseTerm(); // subtraction
            else return x;
        }
    }

    //returns the result of multiplication and division.
    //called by parseExpression, before the expression is parsed,
    //so it'll do stuff before adding or subtracting anything.
    private int parseTerm() {
        //gets the next number
        int x = parseFactor();
        //multiplies or divides that number by the next until there is no more multiplication/division
        while (true) {
            if      (eat('*')) x *= parseFactor(); // multiplication
            else if (eat('/')) x /= parseFactor(); // division
            else return x;
        }
    }

    //returns a portion of the string that is a number, in between each operator and any spaces
    private int parseFactor() {
        int x;
        while (ch == ' ') nextChar();
        int startPos = this.pos;

        if (ch >= '0' && ch <= '9') {
            while (ch >= '0' && ch <= '9') nextChar();
            x = Integer.parseInt(str.substring(startPos, this.pos));
            while (ch == ' ') nextChar();
        } else {
            throw new RuntimeException("Unexpected: " + (char)ch);
        }

        return x;
    }
}
