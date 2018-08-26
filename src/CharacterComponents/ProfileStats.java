package CharacterComponents;

import java.io.Serializable;

/**
 * @author Yurichi
 */
public class ProfileStats implements Serializable{

    int lvl;
    int xp, maxXp;
    int hp, sp, crit, agl;
    int currentHp, currentSp;

    public ProfileStats() {

    }

    public ProfileStats(int nuLVL, int nuHP, int nuSP, int nuCRIT, int nuAGL) {
        lvl = nuLVL;
        xp = 0;
        hp = nuHP;
        sp = nuSP;
        crit = nuCRIT;
        agl = nuAGL;

        refreshCurrentValues();
        calculateMaxXp();
    }

    public ProfileStats(ProfileStats original) {
        lvl = 0;
        xp = 0;
        hp = original.getHp();
        sp = original.getSp();
        crit = original.getCrit();
        agl = original.getAgl();

        refreshCurrentValues();
        calculateMaxXp();
    }

    private void refreshCurrentValues() {
        currentHp = hp;
        currentSp = sp;
    }

    private void calculateMaxXp() {
        //Re-write
        maxXp = 10;
    }

    public int getLvl() {
        return lvl;
    }

    public int getXp() {
        return xp;
    }

    public int getMaxXp() {
        return maxXp;
    }

    public int getHp() {
        return hp;
    }

    public int getSp() {
        return sp;
    }

    public int getCrit() {
        return crit;
    }

    public int getAgl() {
        return agl;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentSp() {
        return currentSp;
    }

    public String toString() {
        //lvl, xp, maxXp, hp, sp, crit, agl, currentHp, currentSp
        StringBuilder sb = new StringBuilder();
        sb.append("LVL: " + "\t" + lvl + "\n");
        sb.append("XP: " + "\t" + xp + "\n");
        sb.append("MAXXP: " + "\t" + maxXp + "\n");
        sb.append("HP: " + "\t" + hp + "\n");
        sb.append("CURRENTHP: " + "\t"+ currentHp + "\n");
        sb.append("SP: " + "\t" + sp + "\n");
        sb.append("CURRENTSP: " + "\t" + currentSp + "\n");
        sb.append("CRIT: " + "\t" + crit + "\n");
        sb.append("AGL: " + "\t" + agl + "\n");

        return sb.toString();
    }

}
