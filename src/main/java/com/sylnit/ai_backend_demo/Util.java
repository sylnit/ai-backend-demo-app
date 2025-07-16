package com.sylnit.ai_backend_demo;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.text.TextContentRenderer;

public class Util {
    public static String stripMarkdown(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        TextContentRenderer renderer = TextContentRenderer.builder().build();
        return renderer.render(document);
    }
}
