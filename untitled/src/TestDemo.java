import java.util.*;

public class TestDemo {
    private static void findMoney(String p, String a) {
        String[] pm = p.split("\\.");
        int moneyp = (pm.length >= 1 ? Integer.parseInt(pm[0]) * 17 * 29 : 0) +
                (pm.length >= 2 ? Integer.parseInt(pm[1]) * 29 : 0) +
                (pm.length >= 3 ? Integer.parseInt(pm[2]) : 0);

        String[] am = a.split("\\.");
        int moneya = (am.length >= 1 ? Integer.parseInt(am[0]) * 17 * 29 : 0) +
                (am.length >= 2 ? Integer.parseInt(am[1]) * 29 : 0) +
                (am.length >= 3 ? Integer.parseInt(am[2]) : 0);
        int money = moneya - moneyp;
        if (money < 0) {
            money = money * (-1);
            System.out.print("-");
        }
        System.out.println(money / (17 * 29) + "." + (money % (17 * 29)) / 29 + "." + money % (17 * 29) % 29);
    }

    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String p = scan.next();
            String a = scan.next();
            findMoney(p, a);
        }
    }

    public static int countNumberOf2(int n) {
        int div = 1;
        int count = 0;
        while (n / div != 0) {
            int num = n / div;//div=1,num=123
            int cur = num % 10;//3
            int high = num / 10;//12
            int low = n % div;
            if (cur < 2) {
                count += high * div;
            } else if (cur == 2) {
                count = count + high * div + (low + 1);
            } else {
                count += (high + 1) * div;
            }
            if (n / div < 20) {
                break;
            }
            div *= 10;
        }
        return count;
    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            char[][] arr = new char[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = scan.next().charAt(0);
                }
            }
            int[][] ret = new int[4][3];
            //平局
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i][0] == 'C' && arr[i][1] == 'C') || (arr[i][0] == 'J' && arr[i][1] == 'J')
                        || (arr[i][0] == 'B' && arr[i][1] == 'B')) {
                    ret[0][1]++;
                    ret[2][1]++;
                }
                //甲赢乙输
                if ((arr[i][0] == 'C' && arr[i][1] == 'J') || (arr[i][0] == 'J' && arr[i][1] == 'B')
                        || ((arr[i][0] == 'B' && arr[i][1] == 'C'))) {
                    ret[0][0]++;
                    ret[2][2]++;
                    if (arr[i][0] == 'C') {
                        ret[1][0]++;
                    }
                    if (arr[i][0] == 'J') {
                        ret[1][1]++;
                    }
                    if (arr[i][0] == 'B') {
                        ret[1][2]++;
                    }
                }
                //当乙赢甲输
                if ((arr[i][0] == 'C' && arr[i][1] == 'B') || (arr[i][0] == 'J' && arr[i][1] == 'C')
                        || ((arr[i][0] == 'B' && arr[i][1] == 'J'))) {
                    ret[2][0]++;
                    ret[0][2]++;
                    if (arr[i][1] == 'C') {
                        ret[3][0]++;
                    }
                    if (arr[i][1] == 'J') {
                        ret[3][1]++;
                    }
                    if (arr[i][1] == 'B') {
                        ret[3][2]++;
                    }
                }
            }
            System.out.println(ret[0][0] + " " + ret[0][1] + " " + ret[0][2]);
            System.out.println(ret[2][0] + " " + ret[2][1] + " " + ret[2][2]);
            if (ret[1][2] >= ret[1][1] && ret[1][2] >= ret[1][0]) {
                System.out.print("B ");
            } else if (ret[1][0] >= ret[1][1] && ret[1][0] >= ret[1][2]) {
                System.out.print("C ");
            } else {
                System.out.print("J ");
            }
            if (ret[3][2] >= ret[3][1] && ret[3][2] >= ret[3][0]) {
                System.out.print("B ");
            } else if (ret[3][0] >= ret[3][1] && ret[3][0] >= ret[3][2]) {
                System.out.print("C ");
            } else {
                System.out.print("J ");
            }
        }
    }

    public int countWays(int n) {
        int[] arr = new int[100000];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i <= n; i++) {
            arr[i] = (arr[i - 1] + (arr[i - 2] + arr[i - 3]) % 1000000007) % 1000000007;
        }
        return arr[n];
    }
//坏键盘
    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);
        String right = scan.nextLine();
        String wrong = scan.nextLine();
        Set<Character> set = new HashSet<>();
        Set<Character> set1 = new HashSet<>();
        for (char ch : wrong.toUpperCase().toCharArray()) {
            set.add(ch);
        }
        for (char ch1 : right.toUpperCase().toCharArray()) {
            if (!set.contains(ch1) && !set1.contains(ch1)) {
                System.out.print(ch1);
                set1.add(ch1);
            }
        }
    }
//计算球的半径和体积
    public static void main4(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] arr = str.split(" ");
        double[] d = new double[6];
        for (int i = 0; i < 6; i++) {
            d[i] = Double.parseDouble(arr[i]);
        }
        double r = Math.pow(Math.pow((d[3] - d[0]), 2) + Math.pow((d[4] - d[1]), 2) +
                Math.pow((d[5] - d[2]), 2), 0.5);
        //Math.acos(-1)==圆周率
        System.out.printf("%.3f %.3f\n", r, 4 * Math.acos(-1) * r * r * r / 3);
    }
//字母统计
    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr=new int[26];
        while (scan.hasNext()) {
            String str = scan.nextLine();
            char[] ch=str.toCharArray();
            for(int i=0;i<ch.length;i++){
                if(ch[i]>='A'&&ch[i]<='Z'){
                    arr[ch[i]-'A']++;
                }
            }
            for(int i=0;i<26;i++){
                System.out.println((char)('A'+i)+":"+arr[i]);
            }
        }
    }
    public static void main6(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.nextLine();
            String str1=str.substring(2,str.length());
            int tmp=0;
            int sum=0;
            int n=16;
            int count=str1.length()-1;
            for(int i=0;i<str1.length();i++){
                char ch=str1.charAt(i);
                if(ch>='0'&&ch<='9'){
                    tmp=ch-'0';
                }else if(ch>='A'&&ch<='Z'){
                    tmp=ch-'A'+10;
                }else if(ch>='a'&&ch<='z'){
                    tmp=ch-'a'+10;
                }else{
                    break;
                }
                sum+=tmp*Math.pow(n,count);
                count--;
            }
            System.out.println(sum);
        }
    }
}
