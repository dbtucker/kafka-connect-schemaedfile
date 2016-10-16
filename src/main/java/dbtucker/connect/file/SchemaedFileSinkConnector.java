package dbtucker.connect.file;

import java.util.List;
import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchemaedFileSinkConnector extends SinkConnector {
  private static Logger log = LoggerFactory.getLogger(SchemaedFileSinkConnector.class);
  private SchemaedFileSinkConnectorConfig config;

  @Override
  public String version() {
    return VersionUtil.getVersion();
  }

  @Override
  public void start(Map<String, String> map) {
    config = new SchemaedFileSinkConnectorConfig(map);

  }

  @Override
  public Class<? extends Task> taskClass() {
    //TODO: Return your task implementation.
    return SchemaedFileSinkTask.class;
  }

  @Override
  public List<Map<String, String>> taskConfigs(int maxTasks) {
    //TODO: Define the individual task configurations that will be executed.

    /**
     * This is used to schedule the number of tasks that will be running. This should not exceed maxTasks.
     */

    throw new UnsupportedOperationException("This has not been implemented.");
  }

  @Override
  public void stop() {
    //TODO: Do things that are necessary to stop your connector.
  }

  @Override
  public ConfigDef config() {
    return SchemaedFileSinkConnectorConfig.conf();
  }
}
