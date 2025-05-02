package hello.hellobasic.trace;

public class TraceStatus {
    private TraceId traceId;
    private Long startTimeMs;
    private String message;

    public String getMessage() {
        return message;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }
}
