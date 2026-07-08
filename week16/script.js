// ⚠️ 請在下方引號內填入你的真實金鑰
const GEMINI_API_KEY = "AQ.Ab8RN6JWrkqSPzF8m7qT0AnbxrpBXcKrXpqBSm98KDBae4SgnQ"; 

async function sendMessage() {
    const inputEl = document.getElementById('userInput');
    const chatBox = document.getElementById('chatBox');
    const text = inputEl.value.trim();
    
    if (!text) return;

    // 1. 顯示使用者發送的訊息
    appendMessage(text, 'user');
    inputEl.value = '';

    // 2. 顯示思考中狀態
    const loadingId = appendMessage('思考中...', 'model');

    try {
        // 3. 修正為最新官方支援 AQ 格式金鑰的 v1 模型路徑
        const response = await fetch(`https://googleapis.com{GEMINI_API_KEY}`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                contents: [{ parts: [{ text: text }] }]
            })
        });

        const data = await response.json();
        
        // 4. 解析回傳內容並更新畫面
        const reply = data.candidates[0].content.parts[0].text;
        document.getElementById(loadingId).innerText = reply;

    } catch (error) {
        console.error(error);
        document.getElementById(loadingId).innerText = '連線錯誤或金鑰無效，請檢查後再試。';
    }
}

function appendMessage(text, sender) {
    const chatBox = document.getElementById('chatBox');
    const msgDiv = document.createElement('div');
    const id = 'msg-' + Date.now();
    
    msgDiv.id = id;
    msgDiv.className = `message ${sender}`;
    msgDiv.innerText = text;
    
    chatBox.appendChild(msgDiv);
    chatBox.scrollTop = chatBox.scrollHeight; 
    return id;
}

// 支援按 Enter 鍵發送
document.getElementById('userInput').addEventListener('keypress', function(e) {
    if (e.key === 'Enter') sendMessage();
});
