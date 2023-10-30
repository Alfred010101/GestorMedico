/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author zoebe
 */
public class HistorialClinico
{
    private String padecimientoAct;
    private String antecedentesPer;
    private String medicamento;
    private String planTratamiento;
    private Datos fecha;

    public HistorialClinico()
    {
    }

    public HistorialClinico(String padecimientoAct, String antecedentesPer, String medicamento, String planTratamiento, Datos fecha)
    {
        this.padecimientoAct = padecimientoAct;
        this.antecedentesPer = antecedentesPer;
        this.medicamento = medicamento;
        this.planTratamiento = planTratamiento;
        this.fecha = fecha;
    }

    /**
     * @return the padecimientoAct
     */
    public String getPadecimientoAct()
    {
        return padecimientoAct;
    }

    /**
     * @param padecimientoAct the padecimientoAct to set
     */
    public void setPadecimientoAct(String padecimientoAct)
    {
        this.padecimientoAct = padecimientoAct;
    }

    /**
     * @return the antecedentesPer
     */
    public String getAntecedentesPer()
    {
        return antecedentesPer;
    }

    /**
     * @param antecedentesPer the antecedentesPer to set
     */
    public void setAntecedentesPer(String antecedentesPer)
    {
        this.antecedentesPer = antecedentesPer;
    }

    /**
     * @return the medicamento
     */
    public String getMedicamento()
    {
        return medicamento;
    }

    /**
     * @param medicamento the medicamento to set
     */
    public void setMedicamento(String medicamento)
    {
        this.medicamento = medicamento;
    }

    /**
     * @return the planTratamiento
     */
    public String getPlanTratamiento()
    {
        return planTratamiento;
    }

    /**
     * @param planTratamiento the planTratamiento to set
     */
    public void setPlanTratamiento(String planTratamiento)
    {
        this.planTratamiento = planTratamiento;
    }

    /**
     * @return the fecha
     */
    public Datos getFecha()
    {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Datos fecha)
    {
        this.fecha = fecha;
    }
    
    
}
