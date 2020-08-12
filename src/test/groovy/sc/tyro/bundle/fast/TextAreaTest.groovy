package sc.tyro.bundle.fast

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension
import sc.tyro.bundle.html5.input.Input
import sc.tyro.core.component.field.TextField

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.core.Tyro.$
import static sc.tyro.core.Tyro.fill
import static sc.tyro.core.Tyro.visit

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("TextArea Tests")
class TextAreaTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'index.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        TextArea in TextField
        TextArea in Input
    }

    @Test
    @DisplayName("Should have expected Properties")
    void properties() {
        TextArea text_area = $('fast-text-area:first') as TextArea

        assert text_area.label() == 'How was your stay?'
        assert text_area.placeholder() == 'Describe your experience'
        assert text_area.value() == ''
        assert text_area.length() == 0

        fill text_area with 'A sample content'

        assert text_area.value() == 'A sample content'
        assert text_area.length() == 16
    }

    @Test
    @DisplayName("Should have expected States")
    void states() {
        TextArea text_area = $('fast-text-area:eq[0]') as TextArea
        TextArea text_area_read_only = $('fast-text-area:eq[1]') as TextArea

        assert !text_area.readOnly()

        assert text_area_read_only.readOnly()
    }
}
