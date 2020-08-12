package sc.tyro.bundle.fast

import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('fast-radio')
class Radio extends sc.tyro.core.component.Radio {
    @Override
    String label() {
        provider.eval(this.id(), "it.text().trim()")
    }

    @Override
    boolean checked() {
        provider.check(id(), "it.hasClass('checked')")
    }
}
