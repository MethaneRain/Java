// Basic attempt at a 1d Kinematics problem

public class Kinematics1d {
	
	double Disp(double x0, double v0, double t) {
	//double x = x0 + (v0*Math.cos(angle)*t);	
	double x = x0 + (v0*t);	

	System.out.println(x+" meters");
	return x;
	}
	
	public static void main(String[] args) {
		double v0 = 1.54;
		double t = 1;
		double x0 = 10;
	
		int k = 5;
		for (int i = 0; i < k; i++) {
			Kinematics1d disp = new Kinematics1d();
			double X = disp.Disp(x0,v0,t+i);
			x0 = X;
			}
		
	}
	

}
