package algo.stroganov.bagpack;

import org.junit.jupiter.api.Test;

class BagPackDPTest {
    private BagPackDP bagPackDP = new BagPackDP();

    @Test
    void bagPackDP() throws InterruptedException {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int result = bagPackDP.bagPackDP(7, weights, values, 4,true);
        assert result == 9;
    }
}