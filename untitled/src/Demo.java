
import java.util.*;
public class Demo {
    static int n,m;
    static int[][] arr;
    static boolean flag=false;
    static int max=0;
    static String result="";
    static LinkedList<String> list=new LinkedList<>();
    public static void main1(String[] args){
        Scanner scan=new Scanner(System.in);
        int p=0;
        while(scan.hasNext()){
            int n=scan.nextInt();
            int m=scan.nextInt();
            p=scan.nextInt();
            arr=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=scan.nextInt();
                }
            }
        }
        func(0,0,p);
        if(flag){
            System.out.println(result);
        }else{
            System.out.println("can not escape");
        }
    }
    public static void func(int x,int y,int p){
        if(p<0||x<0||y<0||x>=n|y>=m||arr[x][y]!=1){
            return;
        }else{
            list.add("["+x+","+y+"]");
            arr[x][y]=0;
            if(x==0&&y==m-1){
                if(p>=max){
                    max=p;
                    path();
                }
                arr[x][y]=1;
                list.removeLast();
                flag=true;
                return;
            }
            func(x+1,y,p);//下
            func(x-1,y,p-3);//上
            func(x,y+1,p-1);//右
            func(x,y-1,p-1);//左
            arr[x][y]=1;
            list.removeLast();
        }
    }
    public static void path(){
        StringBuilder ret=new StringBuilder();
        Iterator<String> it=list.iterator();
        while(it.hasNext()) {
            ret.append(it.next() + ",");
        }
            if(ret.length()>0){
                ret.deleteCharAt(ret.length()-1);
            }
            result=ret.toString();
        }
    public int[] arrayPrint(int[][] arr, int n) {
        List<Integer> list=new ArrayList<>();
        int col=n-1;
        for(int i=col;i>=0;i--){
            int row=0;
            int k=n-i;
            for(int j=i;k>0;j++,k--){
                list.add(arr[row][j]);
                row++;
            }
        }
        int row=1;
        for(int i=row;i<=n-1;i++){
            int k=n-i;
            col=0;
            for(int j=i;k>0;j++,k--){
                list.add(arr[j][col]);
                col++;
            }
        }
       int[] array=new int[list.size()];
        for(int i=0;i<array.length;i++){
            array[i]=list.get(i);
        }
        return array;
    }
    public static void main2(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        int count=0;
        for (int i = 0; i <str.length() ; i++) {
            if(isHuiWen(str.substring(0,i)+str.substring(i+1))){
                count++;
            }
        }
        if(count==0){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }

    private static boolean isHuiWen(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<=right){
           if(s.charAt(left)!=s.charAt(right)){
               return false;
           }
           left++;
           right--;
        }
        return true;
    }
    public String replaceSpace(String iniString,int length){
        char[] ch=iniString.toCharArray();
        if(iniString==null||length<=0){
            return null;
        }
        int chNum=0;
        int spaceNum=0;
        for (int i = 0; i < ch.length; i++) {
            chNum++;
            if(ch[i]==' '){
                spaceNum++;
            }
        }
        int newLength=chNum+spaceNum*2;
        char[] ch1=new char[newLength];
        System.arraycopy(ch,0,ch1,0,length);
        int indexChNum=chNum-1;
        int indexNew=newLength-1;
        while(indexNew>indexChNum && indexChNum>=0){
            if(ch1[indexChNum]==' '){
                ch1[indexNew--]='0';
                ch1[indexNew--]='2';
                ch1[indexNew--]='%';
            }else{
                ch1[indexNew]=ch1[indexChNum];
                indexNew--;
            }
            indexChNum--;
        }
        return String.copyValueOf(ch1);
    }
}
