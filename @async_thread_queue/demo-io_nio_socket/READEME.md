# socket阻塞
(多客户端访问时,阻塞位置)
- socket
socket = server.accept();// TODO 阻塞(等客户端接入)
客户端阻塞:应该上一个连接为完成导致无法接入下一次socket
解决办法:
1.使用异步线程thread处理具体的内容处理,尽快恢复`accept()`的监听
2.使用nio方式,无需开启异步线程,将内容置于缓存中

- nio socket
selector.select();// TODO 阻塞(服务端等待客户端)
客户端非阻塞:客户端将内容发送至nio的Reactor区
,服务端在处理完上一个消息后,可立即处理下一个消息
`JAVA NIO 简介 - Java综合 - Java - ITeye论坛`
http://www.iteye.com/topic/834447

- netty
基于nio的非阻塞网络框架.
`荐Netty4实现Websocket网页间聊天`
https://my.oschina.net/u/1756290/blog/363247