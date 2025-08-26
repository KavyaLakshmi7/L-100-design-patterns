public class Main {
    public static void main(String[] args) {
        ArtStudioFacade artStudio = new ArtStudioFacade();

        System.out.println("Starting sketch:");
        artStudio.createSketch();

        System.out.println("\nPainting portrait:");
        artStudio.paintPortrait();

        System.out.println("\nExporting artwork:");
        artStudio.exportArtwork("PNG");
    }
}
