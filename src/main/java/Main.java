import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

    }

    public static String arrayToStringConverter(String[] toConvert){
        StringBuilder sb = new StringBuilder();
        Arrays.stream(toConvert).forEach(sb::append);
        return sb.toString();
    }

    public static String greet(String[] name) {
        String[] stringArrayToBeUsed = name;
        StringBuilder sb = new StringBuilder();
        String[] splitNames = new String[0];
        List<String> uppercaseStrings = new ArrayList<>();
        if (stringArrayToBeUsed != null) {

            for (int i = 0; i < stringArrayToBeUsed.length; i++) {
                String names = stringArrayToBeUsed[i];
                if (names.contains(",") &! names.contains("\"")) {
                    splitNames = names.split(",[ ]*");
                    List<String> removalList = new ArrayList<>(Arrays.asList(stringArrayToBeUsed));
                    removalList.remove(names);
                    stringArrayToBeUsed = removalList.toArray(new String[0]);
                    stringArrayToBeUsed = Stream.concat(Arrays.stream(stringArrayToBeUsed), Arrays.stream(splitNames)).toArray(String[]::new);
                }
            }
        }

        //if input is null IE no username was entered, a noname greeting is printed
        if (stringArrayToBeUsed == null) {
            return "Hello, my friend.";
        } char[] chars;
        boolean isUppercase = false;
        //The input is checked for all uppercase, if all uppercase is detected in a string the boolean is set as true
            for (int i = 0; i < stringArrayToBeUsed.length; i++) {
                String names = stringArrayToBeUsed[i];
               stringArrayToBeUsed[i] = names.replaceAll("\"","");
                chars = names.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (Character.isUpperCase(chars[j])) {
                        isUppercase = true;
                    } else isUppercase = false;
                }
                if (isUppercase && stringArrayToBeUsed.length >1){
                    uppercaseStrings.add(stringArrayToBeUsed[i]);
                    List<String> removalList = new ArrayList<>(Arrays.asList(stringArrayToBeUsed));
                    removalList.remove(names);
                    stringArrayToBeUsed = removalList.toArray(new String[0]);
                    isUppercase = false;
                }
            }
        if (isUppercase){
            return "HELLO, " + arrayToStringConverter(stringArrayToBeUsed) + "!";
            }
        if(stringArrayToBeUsed.length == 1){
            return "Hello, " + arrayToStringConverter(stringArrayToBeUsed);

        }  if (stringArrayToBeUsed.length == 2 && uppercaseStrings.isEmpty()){
            return "Hello, " + stringArrayToBeUsed[0] + " and " + stringArrayToBeUsed[1] + ".";
        } else sb.append("Hello, ");
            for (int i = 0; i < stringArrayToBeUsed.length; i++) {
            String names = stringArrayToBeUsed[i];
            if (i == stringArrayToBeUsed.length-1 ) {
                sb.append("and " + names + ".");
                if (!uppercaseStrings.isEmpty()){
                    uppercaseStrings.forEach((strings)-> {
                        sb.append(" AND HELLO ");
                        sb.append(strings + "!");
                    });
                }
            } else if (uppercaseStrings.isEmpty()){ sb.append(names + ", ");} else sb.append(names +" ");
        }
            return sb.toString();
    }
}
