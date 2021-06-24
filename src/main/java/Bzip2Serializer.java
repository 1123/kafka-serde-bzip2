import lombok.SneakyThrows;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;

public class Bzip2Serializer implements Serializer<byte[]> {

    @SneakyThrows
    @Override
    public byte[] serialize(String s, byte[] bytes) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BZip2CompressorOutputStream bZip2CompressorOutputStream = new BZip2CompressorOutputStream(byteArrayOutputStream, 1);
        bZip2CompressorOutputStream.write(bytes);
        bZip2CompressorOutputStream.close();
        return byteArrayOutputStream.toByteArray();

    }
}

