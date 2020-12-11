

import observer.CourseRecord;

import observer.pattern.BarChartObserver;
import observer.pattern.CourseController;
import observer.pattern.CourseData;
import observer.pattern.PieChartObserver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseTest {

    /**
     * General behaviour
     */
    @Test
    public void testCore() {

        CourseData data = new CourseData();
        data.addCourseRecord(new CourseRecord("Physics", 50));
        data.addCourseRecord(new CourseRecord("Chemistry", 50));
        data.addCourseRecord(new CourseRecord("Biology", 50));

        CourseController controller = new CourseController(data);
        BarChartObserver bar = new BarChartObserver(data);
        PieChartObserver pie = new PieChartObserver(data);

        assertEquals(pie.getCourseData().elementAt(0).getNumOfStudents(),
                controller.getCourseData().getCourseData().elementAt(0).getNumOfStudents());

        int numStudents = 32;
        controller.getSliders().elementAt(0).setValue(numStudents);

        assertEquals(pie.getCourseData().elementAt(0).getNumOfStudents(),
                numStudents);

    }

}