
# Kafka Connect connector for Schemaed Files (CSV or JSON)

<h2>
Overview
</h2>

This package offers a Source connector that converts flat files with
consistent, simple-to-parse schemas (CSV or JSON) into viable Kafka Connect
SourceRecords.   The corresponding Sink connector takes SinkRecords
from a Kafka topic and saves them to CSV or JSON files, preserving
the available schema (if any).

Users should specify the file type in the configuration file.  The
connector will override that setting for filenames with an explicit
.json or .csv extension.

<h2>
Known Issues
</h2>

Additional data arriving in the SourceConnector's input file will be
published.   However, some users have observed problems with CSV records
being published more than once under those conditions.  The behavior is 
being investigated.

# Unimplemented features

The SourceConnector only supports a single file (published to a single topic).

The publish.rate property is not yet supported.

# Running in development

```
mvn clean package
export CLASSPATH="$(find target/ -type f -name '*.jar'| grep '\-package' | tr '\n' ':')"
$CONFLUENT_HOME/bin/connect-standalone \
	$CONFLUENT_HOME/etc/schema-registry/connect-avro-standalone.properties \
	config/MySourceConnector.properties
```

A simple script that consumes/saves files from/to the testing directory
is included with this package; see standalone-test .
