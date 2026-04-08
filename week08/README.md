# W08 課後作業：海洋生物小百科 Mini APP

> **APP 開發課程** ｜ 第 8 週 ｜ 課後作業
> **繳交期限**：W09 期中考前
> **繳交方式**：將整個 Android 專案資料夾放在 `week08/` 內，push 到 Fork 即可（同一個 PR）

---

## 作業說明

運用 W07-W08 所學的 Android 基礎，獨立完成一個**海洋生物小百科** App。
延續 W03-W05 建立的海洋生物（Shark、Turtle、Dolphin 等），這次把它們「穿上 Android 的衣服」。

**請從以下兩個範例中擇一實作：**

---

## 範例 A：單頁版（One Page）

一個畫面完成所有功能。適合剛入門的同學。

### 功能需求

1. 畫面上方顯示標題「海洋生物小百科」
2. 提供 **4 個按鈕**，每個代表一種海洋生物
3. 點擊按鈕後，下方區域顯示該生物的：
   - 名稱
   - 棲息地
   - 移動方式
   - 覓食方式
4. 搭配一張圖片（放在 `res/drawable/`）

### 畫面示意

```
┌──────────────────────────┐
│     海洋生物小百科         │
│                          │
│  [鯊魚] [海龜] [海豚] [章魚] │
│                          │
│  ┌──────────────────┐    │
│  │   (生物圖片)       │    │
│  └──────────────────┘    │
│                          │
│  名稱：大白鯊             │
│  棲息地：深海             │
│  移動：高速衝刺獵食        │
│  覓食：撕咬獵物           │
└──────────────────────────┘
```

### 專案結構

```
week08/MarineApp/
├── app/src/main/
│   ├── java/.../MainActivity.java
│   ├── res/layout/activity_main.xml
│   └── res/drawable/
│       ├── shark.png
│       ├── turtle.png
│       ├── dolphin.png
│       └── octopus.png
└── ...
```

### 關鍵程式碼提示

**activity_main.xml**（佈局結構）：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="海洋生物小百科"
        android:textSize="28sp"
        android:textStyle="bold"
        android:layout_gravity="center" />

    <!-- 按鈕列 -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:gravity="center"
        android:layout_marginTop="16dp">

        <Button android:id="@+id/btnShark"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="鯊魚" />

        <Button android:id="@+id/btnTurtle"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="海龜" />

        <Button android:id="@+id/btnDolphin"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="海豚" />

        <Button android:id="@+id/btnOctopus"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="章魚" />
    </LinearLayout>

    <!-- 圖片 -->
    <ImageView
        android:id="@+id/imgCreature"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:layout_gravity="center"
        android:layout_marginTop="16dp"
        android:scaleType="centerCrop" />

    <!-- 資訊區 -->
    <TextView android:id="@+id/tvName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="22sp"
        android:textStyle="bold"
        android:layout_marginTop="12dp" />

    <TextView android:id="@+id/tvHabitat"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="16sp"
        android:layout_marginTop="4dp" />

    <TextView android:id="@+id/tvMove"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="16sp"
        android:layout_marginTop="4dp" />

    <TextView android:id="@+id/tvEat"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="16sp"
        android:layout_marginTop="4dp" />

