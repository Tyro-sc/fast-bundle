package sc.tyro.bundle.fast

import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('fast-button')
class Button extends sc.tyro.core.component.Button {
    @Override
    String text() {
        provider.eval(this.id(), "it.text().trim()")
    }
}
