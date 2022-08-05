public class Main
{
    public static void main(String[] args)
    {
        System.out.println(FirstLesson.getTwoBlocksOfFourDigits("1111-fff-2222-ggg-1f2g"));
        System.out.println(FirstLesson.getStringOnlyWithLetters("1111-FFF-2222-GGG-1f2g"));
        System.out.println(FirstLesson.getStringOnlyWithLettersStringBuilder("1111-fff-2222-ggg-1f2g"));
        System.out.println(FirstLesson.checkABC("1111-abc-2222-ggg-1f2g"));
        System.out.println(FirstLesson.checkStartWith555("1111-fff-2222-ggg-1f2g"));
        System.out.println(FirstLesson.checkEndWith1a2b("1111-fff-2222-ggg-1a2b"));

        System.out.println("\n");

        System.out.println(SecondLesson.findTheShortestWord("Герман Денис Костя Ваня Аня Влад"));
        System.out.println(SecondLesson.findTheLongerWord("Герман Денис Костя Ваня Ана Влад"));
        System.out.println(SecondLesson.findWordWithMinimumDifferent("fffff ab f 1234 jkjk"));
        System.out.println(SecondLesson.checkingForAPalindrome("денис иди", 1));
        System.out.println(SecondLesson.duplicationOfEachLetter("Денис"));
    }
}
