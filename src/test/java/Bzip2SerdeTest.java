import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Bzip2SerdeTest {

    @Test
    public void test() {
        String testString = "alsdkjfalskdfjlaksdjflkjasdlkfjlaksdjflkajsdlfjlkasdjflkjasdfabc";
        Bzip2Serializer serializer = new Bzip2Serializer();
        Bzip2Deserializer deserializer = new Bzip2Deserializer();
        String result = new String(deserializer.deserialize(
                "topic1",
                serializer.serialize(
                        "topic1",
                        testString.getBytes(StandardCharsets.UTF_8)
                )
        ));
        assertEquals(testString, result);
    }

}
