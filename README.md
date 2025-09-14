Java Agent vs. eBPF: A Deep Dive into OpenTelemetry Instrumentation Technologies
================================================================================

AI Summary
----------

This talk compares OpenTelemetry's eBPF instrumentation with Java agent technology, focusing on deployment, compatibility, security, and performance. It examines differences in latency reporting, impacts of Kubernetes and service meshes, and advances in eBPF. The session concludes with future plans and strategies for combining both technologies for optimal results.

CfP
---

OpenTelemetry's new eBPF instrumentation [1] offers zero-code automatic instrumentation for a wide range of programming languages, including Java. However, there's also the well-established OpenTelemetry Java instrumentation [2], which is based on the Java agent technology and can be attached to any Java 8+ application. In this talk we'll present a comparative analysis of Java agent vs. eBPF in OpenTelemetry. You will learn to decide which instrumentation technology is right for you.

We'll cover operational aspects (deployment strategies, compatibility with third-party instrumentation), security considerations, deep dive into unexpected behaviors (why latencies reported by the Java agent may differ from the latencies reported by eBPF instrumentation), show how the underlying K8S platform and service meshes affect instrumentation, present recent advances in eBPF instrumentation (like trace ID propagation), and evaluate the performance impact of both Java Agent and eBPF.

We will close out with an outlook on future plans, including ideas on how to combine the two technologies to get the best of both worlds.

[1] https://github.com/open-telemetry/opentelemetry-ebpf-instrumentation/
[2] https://github.com/open-telemetry/opentelemetry-java-instrumentation/

Bio
---

Dr. Fabian Stäber is engineering manager and observability enthusiast at Grafana. He is a member of the Prometheus open source project, where he is maintainer of the Prometheus Java client library and the JMX exporter. At Grafana Fabian has his focus on application observability with OpenTelemetry.
