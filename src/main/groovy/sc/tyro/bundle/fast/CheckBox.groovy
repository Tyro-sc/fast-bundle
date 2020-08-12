package sc.tyro.bundle.fast

import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('fast-checkbox')
class CheckBox extends sc.tyro.core.component.CheckBox{
    @Override
    String label() {
        provider.eval(this.id(), "it.text().trim()")
    }

    @Override
    boolean checked() {
        provider.check(id(), "it.hasClass('checked')")
    }
}
