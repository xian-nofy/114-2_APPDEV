# W07 Android Studio 入門

> **APP 開發課程** ｜ 第 7 週 ｜ 4/9
> **教科書**：Ch02 Android 開發環境建置 ＋ Ch03 Android 程式設計入門

---

## 本週目標

1. 安裝 Android Studio 並建立第一個專案
2. 認識 Android 專案結構
3. 學會基本 XML 佈局與元件

---

## 一、安裝 Android Studio

### 步驟

1. 前往 https://developer.android.com/studio 下載最新版
2. 安裝時選擇 **Standard** 設定
3. 等待 SDK 下載完成（約需 10-20 分鐘）
4. 安裝完成後，建立第一個專案

### 建立第一個專案

1. 開啟 Android Studio → **New Project**
2. 選擇 **Empty Views Activity**
3. 設定：
   - **Name**：`HelloMarine`
   - **Package name**：`com.example.hellomarine`
   - **Language**：Java
   - **Minimum SDK**：API 24（Android 7.0）
4. 點選 **Finish**，等待 Gradle 同步完成

---

## 二、Android 專案結構

建立專案後，左側面板會看到以下結構：

```
app/
├── manifests/
│   └── AndroidManifest.xml    ← App 設定檔（權限、Activity 註冊）
├── java/
│   └── com.example.hellomarine/
│       └── MainActivity.java  ← 主程式（Java 邏輯）
└── res/
    ├── layout/
    │   └── activity_main.xml  ← 畫面佈局（XML 描述 UI）
    ├── values/
    │   └── strings.xml        ← 字串資源
    └── drawable/               ← 圖片資源
```

### 重要觀念

| 檔案 | 角色 | 類比 |
|------|------|------|
| `MainActivity.java` | 程式邏輯（做什麼） | Java 的 main() |
| `activity_main.xml` | 畫面長相（看什麼） | HTML 的排版 |
| `AndroidManifest.xml` | App 身分證 | 告訴系統有哪些畫面 |

---

## 三、XML 佈局基礎

### 常用元件

| 元件 | 功能 | 範例 |
|------|------|------|
| `TextView` | 顯示文字 | 標題、說明文字 |
| `Button` | 按鈕 | 點擊觸發動作 |
| `EditText` | 文字輸入框 | 讓使用者輸入 |
| `ImageView` | 顯示圖片 | 生物照片 |

### 範例：activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    android:gravity="center">

    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="歡迎來到海洋世界"
        android:textSize="24sp"
        android:textStyle="bold" />

    <Button
        android:id="@+id/btnHello"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="點我打招呼" />

    <TextView
        android:id="@+id/tvMessage"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:textSize="18sp" />

</LinearLayout>
```

### 範例：MainActivity.java

```java
package com.example.hellomarine;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 找到元件（用 id 對應 XML）
        TextView tvMessage = findViewById(R.id.tvMessage);
        Button btnHello = findViewById(R.id.btnHello);

        // 2. 設定按鈕點擊事件
        btnHello.setOnClickListener(v -> {
            tvMessage.setText("你好！我是海洋生物小百科 🐬");
        });
    }
}
```

### 觀念連結：Java OOP → Android

| Java OOP（W1-W5） | Android 對應 |
|-------------------|-------------|
| `class` 定義類別 | `MainActivity extends AppCompatActivity` |
| `new Object()` 建立物件 | `findViewById()` 取得元件 |
| 方法呼叫 `obj.method()` | `btn.setOnClickListener(...)` |
| **Interface**（介面） | `View.OnClickListener` ← 點擊事件就是 Interface！ |

> W1-W5 學的 Java 在這裡全部派上用場。

---

## 四、課堂練習

修改 `HelloMarine` 專案，讓畫面顯示你的個人資訊：

1. 標題改為你的名字
2. 新增一個 `TextView` 顯示學號
3. 按鈕點擊後顯示「我是海資三甲的學生！」

完成後**截圖模擬器畫面**，下週會用到。

---

## 五、下週預告

W08 將運用本週學到的 Android 基礎，獨立完成一個 **海洋生物小百科 Mini APP**。
這是期中考前的最後一份作業，請確保 Android Studio 安裝完成且能正常執行。