</LinearLayout>
```

**MainActivity.java**（程式邏輯）：

```java
package com.example.marineapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imgCreature;
    private TextView tvName, tvHabitat, tvMove, tvEat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 找到元件
        imgCreature = findViewById(R.id.imgCreature);
        tvName = findViewById(R.id.tvName);
        tvHabitat = findViewById(R.id.tvHabitat);
        tvMove = findViewById(R.id.tvMove);
        tvEat = findViewById(R.id.tvEat);

        // 設定按鈕事件
        Button btnShark = findViewById(R.id.btnShark);
        btnShark.setOnClickListener(v -> showCreature(
            "大白鯊", "深海", "高速衝刺獵食", "撕咬獵物", R.drawable.shark
        ));

        Button btnTurtle = findViewById(R.id.btnTurtle);
        btnTurtle.setOnClickListener(v -> showCreature(
            "綠蠵龜", "珊瑚礁", "緩慢划動四肢", "啃食海草", R.drawable.turtle
        ));

        Button btnDolphin = findViewById(R.id.btnDolphin);
        btnDolphin.setOnClickListener(v -> showCreature(
            "瓶鼻海豚", "近海", "躍出水面", "合作圍捕魚群", R.drawable.dolphin
        ));

        Button btnOctopus = findViewById(R.id.btnOctopus);
        btnOctopus.setOnClickListener(v -> showCreature(
            "章魚", "岩礁", "噴射水流推進", "用觸手捕捉獵物", R.drawable.octopus
        ));
    }

    private void showCreature(String name, String habitat,
                              String move, String eat, int imageRes) {
        tvName.setText("名稱：" + name);
        tvHabitat.setText("棲息地：" + habitat);
        tvMove.setText("移動：" + move);
        tvEat.setText("覓食：" + eat);
        imgCreature.setImageResource(imageRes);
    }
}
```

---

## 範例 B：雙頁版（Two Pages）

主畫面選擇生物 → 跳轉到詳細頁面。需使用 **Intent** 傳遞資料。

### 功能需求

1. **主畫面（MainActivity）**：顯示 4 個生物按鈕
2. 點擊按鈕 → 用 **Intent** 跳轉到第二個畫面
3. **詳細畫面（DetailActivity）**：顯示該生物的完整資訊與圖片
4. 詳細畫面有「返回」按鈕回到主畫面

### 畫面示意

```
主畫面                          詳細畫面
┌──────────────────┐           ┌──────────────────┐
│  海洋生物小百科    │           │  [← 返回]         │
│                  │  點擊     │                  │
│  ┌────┐ ┌────┐  │ ──────>  │  ┌──────────┐    │
│  │鯊魚│ │海龜│  │           │  │ (生物圖片) │    │
│  └────┘ └────┘  │           │  └──────────┘    │
│  ┌────┐ ┌────┐  │           │                  │
│  │海豚│ │章魚│  │           │  大白鯊           │
│  └────┘ └────┘  │           │  棲息地：深海      │
│                  │           │  移動：高速衝刺    │
│                  │           │  覓食：撕咬獵物    │
└──────────────────┘           └──────────────────┘
```

### 專案結構

```
week08/MarineApp/
├── app/src/main/
│   ├── java/.../
│   │   ├── MainActivity.java      ← 主畫面
│   │   └── DetailActivity.java    ← 詳細畫面
│   ├── res/layout/
│   │   ├── activity_main.xml      ← 主畫面佈局
│   │   └── activity_detail.xml    ← 詳細畫面佈局
│   ├── res/drawable/              ← 圖片
│   └── AndroidManifest.xml        ← 需註冊 DetailActivity
└── ...
```

### 關鍵程式碼提示

**MainActivity.java**（主畫面 — 用 Intent 傳資料）：

```java
package com.example.marineapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShark = findViewById(R.id.btnShark);
        btnShark.setOnClickListener(v -> openDetail(
            "大白鯊", "深海", "高速衝刺獵食", "撕咬獵物", "shark"
        ));

        Button btnTurtle = findViewById(R.id.btnTurtle);
        btnTurtle.setOnClickListener(v -> openDetail(
            "綠蠵龜", "珊瑚礁", "緩慢划動四肢", "啃食海草", "turtle"
        ));

        Button btnDolphin = findViewById(R.id.btnDolphin);
        btnDolphin.setOnClickListener(v -> openDetail(
            "瓶鼻海豚", "近海", "躍出水面", "合作圍捕魚群", "dolphin"
        ));

        Button btnOctopus = findViewById(R.id.btnOctopus);
        btnOctopus.setOnClickListener(v -> openDetail(
            "章魚", "岩礁", "噴射水流推進", "用觸手捕捉獵物", "octopus"
        ));
    }

    private void openDetail(String name, String habitat,
                            String move, String eat, String imageName) {
        // 建立 Intent，指定要跳轉的 Activity
        Intent intent = new Intent(this, DetailActivity.class);

        // 用 putExtra 傳遞資料（key-value）
        intent.putExtra("name", name);
        intent.putExtra("habitat", habitat);
        intent.putExtra("move", move);
        intent.putExtra("eat", eat);
        intent.putExtra("image", imageName);

        // 啟動第二個畫面
        startActivity(intent);
    }
}
```

**DetailActivity.java**（詳細畫面 — 接收 Intent 資料）：

```java
package com.example.marineapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 取得從 MainActivity 傳來的資料
        String name = getIntent().getStringExtra("name");
        String habitat = getIntent().getStringExtra("habitat");
        String move = getIntent().getStringExtra("move");
        String eat = getIntent().getStringExtra("eat");
        String imageName = getIntent().getStringExtra("image");

        // 顯示資料
        TextView tvName = findViewById(R.id.tvName);
        tvName.setText(name);

        TextView tvHabitat = findViewById(R.id.tvHabitat);
        tvHabitat.setText("棲息地：" + habitat);

        TextView tvMove = findViewById(R.id.tvMove);
        tvMove.setText("移動：" + move);

        TextView tvEat = findViewById(R.id.tvEat);
        tvEat.setText("覓食：" + eat);

        // 用圖片名稱找到對應的 drawable 資源
        ImageView imgCreature = findViewById(R.id.imgCreature);
        int imageRes = getResources().getIdentifier(
            imageName, "drawable", getPackageName()
        );
        imgCreature.setImageResource(imageRes);

        // 返回按鈕
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
    }
}
```

**activity_detail.xml**（詳細畫面佈局）：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <Button
        android:id="@+id/btnBack"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="← 返回" />

    <ImageView
        android:id="@+id/imgCreature"
        android:layout_width="250dp"
        android:layout_height="250dp"
        android:layout_gravity="center"
        android:layout_marginTop="16dp"
        android:scaleType="centerCrop" />

    <TextView
        android:id="@+id/tvName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="28sp"
        android:textStyle="bold"
        android:layout_gravity="center"
        android:layout_marginTop="16dp" />

    <TextView
        android:id="@+id/tvHabitat"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:layout_marginTop="12dp" />

    <TextView
        android:id="@+id/tvMove"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:layout_marginTop="8dp" />

    <TextView
        android:id="@+id/tvEat"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:layout_marginTop="8dp" />

</LinearLayout>
```

