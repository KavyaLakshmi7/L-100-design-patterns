package model;

public final class Report {
    private final String dataSource;

    private final String title;
    private final String header;
    private final String footer;
    private final ReportFormat format;
    private final boolean includeCharts;

    private Report(Builder builder) {
        this.dataSource = builder.dataSource;
        this.title = builder.title;
        this.header = builder.header;
        this.footer = builder.footer;
        this.format = builder.format;
        this.includeCharts = builder.includeCharts;
    }

    @Override
    public String toString() {
        return String.format(
            "--- Report Configuration ---\n" +
            "  Data Source:   %s\n" +
            "  Title:         %s\n" +
            "  Format:        %s\n" +
            "  Header:        %s\n" +
            "  Footer:        %s\n" +
            "  Include Charts: %b\n" +
            "--------------------------",
            dataSource,
            title,
            format,
            (header != null ? header : "N/A"),
            (footer != null ? footer : "N/A"),
            includeCharts
        );
    }

    public static class Builder {

        private final String dataSource;

        private String title = "Untitled Report";
        private String header = null;
        private String footer = null;
        private ReportFormat format = ReportFormat.PDF;
        private boolean includeCharts = false;

        public Builder(String dataSource) {
            if (dataSource == null || dataSource.trim().isEmpty()) {
                throw new IllegalArgumentException("Data source cannot be null or empty.");
            }
            this.dataSource = dataSource;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withHeader(String header) {
            this.header = header;
            return this;
        }

        public Builder withFooter(String footer) {
            this.footer = footer;
            return this;
        }

        public Builder withFormat(ReportFormat format) {
            this.format = format;
            return this;
        }

        public Builder shouldIncludeCharts(boolean includeCharts) {
            this.includeCharts = includeCharts;
            return this;
        }
        public Report build() {
            return new Report(this);
        }
    }
}