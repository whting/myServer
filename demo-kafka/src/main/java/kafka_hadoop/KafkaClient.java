package kafka_hadoop;

import cn.hadoop.hdfs.conf.ConfigureAPI.KafkaProperties;
import cn.hadoop.hdfs.kafka.JConsumer;
import cn.hadoop.hdfs.kafka.JProducer;

/**
 * @Date May 22, 2015
 *
 * @Author dengjie
 *
 * @Note To run Kafka Code
 */
public class KafkaClient {

    public static void main(String[] args) {
        JProducer pro = new JProducer(KafkaProperties.TOPIC);
        pro.start();

        JConsumer con = new JConsumer(KafkaProperties.TOPIC);
        con.start();
    }

}