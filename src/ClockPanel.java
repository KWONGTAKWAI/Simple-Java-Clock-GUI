import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class ClockPanel extends JPanel {

    Clock clock;

    private final int ringWidth = 40;
    private final double percentToRadians = 2 * Math.PI;

    public ClockPanel(Clock clock) {
        this.clock = clock;

        this.setPreferredSize(new Dimension(500, 500));
        this.setMinimumSize(new Dimension(ringWidth * 4, ringWidth * 4));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int width = this.getWidth();
        int height = this.getHeight();

        width = Math.min(width, height);
        height = Math.min(width, height);


        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.YELLOW);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.WHITE);

        g2d.fillRect(ringWidth, ringWidth, width - ringWidth * 2, height - ringWidth * 2);

        float hourBarLength = width / 4.0f;
        float minuteBarLength = width / 3.0f;
        float secondBarLength = minuteBarLength;

        int offsetX = (int) (Math.cos((clock.getHours() - 3) / 12.0 * percentToRadians) * hourBarLength);
        int offsetY = (int) (Math.sin((clock.getHours() - 3) / 12.0 * percentToRadians) * hourBarLength);
        g.setColor(Color.BLACK);
        g2d.drawLine(width / 2, height / 2, width / 2 + offsetX, height / 2 + offsetY);

        offsetX = (int) (Math.cos((clock.getMinutes() - 15) / 60.0 * percentToRadians) * minuteBarLength);
        offsetY = (int) (Math.sin((clock.getMinutes() - 15) / 60.0 * percentToRadians) * minuteBarLength);
        g.setColor(Color.BLUE);
        g2d.drawLine(width / 2, height / 2, width / 2 + offsetX, height / 2 + offsetY);

        offsetX = (int) (Math.cos((clock.getSeconds() - 15) / 60.0 * percentToRadians) * secondBarLength);
        offsetY = (int) (Math.sin((clock.getSeconds() - 15) / 60.0 * percentToRadians) * secondBarLength);
        g.setColor(Color.RED);
        g2d.drawLine(width / 2, height / 2, width / 2 + offsetX, height / 2 + offsetY);

    }

}