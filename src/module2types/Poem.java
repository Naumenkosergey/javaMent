package module2types;


public class Poem {

    static String[] roles = new String[]{"Городничий",
            "Аммос Федорович",
            "Артемий Филиппович",
            "Лука Лукич", "Лука"};
    static String text = "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.\n" +
            "Аммос Федорович: Как ревизор?\n" +
            "Артемий Филиппович: Как ревизор?\n" +
            "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.\n" +
            "Аммос Федорович: Вот те на!\n" +
            "Артемий Филиппович: Вот не было заботы, так подай!\n" +
            "Лука Лукич: Господи боже! еще и с секретным предписаньем!";

//    static String[] textLines = new String[]{
//            "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
//            "Аммос Федорович: Как ревизор?",
//            "Артемий Филиппович: Как ревизор?",
//            "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
//            "Аммос Федорович: Вот те на!",
//            "Артемий Филиппович: Вот не было заботы, так подай!",
//            "Лука Лукич: Господи боже! еще и с секретным предписаньем!",
//            "Лука Лукич: сэмпл текс Лука Лукич:",
//            "Лука Лукич: Лука: Господи боже!  еще и с секретным предписаньем",
//            "  "};

    public static void main(String[] args) {
        String[] textLines = text.split("\n");
        System.out.println(printTextPerRole(roles, textLines));

    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
//            stringBuilder.append("\n").append(roles[i]).append(":\n");
            stringBuilder.append(roles[i]).append(":\n");
            String roleRegex = roles[i] + ":";
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(roleRegex)) {
                    stringBuilder.append(j + 1).
                            append(")").
                            append(textLines[j].replaceFirst(roleRegex, "")).
                            append("\n");
                }
            }
            stringBuilder.append("\n");
        }
//        return stringBuilder.toString().replaceFirst("\n", "");
        return stringBuilder.toString();


    }
}
