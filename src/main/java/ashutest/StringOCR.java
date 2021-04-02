public class StringOCR {
    
    public static void main(String[] args) {
        System.out.println(Solution("A2La","2pL1"));
        System.out.println(Solution("a10","10a"));
        System.out.println(Solution("a10p","9ajk"));


    }
        public static String expandOCRString(String inputStr){
            final StringBuilder builder = new StringBuilder();
            boolean needHandling = false;
            int numericPart = 0;
            char c = '0';

            for (int i = 0; i < inputStr.length(); i++) {
                c = inputStr.charAt(i);
                if (Character.isLetter(c)) {
                    if (needHandling) {
                        for (int j = 0; j < numericPart; j++) {
                            builder.append('?');
                        }
                        needHandling = false;
                    }
                    builder.append(c);
                } else {
                    if (needHandling) {
                        numericPart = numericPart * 10 + Character.getNumericValue(c);
                    } else {
                        numericPart = Character.getNumericValue(c);
                    }
                    needHandling = true;
                }
            }
            // Case: last part of char is demical number
            if (needHandling) {
                for (int j = 0; j < numericPart; j++) {
                    builder.append('?');
                }
            }
            return builder.toString();
        }

    public static boolean Solution(String s, String t) {
        final String expandedS = expandOCRString(s);
        final String expandedT = expandOCRString(t);

        if (expandedS.length() != expandedT.length()) {
            return false;
        }

        for (int i = 0; i < expandedS.length(); i++) {
            if (expandedS.charAt(i) != '?' && expandedT.charAt(i) != '?'
                    && expandedS.charAt(i) != expandedT.charAt(i)) {
                return false;
            }
        }

        return true;
    }
    }

