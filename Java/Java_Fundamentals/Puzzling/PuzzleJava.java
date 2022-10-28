import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava{
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            array.add(random.nextInt(20));
        }
        return array;
    }

    public String getRandomLetter(){
        String [] alpha = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        Random randomAlpha = new Random();
        String alphaBet = alpha[randomAlpha.nextInt(25)];
        return alphaBet;
        }

    public String generatePassword(){
        String password = new String();
        for(int i = 0; i < 8; i++){
            password += getRandomLetter();           
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> newPassword = new ArrayList<String>();
        for(int i = 0; i < length; i++){
            newPassword.add(generatePassword());
        }
        return newPassword;

    }

    }
