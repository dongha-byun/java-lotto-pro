package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final int CONTAIN_VALUE = 1;
    public static final int NOT_CONTAIN_VALUE = 0;
    public static final int NUMBER_COUNT = 6;
    private List<LottoNumber> numbers;
    private Lotto(){}
    public static Lotto create(List<Integer> numbers) {
        Lotto lotto = new Lotto();
        lotto.numbers = numbers.stream()
                .sorted()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());

        return lotto;
    }

    public boolean isContain(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public int containNumberCount(Lotto target) {
        int result = 0;
        for (LottoNumber number : this.numbers) {
            result += target.getContainResult(number);
        }
        return result;
    }

    private int getContainResult(LottoNumber number){
        if(isContain(number)){
            return CONTAIN_VALUE;
        }
        return NOT_CONTAIN_VALUE;
    }

    @Override
    public String toString() {
        String result = "";
        for(LottoNumber number : numbers){
            result += number.toString() + ", ";
        }
        return "[" + result.substring(0, result.length()-2) + "]";
    }
}
