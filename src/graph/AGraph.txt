package graph;

import java.util.LinkedList;

/**
 * @ProjectName: structure
 * @Package: graph
 * @ClassName: AGraph
 * @Author: zwj
 * @Description: 注释 A*算法 (寻找次优路线,Dijkstra算法是最优路线但是不实用)
 * @Date: 2019/11/4 11:12
 * @Version: 1.0
 */
public class AGraph {
    private LinkedList<Edge> adj[];//邻接表
    private int v; //顶点数
    private Vertex[]vertexes;

    /**
     * 有向有权图
     */
    public AGraph(int v){
        this.v =v;
        this.adj = new LinkedList[v];
        for(int i = 0;i<v;++i){
            this.adj[i] = new LinkedList<>();
        }
        vertexes = new Vertex[this.v]; // 记录从起始顶点到每个顶点的距离(dist)
    }

    // 添加一条边
    public void addEdge(int s,int t,int w){
        this.adj[s].add(new Edge(s,t,w));
    }

    public void addVetex(int id,int x,int y){
        vertexes[id] = new Vertex(id,x,y);
    }

    /**
     * 曼哈顿距离公式(两点之间横纵坐标的距离之和)计算两点之间的直线距离.
     * @param v1
     * @param v2
     * @return
     */
    int hManhattan(Vertex v1,Vertex v2){
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y+v2.y);
    }

    /**
     * a* 算法
     * @param s
     * @param t
     */
    public void astar(int s,int t){ // 从顶点s到顶点t的路径
        int[]predecessor = new int[this.v];// 用来还原最短路径(记录每个顶点的前驱顶点)
        // 按照vertex的f值构建小顶堆
        PriorityQueue queue = new PriorityQueue(this.v);
        boolean[]inqueue = new boolean[this.v];//标记是否进入过队列
        vertexes[s].dist =0; // 把起始顶点的dist值初始化为0，然后将其放到优先级队列
        vertexes[s].f = 0;
        while(!queue.isEmpty()){
            Vertex minVertex = queue.poll(); // 取堆顶元素并删除(从优先级队列中取出f最小顶点minVertex,然后考察这个顶点可达的所有顶点)
            if(minVertex.id == t)break; //最短路径产生
            for(int i = 0;i<adj[minVertex.id].size();++i){ // 考察这个顶点可达的所有顶点(nextVertex)
                Edge e = adj[minVertex.id].get(i);//取一条minvertex相连的边
                Vertex nextVertex = vertexes[e.tid];// minVertex->nextVertex
                if(minVertex.dist+e.w<nextVertex.dist){//更新next的dist(如果minvertex.dist+w(minvertex与nextvertex变的权重)<nextVertex.dist)
                    nextVertex.dist = minVertex.dist+e.w; // 如果上面判断正确，说明nextVertex.dist比较远，是由另一条路线算出的，所以更改为更短的minVertex.dist+e.w
                    nextVertex.f = nextVertex.dist+hManhattan(nextVertex,vertexes[t]);
                    predecessor[nextVertex.id]= minVertex.id;
                    if(inqueue[nextVertex.id] ==true){
                        queue.update(nextVertex); // 更新队列中的dist,f值
                    }else{
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
                if(nextVertex.id == t){ // 只要到达t就可以退出while,使用贪心算法思想，一旦遇到t就退出，不寻找更短的路径
                    queue.clear(); // 清空队列，才能退出循环
                    break;
                }
            }
        }
        queue.add(vertexes[s]);
        inqueue[s]=true;
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
            while(i/2 > 0 && nodes[i].f<nodes[i/2].f){ // 自下往上堆化,父节点下标=节点下标/2
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

        public void clear(){
            nodes = null;
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
                if(i*2<=n && a[i].f<a[i*2].f){ // 先与左子节点比较
                    maxPos = i*2;
                }
                if(i*2+1<=n && a[maxPos].f<a[i*2+1].f){ // 再与右子节点比较
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


    public static class Vertex{
        public int x; // x坐标
        public int y; // y坐标
        public int f; // 新增 f(i) = g(i)+h(i)
        public int id; // 顶点编号id
        public int dist; //从起始顶点到这个顶点的距离,也就是g(i)
        public Vertex(){}
        public Vertex(int id,int x,int y){
            this.id = id;
            this.x = x;
            this.y = y;
            this.dist = Integer.MAX_VALUE;
            this.f = Integer.MAX_VALUE;
        }
    }
}
