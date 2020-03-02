package com.hcb.algorithm.others;

//https://zhuanlan.zhihu.com/p/74751385

public class FibonacciDemo {

    public static void main(String[] args) {
        double x = myPow(3,5);
        System.out.println(x);
    }
    /**
     * 递归实现,复杂度O(2^n)
     */
    public static long fibonacci_v1(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci_v1(n - 2) + fibonacci_v1(n - 1);
        }
    }
    /**
     * 迭代实现,复杂度O(n)
     */
    public static long fibonacci_v2(int n) {
        if (n <= 0) {
            return 0;
        } else {
            long a = 0;
            long b = 1;

            for (int i = 1; i < n; i++) {
                b = a + b;
                a = b - a;
            }

            return b;
        }
    }
    /**
     * 实现pow函数,实测发现与Math.pow结果存在细微的差别,使用时应做round处理
     */
    public static double myPow(double x, int n) {
        double r = 1;
        double v = x;

        while (n != 0) {
            if (n % 2 == 1) {
                r *= v;
                n -= 1;
            }
            v *= v;
            n /= 2;
        }

        return r;
    }
    /**
     * 实现pow函数,复杂度O(log(n))
     * Math.round()取整
     */
    public static long fibonacci_v4(int n) {
        double result =
                Math.round((FibonacciDemo.myPow((1 + Math.sqrt(5)) / 2, n) - FibonacciDemo.myPow((1 - Math.sqrt(5)) / 2, n)) / Math.sqrt(5));
        return new Double(result).longValue();
    }

    /**
     * 2 * 2 整数矩阵乘法
     */
    public static long[][] matrix22_mul(long[][] a, long[][] b) {
        long[][] r = new long[2][2];

        r[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        r[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        r[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        r[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];

        return r;
    }

    /**
     * 2 * 2 整数矩阵N次幂
     */
    public static long[][] matrix22_pow(long[][] x, int n) {
        long r[][] = {{1, 0}, {0, 1}};
        long[][] v = x;

        while (n != 0) {
            if (n % 2 == 1) {
                r = matrix22_mul(r, v);
                n -= 1;
            }
            v = matrix22_mul(v, v);
            n /= 2;
        }

        return r;
    }

    /**
     * 迭代算法的矩阵实现,复杂度O(log(n))
     * 去除了浮点数运算
     */
    public static long fibonacci_v5(int n) {
        if (n <= 0) {
            return 0;
        } else {
            long x[][] = {{0, 1}, {0, 0}};
            long y[][] = {{0, 1}, {1, 1}};

            return matrix22_mul(x, matrix22_pow(y, n - 1))[0][1];
        }
    }
}
