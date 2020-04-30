package com.hymerfania.rptools.maptool.meta.macrogeneration;

public enum BaseStat {
    Strength,
    Dexterity,
    Intelligence,
    Constitution,
    Wisdom,
    Charisma;

    public String getAbbreviation() {
        switch (this) {
            case Strength:
                return "Str";
            case Dexterity:
                return "Dex";
            case Intelligence:
                return "Int";
            case Constitution:
                return "Con";
            case Wisdom:
                return "Wis";
            case Charisma:
                return "Chr";
            default:
                throw new IllegalStateException("Missing case for " + this.toString());
        }
    }
}
