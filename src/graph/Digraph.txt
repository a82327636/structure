package graph;

import java.util.LinkedList;

/**
 * @ProjectName: structure
 * @Package: graph
 * @ClassName: Digraph
 * @Author: zwj
 * @Description: 注释 有向无环图
 * @Date: 2019/11/1 14:13
 * @Version: 1.0
 */
public class Digraph {

    private int v; // 顶点个数
    private LinkedList<Integer> adj[];// 邻接表 (数组下标是顶点数，链表是与该顶点数相关联的其他顶点)
    private int edges; // 边数

    public Digraph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0;i<v;++i){
            adj[i] = new LinkedList<>();
        }
    }

    // 顶点s指向顶点t关联，增加边
    public void addEdge(int s,int t){
        adj[s].add(t);
        edges++;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }
}
