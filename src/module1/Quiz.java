package module1;


import musorka.Quis2;

public class Quiz {

    public Quiz() {
    }

    public static void main(String[] args) throws Exception {
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        byte[] digest = md.digest("abracadabra".getBytes("UTF-8"));
//        for (byte b : digest) {
//            System.out.printf("%02x", b);
//        }
//
//        String s1 = "cat";
//        String s2 = "cat";
//
//        String s3 = new String("cat").intern();
//        String s4 = new String(s2);
//        String s5 = new String(s3);
//
////        System.out.println(s1==s2);
//        System.out.println(s1==s3);
////        System.out.println(s4==s5);
//
//        String s6 = s1 + s2;
//        String s8 = "cat"+ "cat";
////        String s7 =new String("catcat").intern();
//        String s7 =(new String("cat")+s1).intern();
//
//        System.out.println(s6 == s7);
//        System.out.println(s6.equals(s7));
//        System.out.println(s7.equals(s8));
//        System.out.println(s7 == s8);

//        String s1 = "Something";
//        String s2 = new String(s1);
//        if (s1 == s2) System.out.println("s1 == s2");
//        if (s1.equals(s2)) System.out.println("s1.equals(s2)");

//        Integer a = -129;
//        Integer b = -129;
//        System.out.println(a == b);
//        System.out.println(a == b);
//        System.out.println(a);
//        System.out.println(b);




//        Object i = Integer.valueOf(5);
//        String s = (String) i;  //ava.lang.ClassCastException

       String s = null ;
       String s2 = null ;
        Quiz quiz = new Quiz();
        Quiz quiz3 = new Quiz();
        Quiz quiz1 = new Quis2();
        System.out.println(quiz instanceof Quiz);
        System.out.println(quiz1 instanceof Quiz);
        System.out.println(quiz1 instanceof Quiz);
        System.out.println(quiz instanceof Quis2);

        System.out.println(quiz.getClass() == Quiz.class);


    }


}
