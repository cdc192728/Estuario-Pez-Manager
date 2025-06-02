
package Clases;


public class Estanques {
    int idEstanque;
    String forma;
    String estanque;
    String tipoEstanque;
    float radio;
    float largo;
    float ancho;
    float profundidad;
    float areaM2Circulares;
    float areaM3Circulares;
    float areaM2Rectangulares;
    float areaM3Rectangulares;
    float pecesSembreados;
    double totalPecesSem;
    String especie;
    float densidad;
    float M45;
    float M38;
    float M34;
    float M30;
    float bultosTotales;
    double totalM45;
    double totalM38;
    double totalM34;
    double totalM30;
    double totalBultos;
    String fechaInicio;
    String fechaFin;
    float pesoPromedioCos;
    float KGCos;
    float tonCos;
    int fkCli;
    String propietario;

    public Estanques() {
    }
    
    public Estanques(int idEstanque, String forma, String estanque, String tipoEstanque, float radio, float largo, float ancho, float profundidad, float areaM2Circulares, float areaM3Circulares, float areaM2Rectangulares, float areaM3Rectangulares, float pecesSembreados, String especie, float densidad, float M45, float M38, float M34, float M30, float bultosTotales, String fechaInicio, String fechaFin, float pesoPromedioCos, float KGCos, float tonCos) {
        this.idEstanque = idEstanque;
        this.forma = forma;
        this.estanque = estanque;
        this.tipoEstanque = tipoEstanque;
        this.radio = radio;
        this.largo = largo;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.areaM2Circulares = areaM2Circulares;
        this.areaM3Circulares = areaM3Circulares;
        this.areaM2Rectangulares = areaM2Rectangulares;
        this.areaM3Rectangulares = areaM3Rectangulares;
        this.pecesSembreados = pecesSembreados;
        this.especie = especie;
        this.densidad = densidad;
        this.M45 = M45;
        this.M38 = M38;
        this.M34 = M34;
        this.M30 = M30;
        this.bultosTotales = bultosTotales;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pesoPromedioCos = pesoPromedioCos;
        this.KGCos = KGCos;
        this.tonCos = tonCos;
    }

    public Estanques(int idEstanque, String forma, String estanque, String tipoEstanque, float radio, float largo, float ancho, float profundidad, float areaM2Circulares, float areaM3Circulares, float areaM2Rectangulares, float areaM3Rectangulares, float pecesSembreados, float totalPecesSem, String especie, float densidad, float M45, float M38, float M34, float M30, float bultosTotales, double totalM45, double totalM38, double totalM34, double totalM30, double totalBultos, String fechaInicio, String fechaFin, float pesoPromedioCos, float KGCos, float tonCos, int fkCli, String propietario) {
        this.idEstanque = idEstanque;
        this.forma = forma;
        this.estanque = estanque;
        this.tipoEstanque = tipoEstanque;
        this.radio = radio;
        this.largo = largo;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.areaM2Circulares = areaM2Circulares;
        this.areaM3Circulares = areaM3Circulares;
        this.areaM2Rectangulares = areaM2Rectangulares;
        this.areaM3Rectangulares = areaM3Rectangulares;
        this.pecesSembreados = pecesSembreados;
        this.totalPecesSem = totalPecesSem;
        this.especie = especie;
        this.densidad = densidad;
        this.M45 = M45;
        this.M38 = M38;
        this.M34 = M34;
        this.M30 = M30;
        this.bultosTotales = bultosTotales;
        this.totalM45 = totalM45;
        this.totalM38 = totalM38;
        this.totalM34 = totalM34;
        this.totalM30 = totalM30;
        this.totalBultos = totalBultos;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pesoPromedioCos = pesoPromedioCos;
        this.KGCos = KGCos;
        this.tonCos = tonCos;
        this.fkCli = fkCli;
        this.propietario = propietario;
    }

    public int getIdEstanque() {
        return idEstanque;
    }

