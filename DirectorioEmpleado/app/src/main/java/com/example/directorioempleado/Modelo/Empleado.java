package com.example.directorioempleado.Modelo;

public class Empleado {
    long id;
    String nombre;
    String apellidoP;
    String apellidoM;
    String telefono;
    String correo;
    String nacionalidad;
    String fechaNacimieto;
    String estadoCivil;
    String calle;
    String colonia;
    String ciudad;
    String estado;
    String pais;
    String nomina;
    String puesto;
    String rfc;
    String curp;
    String nss;
    String contacto;
    String escolaridad;
    String estatus;

    public Empleado() {

    }

    public Empleado(long id, String nombre, String apellidoP, String apellidoM, String telefono, String correo, String nacionalidad, String fechaNacimieto, String estadoCivil, String calle, String colonia, String ciudad, String estado, String pais, String nomina, String puesto, String rfc, String curp, String nss, String contacto, String escolaridad, String estatus) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
        this.fechaNacimieto = fechaNacimieto;
        this.estadoCivil = estadoCivil;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.nomina = nomina;
        this.puesto = puesto;
        this.rfc = rfc;
        this.curp = curp;
        this.nss = nss;
        this.contacto = contacto;
        this.escolaridad = escolaridad;
        this.estatus = estatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaNacimieto() {
        return fechaNacimieto;
    }

    public void setFechaNacimieto(String fechaNacimieto) {
        this.fechaNacimieto = fechaNacimieto;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNomina() {
        return nomina;
    }

    public void setNomina(String nomina) {
        this.nomina = nomina;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoP='" + apellidoP + '\'' +
                ", apellidoM='" + apellidoM + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechaNacimieto='" + fechaNacimieto + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", calle='" + calle + '\'' +
                ", colonia='" + colonia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", nomina=" + nomina +
                ", puesto='" + puesto + '\'' +
                ", rfc='" + rfc + '\'' +
                ", curp='" + curp + '\'' +
                ", nss=" + nss +
                ", contacto='" + contacto + '\'' +
                ", escolaridad='" + escolaridad + '\'' +
                ", estatus='" + estatus + '\'' +
                '}';
    }
}
