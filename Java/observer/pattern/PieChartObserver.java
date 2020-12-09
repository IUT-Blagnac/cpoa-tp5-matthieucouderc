package observer.pattern;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import observer.CourseRecord;
import observer.LayoutConstants;

@SuppressWarnings("serial")
public class PieChartObserver extends ChartObserver {

    public PieChartObserver(CourseData data) {
        super(data);
    }

    public void paint(Graphics g) {
        super.paint(g);
        int radius = 100;

        //first compute the total number of students
        double total = 0.0;
        for (int i = 0; i < CourseData.size(); i++) {
            total += CourseData.elementAt(i).getNumOfStudents();
        }
        //if total == 0 nothing to draw
        if (total != 0) {
            double startAngle = 0.0;
            for (int i = 0; i < CourseData.size(); i++) {
                double ratio = (CourseData.elementAt(i).getNumOfStudents() / total) * 360.0;
                //draw the arc
                g.setColor(LayoutConstants.courseColours[i%LayoutConstants.courseColours.length]);
                g.fillArc(LayoutConstants.xOffset, LayoutConstants.yOffset, 2 * radius, 2 * radius, (int) startAngle, (int) ratio);
             
                startAngle += ratio;
            }
        }
    }
}