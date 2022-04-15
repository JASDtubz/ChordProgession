package main.musicLogic;

public class ChordProgression
{
    private final String relative, parallel, dominant, rDominant, subDominant, rSubDominant;

    public ChordProgression(String note)
    {
        final double rawNote = toRaw(note);

        final double equation1 = (rawNote - 2.5 > 0.9) ? rawNote - 2.5 : rawNote - 2.5 + 12;
        final double equation2 = (rawNote - 5 > 0.9) ? rawNote - 5 : rawNote - 5 + 12;
        final double equation3 = (rawNote + 5 < 12.6) ? rawNote + 5 : rawNote + 5 - 12;
        final double equation4 = (rawNote + 2.5 < 12.6) ? rawNote + 2.5 : rawNote + 2.5 - 12;

        if (rawNote == 1 || rawNote == 2 || rawNote == 3 || rawNote == 4 || rawNote == 5 || rawNote == 6 || rawNote == 7
            || rawNote == 8 || rawNote == 9 || rawNote == 10 || rawNote == 11 || rawNote == 12)
        {
            this.relative = toKey(equation1);
            this.parallel = toKey(rawNote + 0.5);
            this.dominant = toKey(equation2);
            this.rDominant = toKey((rawNote + 4.5 < 12.6) ? rawNote + 4.5 : rawNote + 4.5 - 12);
            this.subDominant = toKey(equation3);
            this.rSubDominant = toKey(equation4);
        }
        else
        {
            this.relative = toKey(equation4);
            this.parallel = toKey(rawNote - 0.5);
            this.dominant = toKey(equation2);
            this.rDominant = toKey(equation1);
            this.subDominant = toKey(equation3);
            this.rSubDominant = toKey((rawNote - 4.5 > 0.9) ? rawNote - 4.5: rawNote - 4.5 + 12);
        }
    }

    public String getRelative()
    {
        return this.relative;
    }

    public String getParallel()
    {
        return this.parallel;
    }

    public String getDominant()
    {
        return this.dominant;
    }

    public String getRDominant()
    {
        return this.rDominant;
    }

    public String getSubDominant()
    {
        return this.subDominant;
    }

    public String getRSubDominant()
    {
        return this.rSubDominant;
    }

    private static String toKey(double note)
    {
        if (note == 1) return "CM";
        else if (note == 1.5) return "cm";
        else if (note == 2) return "C#M";
        else if (note == 2.5) return "c#m";
        else if (note == 3) return "DM";
        else if (note == 3.5) return "dm";
        else if (note == 4) return "EbM";
        else if (note == 4.5) return "ebm";
        else if (note == 5) return "EM";
        else if (note == 5.5) return "em";
        else if (note == 6) return "FM";
        else if (note == 6.5) return "fm";
        else if (note == 7) return "F#M";
        else if (note == 7.5) return "f#m";
        else if (note == 8) return "GM";
        else if (note == 8.5) return "gm";
        else if (note == 9) return "AbM";
        else if (note == 9.5) return "abm";
        else if (note == 10) return "AM";
        else if (note == 10.5) return "am";
        else if (note == 11) return "BbM";
        else if (note == 11.5) return "bbm";
        else if (note == 12) return "BM";
        else if (note == 12.5) return "bm";
        else return "";
    }

    private static double toRaw(String note)
    {
        switch (note)
        {
            case "CM": return 1;
            case "cm": return 1.5;
            case "C#M": return 2;
            case "c#m": return 2.5;
            case "DM": return 3;
            case "dm": return 3.5;
            case "EbM": return 4;
            case "ebm": return 4.5;
            case "EM": return 5;
            case "em": return 5.5;
            case "FM": return 6;
            case "fm": return 6.5;
            case "F#M": return 7;
            case "f#m": return 7.5;
            case "GM": return 8;
            case "gm": return 8.5;
            case "AbM": return 9;
            case "abm": return 9.5;
            case "AM": return 10;
            case "am": return 10.5;
            case "BbM": return 11;
            case "bbm": return 11.5;
            case "BM": return 12;
            case "bm": return 12.5;
            default: return 0;
        }
    }
}
