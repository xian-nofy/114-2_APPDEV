public class Q2_Fish {
    // 1. 宣告屬性
    String name;
    double weight;

    // 2. 撰寫行為方法
    public void displayInfo() {
        System.out.println("這隻魚的名字是：" + name + "，重量是：" + weight + "公斤");
    }

    // 3. 主程式執行區
    public static void main(String[] args) {
        // 產生一個 Q2_Fish 的物件
        Q2_Fish myFish = new Q2_Fish();

        // 設定這隻魚的屬性值
        myFish.name = "黑鮪魚";
        myFish.weight = 250.5;

        // 呼叫這隻魚的方法來印出資訊
        myFish.displayInfo();
    }
}
