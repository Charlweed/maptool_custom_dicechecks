package com.hymerfania.rptools.maptool.meta.macrogeneration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@SuppressWarnings("StringBufferReplaceableByString")
public class DiceChecks {
    public static final String META_MACRO_SOURCE_FILENAME = "r:/all_saves_macro_src.txt";
    public static final String FORM_MACRO_SOURCE_FILENAME = "r:/form_macro_src.html";
    static final String NL = System.lineSeparator();

    public static void writeMetaMacroCodeToFile() throws IOException, InterruptedException {
        Path macroSourceTextFile = Paths.get(META_MACRO_SOURCE_FILENAME);

        Files.deleteIfExists(macroSourceTextFile);
        Thread.sleep(500L);

        if (Files.exists(macroSourceTextFile)) {
            throw new IOException("Could not delete " + macroSourceTextFile.toAbsolutePath());
        }
        System.out.println("Writing macro text to " + macroSourceTextFile.toAbsolutePath());

        for (BaseStat stat : BaseStat.values()) {
            appendLineToFile(makeStatMetaMacroOpen(stat), META_MACRO_SOURCE_FILENAME);
            appendLineToFile(makeStatMetaMacroHidden(stat), META_MACRO_SOURCE_FILENAME);
            appendLineToFile(NL, META_MACRO_SOURCE_FILENAME);
        }
        appendLineToFile(NL, META_MACRO_SOURCE_FILENAME);

        for (SecondaryStat stat : SecondaryStat.values()) {
            appendLineToFile(makeStatMetaMacroOpen(stat), META_MACRO_SOURCE_FILENAME);
            appendLineToFile(makeStatMetaMacroHidden(stat), META_MACRO_SOURCE_FILENAME);
            appendLineToFile(NL, META_MACRO_SOURCE_FILENAME);
        }
        appendLineToFile(NL, META_MACRO_SOURCE_FILENAME);

        for (StorySkill skill : StorySkill.values()) {
            appendLineToFile(makeSkillMetaMacroOpen(skill), META_MACRO_SOURCE_FILENAME);
            appendLineToFile(makeSkillMetaMacroHidden(skill), META_MACRO_SOURCE_FILENAME);
            appendLineToFile(NL, META_MACRO_SOURCE_FILENAME);
        }
        appendLineToFile(NL, META_MACRO_SOURCE_FILENAME);

        for (MagicSkill skill : MagicSkill.values()) {
            appendLineToFile(makeMagicMetaMacroOpen(skill), META_MACRO_SOURCE_FILENAME);
            appendLineToFile(makeMagicMetaMacroHidden(skill), META_MACRO_SOURCE_FILENAME);
            appendLineToFile(NL, META_MACRO_SOURCE_FILENAME);
        }
    }

    public static void writeFormMacroCodeToFile() throws IOException, InterruptedException {
        Path macroSourceTextFile = Paths.get(FORM_MACRO_SOURCE_FILENAME);

        Files.deleteIfExists(macroSourceTextFile);
        Thread.sleep(500L);

        if (Files.exists(macroSourceTextFile)) {
            throw new IOException("Could not delete " + macroSourceTextFile.toAbsolutePath());
        }
        System.out.println("Writing macro text to " + macroSourceTextFile.toAbsolutePath());
        StringBuilder bodyText = new StringBuilder();
        bodyText.append(makeStatDivBoxOpen());
        bodyText.append(makeStatDivBoxHidden());
        bodyText.append(makeStorySkillDivBoxOpen());
        bodyText.append(makeStorySkillDivBoxHidden());
        bodyText.append(makeMagicSkillDivBoxOpen());
        bodyText.append(makeMagicSkillDivBoxHidden());
        String result = String.format(Templates.FORM_MACRO_TEMPLATE, bodyText);
        appendLineToFile(result, FORM_MACRO_SOURCE_FILENAME);
    }

    private static String makeStatDivBoxOpen() {
        List<String> inputElements = new ArrayList<>();
        for (BaseStat stat : BaseStat.values()) {
            inputElements.add(makeInputElement(stat, false));
        }
        for (SecondaryStat stat : SecondaryStat.values()) {
            inputElements.add(makeInputElement(stat, false));
        }
        StringBuilder result = new StringBuilder(
                String.format(Templates.DIV_BOX_ELEMENT_TEMPLATE, "box", "Stat Saves:"));
        result.append(NL);
        result.append(String.join(NL, inputElements));
        result.append(NL);
        result.append("    </div>");
        result.append(NL);
        return result.toString();
    }

