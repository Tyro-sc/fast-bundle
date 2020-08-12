package sc.tyro.bundle.fast

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension
import sc.tyro.core.component.Item
import sc.tyro.core.support.property.ItemSupport
import sc.tyro.core.support.state.CollapseSupport

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.core.Tyro.$
import static sc.tyro.core.Tyro.clickOn
import static sc.tyro.core.Tyro.visit

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("Accordion Tests")
class AccordionTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'index.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert Accordion in ItemSupport
        assert AccordionItem in CollapseSupport
        assert AccordionItem in Item
    }

    @Test
    @DisplayName("Should have expected Properties")
    void properties() {
        Accordion accordion = $('fast-accordion:first') as Accordion

        assert accordion.visible()
        assert accordion.items().size() == 3

        assert accordion.item('Panel One').value() == 'Panel One'
    }

    @Test
    @DisplayName("Should have expected States")
    void states() {
        Accordion accordion = $('fast-accordion:first') as Accordion

        assert accordion.items()[0].expanded()
        assert !accordion.items()[1].expanded()
        assert !accordion.items()[2].expanded()

        clickOn accordion.item('Panel Three')

        assert accordion.items()[2].expanded()
    }
}
