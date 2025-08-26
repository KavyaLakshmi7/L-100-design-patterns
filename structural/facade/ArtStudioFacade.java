public class ArtStudioFacade {
    private Canvas canvas;
    private Brush brush;
    private ColorPalette palette;
    private LayerManager layerManager;
    private ExportManager exportManager;

    public ArtStudioFacade() {
        canvas = new Canvas();
        brush = new Brush();
        palette = new ColorPalette();
        layerManager = new LayerManager();
        exportManager = new ExportManager();
    }

    public void createSketch() {
        canvas.create();
        brush.select("Pencil");
        palette.chooseColor("Black");
        brush.stroke();
        layerManager.addLayer("Sketch Layer");
    }

    public void paintPortrait() {
        canvas.create();
        brush.select("Oil Brush");
        palette.chooseColor("Skin Tone");
        brush.stroke();
        layerManager.addLayer("Base Layer");
        palette.chooseColor("Red");
        brush.stroke();
        layerManager.addLayer("Detail Layer");
    }

    public void exportArtwork(String format) {
        layerManager.mergeLayers();
        exportManager.export(format);
    }
}
