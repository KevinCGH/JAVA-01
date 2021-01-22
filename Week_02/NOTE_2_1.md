# 周日作业 1
## 运行课上的例子，以及 `Netty` 的例子，分析相关现象

### HttpServer01

`wrk -c40 -d30s --latency http://192.168.50.134:8801`

```shell script
Running 30s test @ http://192.168.50.134:8801
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    58.84ms   30.22ms 611.04ms   74.68%
    Req/Sec   319.57    166.54     1.18k    88.67%
  Latency Distribution
     50%   64.23ms
     75%   79.50ms
     90%   86.18ms
     99%  155.68ms
  19113 requests in 30.04s, 1.57MB read
  Socket errors: connect 0, read 19124, write 0, timeout 0
Requests/sec:    636.22
Transfer/sec:     53.44KB
```
### HttpServer02
`wrk -c40 -d30s --latency http://192.168.50.134:8802`
```shell script
Running 30s test @ http://192.168.50.134:8802
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    33.71ms   25.11ms 503.65ms   80.85%
    Req/Sec   314.97    160.72     0.95k    83.39%
  Latency Distribution
     50%   28.49ms
     75%   44.16ms
     90%   62.60ms
     99%  143.26ms
  18619 requests in 30.10s, 1.54MB read
  Socket errors: connect 0, read 19177, write 6, timeout 0
Requests/sec:    618.60
Transfer/sec:     52.27KB
```

### HttpServer03

`wrk -c40 -d30s --latency http://192.168.50.134:8803`

```shell script
Running 30s test @ http://192.168.50.134:8803
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    34.46ms   22.66ms 310.59ms   70.58%
    Req/Sec   301.60    146.83   830.00     78.02%
  Latency Distribution
     50%   29.15ms
     75%   46.24ms
     90%   65.84ms
     99%   93.61ms
  18001 requests in 30.00s, 1.49MB read
  Socket errors: connect 0, read 18622, write 6, timeout 0
Requests/sec:    599.98
Transfer/sec:     50.74KB
```

### NettyHttpServer

`wrk -c40 -d30s --latency http://192.168.50.134:8808/test`
```shell script
Running 30s test @ http://192.168.50.134:8808/test
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    35.08ms   26.53ms 244.55ms   86.58%
    Req/Sec   349.66    117.33   626.00     69.55%
  Latency Distribution
     50%   28.69ms
     75%   43.78ms
     90%   59.88ms
     99%  156.91ms
  16369 requests in 30.02s, 1.23MB read
  Socket errors: connect 0, read 16369, write 0, timeout 0
Requests/sec:    545.27
Transfer/sec:     42.07KB
```

## Summary
|  Server  | Request/sec | Latency Avg |
| ---- | ---- | ---- |
|  HttpServer01  | 636.22 | 58.84ms |
|  HttpServer02  | 618.60 | 33.71ms |
|  HttpServer03  | 599.98 | 34.46ms |
|  NettyHttpServer  | 545.27 | 35.08ms  |