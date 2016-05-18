package handlers;

import java.io.File;

/**
 *
 * @author Simon
 */
public class ResponseBuilder {

    public final static String MIME_JAVASCRIPT = "application/javascript";
    public final static String MIME_JSON = "application/json";
    public final static String MIME_HTML = "text/html";
    public final static String MIME_CSS = "text/css";
    public final static String MIME_PLAIN = "text/plain";

    private String rootPath = "";

    public ResponseBuilder() {
        
    }

    public ResponseBuilder(String root) {
        super();
        rootPath = root;
    }

    public File getFile(String fileName) {
        File file = new File(rootPath + fileName);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public String getMimeType(String fileName) {
        String extension = "";
        int index = fileName.lastIndexOf(".");

        if (index != -1) {
            extension = fileName.substring(fileName.lastIndexOf("."));
        }

        switch (extension) {
            case ".js":
                return MIME_JAVASCRIPT;
            case ".html":
                return MIME_HTML;
            case ".css":
                return MIME_CSS;
            case ".json":
                return MIME_JSON;
            default:
                return MIME_PLAIN;
        }

    }

    
    
    
}
