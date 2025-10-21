package recSubsetStringSubseq_3;

public class RecString {

    static void skipAChar(String p,String up){
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch == 'a'){
            skipAChar(p,up.substring(1));
        }else {
            skipAChar(p+ch,up.substring(1));
        }
    }

    static String skipAChar2(String s){
        if (s.isEmpty())return "";
        char ch = s.charAt(0);
        if (ch == 'a'){
            return skipAChar2(s.substring(1));
        }else {
            return ch + skipAChar2(s.substring(1));
        }
    }

    static String skipApple(String s){
        if(s.isEmpty())return "";

        if(s.startsWith("apple"))return skipApple(s.substring(5));
        else return s.charAt(0) + skipApple(s.substring(1));
    }
    /*
    * removes all the 'app' string if it is not forming apple
    * */
    static String skipAppIfNotApple(String s){
        if (s.isEmpty()) return "";
        if(s.startsWith("app") && !s.startsWith("apple")){ // means it is forming only app and not apple then remove it.
            return skipAppIfNotApple(s.substring(3));
        }else{
            return s.charAt(0) + skipAppIfNotApple(s.substring(1));
        }
    }


    public static void main(String[] args) {
        skipAChar("","bishalkishan"); // bishlkishn
        System.out.println(skipAChar2("bishalkishan")); // bishlkishn
        System.out.println(skipApple("appleballapplecat")); // ballcat
        System.out.println(skipAppIfNotApple("appbishappleajdappappleal")); // bishappleajdappleal
    }
}
