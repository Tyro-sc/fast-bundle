package sc.tyro.bundle.fast

import sc.tyro.core.component.Component
import sc.tyro.core.support.property.TextSupport
import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('fast-badge')
class Badge extends Component implements TextSupport {
    @Override
    String text() {
        provider.eval(this.id(), "it.text().trim()")
    }
}