    public void setIdEstanque(int idEstanque) {
        this.idEstanque = idEstanque;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getEstanque() {
        return estanque;
    }

    public void setEstanque(String estanque) {
        this.estanque = estanque;
    }

    public String getTipoEstanque() {
        return tipoEstanque;
    }

    public void setTipoEstanque(String tipoEstanque) {
        this.tipoEstanque = tipoEstanque;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = largo;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(float profundidad) {
        this.profundidad = profundidad;
    }

    public float getAreaM2Circulares() {
        return areaM2Circulares;
    }

    public void setAreaM2Circulares(float areaM2Circulares) {
        this.areaM2Circulares = areaM2Circulares;
    }

    public float getAreaM3Circulares() {
        return areaM3Circulares;
    }

    public void setAreaM3Circulares(float areaM3Circulares) {
        this.areaM3Circulares = areaM3Circulares;
    }

    public float getAreaM2Rectangulares() {
        return areaM2Rectangulares;
    }

    public void setAreaM2Rectangulares(float areaM2Rectangulares) {
        this.areaM2Rectangulares = areaM2Rectangulares;
    }

    public float getAreaM3Rectangulares() {
        return areaM3Rectangulares;
    }

    public void setAreaM3Rectangulares(float areaM3Rectangulares) {
        this.areaM3Rectangulares = areaM3Rectangulares;
    }

    public float getPecesSembreados() {
        return pecesSembreados;
    }

    public void setPecesSembreados(float pecesSembreados) {
        this.pecesSembreados = pecesSembreados;
    }

    public double getTotalPecesSem() {
        return totalPecesSem;
    }

    public void setTotalPecesSem(float totalPecesSem) {
        this.totalPecesSem = totalPecesSem;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getDensidad() {
        return densidad;
    }

    public void setDensidad(float densidad) {
        this.densidad = densidad;
    }

    public float getM45() {
        return M45;
    }

    public void setM45(float M45) {
        this.M45 = M45;
    }

    public float getM38() {
        return M38;
    }

    public void setM38(float M38) {
        this.M38 = M38;
    }

    public float getM34() {
        return M34;
    }

    public void setM34(float M34) {
        this.M34 = M34;
    }

    public float getM30() {
        return M30;
    }

    public void setM30(float M30) {
        this.M30 = M30;
    }

    public float getBultosTotales() {
        return bultosTotales;
    }

    public void setBultosTotales(float bultosTotales) {
        this.bultosTotales = bultosTotales;
    }

    public double getTotalM45() {
        return totalM45;
    }

    public void setTotalM45(double totalM45) {
        this.totalM45 = totalM45;
    }

    public double getTotalM38() {
        return totalM38;
    }

    public void setTotalM38(double totalM38) {
        this.totalM38 = totalM38;
    }

    public double getTotalM34() {
        return totalM34;
    }

    public void setTotalM34(double totalM34) {
        this.totalM34 = totalM34;
    }

    public double getTotalM30() {
        return totalM30;
    }

    public void setTotalM30(double totalM30) {
        this.totalM30 = totalM30;
    }

    public double getTotalBultos() {
        return totalBultos;
    }

    public void setTotalBultos(double totalBultos) {
        this.totalBultos = totalBultos;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getPesoPromedioCos() {
        return pesoPromedioCos;
    }

    public void setPesoPromedioCos(float pesoPromedioCos) {
        this.pesoPromedioCos = pesoPromedioCos;
    }

    public float getKGCos() {
        return KGCos;
    }

    public void setKGCos(float KGCos) {
        this.KGCos = KGCos;
    }

    public float getTonCos() {
        return tonCos;
    }

    public void setTonCos(float tonCos) {
        this.tonCos = tonCos;
    }

    public int getFkCli() {
        return fkCli;
    }

    public void setFkCli(int fkCli) {
        this.fkCli = fkCli;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    public float AreaM2Circulares(float radio){
        areaM2Circulares = (float) (3.1416*(radio * radio));
        return areaM2Circulares;
    }
    
    public float AreaM3Circulares(float prof, float areaM2){
        areaM3Circulares = (float) (prof * areaM2);
        return areaM3Circulares;
    }
    
    public float AreaM2Rectangulares(float largo, float ancho){
        areaM2Rectangulares = (float) (largo * ancho);
        return areaM2Rectangulares;
    }
    
    public float AreaM3Rectangulares(float prof, float areaM2){
        areaM3Rectangulares = (float) (prof * areaM2);
        return areaM3Rectangulares;
    }
    
    public float PecesSembradosCirculares(float areaM3Circulares, float densidad){
        pecesSembreados = areaM3Circulares * densidad;
        return pecesSembreados;
    }
    
    public float pecesSembradosRectangulares(float areaM3Rectangulares, float densidad){
        pecesSembreados = areaM3Rectangulares * densidad;
        return pecesSembreados;
    }
    
    public float M45(float pecesSembrados){
        M45 = pecesSembreados*1/1000;
        return M45;
    }
    
    public float M38(float pecesSembrados){
        M38 = pecesSembreados*2/1000;
        return M38;
    }
    
    public float M34(float pecesSembrados){
        M34 = pecesSembreados*3/1000;
        return M34;
    }
    
    public float M30(float pecesSembrados){
        M30 = pecesSembreados*4/1000;
        return M30;
    }
    
    public float BultosTotales(float M45, float M38, float M34, float M30){
        bultosTotales = M45 + M38 + M34 + M30;
        return bultosTotales;
    }
    
    public float KgCosechados(float pesoPromCos, float pecesSem){
        KGCos = (pesoPromCos * pecesSem)/1000;
        return KGCos;
    }
    
    public float ToneladasCosechadas(float kgCos){
        tonCos = kgCos/1000;
        return tonCos;
    }
    
}
