/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;

/**
 *
 * @author nadia
 */
public class listass {
   private int max;
   private int cantElem;
   private int []elem;
   
   public listass(int max){
       this.cantElem = 0;
       this.max = max;
       this.elem = new int[max];
   }
   public String toString(){
       String s = "[";
       int i = 0;
       while(i < cantElem){
           s = s + elem[i];
           if(i < cantElem - 1) s = s + ",";
           i++;
       }
       return s + "]";
   }
   public void insertarIesimo(int x, int pos){
       if(pos < 0 || pos > cantElem)return;
       if(cantElem == max)return;
       int i = cantElem;
       while(i  > pos){
           elem[i] = elem[i-1];
           i--;
       }
       elem[pos] = x;
       cantElem++;
   }
   public void eliminarIesimo(int pos){
       int i = pos;
       while(i < cantElem - 1){
           elem[i] = elem[i+1];
           i++;
       }
       cantElem--;
   }
   public void insertarPri(int x){
       this.insertarIesimo(x, 0);
   }
   public void insertarUlt(int x){
       this.insertarIesimo(x, cantElem);
   }
   public void insetarExtremos(int n){
       this.insertarPri(n);
       this.insertarUlt(n);
   }
   public void insertarLista(listass L2){
       int i = 0;
       while(i < L2.cantElem && cantElem < max){
           this.insertarUlt(L2.elem[i]);
           i++;
       }
   }
   public void insertarIesimoL2(listass L2,int pos){
       int i = pos;
       int j = 0;
       while(j < L2.cantElem && cantElem < max){
           this.insertarIesimo(L2.elem[j], i);
           i++;
           j++;
       }
   }
   public void insertarListaUlt(listass L2){
       this.insertarIesimoL2(L2, cantElem);
   }
   public void vacia(){
       cantElem = 0;
   }
   public void unir(listass L2, listass L3){
       vacia();
       this.insertarL2Ini(L2);
       this.insertarListaUlt(L2);
   }
   public void eliminarAlternos(){
       int i = 1;
       while(i < cantElem){
           this.eliminarIesimo(i);
           i++;
       }
   }
   public void insertarAsc(int x){
       int i = 0;
       while(i < cantElem && elem[i] < x){
           i++;     
       }
       this.insertarIesimo(x, i);
   }
   public void insertarDesc(int x){
       int i = 0;
       while(i < cantElem && elem[i] > x){
           i++;
       }
       this.insertarIesimo(x, i);
   }
   public void insertarL2Ult(listass L2){
       this.insertarIesimoL2(L2, cantElem);
   }
   public void insertarL2Ini(listass L2){
       this.insertarIesimoL2(L2, 0);
   }
   public void insertarExtList2(listass L2){
       this.insertarL2Ini(L2);
       this.insertarL2Ult(L2);
   }
    
   public void eliminarPri(){
       this.eliminarIesimo(0);
   }
   public void eliminarUlti(){
       this.eliminarIesimo(cantElem -1);
   }
   public void eliminaeExtr(){
       this.eliminarPri();
       this.eliminarUlti();
   }
   public int buscar(int x){
       int i = 0;
       while(i < cantElem){
           if(elem[i] == x) return i;
           i++;
       }
       return -1;
   }
   public void eliminarEle(int x){
       int i = buscar(x);
           if( i != -1){
               this.eliminarIesimo(i);
           }
   }
   public boolean existe(int x){
       int i = 0;
       while(i < cantElem){
        if(elem[i]==x) 
           return true;
       }
            return false;
   }
   public void eliminarL2(listass L2){
       int i = 0;
       while(i < L2.cantElem){
           if(existe(elem[i]))
               this.eliminarIesimo(i);
           else
               i++;
       }
   }
   public void rotarIzq(int n){
       while(n > 0 && cantElem > 0){
           int i = elem[0];
           this.eliminarPri();
           this.insertarUlt(i);
           n--;
       }
   }
   public void rotarDer(int n){
       while(n > 0 && cantElem > 0){
           int i = elem[cantElem -1];
           this.eliminarUlti();
           this.insertarPri(i);
           n--;
       }
   }
   public int frecuencia(int x){
       int i = 0;
       int c = 0;
       while(i < cantElem){
           if(elem[i]==x) c++;
           i++;
       }
       return c;
   }
   public void eliminarUnicos(){
       int i = 0;
       while(i < cantElem){
           if(frecuencia(elem[i]) == 1)
               this.eliminarIesimo(i);
           else 
               i++;
       }
   }
   public void eliminarRepetidos(){
       int i = 0;
       while(i < cantElem){
           if(frecuencia(elem[i]) != 1)
               eliminarIesimo(i);
           else
               i++;
       }
   }
   public void eliminaeRepL2(){
       listass L2 = new listass(max);
       int i = 0;
       while(i < cantElem){
           if( !L2.existe(elem[i]))
               L2.insertarUlt(elem[i]);
           i++;
       }
       cantElem = 0;
       this.insertarLista(L2);
   }
     public void pasarDig(int n){
        while( n > 0){
            this.insertarPri(n % 10);
            n /= 10;
        }
    }
}
