## spring + dubbo接口简单示例，maven + intellj构建

服务端：dubbo-server<br>
客户端：dubbo-client<br>

dubbo接口官网：[dubbo](http://alibaba.github.io/dubbo-doc-static/Home-zh.htm)

### 运行demo
1、启动zookeeper
（参考： [Zookeeper注册中心安装](http://alibaba.github.io/dubbo-doc-static/Administrator+Guide-zh.htm#AdministratorGuide-zh-Zookeeper%E6%B3%A8%E5%86%8C%E4%B8%AD%E5%BF%83%E5%AE%89%E8%A3%85) )

2、启动dubbo服务(两种方法)`
*     （dubbo-server）mvn jetty:run 或
*      (dubbo-server) 运行com.fengjx.main.Provider的main方法


3、启动客户端，调用dubbo服务（两种方法）
*      运行单元测试：com.fengjx.dubbo.service.HelloServiceConsumerTest 或`
*      运行com.fengjx.main.Consumer的main方法

---
# 问题
java.net.ConnectException: Connection refused: no further information
原因：zookeeper未启动
解决：启动zookeeper
`F:\Tool\dubbo\zookeeper-3.4.10\bin\zkServer.cmd`

---
**参考**

`dubbo接口简单示例，maven + intellj构建`
https://git.oschina.net/fengjx/dubbo-demo.git