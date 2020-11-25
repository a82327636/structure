package thought.recall;

/**
 * @ProjectName: structure
 * @Package: thought.recall
 * @ClassName: EightQueen
 * @Author: zwj
 * @Description: 注释 八皇后问题
 * @Date: 2019/11/5 9:54
 * @Version: 1.0
 */
public class EightQueen {

    int[]result = new int[8];

    public void cal8queens(int row){ // 调用方式 cal8queens(0)
        if(row == 8){
            printQueens(result);
            return; // 8个棋子都已经放好,没有办法再递归下去了
        }
        for(int cel = 0;cel<8;++cel){
            if(isOk(row,cel)){ // 判断row行cel列放置是否合适
                result[row] = cel; //第row行的棋子放到第cel列
                cal8queens(row+1); // 考察下一行
            }
        }
    }

    // 判断row行cel列放置是否合适
    private boolean isOk(int row,int cel){
        int leftup = cel - 1,rightup = cel + 1;
        for(int i = row - 1;i>=0;--i){ // 从row的上一行开始
            if(result[i] == cel)return false; // 第i行的第cel列上有值(row行的上一行开始)
            if(leftup>=0){ // 考察左上对角线:第i行的leftup列上有棋子吗?
                if(result[i] == leftup)return false;
            }
            if(rightup<8){ // 考察右上对角线:第i行的rightup列上有棋子吗
                if(result[i] == rightup)return false;
            }
            -- leftup; ++ rightup;// 因为对角线每一行都往外扩展一个格子
        }

        return true;
    }

    private void printQueens(int[]result){ // 打印二维矩阵
        for(int row = 0;row<8;++row){
            for(int cel = 0;cel<8;++cel){
                if(result[row] == cel){System.out.print("Q ");} // 每一行可以放置棋子的位置也只有8列
                else{System.out.print("* ");}
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[]result = new int[8];
        System.out.println(result[2]);
    }

}
