package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: structure
 * @Package: graph
 * @ClassName: UnDirectionGraphBfs
 * @Author: zwj
 * @Description: 注释 注释 无向图->邻接表表示法->深度优先搜索(dfs)
 * @Date: 2019/11/1 10:38
 * @Version: 1.0
 */
public class UnDirectionGraphDfs {

    boolean found = false;
    private int v; // 顶点个数
    private LinkedList<Integer>adj[];// 邻接表 (数组下标是顶点数，链表是与该顶点数相关联的其他顶点)

    public UnDirectionGraphDfs(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0;i<v;++i){
            adj[i] = new LinkedList<>();
        }
    }

    // 顶点s与顶点t关联，增加边
    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    // dfs 从启始顶点s到终止顶点t的路径
    public void dfs(int s,int t){
        if(s==t)return;
        boolean[]visited = new boolean[v]; // 记录被访问的顶点，避免顶点重复访问
        int[]prev = new int[v];
        for(int i = 0;i<v;++i){
            prev[i] = -1;
        }
        recurDfs(s,t,visited,prev);
        print(prev,s,t);
    }

    // 递归回溯，如果发现之前已经访问过，回溯到前一个顶点继续。直到found==true,说明找到目标顶点.
    private void recurDfs(int w,int t,boolean[]visited,int[]prev){
        if(found == true)return;
        visited[w] = true;
        if(w == t){
            found = true;
            return;
        }
        for(int i=0;i<adj[w].size();++i){
            int q = adj[w].get(i);
            if(!visited[q]){ // 按着某一条边走下去，直到可以走下去将found设置为true,否则返回来再走下一条
                prev[q] = w;
                recurDfs(q,t,visited,prev);
            }
        }
    }


    // 递归打印s-->t的路径
    private void print(int[]prev,int s,int t){
        if(prev[t]!= -1 && t!=s){
            print(prev,s,prev[t]);
        }
        System.out.print(t+" ");
    }


}
