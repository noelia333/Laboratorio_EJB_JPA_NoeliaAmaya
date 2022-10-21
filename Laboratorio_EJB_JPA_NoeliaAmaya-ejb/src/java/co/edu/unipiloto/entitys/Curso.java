/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Noelia
 */
@Entity
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCursoId", query = "SELECT c FROM Curso c WHERE c.cursoId = :cursoId"),
    @NamedQuery(name = "Curso.findByNombrecurso", query = "SELECT c FROM Curso c WHERE c.nombrecurso = :nombrecurso"),
    @NamedQuery(name = "Curso.findByNumcreditos", query = "SELECT c FROM Curso c WHERE c.numcreditos = :numcreditos"),
    @NamedQuery(name = "Curso.findBySemestre", query = "SELECT c FROM Curso c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Curso.findByNumestudianteadmitido", query = "SELECT c FROM Curso c WHERE c.numestudianteadmitido = :numestudianteadmitido")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CURSO_ID")
    private Integer cursoId;
    @Size(max = 100)
    @Column(name = "NOMBRECURSO")
    private String nombrecurso;
    @Column(name = "NUMCREDITOS")
    private Integer numcreditos;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "NUMESTUDIANTEADMITIDO")
    private Integer numestudianteadmitido;

    public Curso() {
    }

    public Curso(Integer cursoId, String nombrecurso, Integer numcreditos, Integer semestre, Integer numestudianteadmitido) {
        this.cursoId = cursoId;
        this.nombrecurso = nombrecurso;
        this.numcreditos = numcreditos;
        this.semestre = semestre;
        this.numestudianteadmitido = numestudianteadmitido;
    }

    public Curso(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public Integer getNumcreditos() {
        return numcreditos;
    }

    public void setNumcreditos(Integer numcreditos) {
        this.numcreditos = numcreditos;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getNumestudianteadmitido() {
        return numestudianteadmitido;
    }

    public void setNumestudianteadmitido(Integer numestudianteadmitido) {
        this.numestudianteadmitido = numestudianteadmitido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoId != null ? cursoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.cursoId == null && other.cursoId != null) || (this.cursoId != null && !this.cursoId.equals(other.cursoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entitys.Curso[ cursoId=" + cursoId + " ]";
    }
    
}
