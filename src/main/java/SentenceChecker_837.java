public class SentenceChecker_837 {


    static boolean checkSentence(char[] str) {

        int length = str.length;

        if(str[0] < 'A' || str[0] > 'Z')
            return false;

        if(str[length-1] != '.')
            return false;

        int currState = 0, prevState=0;
        int index =1;

        while (index < str.length) {

            if(str[index] >= 'A' && str[index] <= 'Z')
                currState = 0;
            else if(str[index] == ' ')
                currState = 1;
            else if(str[index] >= 'a' && str[index] <= 'z')
                currState = 2;
            else if(str[index] == '.')
                currState = 3;

            if (prevState == currState && currState != 2)
                return false;

            if (prevState == 2 && currState == 0)
                return false;

            // If we have reached last state and previous state
            // is not 1, then check next character. If next character
            // is '\0', then return true, else false
            if (currState == 3 && prevState != 1)
                return (index + 1 == str.length);

            index++;

            prevState = currState;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] str = {"I love cinema.", "The vertex is S.",
                "I am single.", "My name is KG.",
                "I lovE cinema.", "GeeksQuiz. is a quiz site.",
                "I love Geeksquiz and Geeksforgeeks.",
                " You are my friend.", "I love cinema"};

        int str_size = str.length;

        int i = 0;
        for (i = 0; i < str_size; i++) {
            if (checkSentence(str[i].toCharArray()))
                System.out.println("\"" + str[i] +
                        "\"" + " is correct");
            else
                System.out.println("\"" + str[i] +
                        "\"" + " is incorrect");
        }
    }
}