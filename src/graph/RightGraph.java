package graph;

import java.util.LinkedList;

/**
 * @ProjectName: structure
 * @Package: graph
 * @ClassName: RightGraph
 * @Author: zwj
 * @Description: 注释 有向有权图 邻接表实现
 * @Date: 2019/11/1 15:46
 * @Version: 1.0
 */
public class RightGraph {

    private LinkedList<Edge>adj[];//邻接表
    private int v; //顶点数

    public RightGraph(int v){
        this.v =v;
        this.adj = new LinkedList[v];
        for(int i = 0;i<v;++i){
            this.adj[i] = new LinkedList<>();
        }
    }

    // 添加一条边
    public void addEdge(int s,int t,int w){
        this.adj[s].add(new Edge(s,t,w));
    }


    public LinkedList<Edge>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Edge>[] adj) {
        this.adj = adj;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public static class PriorityQueue{ // 根据vertex.dist构建小顶堆
        private Vertex[] nodes;
        private int count;
        private int n;//堆可以存储的最大数据个数

        public PriorityQueue(int v){
            this.count = v;
            this.n = v;
            this.nodes = new Vertex[v+1];
        }

        public Vertex poll(){
            Vertex value = nodes[0];
            nodes[0] = nodes[count];
            nodes[count] = null;
            --count;
            heapify(nodes,count,1);
            return value;
        }

        public void add(Vertex vertex){
            if(count>=n)return; // 堆满了
            ++count;
            nodes[count]=vertex;
            int i = count;
            while(i/2 > 0 && nodes[i].dist<nodes[i/2].dist){ // 自下往上堆化,父节点下标=节点下标/2
                swap(nodes,i,i/2);// swap()函数的作用，交换下标为i和i/2的两个元素
                i = i/2;
            }
        }

        public void update(Vertex vertex){
            for(int i = 0;i<nodes.length - 1;++i){
                if(nodes[i].id == vertex.id){
                    nodes[i] = vertex;
                    heapify(nodes,count,1);
                    break;
                }
            }

        }

        public boolean isEmpty(){
            if(nodes.length<=0){
                return true;
            }
            return false;
        }

        public void swap(Vertex[]a,int i,int pi){
            Vertex j = a[i];
            a[i] = a[pi];
            a[pi] = j;
        }

        private void heapify(Vertex[]a,int n,int i){ // 自上往下堆化
            while(true){
                int maxPos = i;
                if(i*2<=n && a[i].dist<a[i*2].dist){ // 先与左子节点比较
                    maxPos = i*2;
                }
                if(i*2+1<=n && a[maxPos].dist<a[i*2+1].dist){ // 再与右子节点比较
                    maxPos = i*2+1;
                }
                if(maxPos==i){
                    break;
                }
                swap(a,i,maxPos);
                i = maxPos;
            }
        }
    }

    public class Edge{
        public int sid; // 边的起始编号
        public int tid; // 边的终止编号
        public int w; // 权重
        public Edge(int sid,int tid,int w){
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    // 为了dijkstra实现用的
    public static class Vertex{
        public int id; // 顶点编号id
        public int dist; //从起始顶点到这个顶点的距离
        public Vertex(){}
        public Vertex(int id,int dist){
            this.id = id;
            this.dist = dist;
        }
    }


}
