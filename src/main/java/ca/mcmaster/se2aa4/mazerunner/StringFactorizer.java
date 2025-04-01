package ca.mcmaster.se2aa4.mazerunner;


public class StringFactorizer {

    public String factorize(String str) {
        StringBuilder factorizedString = new StringBuilder();
        String[] steps = str.split("(?<=(\\w))(?=\\w)(?!\\1)");
        
        for (int i = 0; i < steps.length; i++) {
            String s = steps[i];
            if (i != 0) {
                factorizedString.append(' ');
            }
            int n = s.length();
            if (n != 1) {
                factorizedString.append(String.valueOf(n));
            }
            factorizedString.append(s.charAt(0));
        }
        return factorizedString.toString();
    }

    public String expand(String str) {
        StringBuilder expandedString = new StringBuilder();
        String[] steps = str.split("(?<!\\d)| ");
        int n = 1;
        for (String s : steps) {
            if (s.charAt(0) == ' ') {
                continue;
            }
            if (Character.isDigit(s.charAt(0))) {
                n = Integer.parseInt(s.substring(0, s.length()-1));
            } else {
                n = 1;
            }
            for (int i = 0; i < n; i++) {
                expandedString.append(s.charAt(s.length()-1));
            }
        }
        
        return expandedString.toString();
    }
}
