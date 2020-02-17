package view;

import java.text.DecimalFormat;

import model.logic.Feature;
import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar datos de los comparendos");
			System.out.println("2. Consultar comparendo");
			System.out.println("3. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}
		
		public void printFeature(Feature feature){
			
			if(feature == null){
				System.out.println("No hay info de este comparendo o no existe.");
			}
			else{
				System.out.println("\nCOMPARENDO:");
				System.out.println("\n\tOBJECTID: " + feature.getObjectId());
				System.out.println("\n\tFECHA_HORA: " + feature.getDate());
				System.out.println("\n\tINFRACCION: " + feature.getInfraction());
				System.out.println("\n\tCLASE_VEHI: " + feature.getVehicleClass());
				System.out.println("\n\tTIPO_SERVI: " + feature.getServiceType());
				System.out.println("\n\tLOCALIDAD: " + feature.getLocality());
				System.out.println("\n");
			}
			
		}
		
		public void printGeneralFeaturesInfo(int featuresNumber, Feature featureBiggestId, double[] minmax ){
			
			System.out.println("\nDATOS GENERALES:");
			System.out.println("\n-----------------------------------");
			
			System.out.println("\nNUMERO TOTAL DE COMPARENDOS: " + featuresNumber);
			
			System.out.println("\n\nCOMPARENDO CON MAYOR ID:");
			printFeature(featureBiggestId);
			
			System.out.println("\nMINMAX DE LOS COMPARENDOS:\n");
			printMinimax(minmax);
			
		}
		
		public void printMinimax( double[] minmax ){
			
			int altoRect = 10;
			int anchoRect = 20;
			
			DecimalFormat format = new DecimalFormat("#.##");
			
			String maxlat = format.format(minmax[2]);
			String maxlong = format.format(minmax[3]);
			String minlat = format.format(minmax[0]);
			String minlong = format.format(minmax[1]);
			
			System.out.println("MaxLat (" + maxlat + ")");
			System.out.println("MaxLong (" + maxlong + ")");

			System.out.println("minLat (" + minlat + ")");
			System.out.println("minLong (" + minlong + ")\n");
			
			for(int i = 0; i < altoRect ; i++){
	            
				String linea = "";
				
				for(int j = 0; j < anchoRect ; j++){
					
					if( i == 0 && j == 0 )
						linea += (maxlat);
					else if( i == 0 && j == anchoRect - 1)
						linea += (maxlong);
					else if( i == altoRect - 1 && j == 0 )
						linea += (minlat);
					else if( i == altoRect - 1 && j == anchoRect - 1 )
						linea += (minlong);
					else if( i == 0 || i == altoRect - 1 || j == 0 || j == anchoRect - 1){
						if(  j == anchoRect - 1  ){
							linea += "        * ";
						}else{
							linea += "* ";
						}
					}else
						linea += "  ";
			    }
				
				System.out.println(linea);
			 }
			
			System.out.println("\n\n");
			
		}
}
