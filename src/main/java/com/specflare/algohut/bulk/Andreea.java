package com.specflare.algohut.bulk;

public class Andreea {
    public final static int alphabetSize = 26;

    public int searchCountOccur(String pattern, String inputText, int primeNum)
    {
        int M = pattern.length();
        int N = inputText.length();
        int patternHash = 0; // hash value for pattern
        int textHash = 0; // hash value for inputText
        int h = 1;
        int occurCount = 0;

        // The value of h would be "pow(d, M-1)%primeNum"
        for (int i = 0; i < M - 1; i++)
            h = (h * alphabetSize) % primeNum;

        // Calculate the hash value of pattern and first
        // window of text
        for (int i = 0; i < M; i++) {
            patternHash = (alphabetSize * patternHash + pattern.charAt(i)) % primeNum;
            textHash = (alphabetSize * textHash + inputText.charAt(i)) % primeNum;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= N - M; i++) {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if (patternHash == textHash) {
                /* Check for characters one by one */
                int j;
                for (j = 0; j < M; j++) {
                    if (inputText.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                if (j == M) occurCount ++;
            }

            // Calculate hash value for next window of text: Remove leading digit, add trailing digit
            if (i < N - M) {
                textHash = (alphabetSize * (textHash - inputText.charAt(i) * h) + inputText.charAt(i + M)) % primeNum;

                // We might get negative value of textHash, converting it to positive
                if (textHash < 0)
                    textHash = (textHash + primeNum);
            }
        }

        return occurCount;
    }
}
