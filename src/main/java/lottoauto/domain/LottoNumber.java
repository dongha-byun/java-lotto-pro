package lottoauto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private int number;
    public static final List<Integer> CACHE = new ArrayList<>();

    static {
        for(int i=MIN_NUMBER; i<=MAX_NUMBER; i++){
            CACHE.add(i);
        }
    }

    private LottoNumber(){}

    private void validateRange(int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException("로또번호의 범위(1~45)에 맞지 않습니다.");
        }
    }

    public static LottoNumber create(int number){
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.validateRange(number);
        lottoNumber.number = number;

        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
