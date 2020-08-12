package sc.tyro.bundle.fast

import sc.tyro.core.By
import sc.tyro.core.component.Component
import sc.tyro.core.support.property.ItemSupport
import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('fast-accordion')
class Accordion extends Component implements ItemSupport {
    @Override
    List<AccordionItem> items() {
        provider.findAll(By.expression('#' + id() + ' fast-accordion-item'), AccordionItem)
    }

    @Override
    AccordionItem item(String value) {
        items().find { it.value() == value }
    }
}
