import java.util.*;
import java.lang.Math.*;


 
class NeuralNetwork{
		int numOfInput = 35; //keeps track of #of input nodes
		int layerOneNum = 32; //keeps track of #of nodes in layer 1
		int layerTwoNum = 16; //keeps track of # of nodes in layer 2
		int numOfOutput = 26; //keeps track of # of nodes in output layer
		int sample;			  //keeps track of # of samples
		double alpha = 0.03;
		
		double[] out = new double[10];
		
		double[][] w1 = new double[numOfInput][layerOneNum];
		double[][] w2 = new double[layerOneNum][layerTwoNum];
		double[][] w3 = new double[layerTwoNum][numOfOutput];
		
	        //creates layers and weight matrices for the neural network		
		double[][] input;
		double[][] l1;
		double[][] l2;
		double[][]output;
		
		//declares backward prop arrays
		double[][] out_error;
		double[][] out_delta;
	
		double[][] l2_error;
		double[][] l2_delta;
	
		double[][] l1_error;
		double[][] l1_delta;
	
	
		double[][] input_error;
		double[][] input_delta;
		
		double[][] dummyOut;
		

	public NeuralNetwork(int spl){
	    
		sample = spl;
		populate(w1);
		populate(w2);
		populate(w3);
	}
	


	double[] forward(double[] q){
		
		double[][] input = new double[sample][numOfInput];

		double[][] l1 = new double[sample][layerOneNum];

		double[][] l2 = new double[sample][layerTwoNum];

		double[][] output = new double[sample][numOfOutput];
		
		
		//sets the input array to the one passed by the MAIN
		for(int i=0;i<q.length;i++){
				input[0][i] = q[i];
			}
			
		matrixDot(input,w1,l1);
		
		System.out.println("\n\ninput layer\n");
		print_matrix(input);
		
		my_sig(l1);
		
		matrixDot(l1,w2,l2);
		
		my_sig(l2);
		
		matrixDot(l2,w3,output);
		
		my_sig(output);
		
		System.out.println("\nThis is output on SIGMOID: \n");
		print_matrix(output);
		
		//sets the top 5 letters guessed
		get_results(output);
		
		/*sets out to 0, 1, or 0.5 for what letter it thought it was
		set_out(output);
		System.out.println("\nGuessing what letter it is : \n");
		print_matrix(output);
		//prints out the letters for easy reading
		System.out.println("[A , B , C , D , E , F , G , H , I , J , K , L , M , N , O , P , Q , R , S , T , U , V , W , X , Y , Z ].\n\n");*/
		
		return out;	//return for GUI/Preston
		

	}
	
