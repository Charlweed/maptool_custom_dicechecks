package com.hymerfania.rptools.maptool.meta.macrogeneration;

@SuppressWarnings("SwitchStatementWithTooFewBranches")
public enum MagicSkill {
    Elemental,
    Black,
    White,
    Mind,
    Planes,
    Voodoo;

    public BaseStat statOf() {
        BaseStat stat;
        switch (this) {
            case Voodoo:
                stat = BaseStat.Charisma;
                break;
            default:
                stat = BaseStat.Intelligence;
        }
        return stat;
    }
}
