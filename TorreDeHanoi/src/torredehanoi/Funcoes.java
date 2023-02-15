package torredehanoi;

public class Funcoes {
    
    public static void imprimirTorres(String v1[], String v2[], String v3[]){
       System.out.println("0\t0\t0");
       System.out.println("-------------------");
       for (int i = 4; i >= 0; i--){
            System.out.println(v1[i] + "\t" + v2[i] + "\t" + v3[i]);
        } 
        System.out.println("-------------------");
        System.out.println("A\tB\tC");
    }
    
    public static boolean passarBarra (String v1[], String v2[]){
        String traco = "-";
        String pinos = "";
        String aux ="";
        int posicao = 0;
        int posAux = 0;
        int posV2 = 0;
        boolean possivel = false;
        
        for (byte i = 4; i >= 0; i--) {
            
            if(v1[i] != "0"){  
                aux = v1[i];
                posAux = i; 
                break;
            }  
        } 
       
        try{  
            
        posicao = Integer.parseInt(aux);
        
         for (int j = 0; j < posicao; j++) {   
                    traco = "-";
                    pinos = traco + pinos;
        } 
            aux = pinos;   
            
          }catch(NumberFormatException nfe){
      
                int soma = 0;
                String auxVet[] = aux.split("(?!^)");
                   
                   for (int j = 0; j < auxVet.length; j++) {
                       
                       soma++;
                   }
                   posicao = soma;           
                }
        if(v2[0].equals("0")){
            possivel = true;
        }
 
        for (byte i = 1; i < v1.length; i++) {         
             try{
                 
                posV2 =  Integer.parseInt(v2[i-1]);
                
             }catch(NumberFormatException nfe){
                 
               int soma = 0; 
               String auxVet[] = aux.split("(?!^)");
                
               for (int j = 0; j < auxVet.length; j++) {
                     soma++;
                 }
                 posV2 = soma;
             }
           
            if (posicao < posV2){
                possivel = true;
            }   
        }
          
        for (byte i = 0; i < v1.length; i++) { 
          
            if (possivel && v2[i].equals("0")){     
                v2[i] = aux;
                v1[posAux] = "0"; 
                break; 
                
            }if(posV2 < posicao){
                System.out.println(posicao);
                v2[posicao+1] = aux; 
                v1[posAux] = "0"; 
                break;
            }
        }
            return possivel; 
    }        

    public static boolean vitoria(String v1[]){
        boolean igual = true;
        String vetorBase[] = {"5", "4", "3", "2", "1"};
        
        for (int i = 0; i < v1.length; i++) {
            if (vetorBase[i] != v1[i]){
                igual = false;
            }
        }
        
        return igual;
    }
    
    public static boolean entradaCorreta (String e){
        return e.equals("AB") || e.equals("AC") || e.equals("BA")
               || e.equals("BC") || e.equals("CA") || e.equals("CB");
    }
  
}


    