package com.asule.blog.modules.template.directive;

import com.asule.blog.modules.template.DirectiveHandler;
import com.asule.blog.modules.template.TemplateDirective;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ControlsDirective extends TemplateDirective {

    @Override
    public void execute(DirectiveHandler handler) throws IOException, TemplateException {
        handler.render();
    }

    @Override
    public String getName() {
        return "controls";
    }
}
