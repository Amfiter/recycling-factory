package handler;

import container.*;
import material.*;

public class Handler<T extends Material> {

    private final Class<T> type;

    public Handler(Class<T> type) {
        this.type = type;
    }

    public <EXTENDED extends T> Container<EXTENDED> handle(Container<EXTENDED> container) {
        Container<EXTENDED> resultContainer = new Container<>(
            container.getMaterial(),
            container.getMass() * container.getConversionFactor()
        );
        System.out.println("Handler for type " + type.getSimpleName()
            + " has processed container of type " + container.getType().getSimpleName()
            + " with mass " + container.getMass()
            + ". The final container has mass " + resultContainer.getMass()
        );
        return resultContainer;
    }

}
