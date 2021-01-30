# 作业
## Week03
### 周三作业题目：
> 基础代码可以fork： `https://github.com/kimmking/JavaCourseCodes`
`02nio/nio02` 文件夹下，实现以后，代码提交到 GitHub。
1. （必做）整合你上次作业的 httpclient/okhttp；
   - [NettyServerApplication](./src/main/java/com/kevin/java/course/nio02/gateway/NettyServerApplication.java)
2. （选做）使用 netty 实现后端 http 访问（代替上一步骤）
### 周日作业题目：
1. （必做）实现过滤器。
   - 前置过滤器
     [HeaderHttpRequestFilter](./src/main/java/com/kevin/java/course/nio02/gateway/filter/HeaderHttpRequestFilter.java)
   - 后置过滤器
     [HeaderHttpResponseFilter](./src/main/java/com/kevin/java/course/nio02/gateway/filter/HeaderHttpResponseFilter.java)
2. （选做）实现路由。
   - 随机路由
     [RandomHttpEndpointRouter](./src/main/java/com/kevin/java/course/nio02/gateway/router/RandomHttpEndpointRouter.java)
   - 轮询路由
     [RoundRibbonHttpEndpointRouter](./src/main/java/com/kevin/java/course/nio02/gateway/router/RoundRibbonHttpEndpointRouter.java)
   - 权重路由
     [WeightRandomHttpEndpointRouter](./src/main/java/com/kevin/java/course/nio02/gateway/router/WeightRandomHttpEndpointRouter.java)
3. （选做）跑一跑课上的各个例子，加深对多线程的理解
4. （选做）完善网关的例子，试着调整其中的线程池参数