package com.hymerfania.rptools.maptool.meta.macrogeneration;

public class Templates {

    public static final String INPUT_ELEMENT_TEMPLATE = "        <input class=\"%s\" type=\"submit\" name=\"macroLabel\" value=\"%s\"/>&nbsp;";//buttonStyle, stat
    public static final String DIV_BOX_ELEMENT_TEMPLATE = "    <div class=\"%s\"><strong>%s</strong><br>";//divStyle, stat
    public static final String MACRO_PROPS_OPEN_TEMPLATE = "applyToSelected=true;group=%s;playerEditable=false;autoExecute=true;sortBy=%d";//group
    public static final String MACRO_PROPS_HIDDEN_TEMPLATE = "applyToSelected=true;group=%s;playerEditable=false;autoExecute=true;sortBy=%d;color=gray25;fontColor=white";//group

    public static final String OPEN_BASESTAT_CHECK_TEMPLATE =
            "<!-- Open Base Stat Check -->%n" +
                    "[h:de.lib.TestOwnership()]%n" +
                    "[h:Roll = 2d10]%n" +
                    "[h:Stat = \"%s\"]%n" +
                    "[h:StatMod = de.lib.Mod(eval(Stat))]%n" +
                    "[Stat] Save: <font color=green size=+2><b>[r: Roll + StatMod]</b></font><br> (Roll :[Roll], [Stat]:[StatMod])%n" +
                    "%n";

    public static final String HIDDEN_BASESTAT_CHECK_TEMPLATE =
            "<!-- Hidden Base Stat Check -->%n" +
                    "[h:de.lib.TestOwnership()]%n" +
                    "[h:Roll = 2d10]%n" +
                    "[h:Stat = \"%s\"]%n" +
                    "[h:StatMod = de.lib.Mod(eval(Stat))]%n" +
                    "[h:%sCheck = Roll + StatMod]%n" +
                    "Hidden %s Save<br>%n" +
                    "[h:Result = Stat + \" Save: <font color=green size=+2><b>\" + %sCheck + \"</b></font><br> (Roll :\" + Roll + \", \" + Stat + \":\" + StatMod + \")\"]%n" +
                    "[g:Result]%n%n";

    public static final String OPEN_2NDSTAT_CHECK_TEMPLATE =
            "<!-- Open Secondary Stat Check -->%n" +
                    "[h:de.lib.TestOwnership()]%n" +
                    "[h:Roll = 2d10]%n" +
                    "[h:Stat = \"%s\"]%n" +
                    "[h:StatMod = eval(Stat)]%n" +
                    "[Stat] Save: <font color=green size=+2><b>[r: Roll + StatMod]</b></font><br> (Roll :[Roll], [Stat]:[StatMod])%n" +
                    "%n";

    public static final String HIDDEN_2NDSTAT_CHECK_TEMPLATE =
            "<!-- Hidden Secondary Stat Check -->%n" +
                    "[h:de.lib.TestOwnership()]%n" +
                    "[h:Roll = 2d10]%n" +
                    "[h:Stat = \"%s\"]%n" +
                    "[h:StatMod = eval(Stat)]%n" +
                    "[h:%sCheck = Roll + StatMod]%n" +
                    "Hidden %s Save<br>%n" +
                    "[h:Result = Stat + \" Save: <font color=green size=+2><b>\" + %sCheck + \"</b></font><br> (Roll :\" + Roll + \", \" + Stat + \":\" + StatMod + \")\"]%n" +
                    "[g:Result]%n%n";

    public static final String OPEN_SKILL_CHECK_TEMPLATE =
            "<!-- Open Story Skill Check -->%n" +
                    "[h:de.lib.TestOwnership()]%n" +
                    "[h:Roll = 2d10]%n" +
                    "[h:Skill = \"%s\"]%n" +
                    "[h:SkillMod = eval(Skill)]%n" +
                    "[h:Stat = \"%s\"]%n" +
                    "[h:StatMod = de.lib.Mod(eval(Stat))]%n" +
                    "[h:StatMod = min(StatMod, SkillMod)]%n" +
                    "[Skill] roll: <font color=green size=+2><b>[r: Roll + SkillMod + StatMod]</b></font><br> (Roll :[Roll], [Skill]:[SkillMod], [Stat]:[StatMod])%n%n";

    public static final String HIDDEN_SKILL_CHECK_TEMPLATE =
            "<!-- Hidden Story Skill Check -->%n" +
                    "[de.lib.TestOwnership()]%n" +
                    "[h:Roll = 2d10]%n" +
                    "[h:Skill = \"%s\"]%n" +
                    "[h:SkillMod = eval(Skill)]%n" +
                    "[h:Stat = \"%s\"]%n" +
                    "[h:StatMod = de.lib.Mod(eval(Stat))]%n" +
                    "[h:StatMod = min(StatMod, SkillMod)]%n" +
                    "[token.name] rolls secret [Skill] check.<br>%n" +
                    "[h: Result = Skill + \" roll: <font color=green size=+2><b>\" + (Roll + SkillMod + StatMod) + \"</b></font><br> (Roll :\" + Roll +\", \" + Skill + \":\" + SkillMod + \", \" + Stat + \":\" + StatMod + \")\"]%n" +
                    "[g: Result]%n%n";

