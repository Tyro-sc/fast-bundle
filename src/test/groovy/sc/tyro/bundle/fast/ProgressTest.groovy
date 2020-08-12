package sc.tyro.bundle.fast

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension
import sc.tyro.core.support.property.MaximumSupport
import sc.tyro.core.support.property.MinimumSupport
import sc.tyro.core.support.property.ValueSupport

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.core.Tyro.$
import static sc.tyro.core.Tyro.visit

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("Checkbox Tests")
class ProgressTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'index.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert Progress in MaximumSupport
        assert Progress in MinimumSupport
        assert Progress in ValueSupport

        assert ProgressRing in Progress
    }

    @Test
    @DisplayName("Should have expected Properties")
    void properties() {
        Progress progress = $('fast-progress:first') as Progress
        ProgressRing progressRing = $('fast-progress-ring:first') as ProgressRing

        assert progress.maximum() == 100
        assert progress.minimum() == 0
        assert progress.value() == 75

        assert progressRing.maximum() == 100
        assert progressRing.minimum() == 0
        assert progressRing.value() == 75
    }
}
