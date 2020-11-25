package graph;

/**
 * @ProjectName: structure
 * @Package: graph
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/11/1 10:10
 * @Version: 1.0
 */
public class Main {

    // 1: 实现有向图、无向图、有权图、无权图的邻接矩阵和邻接表表示方法。
    // 2: 实现图的深度优先搜索、广度优先搜索
    // 3: 实现Dijkstra算法、A*算法
    // 4: 实现拓扑排序的kahn算法、DFS算法


    public static void main(String[] args) {
        // 2.1 广度优先搜索(无向图->邻接表 表示法)
//        UnDirectionGraphBfs unDirectionGraph = new UnDirectionGraphBfs(8);
//        unDirectionGraph.addEdge(0,1);
//        unDirectionGraph.addEdge(0,3);
//        unDirectionGraph.addEdge(1,2);
//        unDirectionGraph.addEdge(1,4);
//        unDirectionGraph.addEdge(2,5);
//        unDirectionGraph.addEdge(3,4);
//        unDirectionGraph.addEdge(4,5);
//        unDirectionGraph.addEdge(4,6);
//        unDirectionGraph.addEdge(5,7);
//        unDirectionGraph.addEdge(6,7);
//        unDirectionGraph.bfs(0,6);// 顶点0到顶点6的路径

        // 2.2 深度优先搜索(无向图->邻接表 表示法)
//        UnDirectionGraphDfs unDirectionGraphDfs = new UnDirectionGraphDfs(8);
//        unDirectionGraphDfs.addEdge(0,1);
//        unDirectionGraphDfs.addEdge(0,3);
//        unDirectionGraphDfs.addEdge(1,2);
//        unDirectionGraphDfs.addEdge(1,4);
//        unDirectionGraphDfs.addEdge(2,5);
//        unDirectionGraphDfs.addEdge(3,4);
//        unDirectionGraphDfs.addEdge(4,5);
//        unDirectionGraphDfs.addEdge(4,6);
//        unDirectionGraphDfs.addEdge(5,7);
//        unDirectionGraphDfs.addEdge(6,7);
//        unDirectionGraphDfs.dfs(0,6);

        // 4.1 实现拓扑排序的kahn算法
        Digraph digraph = new Digraph(6);
        digraph.addEdge(0,1);
        digraph.addEdge(0,3);
        digraph.addEdge(1,2);
        digraph.addEdge(1,4);
        digraph.addEdge(2,5);
        digraph.addEdge(3,4);
        digraph.addEdge(4,5);
        KahnTopological kahnTopological = new KahnTopological(digraph); // 广度优先遍历
        kahnTopological.topoSortByKahn();
//        // 4.2 实现拓扑排序的DFS算法
//        DfsTopological dfsTopological = new DfsTopological(digraph); // 深度优先遍历
//        dfsTopological.topoSortByDfs();

        // 3.1 实现Dijkstra算法
//        DijkstraGraph dijkstraGraph = new DijkstraGraph(6);
//        dijkstraGraph.addEdge(0,1,10);
//        dijkstraGraph.addEdge(0,4,15);
//        dijkstraGraph.addEdge(1,2,15);
//        dijkstraGraph.addEdge(1,3,2);
//        dijkstraGraph.addEdge(2,5,5);
//        dijkstraGraph.addEdge(3,2,1);
//        dijkstraGraph.addEdge(3,5,12);
//        dijkstraGraph.addEdge(4,5,10);
//        dijkstraGraph.dijkstra(0,5);

        // 3.2 实现a*算法
        //AGraph aGraph = new AGraph(6);

    }



}
