/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author zoebe
 */
public class Personal extends Datos
{
    private char estatus;

    public Personal() 
    {
        
    }

    public Personal(char estatus, String cve, String nom, String primerAp, String segundoAp, char sexo, boolean desnutriccion, boolean sobrepeso, boolean alergias, boolean obecidad, boolean diabetes, String otras) 
    {
        super(cve, nom, primerAp, segundoAp, sexo, desnutriccion, sobrepeso, alergias, obecidad, diabetes, otras);
        this.estatus = estatus;
    }

    /**
     * @return the estatus
     */
    public char getEstatus() 
    {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(char estatus) 
    {
        this.estatus = estatus;
    }
    
    
}

