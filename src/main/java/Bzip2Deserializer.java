import lombok.SneakyThrows;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;

public class Bzip2Deserializer implements Deserializer<byte[]> {

    @SneakyThrows
    @Override
    public byte[] deserialize(String s, byte[] bytes) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        BZip2CompressorInputStream bZip2CompressorInputStream = new BZip2CompressorInputStream(byteArrayInputStream);
        return bZip2CompressorInputStream.readAllBytes();
    }
}
