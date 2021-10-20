public class mid {
    /*

* same comments above

*/

public static boolean findSubStr(String sentence, String word) {

    bool retVal = true;
    int count = 0;
  
    while (count < sentence.length()) {
        if (sentence.contains(word)) {
            count++;
            reVal = true;
        } else {
            count++;
            retVal = false;
        }
    }
    return retVal;   
  }
}
