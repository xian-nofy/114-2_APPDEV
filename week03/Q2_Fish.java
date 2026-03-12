public class Q2_Fish {
    String name;    // 魚的名字
    double weight;  // 魚的重量

    // ii. 撰寫 displayInfo() 方法
    public void displayInfo() {
        System.out.println("這隻魚的名字是：" + name + "，重量是：" + weight + "公斤");
    }

    // iii. 在 main 方法中執行
    public static void main(String[] args) {
        // 產生一個 Q2_Fish 的物件，命名為 myFish
        Q2_Fish myFish = new Q2_Fish();

        // 設定物件的屬性值
        myFish.name = "黑鮪魚";
        myFish.weight = 250.5;

        // 呼叫物件的方法
        myFish.displayInfo();
    }
}