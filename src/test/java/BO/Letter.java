package BO;

import tools.CustomLetter;

public class Letter implements CustomLetter {
    private static String receiversFieldValue = "arrow2383347dmitriy@gmail.com";
    private static String subjectFieldValue = "testSubject";
    private static String bodyOfLetterFieldValue = "testBodyValue";

    public static String getReceiversFieldValue() {
        return receiversFieldValue;
    }

    public static String getSubjectFieldValue() {
        return subjectFieldValue;
    }

    public static String getBodyOfLetterFieldValue() {
        return bodyOfLetterFieldValue;
    }

    @Override
    public String getCustomReceiver(String string) {
        return string;
    }

    @Override
    public String getCustomSubject(String string) {
        return string;
    }

    @Override
    public String getCustomBody(String string) {
        return string;
    }
}
