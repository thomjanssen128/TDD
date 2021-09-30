package nl.thom.tdd2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TrajectPrijsServiceTest {

    @Mock
    private TrajectNaarTrajectEenhedenService tntes;

    @Mock
    private TrajectEenhedenNaarPrijsService tenps;

    @InjectMocks
    private TrajectPrijsService tps;

    @Test
    void getTrajectPrijsTest(){
        String loc1 = "Amsterdam";
        String loc2 = "Utrecht";
        int eenheden = 15;
        when(tenps.getTrajectEenheden(loc1,loc2)).thenReturn(eenheden);
        when(tntes.getPriceTrajectEenheden(eenheden)).thenReturn(18.0);

        double prijs = tps.getTrajectPrijs(loc1, loc2);
        System.out.println(prijs);
        assertEquals(18, prijs,0);
        // assertjing
        assertThat(prijs).isEqualTo(18);
    }

    @Test
    void throwInvalidLocationExceptionOnInvalidLocation(){
        String loc1 = "Amsterdamned";
        String loc2 = "Utrecht";
        when(tenps.getTrajectEenheden(loc1,loc2)).thenThrow(new InvalidLocationException("Waaro? " + loc1));
        assertThatThrownBy(() -> tenps.getTrajectEenheden(loc1,loc2))
                .isInstanceOf(InvalidLocationException.class)
                .hasMessage("Waaro? Amsterdamned");

    }

}