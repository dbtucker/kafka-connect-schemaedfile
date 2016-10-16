package dbtucker.connect.file;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigException;

import java.util.Map;



public class SchemaedFileSinkConnectorConfig extends AbstractConfig {

  private enum CfgKeys {
    ;
    static final String FILE_FORMAT = "file.format" ;
    static final String OUTPUT_TYPE= "output.type" ;
    static final String CSV_HEADERS = "csv.headers" ;
  }

  private enum CfgTips {
    ;
    static final String FILE_FORMAT = "Format string for destination file; use ``${topic}`` as placeholder for source topic name.  OUTPUT_TYPE will be used as file extension." ;
    static final String OUTPUT_TYPE = "CSV or JSON" ;
    static final String CSV_HEADERS = "Include header row in CSV output";
  }

  private static final ConfigDef myConfigDef = new ConfigDef()
      .define(CfgKeys.FILE_FORMAT, ConfigDef.Type.STRING, "${topic}",
         ConfigDef.Importance.HIGH, CfgTips.FILE_FORMAT)
      .define(CfgKeys.OUTPUT_TYPE, ConfigDef.Type.STRING, "json",
         ConfigDef.Importance.HIGH, CfgTips.OUTPUT_TYPE)
      .define(CfgKeys.CSV_HEADERS, ConfigDef.Type.BOOLEAN, false,
         ConfigDef.Importance.MEDIUM, CfgTips.CSV_HEADERS) ;


  public SchemaedFileSinkConnectorConfig(ConfigDef config, Map<String, String> parsedConfig) {
    super(config, parsedConfig);
  }

  public SchemaedFileSinkConnectorConfig(Map<String, String> parsedConfig) {
    this(conf(), parsedConfig);
  }

  public static ConfigDef conf() {
    return myConfigDef ;
  }

  public String getFileFormat() {
    return this.getString(CfgKeys.FILE_FORMAT);
  }

  public String getOutputType() {
    return this.getString(CfgKeys.OUTPUT_TYPE);
  }

  public Boolean getCsvHeaders() {
    return this.getBoolean(CfgKeys.CSV_HEADERS);
  }
}
