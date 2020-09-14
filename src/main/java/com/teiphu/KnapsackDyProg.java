package com.teiphu;

/**
 * @author Zheng Lifu
 */
public class KnapsackDyProg {

    public static void main(String[] args) {
        /*
         * Pack and Weight - Value
         */
        //int W[] = new int[]{3, 4, 5, 9, 4};
        int W[] = new int[]{12, 2, 1, 1, 4};

        //int V[] = new int[]{3, 4, 4, 10, 4};
        int V[] = new int[]{4, 2, 1, 2, 10};

        /*
         * Max Weight
         */
        //int M = 11;
        int M = 15;
        int n = V.length;

        /*
         * Run the algorithm
         */
        knapsackDyProg(W, V, M, n);
    }

    private static void knapsackDyProg(int W[], int V[], int M, int n) {
        int B[][] = new int[n + 1][M + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                B[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                B[i][j] = B[i - 1][j];

                if ((j >= W[i - 1]) && (B[i][j] < B[i - 1][j - W[i - 1]] + V[i - 1])) {
                    B[i][j] = B[i - 1][j - W[i - 1]] + V[i - 1];
                }

                System.out.print(B[i][j] + "\t");
            }
            System.out.print("\n");
        }

        System.out.println("Max Value:\t" + B[n][M]);

        System.out.println("Selected Packs: ");

        while (n != 0) {
            if (B[n][M] != B[n - 1][M]) {
                System.out.println("\tPackage " + n + " with W = " + W[n - 1] + " and Value = " + V[n - 1]);

                M = M - W[n - 1];
            }

            n--;
        }
    }

}
