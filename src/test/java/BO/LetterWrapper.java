package BO;

import io.cucumber.java.ht.Le;
import tools.CustomLetter;

public class LetterWrapper implements CustomLetter {
    private Letter letter;

    public LetterWrapper(Letter letter) {
        this.letter = letter;
    }

    @Override
    public String getCustomReceiver(String string) {
        this.letter.setReceiversFieldValue(string);
        return this.letter.getReceiversFieldValue();
    }

    @Override
    public String getCustomSubject(String string) {
        this.letter.setSubjectFieldValue(string);
        return this.letter.getSubjectFieldValue();
    }

    @Override
    public String getCustomBody(String string) {
        this.letter.setBodyOfLetterFieldValue(string);
        return this.letter.getSubjectFieldValue();
    }
}
