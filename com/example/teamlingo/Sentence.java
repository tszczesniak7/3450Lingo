package com.example.teamlingo;

public class Sentence {
    private int idsentences, idsyntax;
    private String _language, sentence_ex;

    public Sentence(int idsentences, int idsyntax, String _language, String sentence_ex) {
        this.idsentences = idsentences;
        this.idsyntax = idsyntax;
        this._language = _language;
        this.sentence_ex = sentence_ex;
    }

    public int getIdsentences() {
        return idsentences;
    }

    public int getIdsyntax() {
        return idsyntax;
    }

    public String get_language() {
        return _language;
    }

    public String getSentence_ex() {
        return sentence_ex;
    }

    public void setIdsentences(int idsentences) {
        this.idsentences = idsentences;
    }

    public void setIdsyntax(int idsyntax) {
        this.idsyntax = idsyntax;
    }

    public void set_language(String _language) {
        this._language = _language;
    }

    public void setSentence_ex(String sentence_ex) {
        this.sentence_ex = sentence_ex;
    }
}
