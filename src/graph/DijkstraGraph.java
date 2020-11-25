package graph;

import java.util.LinkedList;

/**
 * @ProjectName: structure
 * @Package: graph
 * @ClassName: Dijkstra
 * @Author: zwj
 * @Description: 注释 Dijkstra算法，最短路径算法(最优路线,A*算法是次优路线),会遍历所有路线（比较之前遍历短的路线）
 * @Date: 2019/11/1 16:13
 * @Version: 1.0
 */
public class DijkstraGraph {

    private LinkedList<Edge>adj[];//邻接表
    private int v; //顶点数

    /**
     * 有向有权图
     */
    public DijkstraGraph(int v){
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


    /**
     * dijkstra 算法
     * @param s
     * @param t
     */
    public void dijkstra(int s,int t){
        int[]predecessor = new int[this.v];// 用来还原最短路径(记录每个顶点的前驱顶点)
        Vertex[]vertexes = new Vertex[this.v]; // 记录从起始顶点到每个顶点的距离(dist)
        for(int i = 0;i<this.v;++i){
            vertexes[i] = new Vertex(i,Integer.MAX_VALUE); // 将所有顶点的dist都初始化为无穷大
        }
        PriorityQueue queue = new PriorityQueue(this.v);// 小顶堆
        boolean[]inqueue = new boolean[this.v];//标记是否进入过队列
        vertexes[s].dist =0; // 把起始顶点的dist值初始化为0，然后将其放到优先级队列
        queue.add(vertexes[s]);
        inqueue[s]=true;
        while(!queue.isEmpty()){
            Vertex minVertex = queue.poll(); // 取堆顶元素并删除(从优先级队列中取出dist最小顶点minVertex,然后考察这个顶点可达的所有顶点)
            if(minVertex.id == t)break; //最短路径产生
            for(int i = 0;i<adj[minVertex.id].size();++i){ // 考察这个顶点可达的所有顶点(nextVertex)
                Edge e = adj[minVertex.id].get(i);//取一条minvertex相连的边
                Vertex nextVertex = vertexes[e.tid];// minVertex->nextVertex
                if(minVertex.dist+e.w<nextVertex.dist){//更新next的dist(如果minvertex.dist+w(minvertex与nextvertex边的权重)<nextVertex.dist)
                    nextVertex.dist = minVertex.dist+e.w; // 如果上面判断正确，说明nextVertex.dist(动态计算出)比较远，是由另一条路线算出的，所以更改为更短的minVertex.dist+e.w
                    predecessor[nextVertex.id]= minVertex.id;
                    if(inqueue[nextVertex.id] ==true){
                        queue.update(nextVertex); // 更新队列中的dist值
                    }else{
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }
        // 输出最短路径
        System.out.print(s);
        print(s,t,predecessor);
    }

    public void print(int s,int t,int[]predecessor){
        if(s==t)return;
        print(s,predecessor[t],predecessor);
        System.out.print("->"+t);
    }

    public static class PriorityQueue{ // 根据vertex.dist构建小顶堆
        private Vertex[] nodes;
        private int count;
        private int n;//堆可以存储的最大数据个数

        public PriorityQueue(int v){
            this.count = 0;
            this.n = v;
            this.nodes = new Vertex[v+1];
        }

        public Vertex poll(){
            Vertex value = nodes[1];
            nodes[1] = nodes[count];
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
            for(int i = 1;i<nodes.length;++i){
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
            if(count==0)return; // 队列空了
            while(true){
                int maxPos = i;
                if(i*2<=n && a[i].dist>a[i*2].dist){ // 先与左子节点比较
                    maxPos = i*2;
                }
                if(i*2+1<=n && a[maxPos].dist>a[i*2+1].dist){ // 再与右子节点比较
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
