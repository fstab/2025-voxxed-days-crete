FROM eclipse-temurin:21-ubi9-minimal

COPY target/name-generator-1.0.0-SNAPSHOT.jar /

ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v2.19.0/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar

ENV OTEL_METRIC_EXPORT_INTERVAL=5000
# ENV OTEL_EXPORTER_OTLP_PROTOCOL=http/protobuf
ENV OTEL_EXPORTER_OTLP_METRICS_ENDPOINT=http://prometheus:9090/api/v1/otlp/v1/metrics
ENV OTEL_EXPORTER_OTLP_TRACES_ENDPOINT=http://tempo:4318/v1/traces
ENV OTEL_LOGS_EXPORTER=none

ENV OTEL_EXPORTER_OTLP_METRICS_DEFAULT_HISTOGRAM_AGGREGATION=base2_exponential_bucket_histogram

ENV JAVA_TOOL_OPTIONS="-javaagent:/opentelemetry-javaagent.jar"

CMD [ "java", "-jar", "/name-generator-1.0.0-SNAPSHOT.jar" ]
