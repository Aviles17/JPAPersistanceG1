package com.web.proyectocanchasg1.modelo;

import com.amazonaws.util.json.JSONObject;
import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;
    @Column(name = "fecha_reserva")
    private String fecha;
    @Column(name = "hora_inicio")
    private String horaI;
    @Column(name = "hora_final")
    private String horaF;
    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;


    public Reservas() {
        super();
        this.fecha = null;
        this.horaF = null;
        this.horaI = null;
        this.usuario = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Reservas(String fecha, String horaI, String horaF, Usuario u) {
        this.fecha = fecha;
        this.horaI = horaI;
        this.horaF = horaF;
        this.usuario = u;
    }

    public Long getIdreserva() {
        return id_reserva;
    }

    public void setIdreserva(Long idreserva) {
        this.id_reserva = idreserva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraI() {
        return horaI;
    }

    public void setHoraI(String horaI) {
        this.horaI = horaI;
    }

    public String getHoraF() {
        return horaF;
    }

    public void setHoraF(String horaF) {
        this.horaF = horaF;
    }

    public JSONObject toJSON() throws Exception {
        JSONObject jreserva = new JSONObject();
        jreserva.put("id", getIdreserva());
        jreserva.put("fecha", getFecha());
        jreserva.put("Hora_i", getHoraI());
        jreserva.put("Hora_f", getHoraF());
        jreserva.put("usuario", getUsuario());
        return jreserva;
    }

}
