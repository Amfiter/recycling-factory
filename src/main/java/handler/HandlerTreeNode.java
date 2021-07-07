package handler;

import material.*;

import java.util.*;

public class HandlerTreeNode<T extends Material> {

    private final Class<T> type;
    private final Handler<T> handler;
    private final Collection<HandlerTreeNode<? extends T>> subHandlerTreeNodes;

    public HandlerTreeNode(Class<T> type, Handler<T> handler, Collection<HandlerTreeNode<? extends T>> subHandlerTreeNodes) {
        this.type = type;
        this.handler = handler;
        this.subHandlerTreeNodes = subHandlerTreeNodes;
    }

    public Class<T> getType() {
        return type;
    }

    public Handler<T> getHandler() {
        return handler;
    }

    public Collection<HandlerTreeNode<? extends T>> getSubNodes() {
        return subHandlerTreeNodes;
    }

}
