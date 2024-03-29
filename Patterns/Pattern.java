package DSA.Patterns;

public class Pattern {
    public void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public void pattern5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void pattern6(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * (n - i) - 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public void pattern7(int n) {
        pattern5(n);
        pattern6(n);
    }

    public int nCr(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public void pattern8(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(nCr(i - 1, j - 1) + " ");
            }
            System.out.println();
        }
    }

    public void pattern9(int n) {
        pattern1(n);
        pattern3(n - 1);
    }

    public void pattern10(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }

    public void pattern11(int n) {
        int space = 2 * n - 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
            space -= 2;
        }
    }

    public void pattern12(int n) {
        int k = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(k++ + " ");
            }
            System.out.println();
        }
    }

    public void pattern13(int n) {
        int k = 65;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%c ", k++);
            }
            System.out.println();
            k = 65;
        }
    }

    public void pattern14(int n) {
        int k = 65;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.printf("%c ", k++);
            }
            System.out.println();
            k = 65;
        }
    }

    public void pattern15(int n) {
        int k = 65;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%c ", k);
            }
            System.out.println();
            k++;
        }
    }

    public void pattern16(int n) {
        int k = 65;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.printf("%c ", k);
            }
            System.out.println();
            k++;
        }
    }

    public void pattern17(int n) {
        for (int i = 1; i <= n; i++) {
            int k = 65;
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            int breakPoint = (2 * i - 1) / 2;
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.printf("%c", k);
                if (j <= breakPoint)
                    k++;
                else
                    k--;
            }
            System.out.println();
        }
    }

    public void pattern18(int n) {
        int k = 64+n;
        int start = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(j==1) start = k;
                System.out.printf("%c ",k++);
            }
            k = start-1;
            System.out.println();
        }
    }

    
    public static void main(String[] args) {
        new Pattern().pattern18(6);
    }
}
