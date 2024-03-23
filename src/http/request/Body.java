package http.request;

import http.Format;

public class Body {
    private Format format;
    private String content;

    public Body (String content, Format format) {
        this.content = content;
        this.format = format;
    }
}
