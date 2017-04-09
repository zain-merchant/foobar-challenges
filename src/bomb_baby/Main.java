package bomb_baby;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

public static void main(String [] args)
{
    System.out.println("Input: " + Arrays.toString(args));
    System.out.println(answer(args[0], args[1]));
}

public static String answer(String M, String F) {

    try {
    	BigInteger one = BigInteger.valueOf(1);
    	BigInteger two = BigInteger.valueOf(2);
    	BigInteger zero = BigInteger.valueOf(0);
    	BigInteger  numM= new BigInteger(M);
    	BigInteger numF = new BigInteger(F);
        /*long numM = Long.parseLong(M);
        long numF = Long.parseLong(F);*/

        String output = "impossible";
        long count = 0;
        //numM > 1 or numF > 1
        while (numM.compareTo(one) > 0 || numF.compareTo(one) > 0) {

            if (!checkIsValid(numM, numF)) {
                numM = numF = BigInteger.valueOf(0);
            }
            else if (numM.compareTo(numF) > 0) {
            	numM.subtract(numF);
                //numM -= numF;
                count++;
            }
            else if (numF.compareTo(numM) > 0) {
            	numF.subtract(numM);
                //numF -= numM;
                count++;
            }

            //System.out.println("cycle: " + count + " " + numM + " " + numF);
        }
        
        //numM == 1 && numF == 1
        if (numM.equals(1) && numF.equals(1)) {
            output = ""+count;
        }

        return output;
    }
    catch (NumberFormatException nfe) {
        return "impossible";
    }
}

protected static boolean checkIsValid(BigInteger numM, BigInteger numF) {
	BigInteger one = BigInteger.valueOf(1);
	BigInteger two = BigInteger.valueOf(2);
	BigInteger zero = BigInteger.valueOf(0);
    boolean valid = true;
    //numM % 2 == 0 && numF % 2 == 0
    if (numM.mod(two) == zero && numF.mod(two) == zero) {
        valid = false;
    }
    else if (numM.compareTo(numF) == 0) {
        valid = false;
    }
    //numM <= 0 || numF <= 0
    else if (numM.compareTo(zero) <= 0 || numF.compareTo(zero) <= 0) {
        valid = false;
    }
    //numM > 1 && numF % numM == 0
    else if (numM.compareTo(one) > 0 && numF.mod(numM)== zero) {
        valid = false;
    }
    else if (numF.compareTo(one) > 0 && numM.mod(numF) == zero) {
        valid = false;
    }

    return valid;
}
}