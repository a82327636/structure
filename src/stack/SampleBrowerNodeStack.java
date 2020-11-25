package stack;

/**
 * @ProjectName: structure
 * @Package: stack
 * @ClassName: SampleBrowerNodeStack
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/17 16:12
 * @Version: 1.0
 */
public class SampleBrowerNodeStack {


    transient Bnode top;
    int size = 0;

    public void push(String url){
        Bnode newBnode = new Bnode(url,null);
        if(top == null){
            top = newBnode;
        }else{
            newBnode.next = top;
            top = newBnode;
        }
        size++;
    }

    public String pop(){
        if (top == null) return "";
        String value = top.url;
        top = top.next;
        size--;
        return value;

    }

    public void clear() {
        this.top = null;
        this.size = 0;
    }


    private static class Bnode{
        String url;
        Bnode next;
        Bnode(String url,Bnode next){
            this.url = url;
            this.next = next;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Bnode getNext() {
            return next;
        }

        public void setNext(Bnode next) {
            this.next = next;
        }
    }
}
