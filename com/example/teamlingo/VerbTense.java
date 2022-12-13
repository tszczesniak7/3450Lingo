package com.example.teamlingo;

public class VerbTense {
    private int idverb_tense;
    private String _language, past_simple, past_perfect, past_continuous, present_simple, present_perfect, present_continuous,
            future_simple, future_perfect, future_continuous;
    private int idsyntax;

    public VerbTense(int idverb_tense, String _language, String past_simple, String past_perfect, String past_continuous, String present_simple, String present_perfect, String present_continuous, String future_simple, String future_perfect, String future_continuous, int idsyntax) {
        this.idverb_tense = idverb_tense;
        this._language = _language;
        this.past_simple = past_simple;
        this.past_perfect = past_perfect;
        this.past_continuous = past_continuous;
        this.present_simple = present_simple;
        this.present_perfect = present_perfect;
        this.present_continuous = present_continuous;
        this.future_simple = future_simple;
        this.future_perfect = future_perfect;
        this.future_continuous = future_continuous;
        this.idsyntax = idsyntax;
    }

    public int getIdverb_tense() {
        return idverb_tense;
    }

    public void setIdverb_tense(int idverb_tense) {
        this.idverb_tense = idverb_tense;
    }

    public String get_language() {
        return _language;
    }

    public void set_language(String _language) {
        this._language = _language;
    }

    public String getPast_simple() {
        return past_simple;
    }

    public void setPast_simple(String past_simple) {
        this.past_simple = past_simple;
    }

    public String getPast_perfect() {
        return past_perfect;
    }

    public void setPast_perfect(String past_perfect) {
        this.past_perfect = past_perfect;
    }

    public String getPast_continuous() {
        return past_continuous;
    }

    public void setPast_continuous(String past_continuous) {
        this.past_continuous = past_continuous;
    }

    public String getPresent_simple() {
        return present_simple;
    }

    public void setPresent_simple(String present_simple) {
        this.present_simple = present_simple;
    }

    public String getPresent_perfect() {
        return present_perfect;
    }

    public void setPresent_perfect(String present_perfect) {
        this.present_perfect = present_perfect;
    }

    public String getPresent_continuous() {
        return present_continuous;
    }

    public void setPresent_continuous(String present_continuous) {
        this.present_continuous = present_continuous;
    }

    public String getFuture_simple() {
        return future_simple;
    }

    public void setFuture_simple(String future_simple) {
        this.future_simple = future_simple;
    }

    public String getFuture_perfect() {
        return future_perfect;
    }

    public void setFuture_perfect(String future_perfect) {
        this.future_perfect = future_perfect;
    }

    public String getFuture_continuous() {
        return future_continuous;
    }

    public void setFuture_continuous(String future_continuous) {
        this.future_continuous = future_continuous;
    }

    public int getIdsyntax() {
        return idsyntax;
    }

    public void setIdsyntax(int idsyntax) {
        this.idsyntax = idsyntax;
    }
}
