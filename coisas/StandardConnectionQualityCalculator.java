public class StandardConnectionQualityCalculator implements IConnectionQualityCalculator {
    @Override
    public double assessQuality(Connection c) {
        double jitter = c.getJitter();
        String proposito = c.getProposito().toLowerCase();
        double limite5 = 1.0;
        double limite4 = 10.0;
        double limite3 = 30.0;
        double limite2 = 50.0;

        if (proposito.equals("gaming")) {
            limite4 = limite4 / 2.0;
            limite3 = limite3 / 2.0;
            limite2 = limite2 / 2.0;
        }
        else if (proposito.equals("downloading")) {
            limite5 = limite5 * 5.0;
            limite4 = limite4 * 5.0;
            limite3 = limite3 * 5.0;
            limite2 = limite2 * 5.0;
        }

        if (jitter < limite5) {
            return 5.0;
        } else if (jitter >= limite5 && jitter < limite4) {
            return 4.0;
        } else if (jitter >= limite4 && jitter < limite3) {
            return 3.0;
        } else if (jitter >= limite3 && jitter < limite2) {
            return 2.0;
        } else {
            return 1.0;
        }
    }
}
