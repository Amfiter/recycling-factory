import container.*;
import handler.*;
import material.*;

import java.util.*;

public class EntryPoint {

    public static void main(String[] args) {

        // handler tree init
        HandlerTreeNode<BrownGlass> brownGlassHandlerNode = new HandlerTreeNode<>(BrownGlass.class, new Handler<>(BrownGlass.class), Collections.emptyList());
        HandlerTreeNode<GreenGlass> greenGlassHandlerNode = new HandlerTreeNode<>(GreenGlass.class, new Handler<>(GreenGlass.class), Collections.emptyList());
        HandlerTreeNode<Glass> glassHandlerNode = new HandlerTreeNode<>(Glass.class, new Handler<>(Glass.class), Arrays.asList(brownGlassHandlerNode, greenGlassHandlerNode));
        HandlerTreeNode<Plastic> plasticHandlerNode = new HandlerTreeNode<>(Plastic.class, new Handler<>(Plastic.class), Collections.emptyList());
        HandlerTreeNode<Material> materialHandlerNode = new HandlerTreeNode<>(Material.class, null, Arrays.asList(glassHandlerNode, plasticHandlerNode));

        HandlerResolver handlerResolver = new HandlerResolver(materialHandlerNode);

        // processing
        List<Container<? extends Material>> containers = Arrays.asList(
            new Container<>(new WhiteGlass(), 1.2),
            new Container<>(new GreenGlass(), 1.4)
        );
        for (Container<? extends Material> container : containers) {
            handleWithCapturedWildcard(container, handlerResolver);
        }
    }

    private static <T extends Material> Container<T> handleWithCapturedWildcard(Container<T> container, HandlerResolver resolver) {
        return resolver.resolve(container).handle(container);
    }

}

