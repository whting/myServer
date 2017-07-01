package kafka_hadoop;


/**
 * @Date May 22, 2015
 *
 * @Author dengjie
 *
 * @Note To run Kafka Code
 */
public class KafkaClient {

    public static void main(String[] args) {
        JProducer pro = new JProducer(ConfigureAPI.KafkaProperties.TOPIC);
        pro.start();

        JConsumer con = new JConsumer(ConfigureAPI.KafkaProperties.TOPIC);
        con.start();
    }

}