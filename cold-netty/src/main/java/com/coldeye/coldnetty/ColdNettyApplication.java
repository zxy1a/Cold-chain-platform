package com.coldeye.coldnetty;

import com.coldeye.coldnetty.service.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ColdNettyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ColdNettyApplication.class, args);
    }

    @Override
    public void run(String...args)  throws Exception{
        //1. netty辅助的启动类
        ServerBootstrap bootstrap = new ServerBootstrap();

        //2 . 定义线程池
        //线程池，用来处理接收连接请求的线程池
        EventLoopGroup boss = new NioEventLoopGroup();
        //线程池，用来处理具体的工作
        EventLoopGroup worker = new NioEventLoopGroup();

        //3. 设置启动类的属性
        bootstrap.group(boss, worker);
        bootstrap.option(ChannelOption.SO_BACKLOG, 128);
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);

        // 设置通道类型
        bootstrap.channel(NioServerSocketChannel.class);
        // 设置处理器
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new ServerHandler());
            }
        });


        try{
            // 绑定端口、启动服务
            ChannelFuture f = bootstrap.bind(10010).sync();
            f.channel().closeFuture().sync();
        }
        finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
