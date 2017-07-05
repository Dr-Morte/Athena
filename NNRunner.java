import java.util.*;
import java.text.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;



public class NNRunner{
	
	public static void main(String args[]){
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //clears the screen for the next run
		
		int sample = 1;		//set the number of letters given to the NN
		
		double[] ina = {0, 0, 1, 0, 0,
				 	    0, 1, 0, 1, 0,
					    1, 0, 0, 0, 1,
					    1, 0, 0, 0, 1,
					    1, 1, 1, 1, 1,
					    1, 0, 0, 0, 1, 
					    1, 0, 0, 0, 1}; //for demoing, I am using the letter A
						
		double [] inb = {1, 1, 1, 1, 0,
			 			 0, 1, 0, 0, 1,
					     0, 1, 0, 0, 1, 
					     0, 1, 1, 1, 0, 
						 0, 1, 0, 0, 1, 
					     0, 1, 0, 0, 1, 
						 1, 1, 1, 1, 0};
						 
		double [] inc = {0, 1, 1, 1, 0,
				 		 1, 0, 0, 0, 1, 
					  	 1, 0, 0, 0, 0,
					     1, 0, 0, 0, 0, 
					     1, 0, 0, 0, 0, 
						 1, 0, 0, 0, 1,
						 0, 1, 1, 1, 0};
						 
		double [] ind = {1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0};
		double [] ine = {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1};
		double [] inf = {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0};
		double [] ing = {0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1};
		double [] inh = {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1};
		double [] ini = {0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0};
		double [] inj = {0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0};
		double [] ink = {1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1};
		double [] inl = {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1};
		double [] inm = {1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1};
		double [] inn = {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1};
		double [] ino = {0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0};
		double [] inp = {1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0};
		double [] inq = {0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1};
		double [] inr = {1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1};
		double [] ins = {0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0};
		double [] inT = {1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0};
		double [] inu = {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0};
		double [] inv = {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0};
		double [] inw = {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
		double [] inx = {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1};
		double [] iny = {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0};
		double [] inz = {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1};
					   
		
		
		double[] targOutA = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};	
		double[] targOutB = {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		double[] targOutC = {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};	
		double[] targOutD = {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		double[] targOutE = {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};	
		double[] targOutF = {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		double[] targOutG = {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};	
		double[] targOutH = {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		double[] targOutI = {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};	
		double[] targOutJ = {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		double[] targOutK = {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};	
		double[] targOutL = {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		double[] targOutM = {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0};
		double[] targOutN = {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0};	
		double[] targOutO = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0};
		double[] targOutP = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0};	
		double[] targOutQ = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0};
		double[] targOutR = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0};	
		double[] targOutS = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0};
		double[] targOutT = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0};	
		double[] targOutU = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0};
		double[] targOutV = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0};	
		double[] targOutW = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0};
		double[] targOutX = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0};	
		double[] targOutY = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0};
		double[] targOutZ = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		
				   
		double[][] out;	//the output matrix from forward
		double[] output = {0,0,0,0,0,0,0,0,0,0};	//output array that Preston needs. still need to code that algorithm
		
		//Instanciate the NN
		NeuralNetwork athena = new NeuralNetwork(sample);
		
		
		System.out.println("Weight 1 before training:");
		athena.print_matrix(athena.w1);
		System.out.println("\n\nWeight 2 before training:");
		athena.print_matrix(athena.w2);
		System.out.println("\n\nWeight 3 before training:");
		athena.print_matrix(athena.w3);
		
		
		for(int i=0;i<5000;i++){
			athena.learningprop(ina,targOutA);
			athena.learningprop(ina,targOutB);
			athena.learningprop(ina,targOutC);
			athena.learningprop(ina,targOutD);
			athena.learningprop(ina,targOutE);
			athena.learningprop(ina,targOutF);
			athena.learningprop(ina,targOutG);
			athena.learningprop(ina,targOutH);
			athena.learningprop(ina,targOutI);
			athena.learningprop(ina,targOutJ);
			athena.learningprop(ina,targOutK);
			athena.learningprop(ina,targOutL);
			athena.learningprop(ina,targOutM);
			athena.learningprop(ina,targOutN);
			athena.learningprop(ina,targOutO);
			athena.learningprop(ina,targOutP);
			athena.learningprop(ina,targOutQ);
			athena.learningprop(ina,targOutR);
			athena.learningprop(ina,targOutS);
			athena.learningprop(ina,targOutT);
			athena.learningprop(ina,targOutU);
			athena.learningprop(ina,targOutV);
			athena.learningprop(ina,targOutW);
			athena.learningprop(ina,targOutX);
			athena.learningprop(ina,targOutY);
			athena.learningprop(ina,targOutZ);
			
			
		}
		
		
		
		System.out.println("\n\n\n\n\nWeight 1 after training:");
		athena.print_matrix(athena.w1);
		System.out.println("\n\nWeight 2 after training:");
		athena.print_matrix(athena.w2);
		System.out.println("\n\nWeight 3 after training:");
		athena.print_matrix(athena.w3);
		
		
		output = athena.forward(ina);
		
		System.out.println("\nThis is athena's output for A after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inb);

		
		System.out.println("\nThis is athena's output for B after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(inc);

		
		System.out.println("\nThis is athena's output for C after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(ind);

		
		System.out.println("\nThis is athena's output for D after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(ine);
		
		System.out.println("\nThis is athena's output for E after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inf);

		
		System.out.println("\nThis is athena's output for F after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(ing);

		
		System.out.println("\nThis is athena's output for G after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inh);

		
		System.out.println("\nThis is athena's output for H after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(ini);
		
		System.out.println("\nThis is athena's output for I after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inj);

		
		System.out.println("\nThis is athena's output for J after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(ink);

		
		System.out.println("\nThis is athena's output for K after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inl);

		
		System.out.println("\nThis is athena's output for L after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(inm);
		
		System.out.println("\nThis is athena's output for M after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inn);

		
		System.out.println("\nThis is athena's output for N after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(ino);

		
		System.out.println("\nThis is athena's output for O after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inp);

		
		System.out.println("\nThis is athena's output for P after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(inq);
		
		System.out.println("\nThis is athena's output for Q after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inr);

		
		System.out.println("\nThis is athena's output for R after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(ins);


		System.out.println("\nThis is athena's output for S after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inT);

		
		System.out.println("\nThis is athena's output for T after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(inu);
		
		System.out.println("\nThis is athena's output for U after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inv);

		
		System.out.println("\nThis is athena's output for V after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(inw);

		
		System.out.println("\nThis is athena's output for W after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inx);

		
		System.out.println("\nThis is athena's output for X after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		output = athena.forward(iny);
		
		System.out.println("\nThis is athena's output for Y after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		
		output = athena.forward(inz);

		
		System.out.println("\nThis is athena's output for Z after 'being trained': \n");
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
		
		//System.out.println("The output recieved from Athena :\n");
		//athena.print_matrix(out);
		//System.out.println("[A , B , C , D , E , F , G , H , I , J , K , L , M , N , O , P , Q , R , S , T , U , V , W , X , Y , Z ].\n\n");
		
		//setting a dummy array from the Forward prop output to the array Preston needs
		//eventually this will be the array of the top 5 letters, and their corresponding % values
		
		//System.out.println("output ARRAY : " + Arrays.toString(out) + "\n\n");

	}
}
