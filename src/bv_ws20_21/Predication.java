package bv_ws20_21;

public class Predication {



    public enum PredictorType {
        A("A (horizontal)"),
        B("B (vertikal)"),
        C("C (diagonal)"),
        D("A + B − C"),
        AD("adaptiv");

        private final String name;
        PredictorType(String s) { name = s; }
        public String toString() { return this.name; }
    }
    public void copy(RasterImage src, RasterImage dst) {
        dst.argb=src.argb;
    }

    public void horizontal(RasterImage src, RasterImage dst){
        dst.argb=src.argb;
    }

    public void vertical(RasterImage src, RasterImage dst) {
        dst.argb=src.argb;
    }
    public void diagonal(RasterImage src, RasterImage dst) {
        dst.argb=src.argb;
    }
    public void additive(RasterImage src, RasterImage dst) {
        dst.argb=src.argb;
    }
    public void adaptive(RasterImage src, RasterImage dst) {
        dst.argb=src.argb;
    }
}