    public static final String OPEN_MAGIC_CHECK_TEMPLATE =
            "<!-- Open Magic Check -->%n" +
                    "[h:de.lib.TestOwnership()]%n" +
                    "[h:Roll = 2d10]%n" +
                    "[h:SkillName = \"%s\"]%n" +
                    "[h:Skill = \"Skill\" + SkillName]%n" +
                    "[h:SkillMod = eval(Skill)]%n" +
                    "[h:Stat = \"%s\" ]%n" +
                    "[h:StatMod = de.lib.Mod(eval(Stat))]%n" +
                    "[SkillName] roll: <font color=green size=+2><b>%n" +
                    "[r: Roll + SkillMod + StatMod]%n" +
                    "</b></font><br> (Roll :[Roll], [SkillName] Magic: [SkillMod], [Stat]:[StatMod])%n%n";

    public static final String HIDDEN_MAGIC_CHECK_TEMPLATE =
            "<!-- Hidden Magic Check -->%n" +
                    "[h:de.lib.TestOwnership()]%n" +
                    "[h:Roll = 2d10]%n" +
                    "[h:SkillName = \"%s\"]%n" +
                    "[h:Skill = \"Skill\" + SkillName]%n" +
                    "[h:SkillMod = eval(Skill)]%n" +
                    "[h:Stat = \"%s\" ]%n" +
                    "[h:StatMod = de.lib.Mod(eval(Stat))]%n" +
                    "[token.name] rolls secret [Skill] Magic check.<br>%n" +
                    "[h:LocalResult = Skill + \" roll: <font color=green size=+2><b>\" + (Roll + SkillMod + StatMod) + \"</b></font><br> (Roll :\" + Roll +\", \" + Skill + \":\" + SkillMod + \", \" + Stat + \":\" + StatMod + \")\"]%n" +
                    "[g:LocalResult]%n%n";

    public static final String META_TEMPLATE =// label, code, props,label
            "<!-- Create %s Check Macro -->%n" +
                    "[h: command =base64.decode(\"%s\")]%n" +
                    "[h: props = \"%s\" ]%n" +
                    "[r: createMacro(\"%s\", command, props, \";\")]";


    @SuppressWarnings("unused")
    public static final String FORM_CSS_TEMPLATE =
            "form {%n" +
            "    max-width: 640px;%n" +
            "}%n" +
            "%n" +
            ".box {%n" +
            "    background-color: #ece9d8;%n" +
            "    border-color: #a8ab8e;%n" +
            "    border-style: inset ;%n" +
            "    border-width:3px;%n" +
            "    padding: 6px;%n" +
            "}%n" +
            "%n" +
            ".boxHidden {%n" +
            "    background-color:#ada889;%n" +
            "    border-color: #a8ab8e;%n" +
            "    border-style: inset ;%n" +
            "    border-width:3px;%n" +
            "    padding: 6px;%n" +
            "}%n" +
            "%n" +
            ".submitButton {%n" +
            "    background: #e8e8e8;%n" +
            "    color: #FF0000;%n" +
            "}%n" +
            "%n" +
            ".submitButton, .submitButtonHidden, .submitButtonWide0, .submitButtonWide0Hidden,.submitButtonWide1, .submitButtonWide1Hidden {%n" +
            "    background: #e8e8e8;%n" +
            "    color: #000000;%n" +
            "}%n" +
            "%n" +
            ".submitButton:hover {%n" +
            "  background-color: #a0d6d9;%n" +
            "}%n" +
            "%n" +
            ".submitButtonWide0 {%n" +
            "    width: 80px;%n" +
            "}%n" +
            "%n" +
            ".submitButtonWide1 {%n" +
            "    width: 100px;%n" +
            "}%n" +
            "%n" +
            ".submitButtonWide0:hover, .submitButtonWide1:hover  {%n" +
            "  background-color: #a0d6d9;%n" +
            "}%n" +
            "%n" +
            ".submitButtonHidden, .submitButtonWide0Hidden, .submitButtonWide1Hidden {%n" +
            "    color:#FFFFFF;%n" +
            "    background: #42423e;%n" +
            "    text-decoration: line-through;%n" +
            "}%n" +
            "%n" +
            ".submitButtonWide0Hidden {%n" +
            "    width: 80px;%n" +
            "}%n" +
            "%n" +
            ".submitButtonWide1Hidden {%n" +
            "    width: 100px;%n" +
            "}%n" +
            "%n" +
            ".submitButtonHidden:hover, .submitButtonWide0Hidden:hover, .submitButtonWide1Hidden:hover {%n" +
            "  background-color: #1434a8;%n" +
            "}%n";

    public static final String FORM_UI_TEMPLATE =
            "<html>%n" +
                    "<head>%n" +
                    "    <title>Dice Checks and Saves</title>%n" +
                    "    <link rel='stylesheet' type='text/css' href='DiceCheckForm_css@Lib:Master'></link>%n" +
                    "</head>%n" +
                    "%n" +
                    "<body>%n" +
                    "<form action=\"[r:processorLink]\" method=\"json\">%n" +
                    "%s%n" +
                    "</form>%n" +
                    "</body>%n" +
                    "</html>";

    public static final String FORM_MACRO_TEMPLATE =
            "[h: processorLink = macroLinkText(\"EnvokeDiceCheck@Lib:Master\", \"all\",\"\", currentToken())]%n" +
                    "[frame(\"Dice Checks & Saves\"): {%n" + FORM_UI_TEMPLATE + "}]";
}
