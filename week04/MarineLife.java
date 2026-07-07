// 父類別 (改名以避免與 public class MarineLife 衝突)
class MarineLifeBase {
    protected String name;
    protected String habitat;

    public MarineLifeBase(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    public String info() {
        return name + "，棲息地：" + habitat;
    }

    public String move() {
        return name + " 在水中移動";
    }
}

// TODO 1: Fish 繼承 MarineLifeBase
class Fish extends MarineLifeBase {
    // 新增屬性 scaleColor（鱗片顏色）
    private String scaleColor;

    // 建構子接收 name, habitat, scaleColor，用 super 呼叫父類別建構子
    public Fish(String name, String habitat, String scaleColor) {
        super(name, habitat);
        this.scaleColor = scaleColor;
    }

    // 覆寫 move()，回傳「[name] 擺動魚鰭游泳」
    @Override
    public String move() {
        return name + " 擺動魚鰭游泳";
    }

    // 新增方法 fishInfo()，回傳「[info()] 鱗片：[scaleColor]」
    public String fishInfo() {
        return info() + " 鱗片：" + scaleColor;
    }
}

// TODO 2: Whale 繼承 MarineLifeBase
class Whale extends MarineLifeBase {
    // 新增屬性 length（體長，單位公尺）
    private double length;

    // 建構子接收 name, habitat, length，用 super 呼叫父類別建構子
    public Whale(String name, String habitat, double length) {
        super(name, habitat);
        this.length = length;
    }

    // 覆寫 move()，回傳「[name] 擺動尾鰭前進」
    @Override
    public String move() {
        return name + " 擺動尾鰭前進";
    }

    // 新增方法 whaleInfo()，回傳「[info()] 體長：[length] 公尺」
    public String whaleInfo() {
        return info() + " 體長：" + length + " 公尺";
    }
}

public class MarineLife {
    public static void main(String[] args) {
        // TODO 3: 建立 Fish 和 Whale 各一個
        Fish fish = new Fish("小丑魚", "珊瑚礁", "橘白相間");
        Whale whale = new Whale("藍鯨", "太平洋", 30.0);

        // 印出 fishInfo() / whaleInfo() 和 move()
        System.out.println(fish.fishInfo());
        System.out.println(fish.move());
        System.out.println(whale.whaleInfo());
        System.out.println(whale.move());
    }
}
