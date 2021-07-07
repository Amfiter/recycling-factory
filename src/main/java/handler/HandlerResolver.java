package handler;

import container.*;
import material.*;

public class HandlerResolver {

    private final HandlerTreeNode<Material> rootHandlerTreeNode;

    public HandlerResolver(HandlerTreeNode<Material> rootHandlerTreeNode) {
        this.rootHandlerTreeNode = rootHandlerTreeNode;
    }

    public <T extends Material> Handler<? super T> resolve(Container<T> container) {
        return getHandlerRecursively(rootHandlerTreeNode, container.getType());
    }

    @SuppressWarnings("unchecked")
    private <T extends Material> Handler<? super T> getHandlerRecursively(HandlerTreeNode<? extends Material> parentNode, Class<T> type) {
        for (HandlerTreeNode<? extends Material> node : parentNode.getSubNodes()) {
            if (node.getType().isAssignableFrom(type))
                return getHandlerRecursively(node, type);
        }
        return (Handler<? super T>) parentNode.getHandler();
    }

}