    private static String makeStatDivBoxHidden() {
        List<String> inputElements = new ArrayList<>();
        for (BaseStat stat : BaseStat.values()) {
            inputElements.add(makeInputElement(stat, true));
        }
        for (SecondaryStat stat : SecondaryStat.values()) {
            inputElements.add(makeInputElement(stat, true));
        }
        StringBuilder result = new StringBuilder(
                String.format(Templates.DIV_BOX_ELEMENT_TEMPLATE, "boxHidden", "Stat Saves:HIDDEN"));
        result.append(NL);
        result.append(String.join(NL, inputElements));
        result.append(NL);
        result.append("    </div>");
        result.append(NL);
        return result.toString();
    }

    private static String makeStorySkillDivBoxOpen() {
        List<String> inputElements = new ArrayList<>();
        for (StorySkill skill : StorySkill.values()) {
            inputElements.add(makeInputElement(skill, false));
        }
        StringBuilder result = new StringBuilder(
                String.format(Templates.DIV_BOX_ELEMENT_TEMPLATE, "box", "Story Skills:"));
        result.append(NL);
        result.append(String.join(NL, inputElements));
        result.append(NL);
        result.append("    </div>");
        result.append(NL);
        return result.toString();
    }

    private static String makeStorySkillDivBoxHidden() {
        List<String> inputElements = new ArrayList<>();
        for (StorySkill skill : StorySkill.values()) {
            inputElements.add(makeInputElement(skill, true));
        }
        StringBuilder result = new StringBuilder(
                String.format(Templates.DIV_BOX_ELEMENT_TEMPLATE, "boxHidden", "Story Skills:HIDDEN"));
        result.append(NL);
        result.append(String.join(NL, inputElements));
        result.append(NL);
        result.append("    </div>");
        result.append(NL);
        return result.toString();
    }

    private static String makeMagicSkillDivBoxOpen() {
        List<String> inputElements = new ArrayList<>();
        for (MagicSkill skill : MagicSkill.values()) {
            inputElements.add(makeInputElement(skill, false));
        }
        StringBuilder result = new StringBuilder(
                String.format(Templates.DIV_BOX_ELEMENT_TEMPLATE, "box", "Magic Skills:"));
        result.append(NL);
        result.append(String.join(NL, inputElements));
        result.append(NL);
        result.append("    </div>");
        result.append(NL);
        return result.toString();
    }

    private static String makeMagicSkillDivBoxHidden() {
        List<String> inputElements = new ArrayList<>();
        for (MagicSkill skill : MagicSkill.values()) {
            inputElements.add(makeInputElement(skill, true));
        }
        StringBuilder result = new StringBuilder(
                String.format(Templates.DIV_BOX_ELEMENT_TEMPLATE, "boxHidden", "Magic Skills:HIDDEN"));
        result.append(NL);
        result.append(String.join(NL, inputElements));
        result.append(NL);
        result.append("    </div>");
        result.append(NL);
        return result.toString();
    }


    private static String buttonStyleString(Object keyRep, boolean hidden) {
        String value = keyRep.toString();
        String styleStr = "submitButtonWide0";
        if (value.length() < 4) {
            styleStr = "submitButton";
        }
        if (value.length() > 11) {
            styleStr = "submitButtonWide1";
        }
        if (hidden) {
            styleStr = styleStr + "Hidden";
        }
        return styleStr;
    }

    private static String makeInputElement(BaseStat keyRep, boolean hidden) {
        return makeInputElement(keyRep.getAbbreviation(), hidden);
    }

    private static String makeInputElement(Object keyRep, boolean hidden) {
        return String.format(Templates.INPUT_ELEMENT_TEMPLATE, buttonStyleString(keyRep, hidden), keyRep.toString());
    }

    private static String makeStatMetaMacroOpen(BaseStat stat) {
        String encodedText = Base64.getEncoder().encodeToString(makeStatOpenCheckMacroText(stat.toString()).getBytes());
        return makeMetaMacroText(stat.getAbbreviation(), encodedText, "\tStat Saves:", stat.ordinal() + 1);
    }

    private static String makeStatMetaMacroHidden(BaseStat stat) {
        String encodedText = Base64.getEncoder()
                                   .encodeToString(makeStatHiddenCheckMacroText(stat.toString()).getBytes());
        return makeMetaMacroText(stat.getAbbreviation(), encodedText, "\tStat Saves: HIDDEN", stat.ordinal() + 1, true);
    }

