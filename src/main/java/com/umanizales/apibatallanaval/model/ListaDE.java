package com.umanizales.apibatallanaval.model;

import com.umanizales.apibatallanaval.model.dto.DistribucionBarcoDTO;
import com.umanizales.apibatallanaval.model.dto.RespuestaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ListaDE implements Serializable {
    private NodoDE cabeza;
    private int cont;

    public void adicionarNodoDE(Object dato){
        if(cabeza == null)
        {
            cabeza = new NodoDE(dato);
        }
        else
        {
            //LLamar a mi ayudante y ubicarme en el último
            NodoDE temp = cabeza;
            while(temp.getSiguiente()!=null)
            {
                temp= temp.getSiguiente();
            }
            ///Parado en el ultimo
            temp.setSiguiente(new NodoDE(dato));
            temp.getSiguiente().setAnterior(temp);
        }
        cont++;
    }

    public void adicionarNodoDEAlInicio(Object dato)
    {
        if(cabeza ==null)
        {
            cabeza = new NodoDE(dato);
            cont++;
        }
        else
        {
            NodoDE temp = new NodoDE(dato);
            temp.setSiguiente(cabeza);
            cabeza=temp;
            cont++;
        }
    }

    public String listadoNodoDEs()
    {
        String listado="";
        NodoDE temp=cabeza;
        while(temp!=null)
        {
            listado = listado + temp.getDato();
            temp = temp.getSiguiente();
        }

        return listado;
    }

    public int getCont() {
        return cont;
    }

    public Object encontrarDatoxCodigo(String codigo)
    {
        if(cabeza !=null)
        {
            NodoDE temp=cabeza;
            while(temp !=null)
            {
                if(temp.getDato().equals(codigo))
                {
                    return temp.getDato();
                }
                temp = temp.getSiguiente();
            }
        }
        return null;
    }

<<<<<<< HEAD

}



=======
    public DistribucionBarcoDTO encontrarxPosicion(int posicion){
        if(cabeza!=null)
        {
            NodoDE temp= cabeza;
            int cont=1;
            while(posicion!=cont)
            {
                temp = temp.getSiguiente();
                cont++;
            }
            /// Estamos parados en el que estabamos buscando
            return (DistribucionBarcoDTO) temp.getDato();
        }
        return null;
    }

    public boolean validarCoordenadasNodo(int x, int y)
    {
        if (cabeza == null){
            return false;
        }
        else
        {
            int cont = 1;
            NodoDE temp = cabeza;
            while (temp.getSiguiente() != null){
                if (temp.getDato()      )
                {

                }
                cont++;
                temp = temp.getSiguiente();
            }
            return false;
        }
    }
}
>>>>>>> master
