# ANR
simple and effective code to know where ANR happened

Usage:
```
public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new ANRWatchDog()).start();
    }
}
```

it will track line number where operation takes too much time
```
com.example.ANR.ANRException: ANR happened
        at java.lang.Object.wait(Native Method)
        at org.tensorflow.Graph.close(Graph.java:54)
        at com.zihuiinfo.facesdk.boundingbox.MTCNN.clean(MTCNN.java:419)
        at com.zihuiinfo.facesdk.FaceBoundingBox.clean(FaceBoundingBox.java:30)
        at com.zihuiinfo.facerecogntionsdk.example.CameraOnTheFly.onDestroy(CameraOnTheFly.java:179)
```
