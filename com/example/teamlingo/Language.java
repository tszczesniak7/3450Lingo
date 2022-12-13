package com.example.teamlingo;

public class Language {
    private int idlanguages;
    private String _language, language_family, progenative_language;


    public Language(int idlanguages, String _language, String language_family, String progenative_language) {
        this.idlanguages = idlanguages;
        this._language = _language;
        this.language_family = language_family;
        this.progenative_language = progenative_language;
    }

    public int getIdlanguages() {
        return idlanguages;
    }

    public String get_language() {
        return _language;
    }

    public String getLanguage_family() {
        return language_family;
    }

    public String getProgenative_language() {
        return progenative_language;
    }

    public void setIdlanguages(int idlanguages) {
        this.idlanguages = idlanguages;
    }

    public void set_language(String _language) {
        this._language = _language;
    }

    public void setLanguage_family(String language_family) {
        this.language_family = language_family;
    }

    public void setProgenative_language(String progenative_language) {
        this.progenative_language = progenative_language;
    }
}
