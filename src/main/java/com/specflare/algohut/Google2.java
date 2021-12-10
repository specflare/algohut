package com.specflare.algohut;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Google2 {
    enum VarState { NOT_EXPANDED, EXPANDED, EXPANDING }

    static class Var {
        public VarState state;
        public String str;

        public Var(VarState st, String str) {
            this.state = st;
            this.str = str;
        }

        @Override
        public String toString() {
            return String.format("Var {state=%s, val=%s}\n", state.toString(), str);
        }
    }

    public static String expand(Map<String, Var> varz, String inputText) {
        if (!varz.containsKey(inputText)) {
            return inputText;
        }

        Var textContent = varz.get(inputText);

        if (textContent.state == VarState.EXPANDING) {
            System.out.println("Cyclic dependency! exiting.");
            System.exit(1);
        }

        if (textContent.state == VarState.EXPANDED) {
            return textContent.str;
        }

        textContent.state = VarState.EXPANDING;

        Pattern varPattern = Pattern.compile("%[a-zA-Z]+[a-zA-Z0-9]*%");
        Matcher m = varPattern.matcher(textContent.str);

        String output = textContent.str;
        while(m.find()) {
            String varName = textContent.str.substring(m.start(), m.end());
            String varVal = expand(varz, varName.substring(1, varName.length() - 1));
            output = output.replace(varName, varVal);
        }

        varz.replace(inputText, new Var(VarState.EXPANDED, output));
        return output;
    }

    public static void main(String[] args) {
        Map<String, Var> varz = new HashMap<>();
        varz.put("USER", new Var(VarState.NOT_EXPANDED, "liviu"));
        varz.put("HOME", new Var(VarState.NOT_EXPANDED, "/home/%USER%"));
        varz.put("PATH", new Var(VarState.NOT_EXPANDED, "This is my home: %HOME% and this is my username: %USER%"));

        System.out.println(expand(varz, "PATH"));
        // System.out.println("At the end, varz = " + varz);
    }
}