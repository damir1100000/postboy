package utils;

import http.Format;


//TODO: regex tutorial
public class Convertor {
    private String content;
    private Format from;
    private Format to;

    public Convertor (String content, Format to, Format from) {
        this.content = content;
        this.from = from;
        this.to = to;
    }

    public String extractRaw () {
        return "";
    }

    public String convert() {
        if(this.to.equals(Format.HTML)) {
            return this.toHtml();
        } else if (this.to.equals(Format.JSON)) {
            return this.toJson();
        } else if (this.to.equals(Format.XML)) {
            return this.toXml();
        } else {
            throw new NullPointerException("The format has not been specified");
        }
    }

    public String toHtml () {
        return "";
    }
    public String toJson () {
        /*
        StringBuilder stringBuilder = new StringBuilder();
        if(this.to.equals(Format.JSON)) {
            String [] lines = content.split("");
            for(String line : lines) {
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder.toString();
         */
        return this.content;
    }
    public String toXml () {
        return "";
    }
}
