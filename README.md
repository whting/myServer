
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
all     https://github.com/liuxiang/myServer.git (push)
all     https://git.oschina.net/liuxiang7/myServer.git (push)
all     https://github.com/liuxiang/myServer.git (fetch)
origin  https://github.com/liuxiang/myServer.git (push)
origin  https://github.com/liuxiang/myServer.git (fetch)
osc     https://git.oschina.net/liuxiang7/myServer.git (push)
osc     https://git.oschina.net/liuxiang7/myServer.git (fetch)
```

# 新建远程仓库
- 新增源
git remote add osc <remote_git_address>
- 修改源
git remote set-url origin <remote_git_address>
- 追加源(一般用all,见下文)
git remote set-url --add origin <remote_git_address>

# 指定仓库操作
- github
git fetch origin master         # 仅更新,不合并
git pull -v --progress "origin" # 更新+合并﻿merge
git push origin master          # 仅提交,不切换
git push -u origin master       # 提交+切换(默认主机)

- oschina
git pull -v --progress "osc"    # 更新
git push osc master             # 仅提交,不切换
git push -u osc master          # 提交+切换(默认主机)

注意:
1.推送同时完成-u的默认主机[origin/osc]切换
2.如需多仓库同时操作,可使用相同的仓库名 见:http://blog.csdn.net/isea533/article/details/41382699

# =====================================
# 多主机设置
- 添加多主机共享别名
添加一个remote,这里是all,也可以是别的名字
git remote add all https://github.com/liuxiang/myServer.git
再添加另一个:
git remote set-url --add all https://git.oschina.net/liuxiang7/myServer.git
如果有多个,按照上面这一个命令进行添加.

- 查看
git remote -v

- 提交的时候输入
git push all --all

- 切换主机
git push -u all master

-->