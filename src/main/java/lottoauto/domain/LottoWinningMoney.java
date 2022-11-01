package lottoauto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoWinningMoney {
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int THREE_MONEY = 5000;
    public static final int FOUR_MONEY = 50000;
    public static final int FIVE_MONEY = 1500000;
    public static final int SIX_MONEY = 2000000000;
    private Map<Integer, Integer> winningMoneyTable;
    public LottoWinningMoney() {
        winningMoneyTable = new HashMap<>();
        winningMoneyTable.put(THREE, THREE_MONEY);
        winningMoneyTable.put(FOUR, FOUR_MONEY);
        winningMoneyTable.put(FIVE, FIVE_MONEY);
        winningMoneyTable.put(SIX, SIX_MONEY);
    }

    public int calculateWinningMoney(Map<Integer, Integer> result) {
        int money = 0;
        for (Integer containCount : winningMoneyTable.keySet()) {
            money += result.getOrDefault(containCount, 0) * getWinningMoney(containCount);
        }
        return money;
    }

    public int getWinningMoney(int containCount){
        return winningMoneyTable.get(containCount);
    }

    public Map<Integer, Integer> getWinningMoneyTable() {
        return winningMoneyTable;
    }
}
