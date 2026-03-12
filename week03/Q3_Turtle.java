public class Q3_Turtle {
    // i. 屬性宣告
    String species; // 品種
    int age;        // 年紀

    // ii. 撰寫建構子 (Constructor)
    // 注意：建構子的名稱必須與類別名稱完全相同，且沒有回傳值型態
    public Q3_Turtle(String species, int age) {
        this.species = species; // 使用 this 區分屬性與參數
        this.age = age;
    }

    // 提供 showDetails() 方法印出資訊
    public void showDetails() {
        System.out.println("品種：" + species + "，年紀：" + age + "歲");
    }

    // iii. & iv. main 方法執行
    public static void main(String[] args) {
        // 利用建構子直接建立物件並給值
        Q3_Turtle myTurtle = new Q3_Turtle("綠蠵龜", 50);

        // 呼叫方法印出資訊
        myTurtle.showDetails();
    }
}