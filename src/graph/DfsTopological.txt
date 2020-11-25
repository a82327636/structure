package graph;

import java.util.LinkedList;

/**
 * @ProjectName: structure
 * @Package: graph
 * @ClassName: KahnTopological
 * @Author: zwj
 * @Description: 注释 实现拓扑排序的dfs算法
 *
 * 举例来说，如果我们将一系列需要运行的任务构成一个有向图，图中的有向边则代表某一任务必须在另一个任务之前完成这一限制。
 * 那么运用拓扑排序，我们就能得到满足执行顺序限制条件的一系列任务所需执行的先后顺序。
 * 当然也有可能图中并不存在这样一个拓扑顺序，这种情况下我们无法根据给定要求完成这一系列任务，这种情况称为循环依赖。
 *
 *
 * dfs算法 （深度优先遍历）
 *
 * 核心思路
 *
 * 构建 逆邻接表
 *
 *
 * @Date: 2019/11/1 11:47
 * @Version: 1.0
 */
public class DfsTopological {

    private Digraph digraph;
    public DfsTopological(Digraph digraph){
        this.digraph = digraph;
    }


    public void topoSortByDfs(){
        // 构建 逆邻接表，边s->t,s依赖于t,t先于s(与邻接表相反)
        LinkedList<Integer>inverseAdj[] = new LinkedList[digraph.getV()];
        for(int i = 0;i<digraph.getV();++i){
            inverseAdj[i] = new LinkedList<>();//申请空间
        }
        for(int i = 0;i<digraph.getV();++i){ // 通过邻接表生成逆邻接表
            for(int j = 0;j<digraph.getAdj()[i].size();++j){
                int w = digraph.getAdj()[i].get(j); // i->w
                inverseAdj[w].add(i); // w->i
            }
        }
        boolean[]visited = new boolean[digraph.getV()];
        for(int i = 0; i<digraph.getV();++i){ //深度优先遍历图
            if(visited[i] == false){
                visited[i] = true;
                dfs(i,inverseAdj,visited);
            }
        }

    }

    private void dfs(int vertex,LinkedList<Integer>inverseAdj[],boolean[]visited){
        for(int i = 0;i<inverseAdj[vertex].size();++i){
            int w = inverseAdj[vertex].get(i);
            if(visited[w] == true){
                continue;
            }
            visited[w] = true; // 被访问过
            dfs(w,inverseAdj,visited);
        }
        // 先把vertex这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print("->"+vertex);
    }

}