	//prints out the elements of a given matrix
	void print_matrix(double[][] matrix){
		System.out.println("Rows: " + matrix.length + ", Columns: " + matrix[0].length);
		System.out.print("{");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("{");
	    	for (int j = 0; j < matrix[i].length; j++){
				if(j<matrix[0].length){
	     	   	 	System.out.print(matrix[i][j] + ", ");
		   		}
				else{
					System.out.print(matrix[i][j] + "}");
				}
	    	}
	    	System.out.println();
		}
		System.out.println("}");
		System.out.println("\n\n\n\n\n");
	}
	
	//sets the output to 0,1,or 0.5. 0=negative guess, 1 = positive guess, .5 = not sure
	void set_out(double[][] matrix){
		System.out.println("Rows: " + matrix.length + ", Columns: " + matrix[0].length);
		for (int i = 0; i < matrix.length; i++) {
	    	for (int j = 0; j < matrix[i].length; j++){
				if(matrix[i][j] >=.9){
					matrix[i][j] = 1.0; //if output close to 1,show 1
				}
				else if(matrix[i][j] <=0.1 && matrix[i][j] >=0.0){
					matrix[i][j] = 0.0; //if output close to 0, show this value
				}
				else if(matrix[i][j]<0.0){ 
					matrix[i][j] = -17; //if the output value is somehow less than 0, show this for an 'error'
				}
				else{
					matrix[i][j] = 0.5;
				}
	    	}
		}
	}
	
	//function for multiplying two matrices together
	void matrixDot(double[][] one, double[][]two, double[][] three){
		
		for(int i=0;i<three.length;i++){

			for(int j=0;j<three[0].length;j++){

				for(int k=0;k<one[0].length;k++){
						 three[i][j] += one[i][k]*two[k][j];
				}
			}
		}
	}
	
	//function for setting weights to random values
	void populate(double[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				matrix[i][j] = (Math.random()*8)-4;
			}
		}
	}
	
	//function for applying sigmoid to a matrix
	void my_sig(double[][] x){
		double sig = 0;
		
		for (int i = 0; i < x.length; i++) {
	    	for (int j = 0; j < x[i].length; j++){
	     	   sig = 1/(1+Math.pow(Math.E,(-1*(x[i][j]))));
				   x[i][j] = sig;
	    	}
		}
		
		
	}
	
	//function to get the top 5 guessed letters
	void get_results(double[][] n){
		double greatest = -1;
		double lastGreatest = 2;
		double gIndex = 17;
		for (int i = 0; i < ((out.length)/2); i++) {
			for(int j=0;j<n[0].length;j++){
				if(n[0][j]>greatest && n[0][j]<lastGreatest){
					greatest = n[0][j];
					gIndex = j;
				}
			}
			out[i] = greatest;
			out[i+5] = gIndex;
			lastGreatest = greatest;
			greatest = -1;
		}
	}

	// function for applying the derivative used in pack propagation
	void my_deriv(double[][] x){
		double deriv = 0;
		
		for (int i = 0; i < x.length; i++) {
	    	for (int j = 0; j < x[i].length; j++){
	    		// (x *(1-x))
	     	   deriv = (x[i][j] *(1 - x[i][j])) ;
				   x[i][j] = deriv;
	    	}
		}
			
		
	}
	
	
	//propagate for learning function
	
	void learningprop(double[] q,double[] targetOut){
		
		//arrays needed for FORWARD PROP
		double[][] input = new double[sample][numOfInput];

		double[][] l1 = new double[sample][layerOneNum];

		double[][] l2 = new double[sample][layerTwoNum];

		double[][] output = new double[sample][numOfOutput];
		
		
		
		//arrays needed for backprop
		
			double[][] dummyOut = new double[1][targetOut.length];
			
			double[][] out_error = new double[1][26];
			double[][] out_delta = new double[1][26];
		
			double[][] l2_error = new double[1][16];
			double[][] l2_delta = new double[1][16];
		
			double[][] l1_error = new double[1][32];
			double[][] l1_delta = new double[1][32];
		
		
			double[][] input_error = new double[1][35];
			double[][] input_delta = new double[1][35];
			
		
		
			//STARTING THE FORWARD PROP
		
		//sets the input array to the one passed by the MAIN
		for(int i=0;i<q.length;i++){
				input[0][i] = q[i];
		}
		
		//forward prop on l1
		matrixDot(input,w1,l1);
		
		my_sig(l1);
		
		//forward prop on l2
		matrixDot(l1,w2,l2);
		
		my_sig(l2);
			
		//forward prop on l3
		matrixDot(l2,w3,output);
		
		my_sig(output);
		
		//sets the top 5 letters guessed
		get_results(output);
		
		
		//STARTING THE BACKWARDS PROP
		
	
		
		for(int i=0;i<targetOut.length;i++){
				dummyOut[0][i] = targetOut[i];
		}
			
			
					//calculates the error of the target - actual
				for (int i = 0; i < output[0].length; i++) {
			    		out_error[0][i] = dummyOut[0][i] - output[0][i];
				}
			
			
				//apply deriv of sigmoid, then set each elem in l4delta to the result
				my_deriv(output);
				for(int i=0;i<out_error[0].length;i++){
					out_delta[0][i] = out_error[0][i] * output[0][i];
				}
				
				
				//gets the l2_error
				matrixDot(out_delta,myTranspose(w3),l2_error);
			
				//getting deltal3
				my_deriv(l2);
				for(int i=0;i<l2_error[0].length;i++){
					l2_delta[0][i] = l2_error[0][i] * l2[0][i];
				}
			
				//gets the l1_error
				matrixDot(l2_delta,myTranspose(w2),l1_error);
			
				//getting deltal2
				my_deriv(l1);
				for(int i=0;i<l1_error[0].length;i++){
					l1_delta[0][i] = l1_error[0][i] * l1[0][i];
				}
			
				//gets the input_error
				matrixDot(l1_delta,myTranspose(w1),input_error);
			
		
	       // Updating weight3
	        for(int i=0;i<w3.length;i++){
	            for(int j=0;j<w3[i].length;j++){
	                w3[i][j] = w3[i][j] + alpha*l2[0][i]*out_delta[0][j];
	            } 
	        }
		
			//updating w2
	        for(int i=0;i<w2.length;i++){
	            for(int j=0;j<w2[i].length;j++){
	                w2[i][j] = w2[i][j] + alpha*l1[0][i]*l2_delta[0][j];
	            } 
	        }
		
			//updating w1				
	        for(int i=0;i<w1.length;i++){
	            for(int j=0;j<w1[i].length;j++){
	                w1[i][j] = w1[i][j] + alpha*input[0][i]*l1_delta[0][j];
	            } 
	        }
		
	}
	
	//gets the transpose of a matrix
	double[][] myTranspose(double[][] x){
		double[][] temp = new double[x[0].length][x.length];
		for (int i = 0; i < x.length; i++) {
	    	for (int j = 0; j < x[i].length; j++){
	    		temp[j][i] = x[i][j];
	    	}
		}
		return temp;
	}
	

}

