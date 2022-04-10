# Project Loom 測試

這是一個 Spring Boot 專案，用於測試在 Spring WebFlux 環境中，透過以下兩種方式提供同一種功能的性能與延遲。

- 透過 Project Loom 的 `Thread.startVirtualThread()` 開啓多個 Virtual Thread 同步執行
- 透過 Project Reactor 的 `flatMap()` 非同步執行

## 編譯

**Release 裡有我已經編譯好的 JAR 檔**  
**如果不想要這麼麻煩，也可以直接拿[這裡](https://github.com/ming900518/loom-test/releases/tag/test)的檔案，用基於 JDK 19 的 Project Loom Early-Access Build 執行：`java  --enable-preview -jar [下載回來的JAR檔]`**

1. 安裝 [Project Loom 的 Early-Access Build](https://jdk.java.net/loom/)

2. 把這個專案 Clone 到你的電腦：`git clone https://github.com/ming900518/loom-test.git`

3. 用習慣的 Java IDE 開啓專案，並進行相關設定（以下以 IntelliJ IDEA 為例）：
    - 將 SDK 設定為剛剛安裝的 Project Loom Early-Access Build
    - 將 Language Level 設定為 `X - Experimental features`

4. 透過 Maven 匯入專案

5. 輸入以下指令進行專案編譯：`mvn package -Dmaven.test.skip=true`

6. 編譯完成後，開啓 Terminal，並輸入以下指令執行編譯好的 JAR 檔：`java  --enable-preview -jar [JAR檔]`

## 測試 API

- Project Loom
```
http://localhost:8080/?virtualThread=1
```

- Project Reactor
```
http://localhost:8080/?virtualThread=0
```

本專案在每一個 Thread 都加了 10 秒 sleep，故實際的 Response Time 需要減掉 10 秒。

你也可以透過 `log()` 產生的 output，計算從 `onSubscribe()` 到 `onComplete()`的時間。

## Project Loom 延伸閱讀
### 文章
- [Project Loom: Understand the new Java concurrency model](https://www.infoworld.com/article/3652596/project-loom-understand-the-new-java-concurrency-model.html)
- [On the Performance of User-Mode Threads and Coroutines](https://inside.java/2020/08/07/loom-performance/)
- [Going inside Java’s Project Loom and virtual threads](https://blogs.oracle.com/javamagazine/post/going-inside-javas-project-loom-and-virtual-threads)
### 影片
- [Project Loom: Modern Scalable Concurrency for the Java Platform](https://youtu.be/fOEPEXTpbJA)
- [Project Loom Brings Structured Concurrency - Inside Java Newscast #17](https://youtu.be/2J2tJm_iwk0)
- [Virtual Thread Deep Dive - Inside Java Newscast #23](https://youtu.be/6dpHdo-UnCg)
- [Project Loom - A Friend or Foe of Reactive? - Oleh Dokuka, VMware & Andrii Rodionov](https://youtu.be/YwG04UZP2a0)
