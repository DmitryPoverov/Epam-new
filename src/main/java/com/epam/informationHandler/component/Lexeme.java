package com.epam.informationHandler.component;

public class Lexeme implements Component {

    private String value;
    private LexemeType lexemeType;

    private Lexeme(String value, LexemeType lexemeType) {
        this.value = value;
        this.lexemeType = lexemeType;
    }
    public static Lexeme word(String value) {
        return new Lexeme(value, LexemeType.WORD);
    }
    public static Lexeme expression(String value) {
        return new Lexeme(value, LexemeType.EXPRESSION);
    }

    public String getValue() {
        return value;
    }
    public LexemeType getLexemeType() {
        return lexemeType;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lexeme lexeme = (Lexeme) o;
        if (!value.equals(lexeme.value)) return false;
        return lexemeType == lexeme.lexemeType;
    }
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (lexemeType != null ? lexemeType.hashCode() : 0);
        return result;
    }
    public String toString() {
        return "Lexeme{" +
                "value='" + value + '\'' +
                ", lexemeType=" + lexemeType +
                '}';
    }
}
