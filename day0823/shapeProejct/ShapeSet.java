package shapeProejct;

public class ShapeSet{
	Shape[] shapes = new Shape[100];
	int count;
	
	public void add(Shape s) {
		shapes[count++] = s;
	}
	
	public void allShapeDraw() {
		for(int i=0; i<count; i++) {
			System.out.println(shapes[i].info());
		}
	}
	
}