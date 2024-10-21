
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
/**
 * 测试类设计原则：
 * 1. 等价类划分：
 *    - 测试分数能整除的情况
 *    - 测试无循环小数的情况
 *    - 测试有循环小数的情况
 *    - 测试负数情况
 * 2. 边界值分析：
 *    - 测试极大值和极小值的边界
 */
public class L2022211823_1_Test {
    /**
     * 测试目的：
     * 验证分子能被分母整除时，返回整数结果
     * 测试用例：
     * numerator = 4, denominator = 2，结果应为 "2"
     */
    @Test
    public void testIntegerResult() {
        Solution1 solution = new Solution1();
        assertEquals("2", solution.fractionToDecimal(4, 2));
    }

    /**
     * 测试目的：
     * 验证无循环小数时，返回正确的小数
     * 测试用例：
     * numerator = 1, denominator = 2，结果应为 "0.5"
     */
    @Test
    public void testNonRepeatingDecimal() {
        Solution1 solution = new Solution1();
        assertEquals("0.5", solution.fractionToDecimal(1, 2));
    }

    /**
     * 测试目的：
     * 验证有循环小数时，返回正确的循环部分
     * 测试用例：
     * numerator = 4, denominator = 333，结果应为 "0.(012)"
     */
    @Test
    public void testRepeatingDecimal() {
        Solution1 solution = new Solution1();
        assertEquals("0.(012)", solution.fractionToDecimal(4, 333));
    }

    /**
     * 测试目的：
     * 验证负数情况下返回正确的结果
     * 测试用例：
     * numerator = -1, denominator = 2，结果应为 "-0.5"
     */
    @Test
    public void testNegativeResult() {
        Solution1 solution = new Solution1();
        assertEquals("-0.5", solution.fractionToDecimal(-1, 2));
    }
    /**
     * 测试目的：
     * 测试极大值边界情况
     * 测试用例：
     * numerator = 1, denominator = Integer.MAX_VALUE，结果应为 "0.0000000004656613"
     */
    @Test
    public void testMaxDenominator() {
        Solution1 solution = new Solution1();
        assertEquals("0.0000000004656613", solution.fractionToDecimal(1, Integer.MAX_VALUE));
    }

    /**
     * 测试目的：
     * 测试分子为0的情况
     * 测试用例：
     * numerator = 0, denominator = 5，结果应为 "0"
     */
    @Test
    public void testNumeratorZero() {
        Solution1 solution = new Solution1();
        assertEquals("0", solution.fractionToDecimal(0, 5));
    }
}