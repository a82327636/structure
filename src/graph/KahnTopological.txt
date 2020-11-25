package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ProjectName: structure
 * @Package: graph
 * @ClassName: KahnTopological
 * @Author: zwj
 * @Description: 注释 实现拓扑排序的kahn算法
 *
 *
 * kahn算法 （贪心算法思想）
 *
 * 最重要的概念是 入度
 *
 * 如果入度为0，说明执行这个顶点没有前置条件，就是说不需要先执行其他顶点.
 * 如果发现入度为0的顶点，就将这个顶点删除，并且把这个顶点可达的入度都减1（循环以上过程直到所有顶点被输出，如果还有边说明有环）
 *
 * @Date: 2019/11/1 11:47
 * @Version: 1.0
 */
public class KahnTopological {

    private Digraph digraph;
    public KahnTopological(Digraph digraph){
        this.digraph = digraph;
    }

    public void topoSortByKahn(){
        int[]inDegree = new int[digraph.getV()]; // 统计每个顶点的入度
        for(int i = 0;i<digraph.getV();++i){
            for(int j = 0;j<digraph.getAdj()[i].size();++j){ // 每个顶点对应的指向顶点
                int w = digraph.getAdj()[i].get(j); // i->w
                inDegree[w]++; // w顶点的入度++
            }
        }
        LinkedList<Integer>queue = new LinkedList<>();
        for(int i = 0;i<digraph.getV();++i){
            if(inDegree[i]==0)queue.add(i); // 入度为0,加入队列
        }
        while(!queue.isEmpty()){
            int i = queue.remove(); // 入度为0的顶点
            System.out.print("->"+i); // 最后输出
            for(int j = 0;j<digraph.getAdj()[i].size();++j){ // 入度为0的顶点对应的指向顶点
                int k = digraph.getAdj()[i].get(j); // 获取指向顶点
                inDegree[k]--; // 指向的顶点入度--
                if(inDegree[k]==0)queue.add(k); // 如果指向顶点的入度也为0，则加入队列
            }
        }
    }

}
