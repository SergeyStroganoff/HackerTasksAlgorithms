package easy.teemo_atacking;

public class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration == 0) {
            return 0;
        }
        int finalDuration = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            int nexEffectStart = Integer.MAX_VALUE;
            if (i < timeSeries.length - 1) {
                nexEffectStart = timeSeries[i + 1];
            }
            finalDuration += effectTime(timeSeries[i], duration, nexEffectStart);
        }
        return finalDuration;
    }

    private int effectTime(int nextEffect, int duration, int nextEffectStart) {
        int endAttack = nextEffect + duration - 1;
        int twoAttackGap = nextEffectStart - endAttack - 1;
        if (twoAttackGap < 0) {
            endAttack = endAttack - Math.abs(twoAttackGap);
        }
        return endAttack - nextEffect + 1;
    }


    public int findPoisonedDurationEffective(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration == 0) return 0;

        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            total += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        return total + duration; // last attack always adds full duration
    }

}


