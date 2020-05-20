
package javaapplication1;


public class JavaApplication1 {
    
    public static void main(String[] args) {
        
        Ekwipunek eq = new Ekwipunek();
        
        eq.dodajPrzedmiot();
        eq.dodajPrzedmiot();
        eq.dodajPrzedmiot();

        eq.przeniesPrzedmiot(3, 5);
        
        eq.wyswietlEkwipunek();

        
    }
    
}

class Ekwipunek{
    
    int[] index = new int[5];
    
    Ekwipunek(){
        System.out.println("");
          index[0] = 0;
          index[1] = 0;
          index[2] = 0;
          index[3] = 0;
          index[4] = 0;
    }
    
    void wyswietlEkwipunek(){
        for(int i = 1; i < 6; i++){
            System.out.print(i + ".");
        }
        System.out.println("");
        for(int i = 0; i < 5; i++){
            System.out.print(this.index[i] + " ");
        }
        System.out.println("");
    }
    
    boolean czyPelnySlot(int nrSlotu){
        return this.index[nrSlotu-1] != 0;
    }
    
    boolean czyPelnyEq(){
        for(int i = 1; i < this.index.length+1; i++){
            if(this.czyPelnySlot(i)) {
            } else {
                return false;
            }
        }
        return true;
    }
    
    int wolnyIndex(){
        int count = 0;
        
        for(int i = 0; this.index[i] != 0; i++){
            count = i;
        }
        return index[0] == 0? 0 : count+1;
    }
    
    // Dodaje przedmiot do pierwszego wolnego slotu
    void dodajPrzedmiot(){   
        if (czyPelnyEq()) {
            System.out.println("Ekwipunek jest pełny!");
        }
        else{
            this.index[wolnyIndex()] = 1;
        }
    }
    
    // Dodaje przedmiot do wybranego slotu
    void dodajPrzedmiot(int slotDocelowy){
        if (czyPelnySlot(slotDocelowy)) {
            System.out.println("Slot juz jest pełny!");
        }
        else{
            this.index[slotDocelowy - 1] = 1;
        }
    }
    
    void usunPrzedmiot(int nrPrzedmiotu){
        if (this.index[nrPrzedmiotu-1] == 0) {
            System.out.println("tam nic nie ma!");
        }
        else{
            this.index[nrPrzedmiotu-1] = 0;
        }
    }
    
    void przeniesPrzedmiot(int slotWejsciowy, int slotDocelowy){
        if( this.czyPelnySlot(slotWejsciowy) && this.czyPelnySlot(slotDocelowy)){
        }
        else if(this.czyPelnySlot(slotWejsciowy)){
            this.usunPrzedmiot(slotWejsciowy);
            this.dodajPrzedmiot(slotDocelowy);
        }
        else {
            System.out.println("Nie masz czego przeniesc");
        }
    }
}
