package sc.tyro.bundle.fast

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.core.Tyro.$
import static sc.tyro.core.Tyro.visit

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("Button Tests")
class ButtonTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'index.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert Button in sc.tyro.core.component.Button
    }

    @Test
    @DisplayName("Should have expected Properties")
    void properties() {
        sc.tyro.core.component.Button button = $('fast-button:first') as Button

        assert button.text() == 'My Button'
    }
}
