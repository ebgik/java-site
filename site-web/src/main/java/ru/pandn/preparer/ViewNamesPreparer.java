package ru.pandn.preparer;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.pandn.view.ViewNames;


@Component
public class ViewNamesPreparer implements ViewPreparer {
    private static final Logger logger = LoggerFactory.getLogger(ViewNamesPreparer.class);

    public void execute(Request request, AttributeContext attributeContext) {
        logger.info("ViewNamesPreparer(); ");
        request.getContext(Request.REQUEST_SCOPE).put("ViewNames",new ViewNames());
    }
}
