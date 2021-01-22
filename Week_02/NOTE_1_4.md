# 周三作业 4

## 根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 的总结，提交到 Github

- Serial GC
    - 串行GC，Young 区使用 `mark-copy`（标记-复制）算法，Old区使用`mark-sweep-compact`（标记-清除-整理）算法
    - 单线程，GC会STW，只能使用单个核心
    - 适合几百MB堆内存的JVM
- Parallel GC
    - 并行GC，Young 区使用 `mark-copy`（标记-复制）算法，Old区使用`mark-sweep-compact`（标记-清除-整理）算法
    - 默认使用CPU核心数的GC线程数（-XX:ParallelGCThread=N指定），GC会STW
    - 适用于多核服务器，主要目标是增加吞吐量
    - 对比SerialGC，GC期间暂停时间更短
    - JDK8以前的默认GC
- CMS GC
    - Young区使用并行STW方式的`mark-copy`算法，Old区主要使用并发`mark-sweep`（标记-清除）算法
    - 以降低GC停顿而导致的系统延迟为设计目标
    - `mark-sweep`阶段大部分工作和应用线程一起并发执行
    - 只有`Initial-Mark` 和 `Final-Remark`会短暂STW
    - 缺点：老年代内存碎片
    - 适合追求低延迟场景
- G1 GC
    - Young区使用`mark-copy`，Old区使用`mark-sweep-compact`
    - 设计目标：将STW停顿的时间和分布，变成可预期且可配置
    - 堆不再分为Young区和Old区，而是划分为多个小块堆区域（smaller heap regions），每个region都可以是Eden、Survivor、Old区
    - 垃圾最多的小块会被优先收集（G1 = Garbage-First）
    - JDK9 ～ JDK15 的默认GC
    - 4G内存以上尽量使用G1