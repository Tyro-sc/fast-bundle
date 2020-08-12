package sc.tyro.bundle.fast

import sc.tyro.bundle.html5.input.Input
import sc.tyro.core.component.field.TextField
import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('fast-text-area')
class TextArea extends TextField implements Input {
    @Override
    String label() {
        provider.eval(id(), "it[0].textContent")
    }

    @Override
    void clear() {

    }

    @Override
    String placeholder() {
        provider.eval(id(), "it.attr('placeholder')")
    }

    @Override
    boolean empty() {
        return false
    }

    @Override
    boolean readOnly() {
        provider.check(id(), "it[0].shadowRoot.querySelector('textarea').readOnly === true")
    }

    @Override
    boolean required() {
        return false
    }

    @Override
    boolean focused() {
        return false
    }

    @Override
    void value(Object value) {

    }

    @Override
    Number length() {
        return value().length()
    }

    @Override
    String value() {
        provider.eval(id(), "it[0].shadowRoot.querySelector('textarea').value")
    }

    @Override
    boolean valid() {
        return false
    }
}
