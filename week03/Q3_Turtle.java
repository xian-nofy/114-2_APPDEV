public class Q3_Turtle {
    // 1. 已經宣告好的屬性
    String species;
    int age;

    // 2. 撰寫建構子 (Constructor)
    public Q3_Turtle(String species, int age) {
        this.species = species; // 將傳入的參數值指定給類別的屬性
        this.age = age;         // 將傳入的參數值指定給類別的屬性
    }

    // 印出資訊的方法
    public void showDetails() {
        System.out.println("品種：" + species + "，年紀：" + age + "歲");
    }

    // 3. 主程式執行區
    public static void main(String[] args) {
        // 利用建構子，在建立物件的當下直接傳入 "綠蠵龜" 與 50
        Q3_Turtle myTurtle = new Q3_Turtle("綠蠵龜", 50);

        // 呼叫方法印出資訊
        myTurtle.showDetails();
    }
}
