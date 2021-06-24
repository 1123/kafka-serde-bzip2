# kafka-serde-bzip2

Compression / Decompression of Kafka messages with BZip2

This project gives an example for how to compress / decompress Kafka messages using Bzip2 using Kafka messages serializers and deserializers.

As of today, Kafka producers and consumers support the compression types lz4, gzip, snappy and zstd -- or no compression at all. 
These compression algorithms should be sufficient for almost all use cases. 
Additionally, compression in Kafka happens on a batch of messages, and is therefore more efficient than when compressing each message individually. 
Therefore the standard compression options are usually more suitable than the method described here. 

Yet if for some reason, you need support for bzip2 compression -- e.g. when you are dealing with quite large messages and a high compression ratio is very important,
this project may help you. Simply look at the test cases on how to use the serializers / deserializers, which are based upon the Apache commons compress library. 
