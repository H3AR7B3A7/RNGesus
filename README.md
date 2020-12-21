#RNGesus

The random number generator for streamers and giveaways. 

## JavaFX
Some help with JavaFX for people who want to add to, or make changes to the source code.

### Installation (IntelliJ)
- [Download](https://gluonhq.com/products/scene-builder/) and install SceneBuilder.
- Under Settings > Languages & Frameworks > JavaFX: Set path to SceneBuilder.  
(For example to: "C:\Program Files\SceneBuilder\SceneBuilder.exe")
- [Download](https://gluonhq.com/products/javafx/) and extract JavaFX to your hard drive.  
(For example to: "C:\Program Files\Java\javafx-sdk-16", but feel free to choose your own installation directory)
- Under project structure > Libraries > Add (+): And specify the path where you installed JavaFX "C:\Program Files\Java\javafx-sdk-16\lib"
- In the project, under *'Edit Configurations...'* add the following to VM options:
>--module-path "C:\Program Files\Java\javafx-sdk-16\lib" --add-modules javafx.controls,javafx.fxml

For more documentation, visit [jetbrains.com](https://www.jetbrains.com/help/idea/javafx.html).