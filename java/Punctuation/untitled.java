public void getPunctuationWords(String sentence) {
    int currentWordLength = 0;
    for(int currentWordIndex = 0; currentWordIndex < sentence.length(); currentWordIndex++) {
        char currentChar = sentence.charAt(currentWordIndex);
        currentWordLength++;

        if (currentChar == ' ') {
            String word = sentence.substring(currentWordIndex - currentWordLength + 1, currentWordIndex);
            char lastSymbol = word.charAt(word.length() - 1);

            if (checkForPunctuation(word, lastSymbol)) {
                printWords(word);
            }
            currentWordLength = 0; // reset properly
        }
    }
}
