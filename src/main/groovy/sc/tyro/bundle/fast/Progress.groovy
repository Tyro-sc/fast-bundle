package sc.tyro.bundle.fast

import sc.tyro.core.component.Component
import sc.tyro.core.support.property.MaximumSupport
import sc.tyro.core.support.property.MinimumSupport
import sc.tyro.core.support.property.ValueSupport
import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('fast-progress')
class Progress extends Component implements MaximumSupport, MinimumSupport, ValueSupport {
    @Override
    Number maximum() {
        provider.eval(this.id(), "it.attr('max')") as BigDecimal
    }

    @Override
    Number minimum() {
        provider.eval(this.id(), "it.attr('min')") as BigDecimal
    }

    @Override
    Number value() {
        provider.eval(this.id(), "it.attr('value')") as BigDecimal
    }
}
