package sc.tyro.bundle.fast

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension
import sc.tyro.core.component.Component
import sc.tyro.core.support.property.TextSupport

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.core.Tyro.$
import static sc.tyro.core.Tyro.visit

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("Badge Tests")
class BadgeTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'index.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert Badge in TextSupport
    }

    @Test
    @DisplayName("Should have expected Properties")
    void properties() {
        Badge badge = $('fast-badge:first') as Badge

        assert badge.text() == 'My Badge'
    }
}
