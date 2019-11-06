// Basic attempt at a 1d Kinematics problem

public class Kinematics1d {
	
	double Disp(double x0, double v0, double t, int i) {
	//double x = x0 + (v0*Math.cos(angle)*t);	
	double a = 0.2;
	double x = x0 + (v0*t)-a*t*t;	

	System.out.println("\n"+"time step: "+i+"\nx-displacement: "+x+" meters");
	return x;
	}
	
	public static void main(String[] args) {
		double v0 = 10.54;
		double t = 1;
		double x0 = 0;
	
		int k = 5;
		for (int i = 0; i < k; i++) {
			Kinematics1d disp = new Kinematics1d();
			double X = disp.Disp(x0,v0,t+i,i+1);
			x0 = X;
	
			}
	System.out.println("\nDone.");	
	}
	

}
