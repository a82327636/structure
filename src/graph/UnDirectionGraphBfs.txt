package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: structure
 * @Package: graph
 * @ClassName: UnDirectionGraphBfs
 * @Author: zwj
 * @Description: 注释 无向图->邻接表表示法->广度优先搜索(bfs)
 * @Date: 2019/11/1 10:38
 * @Version: 1.0
 */
public class UnDirectionGraphBfs {

    private int v; // 顶点个数
    private LinkedList<Integer>adj[];// 邻接表 (数组下标是顶点数，链表是与该顶点数相关联的其他顶点)

    public UnDirectionGraphBfs(int v){
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

    // bfs广度优先搜索算法 从启始顶点s到终止顶点t的最短路径
    public void bfs(int s,int t){
        if(s==t)return;
        boolean[]visited = new boolean[v]; // 记录被访问的顶点，避免顶点重复访问
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();// 用来存储已经被访问->但相连的顶点还没有被访问的顶点。
        // 广度优先搜索是逐层访问，只有把第k层的顶点都访问完，才会访问第k+1层。需要把第k层的顶点都记录下来
        // 然后通过第k层的顶点找第k+1层顶点。
        queue.add(s);
        int[]prev = new int[v]; // 用来记录搜索路径。这个路径是反向存储的，prev[w]存储的是，顶点w是从哪个前驱顶点遍历过来的。
        for(int i=0;i<v;++i){
            prev[i] = -1;
        }
        while(queue.size()!=0){
            int w = queue.poll();
            for(int i =0;i<adj[w].size();++i){
                int q = adj[w].get(i);
                if(!visited[q]){
                    prev[q] = w;
                    if(q == t){
                        print(prev,s,t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
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
