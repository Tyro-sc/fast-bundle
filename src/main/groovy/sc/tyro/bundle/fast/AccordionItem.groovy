package sc.tyro.bundle.fast

import sc.tyro.core.ComponentException
import sc.tyro.core.component.Item
import sc.tyro.core.support.state.CollapseSupport
import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('fast-accordion-item')
class AccordionItem extends Item implements CollapseSupport {
    @Override
    Object value() {
        provider.eval(id(), "it.find('[slot=heading]').text().trim()")
    }

    @Override
    boolean selected() {
        throw new ComponentException('Unsupported Operation')
    }

    @Override
    boolean collapsed() {
        !expanded()
    }

    @Override
    boolean expanded() {
        provider.check(id(), "it.hasClass('expanded')")
    }
}
