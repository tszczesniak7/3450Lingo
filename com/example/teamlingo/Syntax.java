package com.example.teamlingo;

public class Syntax {
    private int idsyntax;
    private String _language, word_order, declension_system, gender_rules, particle_words;

    public Syntax(int idsyntax, String _language, String word_order, String declension_system, String gender_rules, String particle_words) {
        this.idsyntax = idsyntax;
        this._language = _language;
        this.word_order = word_order;
        this.declension_system = declension_system;
        this.gender_rules = gender_rules;
        this.particle_words = particle_words;
    }

    public int getIdsyntax() {
        return idsyntax;
    }

    public String get_language() {
        return _language;
    }

    public String getWord_order() {
        return word_order;
    }

    public String getDeclension_system() {
        return declension_system;
    }

    public String getGender_rules() {
        return gender_rules;
    }

    public String getParticle_words() {
        return particle_words;
    }

    public void setIdsyntax(int idsyntax) {
        this.idsyntax = idsyntax;
    }

    public void set_language(String _language) {
        this._language = _language;
    }

    public void setWord_order(String word_order) {
        this.word_order = word_order;
    }

    public void setDeclension_system(String declension_system) {
        this.declension_system = declension_system;
    }

    public void setGender_rules(String gender_rules) {
        this.gender_rules = gender_rules;
    }

    public void setParticle_words(String particle_words) {
        this.particle_words = particle_words;
    }
}
