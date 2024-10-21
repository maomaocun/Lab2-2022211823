import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public String fractionToDecimal(int numerator, int denominator) {
        // 转换为 long，避免溢出
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        
        // 如果整除，直接返回结果
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }

        StringBuilder sb = new StringBuilder();
        // 如果是负数，加上负号
        if ((numeratorLong < 0) ^ (denominatorLong < 0)) {
            sb.append('-');
        }

        // 处理整数部分
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;
        sb.append(integerPart);
        sb.append('.');

        // 处理小数部分
        StringBuilder fractionPart = new StringBuilder();
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        long remainder = numeratorLong % denominatorLong;
        int index = 0;

        // 循环直到出现重复余数
        while (remainder != 0 && !remainderIndexMap.containsKey(remainder)) {
            remainderIndexMap.put(remainder, index);
            remainder *= 10;
            fractionPart.append(remainder / denominatorLong);
            remainder %= denominatorLong;
            index++;
        }

        // 如果有循环节
        if (remainder != 0) {
            int insertIndex = remainderIndexMap.get(remainder);
            fractionPart.insert(insertIndex, '(');
            fractionPart.append(')');
        }

        sb.append(fractionPart.toString());
        return sb.toString();
    }
}