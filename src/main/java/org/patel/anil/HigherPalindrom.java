package org.patel.anil;

public class HigherPalindrom {
    // Still not working fully.
    public static void main(String[] args) throws Exception {
        String s = "123454321";
        System.out.println(s);
        System.out.println(nextHigherPalindrom(s));
        s = "124353421";
        System.out.println(s);
        System.out.println(nextHigherPalindrom(s));
        s = "154353451";
        System.out.println(s);
        System.out.println(nextHigherPalindrom(s));
    }

    /**
     * Get next higher palindrome.
     * 12344321 should return 12433421
     * 123454321 should return 124353421
     *
     * @param number the original number.
     * @return the next higher palindrome.
     * @throws NumberFormatException if number string does not contains digits
     */
    private static String nextHigherPalindrom(String number) throws Exception {
        //System.out.println("Input = " + number);
        if (number == null || number.length() <= 1) {
            return number;
        }
        String theHalfNumber = number.substring(0, number.length() / 2);
        char[] theHalfNumberArray = theHalfNumber.toCharArray();
        //System.out.println(theHalfNumber);
        StringBuilder sb = new StringBuilder(theHalfNumber);
        boolean swapped = false;
        for (int i = theHalfNumberArray.length - 1; i > 0 && !swapped; i--) {
            char digitChar = theHalfNumberArray[i];
            int digit = Integer.parseInt(digitChar+"");
            //System.out.println("value of i=" + i + ", digit = " + digit);
            for (int j = i - 1; j >= 0 && !swapped; j--) {
                //System.out.println("value of j = " + j);
                int previousDigit = Integer.parseInt(theHalfNumberArray[j]+"");
                if (digit > previousDigit) {
                    int temp = digit;
                    digit = previousDigit;
                    previousDigit = temp;
                    //System.out.println("Before replace : " + new String(theHalfNumberArray));
                    //System.out.println("digit = " + digit + ", previousDigit" + previousDigit);
                    sb.replace(j, j+1, digit + "");
                    theHalfNumberArray[i] = String.valueOf(digit).charAt(0);
                    sb.replace(i, i+1, previousDigit + "");
                    theHalfNumberArray[j] = String.valueOf(previousDigit).charAt(0);
                    //System.out.println("After replace : " + new String(theHalfNumberArray));
                    swapped = true;
                }
            }
        }
        StringBuilder finalString = new StringBuilder();
        if (swapped) {
            finalString.append(new String(theHalfNumberArray));
            //System.out.println("finalString : " + finalString);
            String otherHalf = new StringBuilder(finalString.toString()).reverse().toString();
            if (number.length() % 2 == 1) {
                finalString.append(number.charAt((number.length() / 2)));
                //System.out.println("finalString : " + finalString);
            }
            finalString.append(otherHalf);
            //System.out.println("finalString : " + finalString);
        } else {
            throw new Exception("Already maximum polindrome");
        }
        return finalString.toString();
    }
}
