import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Bzip2KafkaProducerTest {

    private byte[] readMessageFromFile() throws IOException {
        var fis = new FileInputStream("src/main/resources/bzip2-wikipedia.html");
        var channel = fis.getChannel();
        var bb = ByteBuffer.allocate((int) channel.size());
        channel.read(bb);
        return bb.array();
    }

    @Test
    public void test() throws ExecutionException, InterruptedException, IOException {
        Properties properties = new Properties();
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", Bzip2Serializer.class);
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("acks", "all");
        KafkaProducer<String, byte[]> kafkaProducer = new KafkaProducer<>(properties);
        var result = kafkaProducer.send(new ProducerRecord<>("topic", readMessageFromFile()));
        result.get();
    }
}
