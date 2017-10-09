
# 各技能代码示例
- maven多模块工程
```
@app
    demo-spider
@async_thread_queue
    demo-io_nio_socket
    demo-kafka
    demo-kotlin-javaScript
    demo-kotlin-jvm
    demo-thread
    demo-websockets
@bigData
    demo-hadoop_learn
@data
    demo-collection_map
    demo-consistentHash
    demo-dataStructure
@java
    demo-at_interface
    demo-bit
    demo-designPatterns
    demo-enum
    demo-java8
    demo-java_common
    demo-log
    demo-math
    demo-proxy
    demo-QPS
    demo-sorting
    demo_idea
@jvm
    demo-classLoader
    demo-jstackAnalyse
    demo-jvm
@kotlin
    demo-kotlin-javaScript
    demo-kotlin-jvm
@nosql
    demo-nosql
@project
    myServe-Common
    myServe-Service
    myServe-UI
    myServe-Web
@rpc
    demo-dubbo-client
    demo-dubbo-server
    demo-rmi
    demo-rpc_socket
    demo-webService
    demo-webService_web_client
    demo-webService_web_server
@spring
    springContext
    springWeb
@springBoot
    springbootweb
```

---
## 非Maven模块,需要`.idea`还原模块引入
```
@rpc/demo-webService_web_client
@rpc/demo-webService_web_server

@kotlin/demo-kotlin
```

<!--
# 查看仓库
```
➜  myServer git:(master) ✗ git remote -v
origin  https://github.com/liuxiang/myServer.git (fetch)
origin  https://github.com/liuxiang/myServer.git (push)
osc     https://git.oschina.net/liuxiang7/myServer.git (fetch)
osc     https://git.oschina.net/liuxiang7/myServer.git (push)
```

# 新建远程仓库
- 修改源
git remote set-url origin <remote_git_address>
- 新增源
git remote add osc <remote_git_address>

# 切换仓库
- github
git push -u origin master

- oschina
git push -u osc master

注意:
1.切换时会自动推送服务器更新
2.同时指定origin为默认主机-u
3.如需多仓库同时操作,可使用相同的仓库名 见:http://blog.csdn.net/isea533/article/details/41382699
-->