    private static String makeStatMetaMacroOpen(SecondaryStat stat) {
        String encodedText = Base64.getEncoder().encodeToString(makeStatOpenCheckMacroText(stat.toString()).getBytes());
        return makeMetaMacroText(stat.toString(), encodedText, "\tStat Saves:", stat.ordinal() + 7);
    }

    private static String makeStatMetaMacroHidden(SecondaryStat stat) {
        String encodedText = Base64.getEncoder()
                                   .encodeToString(makeStatHiddenCheckMacroText(stat.toString()).getBytes());
        return makeMetaMacroText(stat.toString(), encodedText, "\tStat Saves: HIDDEN", stat.ordinal() + 7, true);
    }

    private static String makeSkillMetaMacroOpen(StorySkill skill) {
        String encodedText = Base64.getEncoder()
                                   .encodeToString(
                                           makeSkillOpenCheckMacroText(skill.statOf().toString(),
                                                   skill.toString()).getBytes());
        return makeMetaMacroText(skill.toString(), encodedText, "Story Skills:", skill.ordinal() + 1);
    }

    private static String makeSkillMetaMacroHidden(StorySkill skill) {
        String encodedText = Base64.getEncoder()
                                   .encodeToString(
                                           makeSkillHiddenCheckMacroText(skill.statOf().toString(),
                                                   skill.toString()).getBytes());
        return makeMetaMacroText(skill.toString(), encodedText, "Story Skills: HIDDEN", skill.ordinal() + 1, true);
    }

    private static String makeMagicMetaMacroOpen(MagicSkill skill) {
        String encodedText = Base64.getEncoder()
                                   .encodeToString(
                                           makeMagicOpenCheckMacroText(skill.statOf().toString(),
                                                   skill.toString()).getBytes());
        return makeMetaMacroText(skill.toString(), encodedText, "\u007fMagic Skills:", skill.ordinal() + 1);
    }

    private static String makeMagicMetaMacroHidden(MagicSkill skill) {
        String encodedText = Base64.getEncoder()
                                   .encodeToString(
                                           makeMagicHiddenCheckMacroText(skill.statOf().toString(),
                                                   skill.toString()).getBytes());
        return makeMetaMacroText(skill.toString(), encodedText, "\u007fMagic Skills: HIDDEN", skill.ordinal() + 1,
                true);
    }

    private static String makeMagicOpenCheckMacroText(String stat, String skill) {
        return String.format(Templates.OPEN_MAGIC_CHECK_TEMPLATE, skill, stat);
    }

    private static String makeMetaMacroText(String label, String encoded, String group, int sortBy) {
        return makeMetaMacroText(label, encoded, group, sortBy, false);
    }

    private static String makeMetaMacroText(String label, String encoded, String group, int sortBy, boolean hidden) {
        final String result;
        String propText;
        if (!hidden) {
            propText = String.format(Templates.MACRO_PROPS_OPEN_TEMPLATE, group, sortBy);
            result = String.format(Templates.META_TEMPLATE, label, encoded, propText, label);
        }
        else {
            propText = String.format(Templates.MACRO_PROPS_HIDDEN_TEMPLATE, group, sortBy);
            result = String.format(Templates.META_TEMPLATE, "Hidden " + label, encoded, propText, label + "~");
        }

        return result;
    }

    private static String makeStatOpenCheckMacroText(String stat) {
        return String.format(Templates.OPEN_STAT_CHECK_TEMPLATE, stat);
    }

    private static String makeStatHiddenCheckMacroText(String stat) {
        return String.format(Templates.HIDDEN_STAT_CHECK_TEMPLATE, stat, stat, stat, stat);
    }

    private static String makeSkillOpenCheckMacroText(String stat, String skill) {
        return String.format(Templates.OPEN_SKILL_CHECK_TEMPLATE, skill, stat);
    }

    private static String makeSkillHiddenCheckMacroText(String stat, String skill) {
        return String.format(Templates.HIDDEN_SKILL_CHECK_TEMPLATE, skill, stat);
    }

    private static String makeMagicHiddenCheckMacroText(String stat, String skill) {
        return String.format(Templates.HIDDEN_MAGIC_CHECK_TEMPLATE, skill, stat);
    }

    public static void appendLineToFile(String str, final String fileName) {
        try (  /* Open given file in append mode. */
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(str);
            writer.write(System.lineSeparator());
            System.out.println(str);
        }
        catch (IOException thrown) {
            thrown.printStackTrace();
        }
    }

}
