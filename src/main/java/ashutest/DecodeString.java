package ashutest;

class DecodeString {
    int index = 0;
    String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index)))
                result.append(s.charAt(index++));
            else {
                int k = 0;
                // build k until next character is a digit
                //while (index < s.length() && Character.isDigit(s.charAt(index)))
                    //k = k * 10 + s.charAt(index++) - '0';
                if(index < s.length() &&  Character.isDigit(s.charAt(index)))
                    k = s.charAt(index++) - '0';
                // ignore the opening bracket '['
                index++;
                String decodedString = decodeString(s);
                // ignore the closing bracket ']'
                index++;
                // build k[decodedString] and append to the result
                while (k-- > 0)
                    result.append(decodedString);
            }
        }
        return new String(result);
    }
    public static void main(String args [])
    {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("3[a]2[bc]"));
    }
}
