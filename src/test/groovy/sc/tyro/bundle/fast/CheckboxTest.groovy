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
@DisplayName("Checkbox Tests")
class CheckboxTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'index.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert CheckBox in sc.tyro.core.component.CheckBox
    }

    @Test
    @DisplayName("Should have expected Properties")
    void properties() {
        sc.tyro.core.component.CheckBox apple_checkBox = $('fast-checkbox:eq(0)') as CheckBox
        sc.tyro.core.component.CheckBox banana_checkBox = $('fast-checkbox:eq(1)') as CheckBox
        sc.tyro.core.component.CheckBox mango_checkBox = $('fast-checkbox:eq(2)') as CheckBox

        apple_checkBox.should {
            have label('Apple')

        }

        banana_checkBox.should {
            have label('Banana')
        }

        mango_checkBox.should {
            have label("Mango")
        }
    }

    @Test
    @DisplayName("Should have expected States")
    void states() {
        sc.tyro.core.component.CheckBox apple_checkBox = $('fast-checkbox:eq(0)') as CheckBox
        sc.tyro.core.component.CheckBox banana_checkBox = $('fast-checkbox:eq(1)') as CheckBox
        sc.tyro.core.component.CheckBox mango_checkBox = $('fast-checkbox:eq(2)') as CheckBox

        apple_checkBox.should {
            be enabled
            be checked

        }

        banana_checkBox.should {
            be enabled
            be unchecked
        }

        mango_checkBox.should {
            be disabled
            be checked
        }
    }
}
