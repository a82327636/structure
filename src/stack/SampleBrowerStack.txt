package stack;

/**
 * @ProjectName: structure
 * @Package: stack
 * @ClassName: SampleBrowerStack
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/17 16:00
 * @Version: 1.0
 */
public class SampleBrowerStack {

    SampleBrowerNodeStack sampleBrowerNodeStack1; // 向前

    SampleBrowerNodeStack sampleBrowerNodeStack2; // 向后

    private String currentPage;

    SampleBrowerStack(SampleBrowerNodeStack sampleBrowerNodeStack1,SampleBrowerNodeStack sampleBrowerNodeStack2){
        this.sampleBrowerNodeStack1 = sampleBrowerNodeStack1;
        this.sampleBrowerNodeStack2 = sampleBrowerNodeStack2;
    }

    public void open(String url){
        if(currentPage !=null){
            sampleBrowerNodeStack2.push(url);
            sampleBrowerNodeStack1.clear();
        }
       showUrl(url,"open");
    }

    public String forWard(){
        if (this.canGoForward()) {
            this.sampleBrowerNodeStack2.push(this.currentPage);
            String forwardUrl = this.sampleBrowerNodeStack1.pop();
            showUrl(forwardUrl, "Foward");
            return forwardUrl;
        }

        System.out.println("** Cannot go forward, no pages ahead.");
        return null;
    }

    public String afterWard(){
        if (this.canGoBack()) {
            this.sampleBrowerNodeStack1.push(currentPage);
            String backUrl = sampleBrowerNodeStack2.pop();
            showUrl(backUrl, "Back");
            return backUrl;
        }

        System.out.println("* Cannot go back, no pages behind.");
        return null;
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }

    public boolean canGoBack() {
        return sampleBrowerNodeStack2.size > 0;
    }

    public boolean canGoForward() {
        return sampleBrowerNodeStack1.size > 0;
    }

    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + " page == " + url);
    }


}
