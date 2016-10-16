package dbtucker.connect.file;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



public class SchemaedFileSourceConnectorConfig extends AbstractConfig {

  public enum FileTypes {
    ;
    static final Integer JSON = 0;
    static final Integer CSV = 1;
  }

  private enum CfgKeys {
    ;
    static final String TOPIC = "topic" ;
    static final String FILE = "file" ;
    static final String INPUT_TYPE= "input.type" ;
    static final String CSV_HEADERS = "csv.headers" ;
    static final String PUBLISH_RATE = "publish.rate" ;
  }

  private enum CfgTips {
    ;
    static final String TOPIC = "Topic onto which data will be published" ;
    static final String FILE = "Source filename" ;
    static final String INPUT_TYPE = "CSV or JSON (default)" ;
    static final String CSV_HEADERS = "Include header row in CSV output";
    static final String PUBLISH_RATE = "approximate # of file lines per second to publish to the topic" ;
  }

  private static final ConfigDef myConfigDef = new ConfigDef()
      .define(CfgKeys.TOPIC, ConfigDef.Type.STRING, "",
         ConfigDef.Importance.HIGH, CfgTips.TOPIC)
      .define(CfgKeys.FILE, ConfigDef.Type.STRING, "",
         ConfigDef.Importance.HIGH, CfgTips.FILE) 
      .define(CfgKeys.INPUT_TYPE, ConfigDef.Type.STRING, "json",
         ConfigDef.Importance.HIGH, CfgTips.INPUT_TYPE)
      .define(CfgKeys.CSV_HEADERS, ConfigDef.Type.BOOLEAN, false,
         ConfigDef.Importance.LOW, CfgTips.CSV_HEADERS) 
      .define(CfgKeys.PUBLISH_RATE, ConfigDef.Type.INT, 1000,
         ConfigDef.Importance.HIGH, CfgTips.PUBLISH_RATE) ;

    private String localInputType = null;

    public SchemaedFileSourceConnectorConfig(ConfigDef config, Map<String, String> parsedConfig) {
        super(config, parsedConfig);
        localInputType = this.getString(CfgKeys.INPUT_TYPE);
    }

    public SchemaedFileSourceConnectorConfig(Map<String, String> parsedConfig) {
        this(conf(), parsedConfig);
    }

    public static ConfigDef conf() {
        return myConfigDef;
    }

    public String getTopic(){
        return this.getString(CfgKeys.TOPIC);
    }

    public String getFile(){
        return this.getString(CfgKeys.FILE);
    }

    public String getInputType() {
        return this.localInputType;
    }

    public void setInputType(String newInputType) {
        if (newInputType != null) {
            if (newInputType.equalsIgnoreCase("json")) {
                this.localInputType = "json";
            } else if (newInputType.equalsIgnoreCase("csv")) {
                this.localInputType = "csv";
            }
        }
    }

  public Boolean getCsvHeaders() {
    return this.getBoolean(CfgKeys.CSV_HEADERS);
  }

  public Integer getPublishRate(){
    return this.getInt(CfgKeys.PUBLISH_RATE);
  }
}
