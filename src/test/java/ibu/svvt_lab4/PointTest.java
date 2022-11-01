package ibu.svvt_lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {

	@ParameterizedTest
	@CsvSource({"0,3,4,0,5"})
	void testDistance(int x1, int y1, int x2, int y2, double distance) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		double result = p1.distance(p2);
		assertEquals(distance, result);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"0,3;4,0;5"}, delimiter = ';')
	void testDistanceUsingConverter(
			@ConvertWith(PointConverter.class) Point p1,
			@ConvertWith(PointConverter.class) Point p2,
			double distance
		) {
		double result = p1.distance(p2);
		assertEquals(distance, result);
	}

}
