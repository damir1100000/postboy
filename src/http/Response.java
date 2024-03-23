package http;


import http.request.Request;

public class Response {
    private String content;

    public Response (String content) {
        this.content = content;
    }

    public String getContent () {
        return this.content;
    }
};