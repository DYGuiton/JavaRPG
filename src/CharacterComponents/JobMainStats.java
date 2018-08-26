package CharacterComponents;

import java.io.Serializable;

/**
 * @author Yurichi
 */
public class JobMainStats implements Serializable{

    int rank, maxRank;
    int xp, maxXp;
    int atk, mag, def, mdef, res, spd;
    
    
    public JobMainStats() {

    }

    public JobMainStats(int newAtk, int newMag, int newDef, int newMDef, int newRes, int newSpd) {
        rank = 0;
        xp = 0;
        atk = newAtk;
        mag = newMag;
        def = newDef;
        mdef = newMDef;
        res = newRes;
        spd = newSpd;

        calculateMaxXp();

    }

    public JobMainStats(JobMainStats original) {
        rank = 0;
        xp = 0;
        atk = original.getAtk();
        mag = original.getMag();
        def = original.getDef();
        mdef = original.getMDef();
        res = original.getRes();
        spd = original.getSpd();

        calculateMaxXp();
        calculateMaxRank();
    }

    private void calculateMaxXp() {
        //Re-write
        maxXp = 10;

    }
    
    private void calculateMaxRank(){
        //Re-Write
        maxRank = 3;
    }

    public int getRank() {
        return rank;
    }
    
    public int getMaxRank(){
        return maxRank;
    }

    public int getXp() {
        return xp;
    }

    public int getMaxXp() {
        return maxXp;
    }

    public int getAtk() {
        return atk;
    }
    
    public int getMag(){
        return mag;
    }

    public int getDef() {
        return def;
    }

    public int getMDef() {
        return mdef;
    }

    public int getRes() {
        return res;
    }

    public int getSpd() {
        return spd;
    }

    public String toString(){
        //rank, maxRank, xp, maxXp, atk, mag, def, mDef, res, spd
        StringBuilder sb = new StringBuilder();
        sb.append("RANK: " + "\t" + rank + "\n");
        sb.append("MAXRANK: " + "\t" + maxRank + "\n");
        sb.append("XP: " + "\t" + xp + "\n");
        sb.append("MAXXP: " + "\t" + maxXp + "\n");
        sb.append("ATK: " + "\t" + atk + "\n");
        sb.append("MAG: " + "\t" + mag + "\n");
        sb.append("DEF: " + "\t" + def + "\n");
        sb.append("MDEF: " + "\t" + mdef + "\n");
        sb.append("RES: " + "\t" + res + "\n");
        sb.append("SPD: " + "\t" + spd + "\n");
        
        return sb.toString();
    }
}