**AndroidManifest.xml**（別忘記註冊 DetailActivity）：

```xml
<!-- 在 <application> 標籤內加入 -->
<activity android:name=".DetailActivity" />
```

---

## 評分標準

| 項目 | 配分 | 說明 |
|------|------|------|
| 專案可執行 | 30% | Android Studio 開啟後能成功 Build 並執行 |
| UI 佈局完整 | 30% | 包含標題、按鈕、圖片、文字資訊 |
| 按鈕互動正確 | 20% | 點擊按鈕能正確顯示對應生物資訊 |
| 程式碼品質 | 10% | 命名清晰、有基本註解 |
| 創意加分 | 10% | 自訂生物、額外功能、美化 UI |

### 加分項目（選做）

- 使用 `ConstraintLayout` 取代 `LinearLayout`
- 新增更多海洋生物（超過 4 種）
- 加入生物的叫聲或動畫效果
- 使用 `CardView` 美化資訊卡片

---

## 繳交方式

1. 在你的 Fork 中建立 `week08/` 資料夾
2. 將整個 Android 專案放入（或至少包含 `app/src/main/` 下的 java 和 res 資料夾）
3. **Push 到你的 Fork**，原有的 PR 會自動包含此次 commit
4. 繳交期限：**W09 上課前（4/23）**

---

## 與 Java OOP 的連結

還記得 W03-W05 寫的 `Creature`、`Shark`、`Turtle` 嗎？

| W03-W05 Java OOP | W08 Android APP |
|-------------------|-----------------|
| `class Creature` 定義屬性 | 生物的 name, habitat 顯示在畫面上 |
| `move()` `eat()` 方法 | 點擊按鈕顯示移動/覓食描述 |
| 多型 `Creature[]` 陣列 | 多個按鈕對應不同生物 |
| **Java 的邏輯不變，只是呈現方式從 Console 變成 App 畫面。** |
