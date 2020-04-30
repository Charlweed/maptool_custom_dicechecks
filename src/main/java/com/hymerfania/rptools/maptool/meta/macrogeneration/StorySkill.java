package com.hymerfania.rptools.maptool.meta.macrogeneration;

@SuppressWarnings("DuplicateBranchesInSwitch")
public enum StorySkill {
    Acrobatics,
    Athletics,
    Concocting,
    Crafting,
    Diplomacy,
    Dungeoneering,
    HighSociety,
    Insight,
    Intimidate,
    Lore,
    Medical,
    Nature,
    PerformingArts,
    Perception,
    Seafaring,
    Stealth,
    Streetwise,
    Theology,
    Thievery,
    Common;

    public BaseStat statOf() {
        BaseStat stat;
        switch (this) {
            case Acrobatics:
                stat = BaseStat.Dexterity;
                break;
            case Athletics:
                stat = BaseStat.Constitution;
                break;
            case Concocting:
                stat = BaseStat.Wisdom;
                break;
            case Crafting:
                stat = BaseStat.Intelligence;
                break;
            case Diplomacy:
                stat = BaseStat.Charisma;
                break;
            case Dungeoneering:
                stat = BaseStat.Intelligence;
                break;
            case HighSociety:
                stat = BaseStat.Intelligence;
                break;
            case Insight:
                stat = BaseStat.Charisma;
                break;
            case Intimidate:
                stat = BaseStat.Charisma;
                break;
            case Lore:
                stat = BaseStat.Intelligence;
                break;
            case Medical:
                stat = BaseStat.Intelligence;
                break;
            case Nature:
                stat = BaseStat.Intelligence;
                break;
            case PerformingArts:
                stat = BaseStat.Dexterity;
                break;
            case Perception:
                stat = BaseStat.Intelligence;
                break;
            case Seafaring:
                stat = BaseStat.Wisdom;
                break;
            case Stealth:
                stat = BaseStat.Dexterity;
                break;
            case Streetwise:
                stat = BaseStat.Intelligence;
                break;
            case Theology:
                stat = BaseStat.Wisdom;
                break;
            case Thievery:
                stat = BaseStat.Dexterity;
                break;
            case Common:
                stat = BaseStat.Intelligence;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
        return stat;
    }
}
