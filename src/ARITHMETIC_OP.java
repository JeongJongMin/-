import java.util.Scanner;

public class ARITHMETIC_OP {
    static String[] arithmeticArray = new String[10];
    static int index = 0;
    static int end_of_arithmeticOp = 0;
    //실험
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arithmeticOp = sc.nextLine();

        for (int i = 0; i < arithmeticOp.length(); i++) {
            char number_or_OP = arithmeticOp.charAt(i);
            deTach(number_or_OP);
        }
        calculation();
        System.out.println(arithmeticArray[end_of_arithmeticOp -1]);
    }

    public static void deTach(char num_or_OP) {
        if (num_or_OP >= '0' && num_or_OP <= '9' && arithmeticArray[index] != null) {
            arithmeticArray[index] += Character.toString(num_or_OP);
        }
        if(num_or_OP >= '0' && num_or_OP <= '9' && arithmeticArray[index] == null) {
            arithmeticArray[index] = Character.toString(num_or_OP);
            end_of_arithmeticOp++;
        }
        if (num_or_OP == '+' || num_or_OP == '-' || num_or_OP == '*' || num_or_OP == '/') {
            ++index;
            arithmeticArray[index] = Character.toString(num_or_OP);
            index++;
            end_of_arithmeticOp++;
        }
    }

    public static void calculation() {
        for (int i = 0; i < arithmeticArray.length; i += 2) {
            String operator = arithmeticArray[i + 1];
            Operator(operator, i);
        }
    }

    public static void Operator(String operator, int i) {
        if(arithmeticArray[i+1] == null)
            return;

        int left = Integer.parseInt(arithmeticArray[i]);
        int right = Integer.parseInt(arithmeticArray[i + 2]);

        if (operator.equals("+"))
            arithmeticArray[i + 2] = Integer.toString(left + right);
        if (operator.equals("-"))
            arithmeticArray[i + 2] = Integer.toString(left - right);
        if (operator.equals("*"))
            arithmeticArray[i + 2] = Integer.toString(left * right);
        if (operator.equals("/"))
            arithmeticArray[i + 2] = Integer.toString(left / right);
    }
}
