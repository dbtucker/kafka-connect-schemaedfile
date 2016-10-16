package dbtucker.connect.file;

import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

public class SchemaedFileSinkTask extends SinkTask {
  private static Logger log = LoggerFactory.getLogger(SchemaedFileSinkTask.class);

  @Override
  public String version() {
    return VersionUtil.getVersion();
  }

  @Override
  public void start(Map<String, String> map) {
    //TODO: Create resources like database or api connections here.
  }

  @Override
  public void put(Collection<SinkRecord> collection) {

  }

  @Override
  public void flush(Map<TopicPartition, OffsetAndMetadata> map) {

  }

  @Override
  public void stop() {
    //Close resources here.
  }

}
