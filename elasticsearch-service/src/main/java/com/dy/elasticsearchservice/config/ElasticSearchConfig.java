package com.dy.elasticsearchservice.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: huangdeyao
 * @create: 2018-10-29 11:46
 **/
@Configuration
public class ElasticSearchConfig {

    TransportClient client = null;

    private static final Settings settings = Settings.builder()
            .put("cluster.name", "elasticsearch")
            .put("xpack.security.user", "elastic:HdY1927*")
            //增加嗅探机制，找到ES集群 不是集群不能设置，否则会出问题
//            .put("client.transport.sniff", false)
            //增加线程池个数为1
            //.put("thread_pool.search.size", 5)
            .build();

    @Bean
    public TransportClient client() throws UnknownHostException {
        client = new PreBuiltXPackTransportClient(settings);
        // transportClient = new PreBuiltTransportClient(esSetting);  不适用xpack加密时的用法
        client.addTransportAddresses(new TransportAddress(InetAddress.getByName("39.107.85.146"), 9300));
        return client;
    }
}
