package sc.tyro.bundle.fast

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.core.Tyro.*

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("Radio Tests")
class RadioTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'index.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert Radio in sc.tyro.core.component.Radio
    }

    @Test
    @DisplayName("Should have expected Properties")
    void properties() {
        sc.tyro.core.component.Radio apple_radio = $('fast-radio:eq(0)') as Radio
        sc.tyro.core.component.Radio banana_radio = $('fast-radio:eq(1)') as Radio
        sc.tyro.core.component.Radio mango_radio = $('fast-radio:eq(2)') as Radio

        apple_radio.should {
            have label('Apple')

        }

        banana_radio.should {
            have label('Banana')
        }

        mango_radio.should {
            have label("Mango")
        }
    }

    @Test
    @DisplayName("Should have expected States")
    void states() {
        sc.tyro.core.component.Radio apple_radio = $('fast-radio:eq(0)') as Radio
        sc.tyro.core.component.Radio banana_radio = $('fast-radio:eq(1)') as Radio
        sc.tyro.core.component.Radio mango_radio = $('fast-radio:eq(2)') as Radio

        apple_radio.should {
            be enabled
            be checked

        }

        banana_radio.should {
            be enabled
            be unchecked
        }

        mango_radio.should {
            be disabled
            be checked
        }
    }
}
