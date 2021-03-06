package oripa.paint.creasepattern.tool;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import oripa.paint.creasepattern.tool.RectangleDomain;
import oripa.value.OriLine;
import oripa.value.OriPoint;

public class RectangleDomainTestWithXShapeLines {


	@Test
	public void test() {
		final double shapeSize = 100;
		final OriPoint center = new OriPoint(50, 50);
		CreasePatternFactory factory = new CreasePatternFactory();
		
		// 'X' shape lines
		Collection<OriLine> xLines = factory.createCrossedLines(100, center);

		// the lines should be in regular a rectangle (0, 100, 0, 100)
		RectangleDomain domain = new RectangleDomain(xLines);
		
		final double delta = 1e-8;
		assertEquals(100, domain.getRight(), delta);
		assertEquals(0,   domain.getLeft(), delta);
		assertEquals(0,   domain.getTop(), delta);
		assertEquals(100, domain.getBottom(), delta);

		assertEquals(shapeSize, domain.getWidth(), delta);
		assertEquals(shapeSize, domain.getHeight(), delta);
	}

}
